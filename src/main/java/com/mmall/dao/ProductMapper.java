package com.mmall.dao;

import com.mmall.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    /**
     * 查询商品列表
     */
    List<Product> selectList();

    /**
     * 根据商品名和商品id搜索
     * @param productName 商品名称
     * @param productId 商品Id
     */
    List<Product> selectByNameAndProductId(@Param("productName")String productName,@Param("productId") Integer productId);

    /**
    * 用户产品搜索列表
    * @since 2018年08月05日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param productName 商品名称
    * @param categoryIdList 分类列表
    */
    List<Product> selectByNameAndCategoryIds(@Param("productName")String productName,@Param("categoryIdList")List<Integer> categoryIdList);
}