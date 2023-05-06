package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * 商品信息(Goods)表数据库访问层
 *
 * @author WangFK
 * @since 2023-05-05 14:35:22
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
    @Update("update goods set status=#{status} where id=#{id} ")
    boolean updateStatus(Integer status,Long id);
}

