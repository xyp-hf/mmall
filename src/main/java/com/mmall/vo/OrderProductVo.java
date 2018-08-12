package com.mmall.vo;

import java.math.BigDecimal;
import java.util.List;

/**
* 购物车产品
* @since 2018年08月09日
* @author Yupeng.Xu
* @update Yupeng.Xu
*/
public class OrderProductVo {
    /**
     * 购物车列表
     */
    private List<OrderItemVo> orderItemVoList;
    /**
     * 总价
     */
    private BigDecimal productTotalPrice;
    /**
     * 主图
     */
    private String imageHost;

    public List<OrderItemVo> getOrderItemVoList() {
        return orderItemVoList;
    }

    public void setOrderItemVoList(List<OrderItemVo> orderItemVoList) {
        this.orderItemVoList = orderItemVoList;
    }

    public BigDecimal getProductTotalPrice() {
        return productTotalPrice;
    }

    public void setProductTotalPrice(BigDecimal productTotalPrice) {
        this.productTotalPrice = productTotalPrice;
    }

    public String getImageHost() {
        return imageHost;
    }

    public void setImageHost(String imageHost) {
        this.imageHost = imageHost;
    }
}
