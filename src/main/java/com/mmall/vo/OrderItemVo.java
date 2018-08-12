package com.mmall.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
* 订单明细
* @since 2018年08月09日
* @author Yupeng.Xu
* @update Yupeng.Xu
* @param null 
* @return
*/
public class OrderItemVo {
    /**
     * 订单号
     */
    private Long orderNo;
    /**
     * 商品Id
     */
    private Integer productId;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品主图
     */
    private String productImage;
    /**
     * 商品单价
     */
    private BigDecimal currentUnitPrice;
    /**
     * 商品数量
     */
    private Integer quantity;
    /**
     * 商品总价
     */
    private BigDecimal totalPrice;
    /**
     * 创建时间
     */
    private String createTime;

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public BigDecimal getCurrentUnitPrice() {
        return currentUnitPrice;
    }

    public void setCurrentUnitPrice(BigDecimal currentUnitPrice) {
        this.currentUnitPrice = currentUnitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}

