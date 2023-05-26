package com.itheima.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.dto.SetmealDto;
import com.itheima.service.SetmealService;
import com.itheima.dao.SetmealMapper;
import com.itheima.entity.Setmeal;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 套餐(Setmeal)表服务实现类
 *
 * @author WangFK
 * @since 2023-05-05 14:35:24
 */
@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {
    @Resource
    SetmealMapper setmealMapper;

    @Override
    public boolean updateStatus(List<Long> collect) {
        boolean flag = false;
        if (setmealMapper.updateStatus(collect) > 0) {
            flag = true;
        }
        return flag && setmealMapper.deleteSetmeal(collect);

    }

    @Override
    public boolean saveSetMeal(SetmealDto setmeal) {
        for (String s : setmeal.getImgList()) {
            setmealMapper.insertSetMeal(setmeal.getId(), Long.valueOf(s), setmeal.getName(), setmeal.getPrice());
        }
        return setmealMapper.insert(setmeal) > 0;
    }

    @Override
    public boolean removeSetmeal(List<String> idList) {
        boolean flag = false;
        if (setmealMapper.deleteBatchIds(idList) > 0) {
            flag = true;
        }
        return setmealMapper.deleteSetmealBysetMealId(idList) && flag;
    }
}

