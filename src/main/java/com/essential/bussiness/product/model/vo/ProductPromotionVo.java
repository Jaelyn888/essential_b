package com.essential.bussiness.product.model.vo;

import java.math.BigDecimal;

public class ProductPromotionVo extends ProductAutoAddField {

	private Long productRomotionId;

	private Integer promotionType;

	private Float discountPercent;
	
	private Integer isValidate;
	
	private BigDecimal discountMoney;

	public Long getProductRomotionId() {
		return productRomotionId;
	}

	public void setProductRomotionId(Long productRomotionId) {
		this.productRomotionId = productRomotionId;
	}

	public Integer getPromotionType() {
		return promotionType;
	}

	public void setPromotionType(Integer promotionType) {
		this.promotionType = promotionType;
	}

	public Float getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(Float discountPercent) {
		this.discountPercent = discountPercent;
	}

	public Integer getIsValidate() {
		return isValidate;
	}

	public void setIsValidate(Integer isValidate) {
		this.isValidate = isValidate;
	}

	public BigDecimal getDiscountMoney() {
		return discountMoney;
	}

	public void setDiscountMoney(BigDecimal discountMoney) {
		this.discountMoney = discountMoney;
	}
}
