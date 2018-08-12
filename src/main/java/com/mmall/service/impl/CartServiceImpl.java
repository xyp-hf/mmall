package com.mmall.service.impl;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.mmall.common.Const;
import com.mmall.common.ResponseCode;
import com.mmall.common.ServerResponse;
import com.mmall.dao.CartMapper;
import com.mmall.dao.ProductMapper;
import com.mmall.pojo.Cart;
import com.mmall.pojo.Product;
import com.mmall.service.ICartService;
import com.mmall.util.BigDecimalUtil;
import com.mmall.util.PropertiesUtil;
import com.mmall.vo.CartProductVo;
import com.mmall.vo.CartVo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
* 购物车实现类
* @since 2018年08月05日
* @author Yupeng.Xu
* @update Yupeng.Xu
*/
@Service("iCartService")
public class CartServiceImpl implements ICartService {

    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ProductMapper productMapper;

    /**
    * 购物车商品添加
    * @since 2018年08月05日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param userId 用户Id
    * @param productId 商品Id
    * @param count 数量
    */
    public ServerResponse<CartVo> add(Integer userId,Integer productId,Integer count){
        if(productId == null || count == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        // 查询购物车中是否有这个商品
        Cart cart = cartMapper.selectCartByUserIdProductId(userId,productId);
        if(cart == null){
            //这个产品不在这个购物车里,需要新增一个这个产品的记录
            Cart cartItem = new Cart();
            cartItem.setQuantity(count);
            cartItem.setChecked(Const.Cart.CHECKED);
            cartItem.setProductId(productId);
            cartItem.setUserId(userId);
            cartMapper.insert(cartItem);
        }else{
            //这个产品已经在购物车里了.
            //如果产品已存在,数量相加
            count = cart.getQuantity() + count;
            cart.setQuantity(count);
            cartMapper.updateByPrimaryKeySelective(cart);
        }
        return this.list(userId);
    }

    /**
    * 更新购物车
    * @since 2018年08月06日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param userId 用户Id
    * @param productId 商品Id
    * @param count 商品数量
    */
    public ServerResponse<CartVo> update(Integer userId,Integer productId,Integer count){
        // 判断商品Id存储不存在
        if(productId == null || count == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        // 判断购物车是不是空的
        Cart cart = cartMapper.selectCartByUserIdProductId(userId,productId);
        if(cart != null){
            // 如果购物车不为空的话我们就更新它的数量
            cart.setQuantity(count);
        }
        cartMapper.updateByPrimaryKey(cart);
        return this.list(userId);
    }

    /**
    * 在购物车中删除商品
    * @since 2018年08月06日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param userId 用户Id
    * @param productIds 商品Id
    */
    public ServerResponse<CartVo> deleteProduct(Integer userId,String productIds){
        // 这里使用GUAVA的Splitter方法转成集合,这样会自动用逗号分隔字符串 然后自动添加到集合当中
        List<String> productList = Splitter.on(",").splitToList(productIds);
        if(CollectionUtils.isEmpty(productList)){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        cartMapper.deleteByUserIdProductIds(userId,productList);
        return this.list(userId);
    }

    /**
    * 购物车列表
    * @since 2018年08月06日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param userId 用户Id
    */
    public ServerResponse<CartVo> list (Integer userId){
        CartVo cartVo = this.getCartVoLimit(userId);
        return ServerResponse.createBySuccess(cartVo);
    }

    /**
    * 购物车全选 / 反选
    * @since 2018年08月06日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param userId 用户的Id
    * @param productId 商品Id
    * @param checked 选中
    */
    public ServerResponse<CartVo> selectOrUnSelect (Integer userId,Integer productId,Integer checked){
        cartMapper.checkedOrUncheckedProduct(userId,productId,checked);
        return this.list(userId);
    }

    /**
    * 获取当前用户的购物车商品数量
    * @since 2018年08月06日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param userId 用户Id
    */
    public ServerResponse<Integer> getCartProductCount(Integer userId){
        if(userId == null){
            return ServerResponse.createBySuccess(0);
        }
        return ServerResponse.createBySuccess(cartMapper.selectCartProductCount(userId));
    }

    /**
    * 限制并且返回
    * @since 2018年08月05日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param userId 用户Id
    */
    private CartVo getCartVoLimit(Integer userId){
        CartVo cartVo = new CartVo();
        List<Cart> cartList = cartMapper.selectCartByUserId(userId);
        List<CartProductVo> cartProductVoList = Lists.newArrayList();
        // 初始化购物车的总价
        BigDecimal cartTotalPrice = new BigDecimal("0");

        if(CollectionUtils.isNotEmpty(cartList)){
            for(Cart cartItem : cartList){
                CartProductVo cartProductVo = new CartProductVo();
                cartProductVo.setId(cartItem.getId());
                cartProductVo.setUserId(userId);
                cartProductVo.setProductId(cartItem.getProductId());

                Product product = productMapper.selectByPrimaryKey(cartItem.getProductId());
                if(product != null){
                    cartProductVo.setProductMainImage(product.getMainImage());
                    cartProductVo.setProductName(product.getName());
                    cartProductVo.setProductSubtitle(product.getSubtitle());
                    cartProductVo.setProductStatus(product.getStatus());
                    cartProductVo.setProductPrice(product.getPrice());
                    cartProductVo.setProductStock(product.getStock());
                    // 判断库存
                    int buyLimitCount = 0;
                    // 当产品库存大于购物车数量时
                    if(product.getStock() >= cartItem.getQuantity()){
                        //库存充足的时候
                        buyLimitCount = cartItem.getQuantity();
                        cartProductVo.setLimitQuantity(Const.Cart.LIMIT_NUM_SUCCESS);
                    }else{
                        buyLimitCount = product.getStock();
                        cartProductVo.setLimitQuantity(Const.Cart.LIMIT_NUM_FAIL);
                        //购物车中更新有效库存
                        Cart cartForQuantity = new Cart();
                        cartForQuantity.setId(cartItem.getId());
                        cartForQuantity.setQuantity(buyLimitCount);
                        cartMapper.updateByPrimaryKeySelective(cartForQuantity);
                    }
                    cartProductVo.setQuantity(buyLimitCount);
                    //计算总价
                    cartProductVo.setProductTotalPrice(BigDecimalUtil.mul(product.getPrice().doubleValue(),cartProductVo.getQuantity()));
                    cartProductVo.setProductChecked(cartItem.getChecked());
                }

                if(cartItem.getChecked() == Const.Cart.CHECKED){
                    //如果已经勾选,增加到整个的购物车总价中
                    cartTotalPrice = BigDecimalUtil.add(cartTotalPrice.doubleValue(),cartProductVo.getProductTotalPrice().doubleValue());
                }
                cartProductVoList.add(cartProductVo);
            }
        }
        cartVo.setCartTotalPrice(cartTotalPrice);
        cartVo.setCartProductVoList(cartProductVoList);
        cartVo.setAllChecked(this.getAllCheckedStatus(userId));
        cartVo.setImageHost(PropertiesUtil.getProperty("ftp.server.http.prefix"));

        return cartVo;
    }

    /**
    * 判断是不是全选
    * @since 2018年08月05日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param userId 用户Id
    */
    private boolean getAllCheckedStatus(Integer userId){
        if(userId == null){
            return false;
        }
        return cartMapper.selectCartProductCheckedStatusByUserId(userId) == 0;

    }
}
