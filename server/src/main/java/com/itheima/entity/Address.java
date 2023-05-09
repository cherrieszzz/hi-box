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
 * 收货地址(Address)表实体类
 *
 * @author WangFK
 * @since 2023-05-05 14:35:22
 */
@Data
@NoArgsConstructor
@ApiModel(value = "Address对象", description = "收货地址")
@TableName("address")
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Long userId;

    /**
     * 收货人
     */
    @ApiModelProperty(value = "收货人")
    private String consignee;

    /**
     * 省级名称：eg：河南省
     */
    @ApiModelProperty(value = "省级名称：eg：河南省")
    private String provinceName;

    /**
     * 市级名称：eg：郑州市
     */
    @ApiModelProperty(value = "市级名称：eg：郑州市")
    private String cityName;

    /**
     * 区级名称：eg：中原区
     */
    @ApiModelProperty(value = "区级名称：eg：中原区")
    private String districtName;

    /**
     * 详细地址
     */
    @ApiModelProperty(value = "详细地址")
    private String detail;

    /**
     * 标签：家，公司，学校
     */
    @ApiModelProperty(value = "标签：家，公司，学校")
    private String label;

    /**
     * 收获手机号
     */
    @ApiModelProperty(value = "收获手机号")
    private String phone;

    /**
     * 默认收获地址 1：默认 0：多个
     */
    @ApiModelProperty(value = "默认收获地址 1：默认 0：多个")
    private Integer flag;

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

