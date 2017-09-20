package com.essential.bussiness.product.model.auto;

public class ProductSkuRelationAuto {
    private Long productskuRelation;

    private Long productskuId;

    private Long type;

    private Long specificationValueId;

    private Long specificationKeyId;

    private Long productId;

    private Integer isDelete;

    private String createTime;

    private Long createUser;

    private Long modifyUser;

    private String modifyTime;

    private Integer status;

    private Integer flag;

    public Long getProductskuRelation() {
        return productskuRelation;
    }

    public void setProductskuRelation(Long productskuRelation) {
        this.productskuRelation = productskuRelation;
    }

    public Long getProductskuId() {
        return productskuId;
    }

    public void setProductskuId(Long productskuId) {
        this.productskuId = productskuId;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Long getSpecificationValueId() {
        return specificationValueId;
    }

    public void setSpecificationValueId(Long specificationValueId) {
        this.specificationValueId = specificationValueId;
    }

    public Long getSpecificationKeyId() {
        return specificationKeyId;
    }

    public void setSpecificationKeyId(Long specificationKeyId) {
        this.specificationKeyId = specificationKeyId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Long getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(Long modifyUser) {
        this.modifyUser = modifyUser;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime == null ? null : modifyTime.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}