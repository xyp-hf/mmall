package com.mmall.dao;

import com.mmall.pojo.Shipping;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShippingMapper {
    int deleteByPrimaryKey(Integer id);

    /**
    * 插入用户地址信息
    * @since 2018年08月06日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param record 用户地址信息对象
    */
    int insert(Shipping record);

    int insertSelective(Shipping record);

    Shipping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shipping record);

    int updateByPrimaryKey(Shipping record);

    /**
    * 删除用户地址信息
    * @since 2018年08月06日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param userId 用户Id
    * @param shippingId 用户地址Id
    */
    int deleteByShippingIdUserId(@Param("userId")Integer userId,@Param("shippingId") Integer shippingId);

    /**
    * 更新用户收获地址
    * @since 2018年08月06日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param record 用户收货地址对象
    */
    int updateByShipping(Shipping record);

    /**
    * 查询用户地址详情
    * @since 2018年08月06日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param userId 用户Id
    * @param shippingId 用户地址对象
    */
    Shipping selectByShippingIdUserId(@Param("userId")Integer userId,@Param("shippingId") Integer shippingId);

    /**
    * 查询用户收货地址列表
    * @since 2018年08月06日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param userId 用户Id
    */
    List<Shipping> selectByUserId(@Param("userId")Integer userId);

}