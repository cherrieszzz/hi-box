package com.itheima.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.service.ShoppingCartService;
import com.itheima.dao.ShoppingCartMapper;
import com.itheima.entity.ShoppingCart;
import org.springframework.stereotype.Service;

/**
 * 购物车(ShoppingCart)表服务实现类
 *
 * @author WangFK
 * @since 2023-05-05 14:35:24
 */
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {
}

