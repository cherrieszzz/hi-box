package com.itheima.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.entity.User;

import java.util.List;

/**
 * 用户信息(User)表服务接口
 *
 * @author WangFK
 * @since 2023-05-05 14:35:24
 */
public interface UserService extends IService<User> {
    boolean setRoleName(Integer flag, Long userId);

    String getRoleName(Integer flag);

    boolean deleteUserRole(List<String> idList);

}

