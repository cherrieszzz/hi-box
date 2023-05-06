package com.itheima.controller;


import com.itheima.entity.Permission;
import com.itheima.service.PermissionService;
import com.itheima.entity.Result;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 权限信息(Permission)表控制层
 *
 * @author WangFK
 * @since 2023-05-05 14:39:28
 */
@RestController
@Slf4j
@RequestMapping("/permission")
public class PermissionController {
    /**
     * 服务对象
     */
    @Resource
    private PermissionService permissionService;

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
     * @param permission 实体对象
     * @return 新增结果
     */
    @PostMapping
    public Result insert(@RequestBody Permission permission) {
        return Result.success("功能未开发");
    }

    /**
     * 修改数据
     *
     * @param permission 实体对象
     * @return 修改结果
     */
    @PutMapping
    public Result update(@RequestBody Permission permission) {
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

