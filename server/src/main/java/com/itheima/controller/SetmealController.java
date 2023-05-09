package com.itheima.controller;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dto.SetmealDto;
import com.itheima.entity.Category;
import com.itheima.entity.Goods;
import com.itheima.entity.Setmeal;
import com.itheima.service.CategoryService;
import com.itheima.service.GoodsService;
import com.itheima.service.SetmealService;
import com.itheima.entity.Result;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.itheima.util.Urls;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 套餐(Setmeal)表控制层
 *
 * @author WangFK
 * @since 2023-05-05 14:39:28
 */
@RestController
@Slf4j
@RequestMapping(Urls.setMeal.baseUrl)
public class SetmealController {
    /**
     * 服务对象
     */
    @Resource
    private SetmealService setmealService;
    @Resource
    private CategoryService categoryService;
    @Resource
    private GoodsService goodsService;

    @GetMapping(Urls.setMeal.updateStatus)
    public Result updateStatus(String id){
        Setmeal byId = setmealService.getById(id);
        if (byId.getStatus()==1){
            byId.setStatus(0);
        }else {
            byId.setStatus(1);
        }
        return setmealService.updateById(byId)?Result.success("状态修改成功"): Result.fail("状态修改失败");
    }
    @GetMapping(Urls.setMeal.getPageList)
    public Result getPageList(Long pageNum,Long pageSize,String categoryId,String name,String status){
        Page<Setmeal> setmealPage = new Page<>(pageNum, pageSize);
        LambdaUpdateWrapper<Setmeal> lqw = new LambdaUpdateWrapper<>();
        lqw.eq(StrUtil.isNotBlank(categoryId),Setmeal::getCategoryId,categoryId)
                .eq(StrUtil.isNotBlank(status),Setmeal::getStatus,status)
                .like(StrUtil.isNotBlank(name),Setmeal::getName,name);
        Page<Setmeal> page = setmealService.page(setmealPage, lqw);
        if (page==null){
            return Result.fail("查无此信息");
        }
        Page<SetmealDto> setmealDtoPage = new Page<>();
        BeanUtil.copyProperties(page,setmealDtoPage,"records");
        List<SetmealDto> setmealDtos = new ArrayList<>();
        List<Setmeal> records = page.getRecords();
        records.stream().forEach(item->{
            SetmealDto setmealDto = new SetmealDto();
            BeanUtil.copyProperties(item,setmealDto);
            Category byId = categoryService.getById(item.getCategoryId());
            setmealDto.setCategoryName(byId.getName());
            setmealDtos.add(setmealDto);
        });
        setmealDtoPage.setRecords(setmealDtos);
        setmealDtoPage.setTotal(setmealDtos.size());
        return Result.success(setmealDtoPage,"查询信息成功");
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
    @GetMapping(Urls.setMeal.getGoodsByCategoryId)
    public Result getGoodsByCategoryId(String categoryId){
        LambdaUpdateWrapper<Goods> lqw = new LambdaUpdateWrapper<>();
        lqw.eq(StrUtil.isNotBlank(categoryId),Goods::getCategoryId,categoryId)
                .eq(Goods::getStatus,"1").gt(Goods::getInventory,"0")
                .orderByAsc(Goods::getCreateTime).orderByDesc(Goods::getUpdateTime);
        List<Goods> list = goodsService.list(lqw);
        if (list.isEmpty()){
            return Result.fail("该分类下无商品");
        }
        return Result.success(list,"商品信息如下");
    }
    /**
     * 新增数据
     *
     * @param setmeal 实体对象
     * @return 新增结果
     */
    @PostMapping(Urls.setMeal.save)
    public Result insert(@RequestBody SetmealDto setmeal) {
        if (setmeal.getCategoryId()==null){
            return Result.fail("套餐分类不能为空");
        }
        if (StrUtil.isBlank(setmeal.getName())){
            return Result.fail("套餐名不能为空");
        }
        if (setmeal.getPrice()==null){
            return Result.fail("套餐价格不能为空");
        }
        if (setmeal.getImage()==null&&setmeal.getImgList()==null){
            return Result.fail("套餐图片至少有一张");
        }
        //实际金额
        Double goodsPriceSum= 0D;
        List<Goods> goodsList = goodsService.listByIds(setmeal.getGoodsList());
        List<Double> collect = goodsList.stream().map(Goods::getSellingPrice).collect(Collectors.toList());
        for (Double price : collect) {
            goodsPriceSum+=price;
        }
        if (setmeal.getPrice()>goodsPriceSum+50){
            return Result.fail("套餐价格涨幅太大+50");
        }
        // 系统自动分配 套餐数量 套餐中只要有一个商品数量为空 下架改套餐
        // 找到商品 库存最少
        Long min = goodsList.get(0).getInventory();
        for (Goods goods : goodsList) {
                if (goods.getInventory()<min){
                    min=goods.getInventory();
                }
        }
        setmeal.setCopies(min);
        return setmealService.saveSetMeal(setmeal)?Result.success("新增套餐成功"):Result.fail("新增套餐失败");
    }

    /**
     * 修改数据
     *
     * @param setmeal 实体对象
     * @return 修改结果
     */
    @PutMapping
    public Result update(@RequestBody Setmeal setmeal) {
        return Result.success("功能未开发");
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping(Urls.setMeal.delete)
    public Result delete(@RequestParam("idList") List<String> idList) {
        return setmealService.removeSetmeal(idList)?Result.success("删除成功"): Result.fail("删除失败");
    }
}

