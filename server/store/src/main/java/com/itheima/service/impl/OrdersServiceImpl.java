package com.itheima.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.service.OrdersService;
import com.itheima.dao.OrdersMapper;
import com.itheima.entity.Orders;
import org.springframework.stereotype.Service;

/**
 * 订单表(Orders)表服务实现类
 *
 * @author WangFK
 * @since 2023-05-05 14:35:24
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {
}

