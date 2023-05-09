package com.itheima.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.NoArgsConstructor;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 订单明细表(OrderDetail)表实体类
 *
 * @author WangFK
 * @since 2023-05-05 14:35:23
 */
@Data
@NoArgsConstructor
@ApiModel(value = "OrderDetail对象", description = "订单明细表")
@TableName("order_detail")
public class OrderDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 名字
     */
    @ApiModelProperty(value = "名字")
    private String name;

    /**
     * 图片
     */
    @ApiModelProperty(value = "图片")
    private String img;

    /**
     * 订单id
     */
    @ApiModelProperty(value = "订单id")
    private Long orderId;

    /**
     * 商品id
     */
    @ApiModelProperty(value = "商品id")
    private Long goodsId;

    /**
     * 套餐id
     */
    @ApiModelProperty(value = "套餐id")
    private Long setmealId;

    /**
     * 数量
     */
    @ApiModelProperty(value = "数量")
    private Integer number;

    /**
     * 金额
     */
    @ApiModelProperty(value = "金额")
    private Double amount;

}

