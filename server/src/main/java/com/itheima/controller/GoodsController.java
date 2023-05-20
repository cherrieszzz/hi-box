package com.itheima.controller;


import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.annotation.SaMode;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dto.CommentDto;
import com.itheima.dto.GoodsDto;
import com.itheima.entity.*;
import com.itheima.exception.BusinessException;
import com.itheima.service.CategoryService;
import com.itheima.service.CommentService;
import com.itheima.service.GoodsService;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.itheima.service.SetmealService;
import com.itheima.util.Messages;
import com.itheima.util.QiniuUtils;
import com.itheima.util.Urls;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    private QiniuUtils QiniuUtils;
    @Resource
    private GoodsService goodsService;
    @Resource
    private CategoryService categoryService;
    @Resource
    private CommentService commentService;
    @Resource
    private SetmealService setmealService;

    @PostMapping(Urls.goods.upload)
    @SaIgnore
    Result Upload(@RequestBody MultipartFile imgFile) {
        //文件全名  eg：7d104dd7-15cd-42c5-9a85-b60ea6f423c2.jpg
        String originalFilename = imgFile.getOriginalFilename();
        //获取后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        //随机文件名 + 后缀
        String fileName = UUID.randomUUID().toString() + suffix;
        //七牛云工具类 字节上传
        try {
            QiniuUtils.upload2Qiniu(imgFile.getBytes(), fileName);
            return Result.success(fileName, "上传成功");
        } catch (IOException e) {
            throw new BusinessException("上传失败");
        }
    }

    @PostMapping(Urls.goods.setComment)
    public Result setComment(@RequestBody CommentDto commentDto) {
        return commentService.setComment(commentDto) ? Result.success("设置评论成功") : Result.fail("设置评论失败");
    }

    @SaCheckRole(value = Messages.Role.Role_Business)
    @GetMapping(Urls.goods.updateStatus)
    public Result updateStatus(Long id) {
        Goods one = goodsService.getById(id);
        if (one.getStatus() == 1) {
            one.setStatus(0);
        } else {
            one.setStatus(1);
        }
        return goodsService.updateById(one) ? Result.success("修改状态成功") : Result.fail("修改状态失败");
    }

    @GetMapping(Urls.goods.getPageList)
    @SaCheckRole(value = Messages.Role.Role_Business)
    public Result getPageList(Long pageNum, Long pageSize, String name, String status, String categoryId) {
        Page<Goods> goodsPage = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<Goods> lqw = new LambdaQueryWrapper<>();
        lqw.like(StrUtil.isNotBlank(name), Goods::getName, name)
                .eq(StrUtil.isNotBlank(categoryId), Goods::getCategoryId, categoryId)
                .eq(StrUtil.isNotBlank(status), Goods::getStatus, status)
                .gt(Goods::getInventory, 0)
                .orderByAsc(Goods::getCreateTime).orderByDesc(Goods::getUpdateTime);
        Page<Goods> page = goodsService.page(goodsPage, lqw);
        Page<GoodsDto> goodsDtoPage = new Page<>();
        if (page == null) {
            return Result.fail("查无此信息");
        }
        BeanUtil.copyProperties(page, goodsDtoPage, "records");
        List<Goods> records = page.getRecords();
        ArrayList<GoodsDto> goodsDtos = new ArrayList<>();
        records.stream().forEach(item -> {
            GoodsDto goodsDto = new GoodsDto();
            BeanUtil.copyProperties(item, goodsDto);
            Category byId = categoryService.getById(item.getCategoryId());
            goodsDto.setCategoryName(byId.getName());
            goodsDtos.add(goodsDto);
        });
        if (ObjectUtil.isEmpty(goodsDtos)) {
            return Result.fail("查无此信息");
        }
        goodsDtoPage.setRecords(goodsDtos);
        goodsDtoPage.setTotal(goodsDtos.size());
        return Result.success(goodsDtoPage, "信息查询成功");
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
    @SaCheckRole(value = Messages.Role.Role_Business)
    @PostMapping(Urls.goods.save)
    public Result insert(@RequestBody GoodsDto goods) {
        Result result = getResult(goods);
        if (result != null) {
            return result;
        }
        if (!goods.getImgList().isEmpty()) {
            String img = "";
            for (String s : goods.getImgList()) {
                img = img + s + ",";
            }
            goods.setImg(img);
        }
        return goodsService.save(goods) ? Result.success("添加商品成功") : Result.fail("添加商品失败");
    }

    private static Result getResult(GoodsDto goods) {
        if (StrUtil.isBlank(goods.getName())) {
            return Result.fail("商品名称不能为空");
        }
        if (StrUtil.isBlank(goods.getCategoryId())) {
            return Result.fail("商品分类不能为空");
        }
        if (goods.getInventory() <= 0) {
            return Result.fail("商品库存不能为空");
        }
        if (goods.getOriginalPrice() < 0) {
            return Result.fail("商品原价输入错误");
        }
        if (goods.getSellingPrice() < 0) {
            return Result.fail("商品售价输入错误");
        }
        if (StrUtil.isBlank(goods.getImg()) && ObjectUtil.isEmpty(goods.getImgList())) {
            return Result.fail("商品展示图至少一张");
        }

        return null;
    }

    /**
     * 修改数据
     *
     * @param goods 实体对象
     * @return 修改结果
     */
    @SaCheckRole(value = Messages.Role.Role_Business)
    @PutMapping(Urls.goods.update)
    public Result update(@RequestBody GoodsDto goods) {
        Result result = getResult(goods);
        if (result != null) {
            return result;
        }
        return goodsService.updateById(goods) ? Result.success("修改商品成功") : Result.fail("修改商品失败");
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @SaCheckRole(value = Messages.Role.Role_Business)
    @DeleteMapping(Urls.goods.delete)
    public Result delete(@RequestParam("idList") List<String> idList) {
        // 删除图片
        List<String> list = goodsService.listByIds(idList).stream().map(Goods::getImg).filter(StrUtil::isNotBlank).collect(Collectors.toList());
        list.stream().forEach(item -> {
            String[] split = item.substring(0, item.lastIndexOf(",")).split(",");
            Arrays.stream(split).forEach(QiniuUtils::deleteFileFromQiniu);
        });
        // 删除商品对应的评论
        if (!goodsService.removeComment(idList)) {
            return Result.fail("删除商品评论失败");
        }
        // 下架商品对应的套餐
        List<Long> setmealId = goodsService.getSetmealId(idList);
        if (!setmealId.isEmpty()) {
            List<Long> collect = setmealId.stream().distinct().collect(Collectors.toList());
            if (!setmealService.updateStatus(collect)) {
                return Result.fail("下架套餐失败");
            }
        }
        return goodsService.removeByIds(idList) ? Result.success("删除商品成功") : Result.fail("删除商品失败");
    }
}

