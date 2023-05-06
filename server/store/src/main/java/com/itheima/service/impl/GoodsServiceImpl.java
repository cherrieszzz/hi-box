package com.itheima.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.service.GoodsService;
import com.itheima.dao.GoodsMapper;
import com.itheima.entity.Goods;
import org.springframework.stereotype.Service;

/**
 * 商品信息(Goods)表服务实现类
 *
 * @author WangFK
 * @since 2023-05-05 14:35:22
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
}

