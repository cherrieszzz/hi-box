package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.entity.Setmeal;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 套餐(Setmeal)表数据库访问层
 *
 * @author WangFK
 * @since 2023-05-05 14:35:24
 */
@Mapper
public interface SetmealMapper extends BaseMapper<Setmeal> {
    @Update("update setmeal set status=0 where id in (#{collect})")
    Integer updateStatus(List<Long> collect);

    @Delete("delete from setmeal_goods where goods_id in (#{collect})")
    boolean deleteSetmeal(List<Long> collect);

    @Delete("delete from setmeal_goods where setmeal_id in (#{collect})")
    boolean deleteSetmealBysetMealId(List<String> collect);

    @Insert("insert into setmeal_goods(setmeal_id,goods_id,name,price) values (#{setmealId},#{goodsId},#{name},#{price})")
    boolean insertSetMeal(Long setmealId, Long goodsId, String name, Double price);
}

