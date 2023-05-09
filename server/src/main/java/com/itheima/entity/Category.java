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
 * 商品分类(Category)表实体类
 *
 * @author WangFK
 * @since 2023-05-05 14:35:23
 */
@Data
@NoArgsConstructor
@ApiModel(value = "Category对象", description = "商品分类")
@TableName("category")
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 商品分类
     */
    @ApiModelProperty(value = "商品分类")
    private String name;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private String sort;

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

