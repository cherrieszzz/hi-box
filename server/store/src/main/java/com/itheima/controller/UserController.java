package com.itheima.controller;


import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dto.UserDto;
import com.itheima.entity.Role;
import com.itheima.entity.User;
import com.itheima.service.UserService;
import com.itheima.entity.Result;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.itheima.util.PasswordEncoder;
import com.itheima.util.RegexUtils;
import com.itheima.util.Urls;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
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
@Api(value = "用户管理相关接口",tags = "用户管理相关接口",description = "用户增删改查接口")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "起始页",dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize",value = "每页显示页数",dataType = "Integer"),
            @ApiImplicitParam(name = "search",value = "查询条件 phone/username/account",dataType = "String"),
            @ApiImplicitParam(name = "flag",value = "身份标记 ",dataType = "Integer"),
    })
    @ApiOperation(value = "用户信息显示接口")
    @GetMapping(Urls.user.PersonList)
    public Result PersonList(Integer pageNum,Integer pageSize,String search,Integer flag){
        Page<User> userPage = new Page<User>(pageNum,pageSize);
        LambdaUpdateWrapper<User> lqw = new LambdaUpdateWrapper<>();
        lqw.like(StrUtil.isNotBlank(search),User::getUsername,search).or()
                .like(StrUtil.isNotBlank(search),User::getPhone,search).or()
                .like(StrUtil.isNotBlank(search),User::getAccount,search)
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
            if (Objects.equals(flag, item.getFlag())){
                userDto.setRoleName(userService.getRoleName(flag));
                userDtos.add(userDto);
            }
        });
        userDtoPage.setRecords(userDtos);
        userDtoPage.setTotal(userDtos.size());
        return Result.success(userDtoPage, "查询数据成功");
    }
    // 参数注释
    @ApiImplicitParam(name = "User",value = "注册接口 用户/商家",dataType = "User")
    // 方法注释
    @ApiOperation(value = "注册接口 用户/商家")
    @PostMapping(Urls.user.registered)
    public Result UserRegistered(@RequestBody User user){
        Result result = getResult(user);
        if (result!=null){
            return result;
        }
        // 保存用户信息
        userService.save(user);
        // 分配角色身份
        if (!userService.setRoleName(user.getFlag(),user.getId())){
            return Result.fail("分配角色失败");
        }
        return Result.success("注册成功");
    }

    private Result getResult(User user) {
        // 默认账号
        String account="hg_"+RandomUtil.randomString(8);
        if (StrUtil.isBlank(user.getPassword())){
            // 默认密码 88888888
            user.setPassword(PasswordEncoder.encode("88888888"));
        }
        // 密码加密
        user.setPassword(PasswordEncoder.encode(user.getPassword()));
        if (StrUtil.isBlank(user.getUsername())){
            // 默认昵称 指定账号
            user.setUsername(account);
        }
        if (StrUtil.isBlank(user.getPhone())){
            return Result.fail("手机号不能为空");
        }
        if (RegexUtils.isPhoneInvalid(user.getPhone())){
            return Result.fail("手机号不正确");
        }
        if (user.getSex()==null){
            return Result.fail("请选择正确的性别");
        }
        LambdaUpdateWrapper<User> lqw = new LambdaUpdateWrapper<>();
        lqw.eq(User::getPhone, user.getPhone());
        User one = userService.getOne(lqw);
        if (one!=null){
            return Result.fail("手机号重复,请重新输入");
        }
        return null;
    }

    // 方法注释
    @ApiOperation(value = "登录接口",notes = "手机号/账号/用户名登录")
    @ApiImplicitParam(name = "User",dataType = "User",value = "登录接口")
    @PostMapping(Urls.user.login)
    Result login(@RequestBody User user){
        LambdaUpdateWrapper<User> lqw = new LambdaUpdateWrapper<>();
        lqw.eq(StrUtil.isNotBlank(user.getAccount()),User::getAccount,user.getAccount()).or()
                .eq(StrUtil.isNotBlank(user.getPhone()),User::getPhone,user.getPhone()).or()
                .eq(StrUtil.isNotBlank(user.getUsername()),User::getUsername,user.getUsername());
        User one = userService.getOne(lqw);
        if (one==null){
            return Result.fail("用户不存在");
        }
        if (!PasswordEncoder.matches(one.getPassword(), user.getPassword())){
            return Result.fail("用户名或密码不正确");
        }
        if (one.getStatus()==0){
            return Result.success("该账号冻结，请联系管理员");
        }
        return Result.success(one,"登录成功");
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public Result selectOne(@PathVariable Serializable id) {
        return Result.success("功能未开发");
    }

    /**
     * 新增数据
     *
     * @param user 实体对象
     * @return 新增结果
     */
    @ApiImplicitParam(name = "新增接口",dataType = "User")
    @ApiOperation(value = "新增 和注册思路一样")
    @PostMapping(Urls.user.save)
    public Result insert(@RequestBody User user) {
        Result result = getResult(user);
        if (result!=null){
            return result;
        }
        // 保存用户信息
        userService.save(user);
        // 分配角色身份
        if (!userService.setRoleName(user.getFlag(),user.getId())){
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
    @ApiOperation(value = "修改接口",notes = "修改用户/管理员信息")
    @ApiImplicitParam(name = "User",dataType = "User",value = "修改接口")
    @PutMapping(Urls.user.update)
    public Result update(@RequestBody User user) {
        return userService.updateById(user)?Result.success("修改成功"):Result.fail("修改失败");
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @ApiOperation(value = "删除接口",notes = "可批量删除")
    @ApiImplicitParam(name = "idList",dataType = "List<String>",value = "可批量删除")
    @DeleteMapping
    public Result delete(@RequestParam("idList") List<String> idList) {
        return userService.removeBatchByIds(idList)&&userService.deleteUserRole(idList)?Result.success("删除成功"):Result.fail("删除失败");
    }
}
