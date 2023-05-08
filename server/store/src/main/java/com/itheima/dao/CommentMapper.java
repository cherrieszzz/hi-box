package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.dto.CommentDto;
import com.itheima.entity.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 商品评论(Comment)表数据库访问层
 *
 * @author WangFK
 * @since 2023-05-05 14:35:23
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
    @Insert("insert into goods_comment values (#{userId},#{commentId})")
    boolean setComment(Long userId,Long commentId);
    @Delete("delete from goods_comment where user_id in (#{idList})")
    boolean removeComment(List<String> idList);
}

