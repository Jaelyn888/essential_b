package com.essential.bussiness.recommend.model.vo;

import com.essential.bussiness.recommend.model.auto.RecommendAuto;

public class RecommendInputParamVo extends RecommendAuto  {
	
	private int requestType;
    public int getRequestType() {
		return requestType;
	}
	public void setRequestType(int requestType) {
		this.requestType = requestType;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	private Integer pageSize;
	
	
	

}
