package com.essential.bussiness.promotion.model.vo;

import java.math.BigDecimal;

public class PromotionProductInfoVo {
	/*** 促销活动Id */
	private Long promotionId;
	/*** 促销活动类型 */
	private Integer promotionType;
	/*** 商品Id或店铺Id */
	private Long productOrShopId;
	/*** 打折 */
	private Float discountPercent;
	/*** 减免金额 */
	private BigDecimal discountMoney;
	/*** 满足条件金额 */
	private BigDecimal needTotalPrice;
	/*** 是否多个活动 */
	private Integer isMultistage;
	/*** 活动名称 */
	private String promotionName;
	/*** 生效开始时间 */
	private String startTime;
	/*** 生效结束时间 */
	private String endTime;
	/*** 活动标签 */
	private String tag;
	/*** 是否失效 */
	private Integer isValidate;

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

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Integer getIsValidate() {
		return isValidate;
	}

	public void setIsValidate(Integer isValidate) {
		this.isValidate = isValidate;
	}

}
