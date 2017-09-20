package com.essential.bussiness.order.model.auto;

public class OrderProductPromotionAuto {
    private Long orderPromotionId;

    private Long orderProductId;

    private String orderPromotionName;

    private String promotionMoneyOrDiscount;

    private Integer promotionType;

    private Long promotionId;

    public Long getOrderPromotionId() {
        return orderPromotionId;
    }

    public void setOrderPromotionId(Long orderPromotionId) {
        this.orderPromotionId = orderPromotionId;
    }

    public Long getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(Long orderProductId) {
        this.orderProductId = orderProductId;
    }

    public String getOrderPromotionName() {
        return orderPromotionName;
    }

    public void setOrderPromotionName(String orderPromotionName) {
        this.orderPromotionName = orderPromotionName == null ? null : orderPromotionName.trim();
    }

    public String getPromotionMoneyOrDiscount() {
        return promotionMoneyOrDiscount;
    }

    public void setPromotionMoneyOrDiscount(String promotionMoneyOrDiscount) {
        this.promotionMoneyOrDiscount = promotionMoneyOrDiscount == null ? null : promotionMoneyOrDiscount.trim();
    }

    public Integer getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(Integer promotionType) {
        this.promotionType = promotionType;
    }

    public Long getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Long promotionId) {
        this.promotionId = promotionId;
    }
}