package com.essential.bussiness.promotion.model.vo;

import java.util.List;

import com.essential.bussiness.promotion.model.auto.PromotionProductAuto;

public class PromotionAutoVo {
	/*** 登录用户 */
	private Long loginUser;
	/*** 促销活动Id */
	private Long promotionId;
	/*** 活动类型 */
	private Integer promotionType;
	/*** 活动名称 */
	private String promotionName;
	/*** 生效开始时间 */
	private String startTime;
	/*** 生效结束时间 */
	private String endTime;
	/*** 活动标签 */
	private String tag;
	/*** 店铺Id */
	private Long shopId;
	/*** 商品折扣信息List */
	private List<PromotionProductAuto> promotionList;

	public Long getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(Long loginUser) {
		this.loginUser = loginUser;
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

	public List<PromotionProductAuto> getPromotionList() {
		return promotionList;
	}

	public void setPromotionList(List<PromotionProductAuto> promotionList) {
		this.promotionList = promotionList;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(Long promotionId) {
		this.promotionId = promotionId;
	}
}
