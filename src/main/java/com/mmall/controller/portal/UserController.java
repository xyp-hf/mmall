package com.mmall.controller.portal;

import com.mmall.common.Const;
import com.mmall.common.ResponseCode;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import com.mmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by xuyupeng on 2018/6/18.
 * 我们在controller里面新建一个portal的小包，也就是门户的意思
 * 然后在里面创建一个UserController类
 */
@Controller // 首先我们在class上面添加一个@Controller,这样UserController就可以起到Controller的作用
@RequestMapping("/user/") // 这个意思就是将请求地址全部打到/user命名空间下，也就是说我们现在定义的用户接口全部是/user下的
// 它是一个公共的，所以我们把它写在类上面
// 如果我们把它写在User下面,那么每一个方法都要加这个/user/,这个也是为了重用
public class UserController {
    // 我们把UserService注入进来
    @Autowired
    private IUserService iUserService;
    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @param session session信息
     * @return id,username,email,phone,role,createTime,updateTime 用户id,用户名,邮箱,手机号,用户身份,创建时间,更新时间
     */
    // 用户登录接口 它含有两个参数，一个username一个password,还有我们要把session放进来
    // 首先我们添加RequestMapping这个注解,它有几个值，一个是value，和接口定义保持一致
    // 然后method我们指定它是一个POST请求
    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    // ResponseBody注解的作用是我们在返回的时候自动通过SpringMVC的Jackson插件将我们的返回值序列化成JSON
    @ResponseBody
    public ServerResponse<User> login(String username, String password, HttpSession session){
        // 接下来编写service,然后调用mybatis下的dao接口
        // service -> mybatis -> dao
        // 我们在service下编写一个接口，叫做IUserService
        // 为什么叫IUserService,因为我们用interface的首字母作为类名
        ServerResponse<User> response = iUserService.login(username,password);
        if (response.isSuccess()){
            session.setAttribute(Const.CURRENT_USER,response.getData());
        }
        return response;
    }

    /**
     * 退出登录
     * @param session session信息
     */
    @RequestMapping(value = "logout.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> logout(HttpSession session){
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccessMessage("退出成功");
    }

    /**
     * 注册功能
     * @param user 用户信息对象，包括
     * Integer id, 用户Id
     * String username, 用户名
     * String password, 用户密码
     * String email, 用户邮箱
     * String phone, 用户手机号
     * String question, 密码找回问题
     * String answer, 密码找回答案
     * Integer role, 用户身份：普通用户 Or 管理员
     * Date createTime, 注册时间
     * Date updateTime 更新时间
     */
    @RequestMapping(value = "register.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> register(User user){
        return iUserService.register(user);
    }

    /**
     * 校验用户名和邮箱是否存在
     * str 用户名 or emaill
     * type username or email
     */
    @RequestMapping(value = "check_valid.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> checkValid(String str,String type){
        return iUserService.checkValid(str,type);
    }

    /**
     * 获取用户信息
     * session session信息
     */
    @RequestMapping(value = "get_user_info",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> getUserInfo(HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user != null){
            return ServerResponse.createBySuccess(user);
        }
        return ServerResponse.createByErrorMessage("用户未登录,无法获取当前用户的信息");
    }

    /**
     * 忘记密码 获取问题
     * username 用户名
     */
    @RequestMapping(value = "forget_get_question.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> forgetGetQuestion(String username){
        return iUserService.selectQuestion(username);
    }

    /**
     * 校验找回密码答案是否正确
     * username 用户名
     * question 密码找回问题
     * answer 密码找回答案
     * @return Token
     */
    @RequestMapping(value = "forget_check_answer.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> forgetCheckAnswer(String username,String question ,String answer){
        return iUserService.checkAnswer(username,question,answer);
    }

    /**
     * 忘记密码 中 重置密码
     * username 用户名
     * passwordNew 新密码
     * forgetToken 重置密码的Token
     */
    @RequestMapping(value = "forget_reset_password.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> forgetRestPassword(String username,String passwordNew,String forgetToken){
        return iUserService.forgetResetPassword(username,passwordNew,forgetToken);
    }
    /**
     * 登录状态的重置密码
     * session session信息
     * passwordOld 旧密码
     * passwordNew 新密码
     */
    @RequestMapping(value = "reset_password.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> resetPassword(HttpSession session,String passwordOld,String passwordNew){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        return iUserService.resetPassword(passwordOld,passwordNew,user);
    }
    /**
     * 更新个人用户信息
     * session session信息
     * user 用户信息对象，包括
     * Integer id, 用户Id
     * String username, 用户名
     * String password, 用户密码
     * String email, 用户邮箱
     * String phone, 用户手机号
     * String question, 密码找回问题
     * String answer, 密码找回答案
     * Integer role, 用户身份：普通用户 Or 管理员
     * Date createTime, 注册时间
     * Date updateTime 更新时间
     */
    @RequestMapping(value = "update_information.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> update_information(HttpSession session,User user){
        User currentUser = (User)session.getAttribute(Const.CURRENT_USER);
        if(currentUser == null){
            return  ServerResponse.createByErrorMessage("用户未登录");
        }
        user.setId(currentUser.getId());
        user.setUsername(currentUser.getUsername());
        ServerResponse<User> response = iUserService.updateInformation(user);
        if(response.isSuccess()){
            session.setAttribute(Const.CURRENT_USER,response.getData());
        }
        return  response;
    }

    /**
     * 获取用户的详细信息
     * session session信息
     */
    @RequestMapping(value = "get_information.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> get_information(HttpSession session){
        User currentUser = (User)session.getAttribute(Const.CURRENT_USER);
        if(currentUser == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"未登录,需要强制登录status=10");
        }
        return iUserService.getInformation(currentUser.getId());
    }

}
