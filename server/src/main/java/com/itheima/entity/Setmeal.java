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
 * 套餐(Setmeal)表实体类
 *
 * @author WangFK
 * @since 2023-05-07 17:21:36
 */
@Data
@NoArgsConstructor
@ApiModel(value = "Setmeal对象", description = "套餐")
@TableName("setmeal")
public class Setmeal implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 商品分类id
     */
    @ApiModelProperty(value = "商品分类id")
    private Long categoryId;

    /**
     * 套餐名称
     */
    @ApiModelProperty(value = "套餐名称")
    private String name;

    /**
     * 套餐价格
     */
    @ApiModelProperty(value = "套餐价格")
    private Double price;

    /**
     * 状态 0:停用 1:启用
     */
    @ApiModelProperty(value = "状态 0:停用 1:启用")
    private Integer status;

    /**
     * 份数
     */
    @ApiModelProperty(value = "份数")
    private Long copies;

    /**
     * 描述信息
     */
    @ApiModelProperty(value = "描述信息")
    private String description;

    /**
     * 图片
     */
    @ApiModelProperty(value = "图片")
    private String image;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}

