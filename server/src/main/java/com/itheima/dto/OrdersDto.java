package com.itheima.dto;

import com.itheima.entity.Orders;
import lombok.Data;

/**
 * 订单Dto 废弃
 *
 * @author WangFK
 * @version 1.0
 * @since 2023/5/9 8:51
 */
@Data
public class OrdersDto extends Orders {
    Long goodsId;
    Long count;
}
