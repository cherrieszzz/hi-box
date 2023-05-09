package com.itheima.dto;

import com.itheima.entity.Comment;
import lombok.Data;

/**
 * 商品评论dto
 *
 * @author WangFK
 * @version 1.0
 * @since 2023/5/6 15:21
 */
@Data
public class CommentDto extends Comment {
    Long goodsId;
}
