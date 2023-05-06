package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.entity.Role;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色信息(Role)表数据库访问层
 *
 * @author WangFK
 * @since 2023-05-05 14:35:24
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
}

