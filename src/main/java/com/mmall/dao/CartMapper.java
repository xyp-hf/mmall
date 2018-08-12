package com.mmall.dao;

import com.mmall.pojo.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {
    /**
    * 清除购物车商品
    * @since 2018年08月09日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param id 
    * @return
    */
    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cart record);

    /**
    * 更新购物车的数量
    * @since 2018年08月06日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param record
    */
    int updateByPrimaryKey(Cart record);
    
    /**
    * 查询购物车中此商品是否存在
    * @since 2018年08月05日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param userId 用户Id
    * @param productId 商品Id
    */
    Cart selectCartByUserIdProductId(@Param("userId") Integer userId, @Param("productId")Integer productId);

    /**
    * 根据userId来查购物车的集合
    * @since 2018年08月05日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param userId 用户Id
    */
    List<Cart> selectCartByUserId(Integer userId);

    /**
    * 判断购物车是否全选
    * @since 2018年08月05日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param userId 用户Id
    */
    int selectCartProductCheckedStatusByUserId(Integer userId);

    /**
    * 在购物车中删除商品
    * @since 2018年08月06日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param userId 用户Id
    * @param productIdList 商品Id的集合
    */
    int deleteByUserIdProductIds(@Param("userId") Integer userId,@Param("productIdList")List<String> productIdList);

    /**
    * 购物车全选 / 反选
    * @since 2018年08月06日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param userId 用户Id
    * @param productId 商品Id
    * @param checked 选择
    */
    int checkedOrUncheckedProduct(@Param("userId") Integer userId,@Param("productId")Integer productId,@Param("checked") Integer checked);

    int selectCartProductCount(@Param("userId") Integer userId);

    /**
    * 获取购物车中被勾选的商品
    * @since 2018年08月09日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param userId 用户Id
    */
    List<Cart> selectCheckedCartByUserId(Integer userId);

}