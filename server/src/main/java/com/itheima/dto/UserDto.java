package com.itheima.dto;

import com.itheima.entity.User;
import lombok.Data;

import java.util.List;

/**
 * 用户信息显示
 *
 * @author WangFK
 * @version 1.0
 * @since 2023/5/5 18:53
 */
@Data
public class UserDto extends User {
        String roleName;
}
