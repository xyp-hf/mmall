package com.mmall.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
* 订单对象
* @since 2018年08月09日
* @author Yupeng.Xu
* @update Yupeng.Xu
*/
public class OrderVo {
    /**
     * 订单号
     */
    private Long orderNo;
    /**
     * 付款金额
     */
    private BigDecimal payment;
    /**
     * 支付方式
     */
    private Integer paymentType;
    /**
     * 支付方式描述
     */
    private String paymentTypeDesc;
    /**
     * 运费
     */
    private Integer postage;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 状态描述
     */
    private String statusDesc;
    /**
     * 付款时间
     */
    private String paymentTime;

    private String sendTime;

    private String endTime;

    private String closeTime;

    private String createTime;

    // 订单明细
    private List<OrderItemVo> OrderItemVoList;
    /**
     * 图片路径
     */
    private String imageHost;
    /**
     * 地址模块
     */
    private Integer shippingId;
    /**
     * 收货人姓名
     */
    private String receiverName;
    /**
     * 收货地址
     */
    private ShippingVo shippingVo;

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentTypeDesc() {
        return paymentTypeDesc;
    }

    public void setPaymentTypeDesc(String paymentTypeDesc) {
        this.paymentTypeDesc = paymentTypeDesc;
    }

    public Integer getPostage() {
        return postage;
    }

    public void setPostage(Integer postage) {
        this.postage = postage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public List<OrderItemVo> getOrderItemVoList() {
        return OrderItemVoList;
    }

    public void setOrderItemVoList(List<OrderItemVo> orderItemVoList) {
        OrderItemVoList = orderItemVoList;
    }

    public String getImageHost() {
        return imageHost;
    }

    public void setImageHost(String imageHost) {
        this.imageHost = imageHost;
    }

    public Integer getShippingId() {
        return shippingId;
    }

    public void setShippingId(Integer shippingId) {
        this.shippingId = shippingId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public ShippingVo getShippingVo() {
        return shippingVo;
    }

    public void setShippingVo(ShippingVo shippingVo) {
        this.shippingVo = shippingVo;
    }
}
