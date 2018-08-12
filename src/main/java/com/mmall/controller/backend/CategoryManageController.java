package com.mmall.controller.backend;

import com.mmall.common.Const;
import com.mmall.common.ResponseCode;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import com.mmall.service.ICategoryService;
import com.mmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
/**
* 产品分类
* @since 2018年08月05日
* @author Yupeng.Xu
*/
@Controller
@RequestMapping("/manage/category")
public class CategoryManageController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private ICategoryService iCategoryService;

    /**
    * 增加分类
    * @since 2018年08月05日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
     * @param categoryName 分类名称
     * @param parentId 分类Id, 当前端不传时默认为0
    */
    @RequestMapping("add_category.do")
    @ResponseBody
    public ServerResponse addCategory(HttpSession session,String categoryName,@RequestParam(value = "parentId", defaultValue = "0") int parentId){
        // 校验登录的用户是不是管理员
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录");
        }
        // 校验是否登录
        if(iUserService.checkAdminRole(user).isSuccess()){
            // 是管理员
            // 增加我们处理分类的逻辑
            return iCategoryService.addCategory(categoryName,parentId);
        }else{
            return ServerResponse.createByErrorMessage("无权限操作,需要管理员权限");
        }
    }

    /**
    * 更新分类
    * @since 2018年08月05日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param session session
    * @param categoryId 分类Id
    */
    @RequestMapping("set_category_name.do")
    @ResponseBody
    public ServerResponse setCategoryName(HttpSession session,Integer categoryId,String categoryName){
        // 校验登录的用户是不是管理员
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录");
        }
        // 校验是否登录
        if(iUserService.checkAdminRole(user).isSuccess()){
            // 是管理员
            // 增加我们处理分类的逻辑
            // 更新CategoryName
            return iCategoryService.updateCategoryName(categoryId,categoryName);
        }else{
            return ServerResponse.createByErrorMessage("无权限操作,需要管理员权限");
        }
    }

    /**
    * 编写一个根据当前CategoryId下的子节点的Category信息,并且是平级的，并且不递归
    * 如果前端没有传categoryId默认为0,0表示categoryId的根节点
    * @since 2018年08月05日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param session session信息
    * @param categoryId 分类Id
    */
    @RequestMapping("get_category.do")
    @ResponseBody
    public ServerResponse getChildrenParallelCategory(HttpSession session,@RequestParam(value = "categoryId" ,defaultValue = "0") Integer categoryId){
        // 校验登录的用户是不是管理员
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录");
        }
        // 校验是否登录
        if(iUserService.checkAdminRole(user).isSuccess()){
            // 查询子节点的category信息,并且不递归，保持平级
            return iCategoryService.getChildrenParallelCategory(categoryId);
        }else{
            return ServerResponse.createByErrorMessage("无权限操作,需要管理员权限");
        }
    }


    /**
    * 编写一个获取当前CategoryId的信息并且获取当前子节点的CategoryId
    * @since 2018年08月05日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param session 
     * @param categoryId 
    * @return
    */
    @RequestMapping("get_deep_category.do")
    @ResponseBody
    public ServerResponse getCategoryAndDeepChildrenCategory(HttpSession session,@RequestParam(value = "categoryId" ,defaultValue = "0") Integer categoryId){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录");
        }
        if(iUserService.checkAdminRole(user).isSuccess()){
            //查询当前节点的id和递归子节点的id
//            0->10000->100000
            return iCategoryService.selectCategoryAndChildrenById(categoryId);

        }else{
            return ServerResponse.createByErrorMessage("无权限操作,需要管理员权限");
        }
    }
}
