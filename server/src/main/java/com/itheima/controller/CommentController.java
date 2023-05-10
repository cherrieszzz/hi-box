package com.itheima.controller;


import cn.dev33.satoken.annotation.SaCheckRole;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dto.CommentDto;
import com.itheima.entity.Comment;
import com.itheima.service.CommentService;
import com.itheima.entity.Result;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

import com.itheima.util.Messages;
import com.itheima.util.Urls;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 商品评论(Comment)表控制层
 *
 * @author WangFK
 * @since 2023-05-05 14:39:27
 */
@RestController
@Slf4j
@RequestMapping(Urls.comment.baseUrl)
@Api(description = "评论CRUD接口",tags = "评论管理接口")
public class CommentController {
    /**
     * 服务对象
     */
    @Resource
    private CommentService commentService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public Result selectOne(@PathVariable Serializable id) {
        return Result.success("功能未开发");
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "起始页数",dataType = "Long"),
            @ApiImplicitParam(name = "pageSize",value = "每页页数",dataType = "Long")
    })
    @ApiOperation(value = "显示评论接口",notes = "显示评论接口")
    @GetMapping(Urls.comment.getPageList)
    @SaCheckRole(value = Messages.Role.Role_Business)
    public Result getPageList(Long pageNum,Long pageSize){
        Page<Comment> commentPage = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<Comment> lqw = new LambdaQueryWrapper<>();
        lqw.orderByAsc(Comment::getCreateTime).orderByDesc(Comment::getUpdateTime);
        Page<Comment> page = commentService.page(commentPage, lqw);
        if (page==null){
            return Result.fail("查无信息");
        }
        return Result.success(page,"查询成功");
    }
    /**
     * 新增数据
     *
     * @param comment 实体对象
     * @return 新增结果
     */
    @SaCheckRole(value = Messages.Role.Role_User)
    @ApiOperation(value = "新增评论接口",notes = "新增评论接口")
    @PostMapping(Urls.comment.save)
    public Result insert(@RequestBody CommentDto comment) {
        return commentService.setComment(comment)?Result.success("评论成功"): Result.fail("评论失败");
    }

    /**
     * 修改数据
     *
     * @param comment 实体对象
     * @return 修改结果
     */
    @PutMapping(Urls.comment.update)
    @SaCheckRole(value = Messages.Role.Role_User)
    @ApiOperation(value = "修改评论接口",notes = "修改评论接口")
    public Result update(@RequestBody Comment comment) {
        return commentService.updateById(comment)?Result.success("修改成功"):Result.fail("修改失败");
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @ApiOperation(value = "删除评论接口",notes = "批量删除评论接口")
    @SaCheckRole(value = Messages.Role.Role_User)
    @DeleteMapping(Urls.comment.delete)
    public Result delete(@RequestParam("idList") List<String> idList) {
        return commentService.removeByIds(idList)?Result.success("删除成功"): Result.fail("删除失败");
    }
}

