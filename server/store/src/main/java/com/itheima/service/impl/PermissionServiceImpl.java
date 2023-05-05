package com.itheima.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.service.PermissionService;
import com.itheima.dao.PermissionMapper;
import com.itheima.entity.Permission;
import org.springframework.stereotype.Service;

/**
 * 权限信息(Permission)表服务实现类
 *
 * @author WangFK
 * @since 2023-05-05 14:35:24
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
}

