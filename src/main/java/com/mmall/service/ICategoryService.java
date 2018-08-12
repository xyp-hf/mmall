package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Category;

import java.util.List;

    /**
    * 产品分类接口
    * @since 2018年06月25日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    */
public interface ICategoryService {

    /**
     * 添加品类分类
     * @since 2018年08月05日
     * @author Yupeng.Xu
     * @param categoryName 添加的分类名称
     * @param parentId 添加的分类Id
     */
    ServerResponse addCategory(String categoryName, Integer parentId);

    /**
     * 更新品类分类
     * @since 2018年08月05日
     * @author Yupeng.Xu
     * @update Yupeng.Xu
     * @param categoryId 分类Id
     * @param categoryName 分类名称
     */
    ServerResponse updateCategoryName(Integer categoryId,String categoryName);

    /**
     * 编写一个根据当前CategoryId获取下面子节点的Category信息,并且是平级的，并且不递归
     * @since 2018年08月05日
     * @author Yupeng.Xu
     * @update Yupeng.Xu
     * @param categoryId 分类Id
     */
    ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);
    /**
    * 递归查询本节点的id及孩子节点的id
    * @since 2018年08月05日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param categoryId 分类Id
    * @return
    */
    ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId);

}
