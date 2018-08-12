package com.mmall.dao;

import com.mmall.pojo.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);

    /**
    * 订单明细
    * @since 2018年08月07日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param orderNo 订单号
    * @param userId 用户Id
    */
    List<OrderItem> getByOrderNoUserId(@Param("orderNo")Long orderNo,@Param("userId")Integer userId);

    /**
    * 管理员查询订单，不需要用户Id
    * @since 2018年08月09日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param orderNo 
    * @return
    */
    List<OrderItem> getByOrderNo(@Param("orderNo")Long orderNo);

    void batchInsert(@Param("orderItemList") List<OrderItem> orderItemList);
}