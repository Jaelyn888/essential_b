package com.essential.bussiness.promotion.model.vo;

import java.util.List;

import com.essential.bussiness.promotion.model.auto.PromotionAuto;

public class PromotionAutoInfoVo{
	//总条数
	private Integer pageCount;
	
	//活动列表List
	private List<PromotionAuto> promotionAutoList;

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public List<PromotionAuto> getPromotionAutoList() {
		return promotionAutoList;
	}

	public void setPromotionAutoList(List<PromotionAuto> promotionAutoList) {
		this.promotionAutoList = promotionAutoList;
	}

}
