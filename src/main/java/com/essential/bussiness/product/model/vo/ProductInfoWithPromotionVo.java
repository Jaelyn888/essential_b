package com.essential.bussiness.product.model.vo;

import java.math.BigDecimal;

/**
 * 含有折扣信息的商品信息
 * @author Jaelyn
 *
 */
public class ProductInfoWithPromotionVo  extends ProductBaseInfoVo{
	private Integer promotionType;

	private String promotionName;

	private String startTime;

	private String endTime;


    private Float discountPercent;

    private BigDecimal discountMoney;

    private BigDecimal needTotalPrice;

    private Integer isMultistage;

    private Integer isValidate;

	public Integer getPromotionType() {
		return promotionType;
	}

	public void setPromotionType(Integer promotionType) {
		this.promotionType = promotionType;
	}

	public String getPromotionName() {
		return promotionName;
	}

	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
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
	

}
