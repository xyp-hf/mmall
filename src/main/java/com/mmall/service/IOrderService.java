package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Order;
import com.mmall.vo.OrderVo;

import java.util.Map;

/**
* 支付宝支付模块
* @since 2018年07月05日
* @author Yupeng.Xu
* @update Yupeng.Xu
*/
public interface IOrderService {
    /**
     * 支付功能
     * @since 2018年08月07日
     * @author Yupeng.Xu
     * @update Yupeng.Xu
     * @param orderNo 用户订单号
     * @param userId 用户Id
     * @param path upload文件夹路径
     */
    ServerResponse pay(Long orderNo, Integer userId, String path);

    /**
    * 支付宝的回调
    * @since 2018年08月07日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    */
    ServerResponse aliCallback(Map<String,String> params);
    ServerResponse queryOrderPayStatus(Integer userId,Long orderNo);
    /**
    * 创建订单给的
    * @since 2018年08月09日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param userId 用户Id
    * @param shippingId 地址Id
    */
    ServerResponse createOrder(Integer userId,Integer shippingId);
    /**
    * 未付款状态下取消订单
    * @since 2018年08月09日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param userId 用户ID
    * @param orderNo 订单号
    */
    ServerResponse<String> cancel(Integer userId,Long orderNo);
    /**
    * 获取购物车中已经选中的的商品详情
    * @since 2018年08月09日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param userId 用户Id
    */
    ServerResponse getOrderCartProduct(Integer userId);
    /**
    * 查看订单详情
    * @since 2018年08月09日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param userId 用户Id
    * @param orderNo 订单号
    */
    ServerResponse<OrderVo> getOrderDetail(Integer userId, Long orderNo);

    /**
    * 查看订单列表
    * @since 2018年08月09日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param userId 用户Id
    * @param pageNum 第几页
    * @param pageSize 每页数据条数
    */
    ServerResponse<PageInfo> getOrderList(Integer userId, int pageNum, int pageSize);

    // backend
    /**
    * 管理员查询订单列表
    * @since 2018年08月09日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param pageNum 第几页
    * @param pageSize 每页数据量
    */
    ServerResponse<PageInfo> manageList(int pageNum,int pageSize);
    /**
     * 管理员获取订单详情
     * @since 2018年08月09日
     * @author Yupeng.Xu
     * @update Yupeng.Xu
     * @param orderNo 订单号
     */
    ServerResponse<OrderVo> manageDetail(Long orderNo);
    /**
     * 管理员用户按订单号搜索
     * @since 2018年08月09日
     * @author Yupeng.Xu
     * @update Yupeng.Xu
     * @param orderNo 订单号
     * @param pageNum 第几页
     * @param pageSize 每页数据量
     */
    ServerResponse<PageInfo> manageSearch(Long orderNo,int pageNum,int pageSize);

    /**
     * 管理员发货功能
     * @since 2018年08月09日
     * @author Yupeng.Xu
     * @update Yupeng.Xu
     * @param orderNo 订单号
     */
    ServerResponse<String> manageSendGoods(Long orderNo);

}
