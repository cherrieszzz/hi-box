package com.itheima.controller;


import com.itheima.entity.Orders;
import com.itheima.service.OrdersService;
import com.itheima.entity.Result;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

import com.itheima.util.Urls;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 订单表(Orders)表控制层
 *
 * @author WangFK
 * @since 2023-05-05 14:39:28
 */
@RestController
@Slf4j
@RequestMapping(Urls.orders.baseUrl)
public class OrdersController {
    /**
     * 服务对象
     */
    @Resource
    private OrdersService ordersService;

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
     * @param orders 实体对象
     * @return 新增结果
     */
    @PostMapping
    public Result insert(@RequestBody Orders orders) {
        return Result.success("功能未开发");
    }

    /**
     * 修改数据
     *
     * @param orders 实体对象
     * @return 修改结果
     */
    @PutMapping
    public Result update(@RequestBody Orders orders) {
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

