package com.mmall.dao;

import com.mmall.pojo.Category;

import java.util.List;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    /**
    * 查找子节点
    * @since 2018年08月05日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    */
    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    /**
    * 根据ParentId获取子节点的Category信息集合
    * @since 2018年08月05日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param parentId 父节点Id
    */
    List<Category> selectCategoryChildrenByParentId(Integer parentId);
}