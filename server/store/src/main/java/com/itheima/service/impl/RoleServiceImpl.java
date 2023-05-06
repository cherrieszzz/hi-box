package com.itheima.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.service.RoleService;
import com.itheima.dao.RoleMapper;
import com.itheima.entity.Role;
import org.springframework.stereotype.Service;

/**
 * 角色信息(Role)表服务实现类
 *
 * @author WangFK
 * @since 2023-05-05 14:35:24
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
}

