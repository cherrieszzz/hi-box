package com.itheima.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.service.SetmealService;
import com.itheima.dao.SetmealMapper;
import com.itheima.entity.Setmeal;
import org.springframework.stereotype.Service;

/**
 * 套餐(Setmeal)表服务实现类
 *
 * @author WangFK
 * @since 2023-05-05 14:35:24
 */
@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {
}

