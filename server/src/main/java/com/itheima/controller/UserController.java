package com.itheima.controller;


import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.annotation.SaMode;
import cn.dev33.satoken.session.SaSessionCustomUtil;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dto.UserDto;
import com.itheima.entity.Role;
import com.itheima.entity.User;
import com.itheima.exception.BusinessException;
import com.itheima.service.UserService;
import com.itheima.entity.Result;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

import com.itheima.util.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static com.itheima.util.Messages.Email.getContendEnd1;

/**
 * 用户信息(User)表控制层
 *
 * @author WangFK
 * @since 2023-05-05 14:39:28
 */
@RestController
@Slf4j
@RequestMapping(Urls.user.baseUrl)
@Transactional(rollbackFor = Exception.class)
@Api(value = "用户管理相关接口", tags = "用户管理相关接口", description = "用户增删改查接口")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;
    @Resource
    private QiniuUtils QiniuUtils;
    @SaIgnore
    @GetMapping
    public String test(){
        String filename = IdUtil.fastUUID()+".jpg";
        QiniuUtils.upload2Qiniu("D:\\hi-box\\server\\src\\main\\resources\\37bb8736-8fec-400e-8994-0c06a465976d.jpg",filename);
        return "上传成功,文件名："+filename;
    }
    @SaIgnore
    @ApiOperation(notes = "头像上传接口", value = "用户头像上传接口")
    @PostMapping(Urls.user.upload)
    Result Upload(@RequestBody MultipartFile imgFile) {
        //文件全名  eg：7d104dd7-15cd-42c5-9a85-b60ea6f423c2.jpg
        String originalFilename = imgFile.getOriginalFilename();
        //获取后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        //随机文件名 + 后缀
        String fileName = UUID.randomUUID().toString() + suffix;
        //七牛云工具类 字节上传
        try {
            QiniuUtils.upload2Qiniu(imgFile.getBytes(), fileName);
            return Result.success(fileName, "上传成功");
        } catch (IOException e) {
            throw new BusinessException("上传失败");
        }
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "起始页", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示页数", dataType = "Integer"),
            @ApiImplicitParam(name = "search", value = "查询条件 phone/username/account", dataType = "String")
    })
    @ApiOperation(value = "用户信息显示接口")
    //@SaCheckRole(value = Messages.Role.Role_Business)
    @SaIgnore
    @GetMapping(Urls.user.PersonList)
    public Result PersonList( Integer pageNum, Integer pageSize, String search) {
        Page<User> userPage = new Page<User>(pageNum, pageSize);
        LambdaUpdateWrapper<User> lqw = new LambdaUpdateWrapper<>();
        lqw.like(StrUtil.isNotBlank(search), User::getUsername, search).or()
                .like(StrUtil.isNotBlank(search), User::getPhone, search).or()
                .like(StrUtil.isNotBlank(search), User::getAccount, search)
                .orderByDesc(User::getUpdateTime);
        Page<User> page = userService.page(userPage, lqw);
        Page<UserDto> userDtoPage = new Page<>();
        List<User> records = page.getRecords();
        if (CollectionUtil.isEmpty(records)) {
            return Result.success(page, "查无此信息");
        }
        BeanUtil.copyProperties(page, userDtoPage, "records");
        ArrayList<UserDto> userDtos = new ArrayList<>();
        records.stream().forEach(item -> {
            UserDto userDto = new UserDto();
            BeanUtil.copyProperties(item, userDto);
            if (item.getFlag() == 0) {
                userDto.setRoleName(userService.getRoleName(0));
                userDtos.add(userDto);
            }
        });
        userDtoPage.setRecords(userDtos);
        userDtoPage.setTotal(userDtos.size());
        return Result.success(userDtoPage, "查询数据成功");
    }

    // 参数注释
    @ApiImplicitParam(name = "User", value = "注册接口 用户/商家", dataType = "User")
    // 方法注释
    @ApiOperation(value = "注册接口 用户/商家")
    @PostMapping(Urls.user.registered)
    @SaIgnore
    public Result UserRegistered(@RequestBody User user) {
        Result result = getResult(user);
        if (result != null) {
            return result;
        }
        // 保存用户信息
        userService.save(user);
        if (user.getFlag() == null) {
            user.setFlag(0);
        }
        // 分配角色身份
        if (!userService.setRoleName(user.getFlag(), user.getId())) {
            return Result.fail("分配角色失败");
        }
        return Result.success("注册成功");
    }

    @SaIgnore
    @ApiImplicitParam(name = "User", value = "注册接口 用户/商家", dataType = "User")
    @PostMapping(Urls.user.registeredEmail)
    public Result registeredEmail(@RequestBody UserDto user, HttpSession session) {
        String code1 = user.getCode();
        if (StrUtil.isBlank(code1)) {
            return Result.fail("验证码不能为空");
        }
        if (StrUtil.isBlank(user.getEmail())) {
            return Result.fail("邮箱不能为空");
        }
        String code = (String) session.getAttribute(user.getEmail());
        if (StrUtil.isBlank(code)) {
            return Result.fail("请确认两次邮箱是否一致");
        }
        if (!code1.equals(code)) {
            return Result.fail("验证码不正确");
        }
        User extracted = extracted(user);
        // 保存用户信息
        userService.save(extracted);
        if (extracted.getFlag() == null) {
            extracted.setFlag(0);
        }
        // 分配角色身份
        if (!userService.setRoleName(extracted.getFlag(), extracted.getId())) {
            return Result.fail("分配角色失败");
        }
        session.removeAttribute(extracted.getEmail());
        return Result.success("注册成功");
    }

    @SaIgnore
    @PostMapping(Urls.user.sendCode)
    public Result sendCode(@RequestBody User user, HttpSession session) {
        String email = user.getEmail();
        if (StrUtil.isBlank(email)) {
            return Result.fail("邮箱不能为空");
        }
        if (RegexUtils.isEmailInvalid(email)) {
            return Result.fail("邮箱格式不正确");
        }
        LambdaUpdateWrapper<User> lqw = new LambdaUpdateWrapper<>();
        lqw.eq(User::getEmail, user.getEmail());
        List<User> one = userService.list(lqw);
        if (!one.isEmpty()) {
            return Result.fail("邮箱重复,请重新输入");
        }
        // 验证码
        String code = ValidateCodeUtils.generateValidateCode4String(6);
        // 失效时间
        DateTime setTimeout = DateUtil.offsetMinute(DateUtil.date(), 5);
        String contend = Messages.Email.contendFix + code + Messages.Email.getContendEnd + setTimeout + getContendEnd1;
        MailUtil.sendHtml(email, Messages.Email.subject, contend);
        session.setAttribute(email, code);
        // 5分钟失效
        session.setMaxInactiveInterval(5 * 60);
        return Result.success("邮箱发送成功");
    }

    private Result getResult(User user) {
        User extracted = extracted(user);
        if (StrUtil.isBlank(extracted.getPhone())) {
            return Result.fail("手机号不能为空");
        }
        if (RegexUtils.isPhoneInvalid(extracted.getPhone())) {
            return Result.fail("手机号不正确");
        }
        LambdaUpdateWrapper<User> lqw = new LambdaUpdateWrapper<>();
        lqw.eq(User::getPhone, extracted.getPhone());
        List<User> one = userService.list(lqw);
        if (!one.isEmpty()) {
            return Result.fail("手机号重复,请重新输入");
        }
        return null;
    }

    private static User extracted(User user) {
        // 默认账号
        String StrPrefix = "hi-box_";
        String account = StrPrefix + RandomUtil.randomString(8);
        user.setAccount(account);
        // 默认密码 88888888
        String password = PasswordEncoder.encode("88888888");
        // 密码加密
        if (!StrUtil.isBlank(user.getPassword())) {
            password = PasswordEncoder.encode(user.getPassword());
        }
        user.setPassword(password);
        if (StrUtil.isBlank(user.getUsername())) {
            // 默认昵称 指定账号
            user.setUsername(account);
        }
        return user;
    }

    // 方法注释
    @ApiOperation(value = "登录接口", notes = "手机号/账号/用户名登录")
    @ApiImplicitParam(name = "User", dataType = "User", value = "登录接口")
    @SaIgnore
    @PostMapping(Urls.user.login)
    public Result login(@RequestBody User user) {
        LambdaUpdateWrapper<User> lqw = new LambdaUpdateWrapper<>();
        lqw.eq(StrUtil.isNotBlank(user.getAccount()), User::getAccount, user.getAccount()).or()
                .eq(StrUtil.isNotBlank(user.getPhone()), User::getPhone, user.getPhone()).or()
                .eq(StrUtil.isNotBlank(user.getUsername()), User::getUsername, user.getUsername()).or()
                .eq(StrUtil.isNotBlank(user.getEmail()), User::getEmail, user.getEmail());
        User one = userService.getOne(lqw);
        if (one == null) {
            return Result.fail("用户不存在");
        }
        if (!PasswordEncoder.matches(one.getPassword(), user.getPassword())) {
            return Result.fail("用户名或密码不正确");
        }
        if (one.getStatus() == 0) {
            return Result.success("该账号冻结，请联系管理员");
        }
        if (user.getFlag() != null) {
            if (!Objects.equals(user.getFlag(), one.getFlag())) {
                return Result.fail("该账号无权访问");
            }
        }
        UserDto userDto = new UserDto();
        BeanUtil.copyProperties(one, userDto);
        StpUtil.login(one.getId());
        String roleName = userService.getRoleName(one.getFlag());
        userDto.setRoleName(roleName);
        // 最简单的身份验证
/*        userDto.setRoleName(Messages.Role.Role_Business);
        if (one.getFlag() == 0) {
            userDto.setRoleName(Messages.Role.Role_User);
        }
        */

        userDto.setSatoken(StpUtil.getTokenInfo().tokenValue);
        // 在登录时缓存user对象
        StpUtil.getSession().set("user", userDto);
        return Result.success(userDto, "登录成功");
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @SaIgnore
    @GetMapping("{id}")
    public Result selectOne(@PathVariable Serializable id) {
        return Result.success(id,"功能未开发");
    }

    /**
     * 新增数据
     *
     * @param user 实体对象
     * @return 新增结果
     */
    @ApiImplicitParam(name = "新增接口", dataType = "User")
    @ApiOperation(value = "新增 和注册思路一样")
    @SaCheckRole(value = Messages.Role.Role_Business)
    @PostMapping(Urls.user.save)
    public Result insert(@RequestBody User user) {
        Result result = getResult(user);
        if (result != null) {
            return result;
        }
        // 保存用户信息
        userService.save(user);
        if (user.getFlag() == null) {
            user.setFlag(0);
        }
        // 分配角色身份
        if (!userService.setRoleName(user.getFlag(), user.getId())) {
            return Result.fail("分配角色失败");
        }
        return Result.success("新增成功");
    }

    /**
     * 修改数据
     *
     * @param user 实体对象
     * @return 修改结果
     */
    @SaCheckRole(value = {Messages.Role.Role_Business, Messages.Role.Role_User}, mode = SaMode.OR)
    @ApiOperation(value = "修改接口", notes = "修改用户/管理员信息")
    @ApiImplicitParam(name = "User", dataType = "User", value = "修改接口")
    @PutMapping(Urls.user.update)
    public Result update(@RequestBody User user) {
        // 更新图片先删除图片
        String img = userService.getById(user.getId()).getAvatar();
        if (!img.equals(user.getAvatar())) {
            QiniuUtils.deleteFileFromQiniu(img);
        }
        return userService.updateById(user) ? Result.success("修改成功") : Result.fail("修改失败");
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", dataType = "String"),
            @ApiImplicitParam(name = "oldPassword", value = "原密码", dataType = "String"),
            @ApiImplicitParam(name = "newPassword", value = "新密码", dataType = "String")
    })
    @ApiOperation(notes = "修改密码接口", value = "修改密码接口")
    @SaCheckRole(value = {Messages.Role.Role_Business, Messages.Role.Role_User}, mode = SaMode.OR)
    @PostMapping(Urls.user.updatePassword)
    Result updatePassword(@RequestBody Map map) {
        String id = String.valueOf(map.get("id"));
        User byId = userService.getById(id);
        String oldPassword = (String) map.get("oldPassword");
        String newPassword = (String) map.get("newPassword");
        if (!PasswordEncoder.matches(byId.getPassword(), oldPassword)) {
            return Result.fail("原密码错误，请重新输入");
        }
        if (PasswordEncoder.matches(byId.getPassword(), newPassword)) {
            return Result.fail("两次密码不能一样");
        }
        User user = new User();
        user.setPassword(PasswordEncoder.encode(newPassword));
        user.setId(Long.valueOf(id));
        if (userService.updateById(user)) {
            StpUtil.kickout(user.getId());
            SaSessionCustomUtil.deleteSessionById(String.valueOf(user.getId()));
            return Result.success("修改密码成功,请重新登录");
        }
        return Result.fail("修改密码失败");
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */

    @ApiOperation(value = "删除接口", notes = "可批量删除")
    @ApiImplicitParam(name = "idList", dataType = "List<String>", value = "可批量删除")
    @SaCheckRole(value = Messages.Role.Role_Business)
    @DeleteMapping(Urls.user.delete)
    public Result delete(@RequestParam("idList") List<String> idList) {
        // 删除图片
        List<String> collect = userService.listByIds(idList).stream().map(User::getAvatar).filter(StrUtil::isNotBlank).collect(Collectors.toList());
        collect.stream().forEach(QiniuUtils::deleteFileFromQiniu);
        // 删除用户身份
        return userService.removeBatchByIds(idList) && userService.deleteUserRole(idList) ? Result.success("删除成功") : Result.fail("删除失败");
    }

}

