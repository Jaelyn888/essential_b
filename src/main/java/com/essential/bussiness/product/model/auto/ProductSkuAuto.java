package com.essential.bussiness.product.model.auto;

import java.math.BigDecimal;

public class ProductSkuAuto {
    private Long productskuId;

    private Long specificationid1;

    private Long specificationid2;

    private Long specificationid3;

    private Long specificationid4;

    private Long productskuCount;

    private String articleNumber;

    private BigDecimal prices;

    private Long productId;

    private Integer isDelete;

    private String createTime;

    private Long createIser;

    private Long modifyUser;

    private String modifyTime;

    private Integer status;

    private Integer specificationType;

    public Long getProductskuId() {
        return productskuId;
    }

    public void setProductskuId(Long productskuId) {
        this.productskuId = productskuId;
    }

    public Long getSpecificationid1() {
        return specificationid1;
    }

    public void setSpecificationid1(Long specificationid1) {
        this.specificationid1 = specificationid1;
    }

    public Long getSpecificationid2() {
        return specificationid2;
    }

    public void setSpecificationid2(Long specificationid2) {
        this.specificationid2 = specificationid2;
    }

    public Long getSpecificationid3() {
        return specificationid3;
    }

    public void setSpecificationid3(Long specificationid3) {
        this.specificationid3 = specificationid3;
    }

    public Long getSpecificationid4() {
        return specificationid4;
    }

    public void setSpecificationid4(Long specificationid4) {
        this.specificationid4 = specificationid4;
    }

    public Long getProductskuCount() {
        return productskuCount;
    }

    public void setProductskuCount(Long productskuCount) {
        this.productskuCount = productskuCount;
    }

    public String getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(String articleNumber) {
        this.articleNumber = articleNumber == null ? null : articleNumber.trim();
    }

    public BigDecimal getPrices() {
        return prices;
    }

    public void setPrices(BigDecimal prices) {
        this.prices = prices;
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

    public Long getCreateIser() {
        return createIser;
    }

    public void setCreateIser(Long createIser) {
        this.createIser = createIser;
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

    public Integer getSpecificationType() {
        return specificationType;
    }

    public void setSpecificationType(Integer specificationType) {
        this.specificationType = specificationType;
    }
}