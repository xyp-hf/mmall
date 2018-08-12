package com.mmall.dao;

import com.mmall.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    /**
    * 插入订单
    * @since 2018年08月09日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param record 订单对象
    * @return
    */
    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    /**
    * 根据用户Id和订单号查询此订单存不存在
    * @since 2018年08月07日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param userId 用户Id
    * @param orderNo 订单号
    */
    Order selectByUserIdAndOrderNo(@Param("userId")Integer userId,@Param("orderNo")Long orderNo);

    /**
    * 根据订单号查询订单存不存在
    * @since 2018年08月07日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param orderNo 订单号
    */
    Order selectByOrderNo(Long orderNo);

    /**
    * 获取订单集合
    * @since 2018年08月09日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param userId 用户Id
    */
    List<Order> selectByUserId(Integer userId);

    List<Order> selectAllOrder();
}