package com.mmall.controller.portal;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.demo.trade.config.Configs;
import com.google.common.collect.Maps;
import com.mmall.common.Const;
import com.mmall.common.ResponseCode;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import com.mmall.service.IOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.Map;

/**
* 支付宝支付模块
* @since 2018年05月05日
* @author Yupeng.Xu
* @update Yupeng.Xu
*/
@Controller
@RequestMapping("/order/")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private IOrderService iOrderService;

    /**
    * 创建订单
    * @since 2018年08月09日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param session session信息
    * @param shippingId 用户地址信息对象
    */
    @RequestMapping("create.do")
    @ResponseBody
    public ServerResponse create(HttpSession session,Integer shippingId){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user ==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iOrderService.createOrder(user.getId(),shippingId);
    }

    /**
    * 未付款状态下取消订单
    * @since 2018年08月09日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param session session
    * @param orderNo 订单号
    */
    @RequestMapping("cancel.do")
    @ResponseBody
    public ServerResponse cancel(HttpSession session, Long orderNo){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user ==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iOrderService.cancel(user.getId(),orderNo);
    }

    /**
    * 获取购物车中已经选中的的商品详情
    * @since 2018年08月09日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param session session信息
    */
    @RequestMapping("get_order_cart_product.do")
    @ResponseBody
    public ServerResponse getOrderCartProduct(HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user ==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iOrderService.getOrderCartProduct(user.getId());
    }

    /**
    * 订单详情
    * @since 2018年08月09日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param session session信息
    * @param orderNo 订单号
    */
    @RequestMapping("detail.do")
    @ResponseBody
    public ServerResponse detail(HttpSession session,Long orderNo){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user ==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iOrderService.getOrderDetail(user.getId(),orderNo);
    }

    /**
    * 查看订单列表
    * @since 2018年08月09日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param session session信息
    * @param pageNum 第几页
    * @param pageSize 每页数据条数
    */
    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse list(HttpSession session, @RequestParam(value = "pageNum",defaultValue = "1") int pageNum, @RequestParam(value = "pageSize",defaultValue = "10")int pageSize){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user ==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iOrderService.getOrderList(user.getId(),pageNum,pageSize);
    }

    /**
    * 支付功能
    * @since 2018年08月07日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param session session信息，验证用户身份
    * @param orderNo 用户订单号
    * @param request 用它获取Servlet的上下文拿到upload文件夹路径
    * 讲自动生成的二维码传到FTP服务器，然后返回给前端这个二维码的图片地址，然后前端进行页面展示让用户扫码支付
    */
    @RequestMapping("pay.do")
    @ResponseBody
    public ServerResponse pay(HttpSession session, Long orderNo, HttpServletRequest request){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user ==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        String path = request.getSession().getServletContext().getRealPath("upload");
        return iOrderService.pay(orderNo,user.getId(),path);
    }

    /**
    * 支付宝的回调函数
    * @since 2018年08月07日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param request 支付宝会把所有的数据放到request里面共我们的自己获取
    */
    @RequestMapping("alipay_callback.do")
    @ResponseBody
    public Object alipayCallback(HttpServletRequest request){
        Map<String,String> params = Maps.newHashMap();

        Map requestParams = request.getParameterMap();
        for(Iterator iter = requestParams.keySet().iterator(); iter.hasNext();){
            String name = (String)iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for(int i = 0; i < values.length;i++){
                valueStr = (i == values.length - 1)?valueStr + values[i]:valueStr + values[i]+",";
            }
            params.put(name,valueStr);
        }
        logger.info("支付宝回调,sign:{},trade_status:{},参数:{}",params.get("sign"),params.get("trade_status"),params.toString());
        // 非常重要,验证回调的正确性，是不是支付宝发的，并且呢还要避免重复通知
        params.remove("sign_type");
        try {
            boolean alipayRSACheckedV2 = AlipaySignature.rsaCheckV2(params, Configs.getAlipayPublicKey(),"utf-8", Configs.getSignType());
            if(!alipayRSACheckedV2){
                return ServerResponse.createByErrorMessage("非法请求,验证不通过,再恶意请求我就报警找网警了");
            }
        } catch (AlipayApiException e) {
            logger.error("支付宝验证回调异常",e);
        }
        // todo 验证各种数据
        ServerResponse serverResponse = iOrderService.aliCallback(params);
        if(serverResponse.isSuccess())
            return Const.AlipayCallback.RESPONSE_SUCCESS;
        return Const.AlipayCallback.RESPONSE_FAILED;
    }

    /**
    * 查看付款状态是否成功
    * @since 2018年08月07日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param session session信息
    * @param orderNo 订单号
    */
    @RequestMapping("query_order_pay_status.do")
    @ResponseBody
    public ServerResponse<Boolean> queryOrderPayStatus(HttpSession session, Long orderNo){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user ==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }

        ServerResponse serverResponse = iOrderService.queryOrderPayStatus(user.getId(),orderNo);
        if(serverResponse.isSuccess()){
            return ServerResponse.createBySuccess(true);
        }
        return ServerResponse.createBySuccess(false);
    }
}
