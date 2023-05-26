package com.itheima.service.impl;

import cn.dev33.satoken.stp.StpInterface;
import cn.hutool.core.util.ObjectUtil;
import com.itheima.dao.RoleMapper;
import com.itheima.entity.Role;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 权限
 *
 * @author WangFK
 * @version 1.0
 * @since 2023/5/10 8:13
 */
@Component
public class StpInterfaceImpl implements StpInterface {
    @Resource
    private RoleMapper roleMapper;
    /**
     * 返回一个账号所拥有的权限码集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        // 本list仅做模拟，实际项目中要根据具体业务逻辑来查询权限
        List<String> list = new ArrayList<String>();
        list.add("101");
        list.add("user.add");
        list.add("user.update");
        list.add("user.get");
        // list.add("user.delete");
        list.add("art.*");
        return list;
    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        // 本list仅做模拟，实际项目中要根据具体业务逻辑来查询角色
        List<String> list = new ArrayList<String>();
        String roleName = roleMapper.getRoleName(loginId.toString());
        list.add(roleName);
        return list;
    }

}
