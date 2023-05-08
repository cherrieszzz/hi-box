package com.itheima.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.service.AddressService;
import com.itheima.dao.AddressMapper;
import com.itheima.entity.Address;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 收货地址(Address)表服务实现类
 *
 * @author WangFK
 * @since 2023-05-05 14:35:23
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {
    @Resource
    AddressMapper addressMapper;
    @Override
    public boolean updateFlag(Long id, Long userId) {
        return addressMapper.updateFlag0(userId)>0&&addressMapper.updateFlag1(id)>0;

    }
}

