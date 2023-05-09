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
 * 订单表(Orders)表实体类
 *
 * @author WangFK
 * @since 2023-05-09 09:42:00
 */
@Data
@NoArgsConstructor
@ApiModel(value = "Orders对象", description = "订单表")
@TableName("orders")
public class Orders implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 订单号
     */
    @ApiModelProperty(value = "订单号")
    private String number;

    /**
     * 订单状态 1待付款 2待接单 3已接单 4派送中 5已完成 6已取消 7退款
     */
    @ApiModelProperty(value = "订单状态 1待付款 2待接单 3已接单 4派送中 5已完成 6已取消 7退款")
    private Integer status;

    /**
     * 下单用户
     */
    @ApiModelProperty(value = "下单用户")
    private Long userId;

    /**
     * 商品id
     */
    @ApiModelProperty(value = "商品id")
    private Long goodsId;

    /**
     * 地址id
     */
    @ApiModelProperty(value = "地址id")
    private Long addressId;

    /**
     * 下单时间
     */
    @ApiModelProperty(value = "下单时间")
    private Date orderTime;

    /**
     * 结账时间
     */
    @ApiModelProperty(value = "结账时间")
    private Date checkoutTime;

    /**
     * 支付方式 1微信,2支付宝
     */
    @ApiModelProperty(value = "支付方式 1微信,2支付宝")
    private Integer payMethod;

    /**
     * 支付状态 0未支付 1已支付 2退款
     */
    @ApiModelProperty(value = "支付状态 0未支付 1已支付 2退款")
    private Integer payStatus;

    /**
     * 商品数量
     */
    @ApiModelProperty(value = "商品数量")
    private Long count;

    /**
     * 实收金额
     */
    @ApiModelProperty(value = "实收金额")
    private Double amount;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String phone;

    /**
     * 地址
     */
    @ApiModelProperty(value = "地址")
    private String address;

    /**
     * 用户名称
     */
    @ApiModelProperty(value = "用户名称")
    private String userName;

    /**
     * 收货人
     */
    @ApiModelProperty(value = "收货人")
    private String consignee;

    /**
     * 订单取消原因
     */
    @ApiModelProperty(value = "订单取消原因")
    private String cancelReason;

    /**
     * 订单拒绝原因
     */
    @ApiModelProperty(value = "订单拒绝原因")
    private String rejectionReason;

    /**
     * 订单取消时间
     */
    @ApiModelProperty(value = "订单取消时间")
    private Date cancelTime;

    /**
     * 预计送达时间
     */
    @ApiModelProperty(value = "预计送达时间")
    private Date estimatedDeliveryTime;

    /**
     * 配送状态  1立即送出  0选择具体时间
     */
    @ApiModelProperty(value = "配送状态  1立即送出  0选择具体时间")
    private Integer deliveryStatus;

    /**
     * 送达时间
     */
    @ApiModelProperty(value = "送达时间")
    private Date deliveryTime;

    /**
     * 打包费
     */
    @ApiModelProperty(value = "打包费")
    private Integer packAmount;

    /**
     * 餐具数量
     */
    @ApiModelProperty(value = "餐具数量")
    private Integer tablewareNumber;

    /**
     * 餐具数量状态  1按餐量提供  0选择具体数量
     */
    @ApiModelProperty(value = "餐具数量状态  1按餐量提供  0选择具体数量")
    private Integer tablewareStatus;

}

