package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.entity.Setmeal;
import org.apache.ibatis.annotations.Mapper;

/**
 * 套餐(Setmeal)表数据库访问层
 *
 * @author WangFK
 * @since 2023-05-05 14:35:24
 */
@Mapper
public interface SetmealMapper extends BaseMapper<Setmeal> {
}

