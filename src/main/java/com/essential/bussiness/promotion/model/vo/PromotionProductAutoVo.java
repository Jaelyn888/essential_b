package com.essential.bussiness.promotion.model.vo;

import java.util.List;

public class PromotionProductAutoVo{
	//总条数
	private Integer pageCount;
	//活动商品列表List
	private List<PromotionProductVo> promotionProductVoList;
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public List<PromotionProductVo> getPromotionProductVoList() {
		return promotionProductVoList;
	}
	public void setPromotionProductVoList(List<PromotionProductVo> promotionProductVoList) {
		this.promotionProductVoList = promotionProductVoList;
	}
}
