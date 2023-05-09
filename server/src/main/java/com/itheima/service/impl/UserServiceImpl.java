package com.itheima.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.service.UserService;
import com.itheima.dao.UserMapper;
import com.itheima.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户信息(User)表服务实现类
 *
 * @author WangFK
 * @since 2023-05-05 14:35:24
 */
@Service
 public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public boolean setRoleName(Integer flag, Long userId) {
        Long roleId = userMapper.getRoleIdByName(flag);
        return userMapper.setRoleName(userId,roleId);
    }

    @Override
    public String getRoleName(Integer flag) {
        return userMapper.getRoleName(flag);
    }

    @Override
    public boolean deleteUserRole(List<String> idList) {
        return userMapper.deleteUserRole(idList);
    }
}

