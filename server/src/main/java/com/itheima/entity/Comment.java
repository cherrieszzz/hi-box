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
 * 商品评论(Comment)表实体类
 *
 * @author WangFK
 * @since 2023-05-06 09:13:07
 */
@Data
@NoArgsConstructor
@ApiModel(value = "Comment对象", description = "商品评论")
@TableName("comment")
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 评论图片，多个用逗号隔开
     */
    @ApiModelProperty(value = "评论图片，多个用逗号隔开")
    private String img;

    /**
     * 评论时间
     */
    @ApiModelProperty(value = "评论时间")
    private Date createTime;

    /**
     * 评论修改时间
     */
    @ApiModelProperty(value = "评论修改时间")
    private Date updateTime;

    /**
     * 评论人
     */
    @ApiModelProperty(value = "评论人")
    private String createUser;

    /**
     * 评论内容
     */
    @ApiModelProperty(value = "评论内容")
    private String description;

}

