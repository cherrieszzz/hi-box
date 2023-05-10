package com.itheima.dto;

import com.itheima.entity.Goods;
import com.itheima.entity.ShoppingCart;
import lombok.Data;

/**
 * 购物车Dto
 *
 * @author WangFK
 * @version 1.0
 * @since 2023/5/9 14:02
 */
@Data
public class ShoppingCartDto extends ShoppingCart {
     Goods goods;
}
