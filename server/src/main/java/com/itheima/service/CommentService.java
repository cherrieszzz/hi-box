package com.itheima.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.dto.CommentDto;
import com.itheima.entity.Comment;

/**
 * 商品评论(Comment)表服务接口
 *
 * @author WangFK
 * @since 2023-05-05 14:35:23
 */
public interface CommentService extends IService<Comment> {
    boolean setComment(CommentDto commentDto);

}

