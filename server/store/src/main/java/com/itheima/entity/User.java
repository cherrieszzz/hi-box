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
 * 用户信息(User)表实体类
 *
 * @author WangFK
 * @since 2023-05-05 14:35:24
 */
@Data
@NoArgsConstructor
@ApiModel(value = "User对象", description = "用户信息")
@TableName("user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    private String avatar;

    /**
     * 账号，默认分配
     */
    @ApiModelProperty(value = "账号，默认分配")
    private String account;

    /**
     * 昵称：未指定默认账号
     */
    @ApiModelProperty(value = "昵称：未指定默认账号")
    private String username;

    /**
     * 密码：未指定默认密码
     */
    @ApiModelProperty(value = "密码：未指定默认密码")
    private String password;

    /**
     * 性别：1：男 2：女 0：保密
     */
    @ApiModelProperty(value = "性别：1：男 2：女 0：保密")
    private Integer sex;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String phone;

    /**
     * 出生日期
     */
    @ApiModelProperty(value = "出生日期")
    private Date birthTime;

    /**
     * 注册时间
     */
    @ApiModelProperty(value = "注册时间")
    private Date createTime;

    /**
     * 个人信息更新时间
     */
    @ApiModelProperty(value = "个人信息更新时间")
    private Date updateTime;

    /**
     * 状态：1可用 0冻结
     */
    @ApiModelProperty(value = "状态：1可用 0冻结")
    private Integer status;

    /**
     * 浏览记录,多个逗号隔开
     */
    @ApiModelProperty(value = "浏览记录,多个逗号隔开")
    private String goodsIdBrowse;


    /**
     * 商品收藏,多个逗号隔开
     */
    @ApiModelProperty(value = "商品收藏,多个逗号隔开")
    private String goodsIdFavorite;

    /**
     * 1：商家 0：用户 2：管理员 3：超级管理员
     */
    @ApiModelProperty(value = "1：商家 0：用户 2：管理员 3：超级管理员")
    private Integer flag;

}

