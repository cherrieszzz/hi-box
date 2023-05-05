package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.entity.Category;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品分类(Category)表数据库访问层
 *
 * @author WangFK
 * @since 2023-05-05 14:35:23
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}

