package com.itheima.dto;

import com.itheima.entity.Goods;
import lombok.Data;

import java.util.List;

/**
 * 商品dto
 *
 * @author WangFK
 * @version 1.0
 * @since 2023/5/6 14:18
 */
@Data
public class GoodsDto extends Goods {
    public String categoryName;
    List<String>imgList;
}
