package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单表(Orders)表数据库访问层
 *
 * @author WangFK
 * @since 2023-05-05 14:35:23
 */
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {
}

