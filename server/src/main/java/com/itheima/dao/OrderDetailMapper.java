package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单明细表(OrderDetail)表数据库访问层
 *
 * @author WangFK
 * @since 2023-05-05 14:35:23
 */
@Mapper
public interface OrderDetailMapper extends BaseMapper<OrderDetail> {
}

