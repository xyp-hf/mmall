package com.mmall.controller.backend;

import com.mmall.common.Const;
import com.mmall.common.ServerResponse;
import com.mmall.service.IUserService;
import com.mmall.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
* 管理员用户
* @since 2018年08月05日
* @author Yupeng.Xu
*/
@Controller
@RequestMapping("/manage/user")
public class UserManageController {
    @Autowired
    private IUserService iUserService;
    /**
    * 管理员用户登录
    * @since 2018年08月05日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param username 用户名
    * @param password 密码
    */
    @RequestMapping(value="login.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> login(String username, String password, HttpSession session){
        ServerResponse<User> response = iUserService.login(username,password);
        if(response.isSuccess()){
            User user = response.getData();
            if(user.getRole() == Const.Role.ROLE_ADMIN){
                //说明登录的是管理员
                session.setAttribute(Const.CURRENT_USER,user);
                return response;
            }else{
                return ServerResponse.createByErrorMessage("不是管理员,无法登录");
            }
        }
        return response;
    }
}
