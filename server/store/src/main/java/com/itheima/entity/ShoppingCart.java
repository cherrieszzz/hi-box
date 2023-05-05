package com.itheima.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.NoArgsConstructor;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 购物车(ShoppingCart)表实体类
 *
 * @author WangFK
 * @since 2023-05-05 14:35:24
 */
@Data
@NoArgsConstructor
@ApiModel(value = "ShoppingCart对象", description = "购物车")
@TableName("shopping_cart")
public class ShoppingCart implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 图片
     */
    @ApiModelProperty(value = "图片")
    private String image;

    /**
     * 用户主键
     */
    @ApiModelProperty(value = "用户主键")
    private Long userId;

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

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

}

