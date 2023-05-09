package com.itheima.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.service.CategoryService;
import com.itheima.dao.CategoryMapper;
import com.itheima.entity.Category;
import org.springframework.stereotype.Service;

/**
 * 商品分类(Category)表服务实现类
 *
 * @author WangFK
 * @since 2023-05-05 14:35:23
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
}

