package com.itheima.controller;


import com.itheima.entity.Address;
import com.itheima.service.AddressService;
import com.itheima.entity.Result;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

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
@RequestMapping("/address")
public class AddressController {
    /**
     * 服务对象
     */
    @Resource
    private AddressService addressService;

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
    @PostMapping
    public Result insert(@RequestBody Address address) {
        return Result.success("功能未开发");
    }

    /**
     * 修改数据
     *
     * @param address 实体对象
     * @return 修改结果
     */
    @PutMapping
    public Result update(@RequestBody Address address) {
        return Result.success("功能未开发");
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public Result delete(@RequestParam("idList") List<Long> idList) {
        return Result.success("功能未开发");
    }
}

