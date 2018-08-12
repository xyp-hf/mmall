package com.mmall.common;

/**
 * Created by xujiqing on 2018/6/18.
 */
// 这是一个enum的枚举类
public enum ResponseCode {
    SUCCESS(0,"SUCCESS"), // 成功
    ERROR(1,"ERROR"), // 失败
    NEED_LOGIN(10,"NEED_LOGIN"), // 需要登录
    ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT"); // 参数错误

    // 我们声明两个属性
    private final int code;
    private final String desc;

    // 我把构造器写一下
    ResponseCode(int code,String desc){
        this.code = code;
        this.desc = desc;
    }
    // 同时我们还需要把code和desc开放
    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }
}
