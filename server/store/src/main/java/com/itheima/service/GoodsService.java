package com.itheima.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.entity.Goods;

/**
 * 商品信息(Goods)表服务接口
 *
 * @author WangFK
 * @since 2023-05-05 14:35:22
 */
public interface GoodsService extends IService<Goods> {
    boolean updateStatus(Integer status,Long id);

}

