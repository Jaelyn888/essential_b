package com.essential.bussiness.brand.model.auto;

public class BrandAndCategoryAuto {
    private Long brandandcategoryId;

    private Long brandId;

    private Long categoryId;

    private String createTime;

    private Long createUser;

    private String modifyTime;

    private Long modifyUser;

    private Integer status;

    public Long getBrandandcategoryId() {
        return brandandcategoryId;
    }

    public void setBrandandcategoryId(Long brandandcategoryId) {
        this.brandandcategoryId = brandandcategoryId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Long getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(Long modifyUser) {
        this.modifyUser = modifyUser;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}