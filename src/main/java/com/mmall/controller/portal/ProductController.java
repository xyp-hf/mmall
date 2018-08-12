package com.mmall.controller.portal;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.service.IProductService;
import com.mmall.vo.ProductDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* 前台-商品管理
* @since 2018年06月27日
* @author Yupeng.Xu
* @update Yupeng.Xu
*/
@Controller
@RequestMapping("/product/")
public class ProductController {

    @Autowired
    protected IProductService iProductService;

    /**
    * 前台-获取商品详情
    * @since 2018年08月05日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param productId 商品Id
    */
    @RequestMapping("detail.do")
    @ResponseBody
    public ServerResponse<ProductDetailVo> detail(Integer productId) {
        return iProductService.getProductDetail(productId);
    }

    /**
    * 用户产品搜索列表
    * @since 2018年08月05日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param keyword 关键字
    * @param categoryId 分类Id
    * @param pageNum 第几页
    * @param pageSize 每页数据条数
    * @param orderBy 排序方式
    */
    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse<PageInfo> list(
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(value = "categoryId", required = false) Integer categoryId,
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
            @RequestParam(value = "orderBy", defaultValue = "") String orderBy
    ) {
        return iProductService.getProductByKeywordCategory(
                keyword,
                categoryId,
                pageNum,
                pageSize,
                orderBy
        );

    }

}
