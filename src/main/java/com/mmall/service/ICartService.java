package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.vo.CartVo;
/**
* 购物车接口
* @since 2018年08月05日
* @author Yupeng.Xu
* @update Yupeng.Xu
*/
public interface ICartService {
    /**
    * 添加商品到购物车
    * @since 2018年08月05日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param userId 用户Id
    * @param productId 商品Id
    * @param count 数量
    */
    ServerResponse<CartVo> add(Integer userId, Integer productId, Integer count);

    /**
    * 更新购物车
    * @since 2018年08月06日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param userId 用户Id
    * @param productId 商品Id
    * @param count 数量
    */
    ServerResponse<CartVo> update(Integer userId,Integer productId,Integer count);
    
    /**
    * 在购物车中删除商品
    * @since 2018年08月06日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param userId 用户Id
    * @param productIds 商品Id
    */
    ServerResponse<CartVo> deleteProduct(Integer userId,String productIds);

    /**
    * 查询购物车列表
    * @since 2018年08月06日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param userId 用户Id
    */
    ServerResponse<CartVo> list (Integer userId);
    
    /**
    * 购物车全选 / 反选
    * @since 2018年08月06日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param userId 用户Id
    * @param productId 商品Id
    * @param checked 选择
    * @return
    */
    ServerResponse<CartVo> selectOrUnSelect (Integer userId,Integer productId,Integer checked);
    
    /**
    * 获取当前用户的购物车商品数量
    * @since 2018年08月06日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param userId 用户Id
    */
    ServerResponse<Integer> getCartProductCount(Integer userId);
}
