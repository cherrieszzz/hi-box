package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 角色信息(Role)表数据库访问层
 *
 * @author WangFK
 * @since 2023-05-05 14:35:24
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    @Select("select if(t2.status=1,t2.keyword,NULL) roleName from user_role t1 join role t2 on t1.role_id=t2.id where t1.user_id=#{userId}")
    String getRoleName(String userId);
}

