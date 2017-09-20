package com.essential.bussiness.promotion.model.auto;

import java.math.BigDecimal;

public class PromotionProductAuto {
    private Long productRomotionId;

    private Long promotionId;

    private Integer promotionType;

    private Long productOrShopId;

    private Float discountPercent;

    private BigDecimal discountMoney;

    private BigDecimal needTotalPrice;

    private Integer isMultistage;

    private Integer isValidate;

    private Integer promotionStatus;

    private String remark1;

    private String remark2;

    private String remark3;

    private String remark4;

    private String remark5;

    public Long getProductRomotionId() {
        return productRomotionId;
    }

    public void setProductRomotionId(Long productRomotionId) {
        this.productRomotionId = productRomotionId;
    }

    public Long getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Long promotionId) {
        this.promotionId = promotionId;
    }

    public Integer getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(Integer promotionType) {
        this.promotionType = promotionType;
    }

    public Long getProductOrShopId() {
        return productOrShopId;
    }

    public void setProductOrShopId(Long productOrShopId) {
        this.productOrShopId = productOrShopId;
    }

    public Float getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Float discountPercent) {
        this.discountPercent = discountPercent;
    }

    public BigDecimal getDiscountMoney() {
        return discountMoney;
    }

    public void setDiscountMoney(BigDecimal discountMoney) {
        this.discountMoney = discountMoney;
    }

    public BigDecimal getNeedTotalPrice() {
        return needTotalPrice;
    }

    public void setNeedTotalPrice(BigDecimal needTotalPrice) {
        this.needTotalPrice = needTotalPrice;
    }

    public Integer getIsMultistage() {
        return isMultistage;
    }

    public void setIsMultistage(Integer isMultistage) {
        this.isMultistage = isMultistage;
    }

    public Integer getIsValidate() {
        return isValidate;
    }

    public void setIsValidate(Integer isValidate) {
        this.isValidate = isValidate;
    }

    public Integer getPromotionStatus() {
        return promotionStatus;
    }

    public void setPromotionStatus(Integer promotionStatus) {
        this.promotionStatus = promotionStatus;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1 == null ? null : remark1.trim();
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2 == null ? null : remark2.trim();
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3 == null ? null : remark3.trim();
    }

    public String getRemark4() {
        return remark4;
    }

    public void setRemark4(String remark4) {
        this.remark4 = remark4 == null ? null : remark4.trim();
    }

    public String getRemark5() {
        return remark5;
    }

    public void setRemark5(String remark5) {
        this.remark5 = remark5 == null ? null : remark5.trim();
    }
}