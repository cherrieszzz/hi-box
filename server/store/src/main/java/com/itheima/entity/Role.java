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
 * 角色信息(Role)表实体类
 *
 * @author WangFK
 * @since 2023-05-05 14:35:24
 */
@Data
@NoArgsConstructor
@ApiModel(value = "Role对象", description = "角色信息")
@TableName("role")
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 角色类型
     */
    @ApiModelProperty(value = "角色类型")
    private String type;

    /**
     * 标识
     */
    @ApiModelProperty(value = "标识")
    private String keyword;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String description;

    /**
     * 状态 1：启用 0禁用
     */
    @ApiModelProperty(value = "状态 1：启用 0禁用")
    private Integer status;

    /**
     * 最新更新时间
     */
    @ApiModelProperty(value = "最新更新时间")
    private Date updateTime;


}

