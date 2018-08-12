package com.mmall.util;

import java.math.BigDecimal;

/**
* BigDecimalUtil工具类 解决商业运算浮点型数据丢失精度问题
* @since 2018年08月05日
* @author Yupeng.Xu
* @update Yupeng.Xu
*/
public class BigDecimalUtil {

    private BigDecimalUtil(){

    }

    // 加法
    public static BigDecimal add(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2);
    }

    // 减法
    public static BigDecimal sub(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2);
    }

    // 乘法
    public static BigDecimal mul(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2);
    }

    // 除法
    public static BigDecimal div(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        //除不尽的情况
        //四舍五入,保留2位小数
        return b1.divide(b2,2,BigDecimal.ROUND_HALF_UP);
    }
}
