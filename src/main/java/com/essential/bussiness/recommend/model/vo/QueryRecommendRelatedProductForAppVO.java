package com.essential.bussiness.recommend.model.vo;

import java.util.List;

public class QueryRecommendRelatedProductForAppVO  extends QueryRecommendCarouselVo{
	
	public List<RelatedProductVo> getRelatedProductList() {
		return relatedProductList;
	}

	public void setRelatedProductList(List<RelatedProductVo> relatedProductList) {
		this.relatedProductList = relatedProductList;
	}

	private List<RelatedProductVo> relatedProductList;
	

	
	
	

}
