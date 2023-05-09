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
 * 权限信息(Permission)表实体类
 *
 * @author WangFK
 * @since 2023-05-05 14:35:24
 */
@Data
@NoArgsConstructor
@ApiModel(value = "Permission对象", description = "权限信息")
@TableName("permission")
public class Permission implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 权限类型
     */
    @ApiModelProperty(value = "权限类型")
    private String type;

    private String keyword;

    private String description;

}

