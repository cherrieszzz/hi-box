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
 * 商品信息(Goods)表实体类
 *
 * @author WangFK
 * @since 2023-05-05 14:35:22
 */
@Data
@NoArgsConstructor
@ApiModel(value = "Goods对象", description = "商品信息")
@TableName("goods")
public class Goods implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 商品编号
     */
    @ApiModelProperty(value = "商品编号")
    private Long id;

    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称")
    private String name;

    /**
     * 商品分类
     */
    @ApiModelProperty(value = "商品分类")
    private String categoryId;

    /**
     * 商品描述
     */
    @ApiModelProperty(value = "商品描述")
    private String description;

    /**
     * 原价
     */
    @ApiModelProperty(value = "原价")
    private Double originalPrice;

    /**
     * 售价
     */
    @ApiModelProperty(value = "售价")
    private Double sellingPrice;

    /**
     * 商品图片，可能有多个，若有多张，，分割
     */
    @ApiModelProperty(value = "商品图片，可能有多个，若有多张，，分割")
    private String img;

    /**
     * 库存
     */
    @ApiModelProperty(value = "库存")
    private Long inventory;

    /**
     * 状态：1：上架 0：下架
     */
    @ApiModelProperty(value = "状态：1：上架 0：下架")
    private Integer status;


    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;


}

