package com.itheima.controller;


import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.entity.Category;
import com.itheima.exception.BusinessException;
import com.itheima.service.CategoryService;
import com.itheima.entity.Result;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Stream;

import com.itheima.util.Messages;
import com.itheima.util.Urls;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 商品分类(Category)表控制层
 *
 * @author WangFK
 * @since 2023-05-05 14:39:27
 */
@RestController
@Slf4j
@RequestMapping(Urls.category.baseUrl)
@Api(tags = "分类管理相关接口",description = "分类CRUD接口")
public class CategoryController {
    /**
     * 服务对象
     */
    @Resource
    private CategoryService categoryService;
    @SaCheckRole(value = {Messages.Role.Role_Business,Messages.Role.Role_User},mode = SaMode.OR)
    @ApiOperation(value = "获取分类接口",notes = "获取分类信息")
    @GetMapping(Urls.category.getList)
    public Result getList(){
        // Stream<String> categoryName = categoryService.list().stream().map(Category::getName);
        LambdaQueryWrapper<Category> lqw = new LambdaQueryWrapper<>();
        lqw.orderByAsc(Category::getCreateTime).orderByDesc(Category::getUpdateTime).orderByAsc(Category::getSort);
        List<Category> list = categoryService.list();
        if (ObjectUtil.isEmpty(list)){
            return Result.fail("暂无此信息");
        }
        return Result.success(list,"获取分类成功");
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "起始页",dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize",value = "每页显示页数",dataType = "Integer"),
            @ApiImplicitParam(name = "name",value = "查询条件 ",dataType = "String"),
    })
    @ApiOperation(value = "商品分类信息显示接口")
    @SaCheckRole(value = Messages.Role.Role_Business)
    @GetMapping(Urls.category.getPageList)
    public Result getPageList(Long pageNum,Long pageSize,String name){
        Page<Category> categoryPage = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<Category> lqw = new LambdaQueryWrapper<>();
        lqw.like(StrUtil.isNotBlank(name),Category::getName,name)
                .orderByAsc(Category::getSort)
                .orderByDesc(Category::getUpdateTime)
                .orderByAsc(Category::getCreateTime);
        Page<Category> page = categoryService.page(categoryPage, lqw);
        return page!=null?Result.success(page,"查询分类成功"): Result.fail("查无此人");
    }
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

    /**
     * 新增数据
     *
     * @param category 实体对象
     * @return 新增结果
     */
    @ApiOperation(value = "新增接口")
    @ApiImplicitParam(name = "Category",value = "新增接口",dataType = "Category")
    @SaCheckRole(value = Messages.Role.Role_Business)
    @PostMapping(Urls.category.save)
    public Result insert(@RequestBody Category category) {
        if (StrUtil.isBlank(category.getName())){
            return Result.fail("分类名不能为空");
        }
        LambdaUpdateWrapper<Category> lqw = new LambdaUpdateWrapper<>();
        lqw.eq(Category::getName,category.getName());
        if (!ObjectUtil.isEmpty(categoryService.list(lqw))){
            return Result.fail("该分类已存在:"+category.getName());
        }


        return categoryService.save(category)?Result.success("分类新增成功"):Result.fail("未知错误");
    }

    /**
     * 修改数据
     *
     * @param category 实体对象
     * @return 修改结果
     */
    @ApiOperation(value = "修改接口")
    @ApiImplicitParam(name = "Category",value = "新增分类接口",dataType = "Category")
    @PutMapping(Urls.category.update)
    @SaCheckRole(value = Messages.Role.Role_Business)
    public Result update(@RequestBody Category category) {
        if (StrUtil.isBlank(category.getName())){
            return Result.fail("分类名不能为空");
        }
        return categoryService.updateById(category)?Result.success("修改成功"):Result.fail("修改失败");
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @ApiOperation(value = "删除接口",notes = "可批量删除")
    @ApiImplicitParam(name = "idList",value = "删除分类接口",dataType = "List<String>")
    @DeleteMapping(Urls.category.delete)
    @SaCheckRole(value = Messages.Role.Role_Business)
    public Result delete(@RequestBody List<Long> idList) {
        return categoryService.removeBatchByIds(idList)? Result.success("删除成功"): Result.fail("删除失败");
    }
}

