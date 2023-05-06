package com.itheima.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.entity.Address;
import com.itheima.service.AddressService;
import com.itheima.entity.Result;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

import com.itheima.util.RegexUtils;
import com.itheima.util.Urls;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 收货地址(Address)表控制层
 *
 * @author WangFK
 * @since 2023-05-05 14:39:27
 */
@RestController
@Slf4j
@RequestMapping(Urls.address.baseUrl)
@Api(tags = "地址管理接口",description = "地址CRUD接口")
public class AddressController {
    /**
     * 服务对象
     */
    @Resource
    private AddressService addressService;
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "起始页数",dataType = "Long"),
            @ApiImplicitParam(name = "pageSize",value = "每页页数",dataType = "Long"),
            @ApiImplicitParam(name = "search",value = "查询条件 手机号/收货人",dataType = "String"),
    })
    @ApiOperation(value = "显示所有地址接口",notes = "显示地址接口")
    @GetMapping(Urls.address.getPageList)
    public Result getPageList(Long pageNum,Long pageSize,String search){
        Page<Address> addressPage = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<Address> lqw = new LambdaQueryWrapper<>();
        lqw.like(StrUtil.isNotBlank(search),Address::getConsignee,search).or()
                .like(StrUtil.isNotBlank(search),Address::getPhone,search)
                .orderByAsc(Address::getCreateTime).orderByDesc(Address::getUpdateTime);
        Page<Address> page = addressService.page(addressPage, lqw);
        if (page==null){
            return Result.fail("暂无信息");
        }
        return Result.success(page,"查询成功");
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
     * @param address 实体对象
     * @return 新增结果
     */
    @ApiImplicitParam(value = "新增接口",dataType = "Address")
    @ApiOperation(notes = "新增地址接口",value = "新增地址接口")
    @PostMapping(Urls.address.save)
    public Result insert(@RequestBody Address address) {
        Result result = getResult(address);
        if (result != null) {
            return result;
        }
        return addressService.save(address)?Result.success("新增成功"):Result.fail("新增失败");
    }

    private static Result getResult(Address address) {
        if (address.getUserId()==null){
            return Result.fail("user_id不能为空");
        }
        if (StrUtil.isBlank(address.getPhone())){
            return Result.fail("手机号不能为空");
        }
        if (!RegexUtils.isPhoneInvalid(address.getPhone())){
            return Result.fail("手机号格式不正确");
        }
        if (StrUtil.isBlank(address.getConsignee())){
            return Result.fail("收货人不能为空");
        }
        return null;
    }

    /**
     * 修改数据
     *
     * @param address 实体对象
     * @return 修改结果
     */
    @ApiOperation(notes = "修改接口",value = "修改接口")
    @ApiImplicitParam(name = "Address",dataType = "Address",value = "修改信息接口")
    @PutMapping(Urls.address.update)
    public Result update(@RequestBody Address address) {
        Result result = getResult(address);
        if (result != null) {
            return result;
        }
        return addressService.updateById(address)?Result.success("修改成功"): Result.fail("修改失败");
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @ApiImplicitParam(name = "idList",dataType = "List<String>",value = "删除ID集合")
    @ApiOperation(notes = "删除接口 ",value = "可批量删除")
    @DeleteMapping(Urls.address.delete)
    public Result delete(@RequestParam("idList") List<String> idList) {
        return addressService.removeByIds(idList)?Result.success("删除成功"): Result.fail("删除失败");
    }
}

