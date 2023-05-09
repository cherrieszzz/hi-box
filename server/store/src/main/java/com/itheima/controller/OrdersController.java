package com.itheima.controller;


import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dto.OrdersDto;
import com.itheima.entity.*;
import com.itheima.service.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

import com.itheima.util.Urls;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * 订单表(Orders)表控制层
 *
 * @author WangFK
 * @since 2023-05-05 14:39:28
 */
@RestController
@Slf4j
@RequestMapping(Urls.orders.baseUrl)
public class OrdersController {
    /**
     * 服务对象
     */
    @Resource
    private OrdersService ordersService;
    @Resource
    private UserService userService;
    @Resource
    private AddressService addressService;
    @Resource
    private GoodsService goodsService;
    @Resource
    private OrderDetailService orderDetailService;

    /**
     * 查询全部订单数据 查询条件有待商榷
     * @param pageNum
     * @param pageSize
     * @param search
     * @return
     */
    @GetMapping(Urls.orders.getPageList)
    public Result getPageList(Long pageNum,Long pageSize,String search){
        Page<Orders> ordersPage = new Page<>(pageNum, pageSize);
        LambdaUpdateWrapper<Orders> lqw = new LambdaUpdateWrapper<>();
        lqw.orderByDesc(Orders::getOrderTime);
        Page<Orders> page = ordersService.page(ordersPage, lqw);
        if (page==null){
            return Result.fail("暂无信息");
        }
        return Result.success(page,"获取订单信息成功");
    }

    /**
     * 查询某一用户的订单数据
     *
     * @param userId 主键
     * @return 单条数据
     */
    @GetMapping(Urls.orders.orderByUserId)
    public Result selectOne( String userId) {
        LambdaUpdateWrapper<Orders> lqw = new LambdaUpdateWrapper<>();
        lqw.eq(Orders::getUserId,userId).orderByDesc(Orders::getOrderTime);
        List<Orders> list = ordersService.list(lqw);
        if (list.isEmpty()){
            return Result.fail("该用户无订单数据");
        }
        return Result.success(list,"该用户订单数据如下");
    }

    /**
     * 新增数据 单个商品下单
     *
     * @param orders 实体对象
     * @return 新增结果
     */
    @PostMapping(Urls.orders.save)
    public Result insert(@RequestBody Orders orders) {
        // 订单状态：目前暂无支付接口 默认 待付款状态
        orders.setStatus(1);
        // 生成订单号
        orders.setNumber(RandomUtil.randomString(32));
        // 支付方式
        orders.setPayMethod(1);
        // 支付状态
        switch (orders.getStatus()){
            case 1:orders.setPayStatus(0);break;
            case 6:orders.setPayStatus(2);break;
            case 7:orders.setPayStatus(2);break;
            default:orders.setPayStatus(1);
        }
        // 下单商品
        if (orders.getGoodsId()==null){
            return Result.fail("请选择下单商品");
        }
        // 下单用户
        if (orders.getUserId()==null){
            return Result.fail("下单用户不能为空");
        }
        // 收获地址
        if (orders.getAddressId()==null){
            return Result.fail("请选择收获地址");
        }
        Goods byId2 = goodsService.getById(orders.getGoodsId());
        if (ObjectUtil.isEmpty(byId2)||byId2.getStatus()==0||byId2.getInventory()<1){
            return Result.fail("该商品已下架");
        }
        User byId = userService.getById(orders.getUserId());
        if (ObjectUtil.isEmpty(byId)){
            return Result.fail("该用户不存在");
        }
        Address byId1 = addressService.getById(orders.getAddressId());
        if (ObjectUtil.isEmpty(byId1)){
            return Result.fail("该地址不存在，请先添加地址");
        }
        if (orders.getAmount()==null){
            return Result.fail("付款金额不能为空");
        }
        double price = byId2.getSellingPrice() * orders.getCount();
        if (price!=orders.getAmount()){
            return Result.fail("二次校验，付款金额不一致");
        }
        orders.setPhone(byId1.getPhone());
        String address=byId1.getProvinceName()+byId1.getCityName()+byId1.getDistrictName()+"--"+byId1.getDetail();
        orders.setAddress(address);
        orders.setUserName(byId.getUsername());
        orders.setConsignee(byId1.getConsignee());
        try {
            if (ordersService.save(orders)){
                Goods goods = new Goods();
                goods.setId(byId2.getId());
                goods.setInventory( byId2.getInventory()-orders.getCount());
                //byId2.setInventory( byId2.getInventory()-orders.getCount());
                // 商品数量为空 直接下架
                if (goods.getInventory()<1){
                    goods.setStatus(0);
                }
                goodsService.updateById(goods);
            }
        } catch (Exception e) {
            return Result.fail("删减库存失败");
        }

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setName(byId.getUsername());
        orderDetail.setOrderId(orders.getId());
        orderDetail.setGoodsId(orders.getGoodsId());
        orderDetail.setNumber(Math.toIntExact(orders.getCount()));
        orderDetail.setAmount(orders.getAmount());

        return orderDetailService.save(orderDetail)?Result.success("下单成功"):Result.fail("下单失败");
    }

    /**
     * 购物车下单
     * @param orders
     * @return
     */
    @PostMapping(Urls.orders.orderCart)
    public Result orderCart(@RequestBody Orders orders ){
        return Result.success("功能未开发");
    }

    /**
     * 加入购物车->
     * @param shoppingCartList
     * @return
     */
    @PostMapping(Urls.orders.joinCart)
    public Result joinCart(@RequestBody List<ShoppingCart> shoppingCartList ){
        return Result.success("功能未开发");
    }

    /**
     * 修改数据
     *
     * @param orders 实体对象
     * @return 修改结果
     */
    @PutMapping(Urls.orders.update)
    public Result update(@RequestBody Orders orders) {
        return Result.success("功能未开发");
    }

    /**
     * 删除订单
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public Result delete(@RequestParam("idList") List<Long> idList) {
        LambdaUpdateWrapper<OrderDetail> lqw = new LambdaUpdateWrapper<>();
        lqw.in(OrderDetail::getOrderId,idList);

        return orderDetailService.remove(lqw)&&ordersService.removeByIds(idList)?Result.success("订单删除成功"):Result.fail("订单删除失败");
    }
}

