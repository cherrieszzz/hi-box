package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户信息(User)表数据库访问层
 *
 * @author WangFK
 * @since 2023-05-05 14:35:24
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select id from role where keyword=(case #{flag} when 1 then 'ROLE_BUSINESS' when 2 then 'ROLE_ADMIN' when 3 then 'ROLE_SUPER_ADMIN' else 'ROLE_USER' end )")
    Long getRoleIdByName(Integer flag);
    @Select("select type from role where keyword=(case #{flag} when 1 then 'ROLE_BUSINESS' when 2 then 'ROLE_ADMIN' when 3 then 'ROLE_SUPER_ADMIN' else 'ROLE_USER' end )")
    String getRoleName(Integer flag);
    @Insert("insert into user_role values (#{userId},#{roleId})")
    boolean setRoleName(Long userId,Long roleId);
    @Delete("delete from user_role where user_id in (#{idList})")
    boolean deleteUserRole(List<String> idList);
}

