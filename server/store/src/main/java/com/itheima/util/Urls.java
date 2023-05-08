package com.itheima.util;

/**
 * 接口地址
 *
 * @author WangFK
 * @version 1.0
 * @since 2023/4/27 16:21
 */
public class Urls {
    /**
     * @Author WangFK
     * @Date 2023/5/3 20:34
     * @Param 订单详情接口
     **/
    public  class orderDetail{
        final static public String baseUrl="/orderDetail";
    };

    /**
     * @Author WangFK
     * @Date 2023/5/3 20:25
     * @Param 地址接口
     **/

     public class address{
         final static public String baseUrl="/address";
        /**
         * 修改用户默认地址
         */
        final static public String updateFlag="/updateFlag";

        /**
         * 获取用户地址
         */
        final static public String getUserById="/getUserById";

        /**
         * 分页显示
         */
        final static public String getPageList="/getPageList";
        /**
         * 新增地址
         */
        final static public String save="/save";
        /**
         * 修改地址
         */
        final static public String update="/update";
        /**
         * 删除地址
         */
        final static public String delete="/delete";
    }
    /**
     * @Author WangFK
     * @Date 2023/5/3 20:25
     * @Param 商品分类接口
     **/

    public class category{
        final static public String baseUrl="/category";
        /**
         * 分页显示
         */
        final static public String getPageList="/getPageList";
        /**
         * 显示所有分类
         */
        final static public String getList="/getList";
        /**
         * 新增分类
         */
        final static public String save="/save";
        /**
         * 修改分类
         */
        final static public String update="/update";
        /**
         * 删除分类
         */
        final static public String delete="/delete";
    }

    /**
     * @Author WangFK
     * @Date 2023/5/3 20:26
     * @Param 商品评论接口
     **/
    public class comment{
        final static public String baseUrl="/comment";
        /**
         * 分页显示
         */
        final static public String getPageList="/getPageList";
        /**
         * 新增分类
         */
        final static public String save="/save";
        /**
         * 修改分类
         */
        final static public String update="/update";
        /**
         * 删除分类
         */
        final static public String delete="/delete";
    }
    /**
     * @Author WangFK
     * @Date 2023/5/3 20:26
     * @Param 商品接口
     **/
    public class goods{
        final static public String baseUrl="/goods";
        /**
         * 图片上传
         */
        final static public String upload="/upload";
        /**
         * 商品-评论
         */
        final static public String setComment="/setComment";
        /**
         * 修改商品上架状态
         */
        final static public String updateStatus="/updateStatus";

        /**
         * 分页显示
         */
        final static public String getPageList="/getPageList";
        /**
         * 新增
         */
        final static public String save="/save";
        /**
         * 修改
         */
        final static public String update="/update";
        /**
         * 删除
         */
        final static public String delete="/delete";
    }
    /**
     * @Author WangFK
     * @Date 2023/5/3 20:27
     * @Param 订单接口
     **/
    public class orders{
        final static public String baseUrl="/orders";
    }
    /**
     * @Author WangFK
     * @Date 2023/5/3 20:27
     * @Param 套餐接口
     **/
    public class setMeal{
        final static public String baseUrl="/setmeal";
        /**
         * 修改套餐上架状态
         */
        final static public String updateStatus="/updateStatus";
        /**
         * 根据商品分类返回商品信息
         */
        final static public String getGoodsByCategoryId="/getGoodsByCategoryId";

        /**
         * 分页显示
         */
        final static public String getPageList="/getPageList";
        /**
         * 新增
         */
        final static public String save="/save";
        /**
         * 修改
         */
        final static public String update="/update";
        /**
         * 删除
         */
        final static public String delete="/delete";

    }
    /**
     * @Author WangFK
     * @Date 2023/5/3 20:27
     * @Param 店铺接口
     **/
    public class shop{
        final static public String baseUrl="/shop";
    }
    /**
     * @Author WangFK
     * @Date 2023/5/3 20:28
     * @Param 购物车接口
     **/
    public class shoppingCart{
        final static public String baseUrl="/shoppingCart";
    }
    /**
     * @Author WangFK
     * @Date 2023/5/3 20:28
     * @Param 用户接口
     **/
    public class user{
        final static public String baseUrl="/user";
        /**
         * 图片上传
         */
        final static public String upload="/upload";
        /**
         * 修改密码
         */
        final static public String updatePassword="/updatePassword";

        /**
         * 注册
         */
        final static public String registered="/registered";

        /**
         * 登录
         */
        final static public String login="/login";
        /**
         * 新增
         */
        final static public String save="/save";
        /**
         * 修改
         */
        final static public String update="/update";
        /**
         * 删除
         */
        final static public String delete="/delete";

        /**
         * 显示
         */
        final static public String PersonList="/PersonList";
    }
}
