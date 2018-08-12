package com.mmall.controller.portal;

import com.mmall.common.Const;
import com.mmall.common.ResponseCode;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import com.mmall.service.ICartService;
import com.mmall.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
* 购物车模块
* @since 2018年08月05日
* @author Yupeng.Xu
* @update Yupeng.Xu
*/
@Controller
@RequestMapping("/cart/")
public class CartController {

    @Autowired
    private ICartService iCartService;
    
    /**
    * 查询购物车列表
    * @since 2018年08月06日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param session session信息
    */
    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse<CartVo> list(HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.list(user.getId());
    }

    /**
    * 添加购物车
    * @since 2018年08月05日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param session session信息
    * @param count 数量
    * @param productId 商品Id
    */
    @RequestMapping("add.do")
    @ResponseBody
    public ServerResponse<CartVo> add(HttpSession session, Integer count, Integer productId){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user ==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.add(user.getId(),productId,count);
    }

    /**
    * 更新购物车
    * @since 2018年08月06日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param session session信息
    * @param count 数量
    * @param productId 商品Id
    */
    @RequestMapping("update.do")
    @ResponseBody
    public ServerResponse<CartVo> update(HttpSession session, Integer count, Integer productId){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user ==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.update(user.getId(),productId,count);
    }

    /**
    * 在购物车中删除商品
    * @since 2018年08月06日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param session session信息
    * @param productIds 商品Id
    */
    @RequestMapping("delete_product.do")
    @ResponseBody
    public ServerResponse<CartVo> deleteProduct(HttpSession session,String productIds){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user ==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.deleteProduct(user.getId(),productIds);
    }

    /**
    * 购物车全选
    * @since 2018年08月06日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param session session信息
    */
    @RequestMapping("select_all.do")
    @ResponseBody
    public ServerResponse<CartVo> selectAll(HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user ==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.selectOrUnSelect(user.getId(),null,Const.Cart.CHECKED);
    }

    /**
    * 购物车全反选
    * @since 2018年08月06日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param session session信息
    */
    @RequestMapping("un_select_all.do")
    @ResponseBody
    public ServerResponse<CartVo> unSelectAll(HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user ==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.selectOrUnSelect(user.getId(),null,Const.Cart.UN_CHECKED);
    }


    /**
    * 购物车商品单独选中
    * @since 2018年08月06日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param session session信息
    * @param productId 商品Id
    */
    @RequestMapping("select.do")
    @ResponseBody
    public ServerResponse<CartVo> select(HttpSession session,Integer productId){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user ==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.selectOrUnSelect(user.getId(),productId,Const.Cart.CHECKED);
    }

    /**
    * 购物车商品单独反选
    * @since 2018年08月06日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param session session信息
    * @param productId 商品Id
    */
    @RequestMapping("un_select.do")
    @ResponseBody
    public ServerResponse<CartVo> unSelect(HttpSession session,Integer productId){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user ==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.selectOrUnSelect(user.getId(),productId,Const.Cart.UN_CHECKED);
    }

    /**
    * 获取当前用户的购物车商品数量
    * @since 2018年08月06日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param session session信息
    */
    @RequestMapping("get_cart_product_count.do")
    @ResponseBody
    public ServerResponse<Integer> getCartProductCount(HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user ==null){
            // 如果未登录返回0
            return ServerResponse.createBySuccess(0);
        }
        return iCartService.getCartProductCount(user.getId());
    }

    //全选
    //全反选

    //单独选
    //单独反选

    //查询当前用户的购物车里面的产品数量,如果一个产品有10个,那么数量就是10.
}
