package com.itheima.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.dto.CommentDto;
import com.itheima.service.CommentService;
import com.itheima.dao.CommentMapper;
import com.itheima.entity.Comment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 商品评论(Comment)表服务实现类
 *
 * @author WangFK
 * @since 2023-05-05 14:35:23
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Resource
    private CommentMapper commentMapper;

    @Override
    public boolean setComment(CommentDto commentDto) {
        boolean flag = false;
        if (commentMapper.insert(commentDto) > 0) {
            flag = true;
        }

        return flag && commentMapper.setComment(commentDto.getGoodsId(), commentDto.getId());
    }


}

