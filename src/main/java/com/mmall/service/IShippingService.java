package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Shipping;

/**
 * Created by xuyupeng
 */
public interface IShippingService {

    /**
    * 添加用户地址
    * @since 2018年08月06日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param userId 用户Id
    * @param shipping 用户地址信息对象
    */
    ServerResponse add(Integer userId, Shipping shipping);
    
    /**
    * 删除用户地址
    * @since 2018年08月06日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param userId 用户Id
    * @param shippingId 用户地址Id
    */
    ServerResponse<String> del(Integer userId,Integer shippingId);

    /**
     * 更新用户地址
     * @param userId 用户Id
     * @param shipping 用户地址对象
     */
    ServerResponse update(Integer userId, Shipping shipping);
    
    /**
    * 用户收货地址查询
    * @since 2018年08月06日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param userId 用户Id
    * @param shippingId 用户地址模块
    */
    ServerResponse<Shipping> select(Integer userId, Integer shippingId);
    
    /**
    * 用户地址列表
    * @since 2018年08月06日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param userId 用户Id
    * @param pageNum 第几页
    * @param pageSize 一页多少条
    */
    ServerResponse<PageInfo> list(Integer userId, int pageNum, int pageSize);
}