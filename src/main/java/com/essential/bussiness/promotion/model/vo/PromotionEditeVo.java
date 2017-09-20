package com.essential.bussiness.promotion.model.vo;

import java.util.List;

import com.essential.bussiness.promotion.model.auto.PromotionProductAuto;

public class PromotionEditeVo {
	// 活动Id
	private Long promotionId;
	// 总条数
	private Integer pageCount;
	// 活动名称
	private String promotionName;
	// 活动开始时间
	private String startTime;
	// 活动结束时间
	private String endTime;
	// 活动标签
	private String tag;
	// 商品列表
	private List<PromotionProductVo> promotionProductList;

	public Long getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(Long promotionId) {
		this.promotionId = promotionId;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
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

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag == null ? null : tag.trim();
	}

	public List<PromotionProductVo> getPromotionProductList() {
		return promotionProductList;
	} 

	public void setPromotionProductList(List<PromotionProductVo> promotionProductList) {
		this.promotionProductList = promotionProductList;
	}
}
