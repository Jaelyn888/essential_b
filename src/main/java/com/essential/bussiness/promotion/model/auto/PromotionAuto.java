package com.essential.bussiness.promotion.model.auto;

import java.math.BigDecimal;

public class PromotionAuto {
	private Long promotionId;

	private Integer promotionType;

	private String promotionName;

	private String startTime;

	private String endTime;

	private BigDecimal discountMoney;

	private Float discountPercent;

	private BigDecimal needTotalPrice;

	private Integer isMultistage;

	private Integer isFreeShipping;

	private Integer isValidate;

	private Integer promotionStatus;

	private Long createUser;

	private String creatTime;

	private Long modifyUser;

	private String modifyTime;

	private String tag;

	private Integer isDelelte;

	private Long shopId;

	private String remark1;

	private String remark2;

	private String remark3;

	private String remark4;

	private String remark5;

	private String remark6;

	private String remark7;

	private String remark8;

	private String remark9;

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

	public String getPromotionName() {
		return promotionName;
	}

	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName == null ? null : promotionName.trim();
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime == null ? null : startTime.trim();
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime == null ? null : endTime.trim();
	}

	public BigDecimal getDiscountMoney() {
		return discountMoney;
	}

	public void setDiscountMoney(BigDecimal discountMoney) {
		this.discountMoney = discountMoney;
	}

	public Float getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(Float discountPercent) {
		this.discountPercent = discountPercent;
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

	public Integer getIsFreeShipping() {
		return isFreeShipping;
	}

	public void setIsFreeShipping(Integer isFreeShipping) {
		this.isFreeShipping = isFreeShipping;
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

	public Long getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}

	public String getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime == null ? null : creatTime.trim();
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

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag == null ? null : tag.trim();
	}

	public Integer getIsDelelte() {
		return isDelelte;
	}

	public void setIsDelelte(Integer isDelelte) {
		this.isDelelte = isDelelte;
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

	public String getRemark6() {
		return remark6;
	}

	public void setRemark6(String remark6) {
		this.remark6 = remark6 == null ? null : remark6.trim();
	}

	public String getRemark7() {
		return remark7;
	}

	public void setRemark7(String remark7) {
		this.remark7 = remark7 == null ? null : remark7.trim();
	}

	public String getRemark8() {
		return remark8;
	}

	public void setRemark8(String remark8) {
		this.remark8 = remark8 == null ? null : remark8.trim();
	}

	public String getRemark9() {
		return remark9;
	}

	public void setRemark9(String remark9) {
		this.remark9 = remark9 == null ? null : remark9.trim();
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
}