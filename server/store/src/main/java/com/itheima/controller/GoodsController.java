package com.itheima.controller;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dto.GoodsDto;
import com.itheima.entity.Category;
import com.itheima.entity.Goods;
import com.itheima.service.CategoryService;
import com.itheima.service.GoodsService;
import com.itheima.entity.Result;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.itheima.util.Urls;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 商品信息(Goods)表控制层
 *
 * @author WangFK
 * @since 2023-05-05 14:39:27
 */
@RestController
@Slf4j
@RequestMapping(Urls.goods.baseUrl)
public class GoodsController {
    /**
     * 服务对象
     */
    @Resource
    private GoodsService goodsService;
    @Resource
    private CategoryService categoryService;

    @PostMapping(Urls.goods.updateStatus)
    @GetMapping(Urls.goods.getPageList)
    public Result getPageList(Long pageNum,Long pageSize,String search){
        Page<Goods> goodsPage = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<Goods> lqw = new LambdaQueryWrapper<>();
        lqw.like(StrUtil.isNotBlank(search),Goods::getName,search).or()
                .like(StrUtil.isNotBlank(search),Goods::getCategoryId,search)
                .orderByAsc(Goods::getCreateTime).orderByDesc(Goods::getUpdateTime);
        Page<Goods> page = goodsService.page(goodsPage, lqw);
        Page<GoodsDto> goodsDtoPage = new Page<>();
        if (page==null){
            return Result.fail("查无此信息");
        }
        BeanUtil.copyProperties(page,goodsDtoPage,"records");
        List<Goods> records = page.getRecords();
        ArrayList<GoodsDto> goodsDtos = new ArrayList<>();
        records.stream().forEach(item->{
            if (item.getInventory()<=0){
                return;
            }
            GoodsDto goodsDto = new GoodsDto();
            BeanUtil.copyProperties(item,goodsDto);
            Category byId = categoryService.getById(item.getCategoryId());
            goodsDto.setCategoryName(byId.getName());
            goodsDtos.add(goodsDto);
        });
        if (ObjectUtil.isEmpty(goodsDtos)){
            return Result.fail("查无此信息");
        }
        goodsDtoPage.setRecords(goodsDtos);
        return Result.success(goodsDtoPage,"信息查询成功");
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
     * @param goods 实体对象
     * @return 新增结果
     */
    @PostMapping(Urls.goods.save)
    public Result insert(@RequestBody Goods goods) {
        Result result = getResult(goods);
        if (result != null) {
            return result;
        }
        return goodsService.save(goods)?Result.success("添加商品成功"):Result.fail("添加商品失败");
    }

    private static Result getResult(Goods goods) {
        if (StrUtil.isBlank(goods.getName())){
            return Result.fail("商品名称不能为空");
        }
        if (StrUtil.isBlank(goods.getCategoryId())){
            return Result.fail("商品分类不能为空");
        }
        if (goods.getOriginalPrice()<0){
            return Result.fail("商品原价输入错误");
        }
        if (goods.getSellingPrice()<0){
            return Result.fail("商品售价输入错误");
        }
        return null;
    }

    /**
     * 修改数据
     *
     * @param goods 实体对象
     * @return 修改结果
     */
    @PutMapping
    public Result update(@RequestBody Goods goods) {
        return Result.success("功能未开发");
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public Result delete(@RequestParam("idList") List<Long> idList) {
        return Result.success("功能未开发");
    }
}

