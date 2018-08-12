package com.mmall.service;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;

/**
 * Created by xuyupeng on 2018/6/18.
 */
// 我们将首字母写成大写I,这样我们就知道这是一个接口
// 这对我们以后维护是一个非常方便的事情
// 同时我们使用接口和接口实现的方式为以后LP做一个准备
// 无论我们使用静态代理还是动态代理，包括我们后续发展的LP,我们都用接口代理
// 当然我们也可以使用CZlib来动态代理我们的class,但是这种方式没有接口扩展性强
// 因为一个类做扩展性的时候肯定是没有接口强的
public interface IUserService {
    // 我们声明一个接口
    // 稍后我们要做一个泛型，做一个通用的数据响应对象
    // 然后我们在service目录下创建一个包，impl是implements缩写
    // 然后在里面创建UserServiceImpl,用Impl我们可以很清楚的知道这是一个接口的实现

    /**
     * 登录接口
     * @param username 用户名
     * @param password 用户密码
     * @return id,username,email,phone,role,createTime,updateTime 用户id,用户名,邮箱,手机号,用户身份,创建时间,更新时间
     */
    ServerResponse<User> login(String username, String password);

    /**
     * 注册接口
     * @param user 包括username,password,email,phone,question,answer 用户名,密码,邮箱,手机,密码找回问题,密码找回答案
     */
    ServerResponse<String> register(User user);

    /**
     * 检查用户名或邮箱是否有效
     * @param str str可以是用户名也可以是email
     * @param type 对应的type是username和email
     */
    ServerResponse<String> checkValid(String str,String type);

    /**
     * 获取忘记密码,获取找回密码问题
     * @param username 用户名
     */
    ServerResponse selectQuestion(String username);

    /**
     * 校验密码找回问题答案是否正确
     * @param username 用户名
     * @param question 密码找回问题
     * @param answer 密码找回答案
     */
    ServerResponse<String> checkAnswer(String username,String question ,String answer);

    /**
     * 忘记密码 重置密码
     * @param username 用户名
     * @param passwordNew 新密码
     * @param forgetToken 设置密码Token
     */
    ServerResponse<String> forgetResetPassword(String username,String passwordNew,String forgetToken);

    /**
     * 登录状态的重置密码
     * @param passwordOld 旧密码
     * @param passwordNew 新密码
     * @param user 用户信息
     */
    ServerResponse<String> resetPassword(String passwordOld,String passwordNew,User user);

    /**
     * 更新个人用户信息
     * @param user username,password,email,phone,question,answer
     */
    ServerResponse<User> updateInformation(User user);

    /**
     * 获取用户的详细信息
     * @param userId 用户id
     */
    ServerResponse<User> getInformation(Integer userId);

    /**
     * 判断用户身份是不是管理员
     * @param user 用户信息
     */
    ServerResponse<User> checkAdminRole(User user);
}
