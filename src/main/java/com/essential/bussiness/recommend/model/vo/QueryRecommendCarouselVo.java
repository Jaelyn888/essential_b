package com.essential.bussiness.recommend.model.vo;

import com.essential.bussiness.recommend.model.auto.RecommendAuto;

public class QueryRecommendCarouselVo extends RecommendAuto  {
	private String  picPath;
	
	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public String getPicSort() {
		return picSort;
	}

	public void setPicSort(String picSort) {
		this.picSort = picSort;
	}

	private String picSort;
	
	
	

}
