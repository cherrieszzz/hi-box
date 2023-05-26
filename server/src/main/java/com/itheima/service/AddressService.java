package com.itheima.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.entity.Address;

/**
 * 收货地址(Address)表服务接口
 *
 * @author WangFK
 * @since 2023-05-05 14:35:23
 */
public interface AddressService extends IService<Address> {
    boolean updateFlag(Long id, Long userId);

}

