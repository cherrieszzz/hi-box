package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.entity.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * 收货地址(Address)表数据库访问层
 *
 * @author WangFK
 * @since 2023-05-05 14:35:22
 */
@Mapper
public interface AddressMapper extends BaseMapper<Address> {
    @Update("update address set flag=0 where user_id=#{userId}")
    int updateFlag0(Long userId);

    @Update("update address set flag=1 where id=#{id}")
    int updateFlag1(Long id);

    @Update("UPDATE address set province_name=#{provinceName} where id=#{id}")
    int Update(String provinceName, Long id);
}

