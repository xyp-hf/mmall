package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Product;
import com.mmall.vo.ProductDetailVo;

    /**
    * 商品管理
    * @since 2018年06月25日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param null
    * @return
    */
public interface IProductService {
    /**
     * 保存或更新产品
     * @since 2018年08月05日
     * @author Yupeng.Xu
     * @update Yupeng.Xu
     * @param product 产品Id
     */
    ServerResponse saveOrUpdateProduct(Product product);

    /**
      * 更新商品的销售状态 上下架
      * @since 2018年08月05日
      * @author Yupeng.Xu
      * @update Yupeng.Xu
      * @param productId 商品Id
      * @param status 商品销售状态
      */
    ServerResponse<String> setSaleStatus(Integer productId,Integer status);

    /**
    * 后台-获取商品详情
    * @since 2018年08月05日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param productId 商品Id
    */
    ServerResponse<ProductDetailVo> manageProductDetail(Integer productId);

    /**
    * 获取商品列表
    * @param pageNum 第几页
    * @param pageSize 每页数据条数
    */
    ServerResponse<PageInfo> getProductList(int pageNum, int pageSize);

    /**
    * 商品搜索
    * @since 2018年08月05日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param productName 商品名称
    * @param productId 商品Id
    * @param pageNum 第几页
     * @param pageSize 每页数据条数
    */
    ServerResponse<PageInfo> searchProduct(String productName,Integer productId,int pageNum,int pageSize);

    /**
    * 前台-获取商品详情
    * @since 2018年08月05日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param productId 商品Id
    */
    ServerResponse<ProductDetailVo> getProductDetail(Integer productId);

    /**
    * 前台用户搜索 商品
    * @since 2018年08月05日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param keyword 搜索关键字
    * @param categoryId 分类Id
    * @param pageNum 第几页
    * @param pageSize 每页数据条数
    * @param orderBy 排序方式
    */
    ServerResponse<PageInfo> getProductByKeywordCategory(String keyword,Integer categoryId,int pageNum,int pageSize,String orderBy);
}
