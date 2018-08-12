package com.mmall.vo;

import java.math.BigDecimal;

    /**
    * 商品详情Vo
    * @since 2018年06月26日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    */
public class ProductDetailVo {
    /**
    * 商品Id
    */
    private Integer  id;

    /**
    * 分类Id
    */
    private Integer categoryId;

    /**
     * 产品名字
     */
    private String name;

    /**
     * 产品副标题
     */
    private String subtitle;

    /**
     * 产品主图
     */
    private String mainImage;

    /**
    * 产品辅图
    */
    private String subImages;

    /**
    * 详情描述
    */
    private String detail;

    /**
    * 商品价格
    */
    private BigDecimal price;

    /**
    * 库存数量
    */
    private Integer stock;

    /**
    * 销售状态 上架/下架
    */
    private Integer status;

    /**
    * 创建时间
    */
    private String createTime;

    /**
    * 更新时间
    */
    private String updateTime;

    /**
    * 图片服务器的Url前缀
    */
    private String imageHost;

    /**
    * 父分类的Id
    */
    private Integer parentCategoryId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public String getSubImages() {
        return subImages;
    }

    public void setSubImages(String subImages) {
        this.subImages = subImages;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getImageHost() {
        return imageHost;
    }

    public void setImageHost(String imageHost) {
        this.imageHost = imageHost;
    }

    public Integer getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Integer parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }
}
