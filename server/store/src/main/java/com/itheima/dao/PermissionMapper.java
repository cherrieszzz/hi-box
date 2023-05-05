package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.entity.Permission;
import org.apache.ibatis.annotations.Mapper;

/**
 * 权限信息(Permission)表数据库访问层
 *
 * @author WangFK
 * @since 2023-05-05 14:35:24
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {
}

