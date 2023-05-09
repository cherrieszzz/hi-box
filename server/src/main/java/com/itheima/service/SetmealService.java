package com.itheima.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.dto.SetmealDto;
import com.itheima.entity.Setmeal;

import java.util.List;

/**
 * 套餐(Setmeal)表服务接口
 *
 * @author WangFK
 * @since 2023-05-05 14:35:24
 */
public interface SetmealService extends IService<Setmeal> {
    boolean updateStatus(List<Long> collect);

    boolean saveSetMeal(SetmealDto setmeal);

    boolean removeSetmeal(List<String> idList);

}

