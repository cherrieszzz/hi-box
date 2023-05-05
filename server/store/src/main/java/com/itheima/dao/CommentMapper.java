package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评论(Comment)表数据库访问层
 *
 * @author WangFK
 * @since 2023-05-05 14:35:23
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
}

