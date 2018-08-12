package com.mmall.controller.backend;

import com.google.common.collect.Maps;
import com.mmall.common.Const;
import com.mmall.common.ResponseCode;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Product;
import com.mmall.pojo.User;
import com.mmall.service.IFileService;
import com.mmall.service.IProductService;
import com.mmall.service.IUserService;
import com.mmall.util.PropertiesUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
* 商品管理
* @since 2018年06月25日
* @author Yupeng.Xu
* @update Yupeng.Xu
*/
@Controller
@RequestMapping("/manage/product")
public class ProductManageController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IProductService iProductService;

    @Autowired
    protected IFileService iFileService;

    /**
    * 保存商品
    * @since 2018年08月05日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
     * @param session session信息
     * @param product 商品
    */
    @RequestMapping("save.do")
    @ResponseBody
    public ServerResponse productSave(HttpSession session, Product product){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录管理员");

        }
        // 判断用户身份是不是管理员
        if(iUserService.checkAdminRole(user).isSuccess()){
            //填充我们增加产品的业务逻辑
            return iProductService.saveOrUpdateProduct(product);
        }else{
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }

    /**
    * 产品上下架
    * @since 2018年08月05日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param session session信息，用户判断用户身份是否是管理员
    * @param productId 商品Id
    * @param status 商品上下架状态
    */
    @RequestMapping("set_sale_status.do")
    @ResponseBody
    public ServerResponse setSaleStatus(HttpSession session, Integer productId, Integer status){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录管理员");
        }
        if(iUserService.checkAdminRole(user).isSuccess()){
            return iProductService.setSaleStatus(productId,status);
        }else{
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }

    /**
    * 获取产品详情
    * @since 2018年08月05日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param session session,获取用户身份信息，校验是否有管理员权限
     * @param productId 商品Id
    */
    @RequestMapping("detail.do")
    @ResponseBody
    public ServerResponse getDetail(HttpSession session, Integer productId){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录管理员");
        }
        if(iUserService.checkAdminRole(user).isSuccess()){
            // 填充业务 获取商品详情
            return iProductService.manageProductDetail(productId);
        }else{
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }

    /**
     * 后台管理员 商品列表
     * @param session
     * @param pageNum 第几页, 默认第1页
     * @param pageSize 页面容量,默认10条
     * @return
     */
    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse getList(HttpSession session, @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,@RequestParam(value = "pageSize",defaultValue = "10")int pageSize){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录管理员");
        }
        if(iUserService.checkAdminRole(user).isSuccess()){
            // 填充业务
            return iProductService.getProductList(pageNum,pageSize);
        }else{
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }

    /**
    * 后台管理员 产品搜索
    * @since 2018年08月05日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param session session信息
    * @param productName 商品名称
    * @param productId 商品Id
    * @param pageNum 第几页
    * @param pageSize 每页数据条数
    */
    @RequestMapping("search.do")
    @ResponseBody
    public ServerResponse productSearch(
            HttpSession session,
            String productName,
            Integer productId,
            @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize",defaultValue = "10")int pageSize
    ){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录管理员");
        }
        if(iUserService.checkAdminRole(user).isSuccess()){
            // 填充业务
            return iProductService.searchProduct(productName,productId,pageNum,pageSize);
        }else{
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }

    /**
    * 文件上传 在编辑产品的时候把产品的图片上传到服务器上
    * @since 2018年08月05日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param session 
    * @param file 文件
    * @param request 根据Servlet的上下文创建一个相对路径
    */
    @RequestMapping("upload.do")
    @ResponseBody
    public ServerResponse upload(HttpSession session,@RequestParam(value = "upload_file",required = false) MultipartFile file,HttpServletRequest request){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录管理员");
        }
        if(iUserService.checkAdminRole(user).isSuccess()){
            // 从request.getSession()拿到getServletContext(),通过getRealPath()的方法指定上传文件的文件夹叫做upload
            String path = request.getSession().getServletContext().getRealPath("upload");
            String targetFileName = iFileService.upload(file,path);
            String url = PropertiesUtil.getProperty("ftp.server.http.prefix")+targetFileName;

            Map fileMap = Maps.newHashMap();
            fileMap.put("uri",targetFileName);
            fileMap.put("url",url);
            return ServerResponse.createBySuccess(fileMap);
        }else{
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }

    /**
    * 富文本文件上传
    * @since 2018年08月05日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param session session信息
     * @param file 文件按
     * @param request 相对路径
     * @param response
    */
    @RequestMapping("richtext_img_upload.do")
    @ResponseBody
    public Map richtextImgUpload(HttpSession session, @RequestParam(value = "upload_file",required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        Map resultMap = Maps.newHashMap();
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            resultMap.put("success",false);
            resultMap.put("msg","请登录管理员");
            return resultMap;
        }
        //富文本中对于返回值有自己的要求,我们使用是simditor所以按照simditor的要求进行返回
        // API文档 http://simditor.tower.im/docs/doc-config.html
        if(iUserService.checkAdminRole(user).isSuccess()){
            String path = request.getSession().getServletContext().getRealPath("upload");
            String targetFileName = iFileService.upload(file,path);
            if(StringUtils.isBlank(targetFileName)){
                resultMap.put("success",false);
                resultMap.put("msg","上传失败");
                return resultMap;
            }
            String url = PropertiesUtil.getProperty("ftp.server.http.prefix")+targetFileName;
            resultMap.put("success",true);
            resultMap.put("msg","上传成功");
            resultMap.put("file_path",url);
            // 按文档中的要求我们需要修改response的Header
            response.addHeader("Access-Control-Allow-Headers","X-File-Name");
            return resultMap;
        }else{
            resultMap.put("success",false);
            resultMap.put("msg","无权限操作");
            return resultMap;
        }
    }


}
