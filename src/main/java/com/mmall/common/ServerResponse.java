package com.mmall.common;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * Created by xujiqing on 2018/6/18.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
// 保证序列号json的时候,如果是null对象,key也会消失
// 我们用泛型来声明这个类,这里面我们可以传一个泛型T,它就代表我们响应里面要封装的数据对象是什么类型
// 然后我们让他实现序列号接口Serializable
public class ServerResponse<T> implements Serializable {
    // 响应对象里面有三个属性，而data是一个泛型
    // 我们声明它,这里为了声明成通用的,我们采用T用作泛型
    // 这个泛型有个好处,也就是说在返回的时候，我们可以指定泛型里面的内容
    // 也可以不知道泛型里面的强制类型
    // 这样在一些特殊的场景,例如正确的时候，我们可能里面封装一个String；
    // 错误的时候我封装的不是String有事另外一种类型
    // 又或者第三种情况，我们在里面封装一个List
    // 但是在我们方法声明的时候我们只能声明一个类型返回值
    // 那么我们这个泛型就起到了这个作用
    private  int status;
    private  String msg;
    private  T data;

    // 然后我们来写它的构造方法,我们把它的构造方法写成私有的
    // 这个私有的就代表外部是不能new它的
    // 然后我们会开放供外部使用的public方法
    private ServerResponse(int status){
        this.status = status;
    }
    private ServerResponse(int status,T data){
        this.status = status;
        this.data = data;
    }

    private ServerResponse(int status,String msg,T data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    private ServerResponse(int status,String msg){
        this.status = status;
        this.msg = msg;
    }
    // 如果我们调用这个构造器;当我们的泛型是一个String的时候
    // 它会调用什么呢
    // 也就是说当第二个参数是String的时候就会调msg，当第二个参数非String的时候就会调T泛型的构造器

    // 但是有人会说我们返回的数据就是一个String类型
    // 我要给它放到data里面啊，我如果调用这个构造器岂不是放到msg里面了，data里面有没有

    //这个我们待会将会通过对外public方法的处理来规避这个问题

    // 这个时候我们来封装一个，来确定这个响应是不是一个正确的响应
    // 是不是一个成功的响应
    // 下面我们编写这个方法
    @JsonIgnore
    //使之不在json序列化结果当中
    public boolean isSuccess(){
        // 这里return this.status如果返回0就返回true，否则就返回false
        // return this.status == 0;
        // 这里我们用一个枚举给我们后面的魔法数字进行一个归类
        // 我们在commin里面继续声明一个ResponseCode，
        // 它是status的一个code

        // 也就是说如果这个status和SUCCESS这个枚举的Code，也就是说0相等的话，就返回一个true
        return this.status == ResponseCode.SUCCESS.getCode();
    }
    // 返回state
    public int getStatus(){
        return  status;
    }
    // 返回data
    public T getData(){
        return data;
    }
    // 返回Msg
    public String getMsg(){
        return msg;
    }
    // 再开放就使用静态方法来开放
    // 这里就要用到泛型了
    public static <T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }
    // 这里也是一个成功，但是成功的话也要返回一个文本
    public static <T> ServerResponse<T> createBySuccessMessage(String msg){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
    }
    // 这是一个成功的服务器响应，但是我要把data填充进去
    // 当String当做一个T的时候，它调用的构造器是一个Code和data的构造器
    // 因为构造类型只有一个T，所以呢它只会调用数据类型为T的构造方法
    public static <T> ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data);
    }
    // 这是一个成功的服务器响应，我们要把消息和数据都传出去

    // 这是时候第二个构造器和第三个构造器，我们要传一个String作为data的时候
    // 我们对外开放就会调用这个方法，我们把String传到这个T进来之后
    // 会发现它调用的构造器是三个参数的
    // 我们把String作为Data的时候,我们对外开放就会传这个方法;
    // 我们把String传到这个T之后,会发现它调用的构造器是三个参数的，msg也会传过来

    // 第二个，我们将String作为一个T的时候传过来,它调用的是Code和data的构造器
    // 因为他的数据类似是一个T，所以它只会调用T的构造方法
    public static <T> ServerResponse<T> createBySuccess(String msg,T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }

    // 成功的我们都创建好了,下面我们来创建失败的，失败的和成功的异曲同工
    // 这里就返回一个纯粹的Code,描述就直接传描述Desc;
    public static <T> ServerResponse<T> createByError(){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }
    // 然后我们还有一些错误要返回一些提示
    // 例如到注册的时候我们添加一个用户名 我们给永用户返回该用户名已注册
    public static <T> ServerResponse<T> createByErrorMessage(String errorMessage){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),errorMessage);
    }
    // 这里我们再声明一个可以把Code声明成一个变量的方法
    // 因为在我们很多操作的时候,我们需要暴露出一个需要登录,
    // 如果参数校验错误,我们需要暴露出参数校验错误的服务端响应
    public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode,String errorMessage){
        return new ServerResponse<T>(errorCode,errorMessage);
    }

}
