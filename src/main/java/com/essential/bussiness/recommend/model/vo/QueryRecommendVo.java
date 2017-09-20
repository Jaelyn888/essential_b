package com.essential.bussiness.recommend.model.vo;

import com.essential.bussiness.recommend.model.auto.RecommendAuto;

/**
 * 推荐列表查询Vo
 * @author essential-gfs
 *
 */
public class QueryRecommendVo extends RecommendAuto {
	//页码
    private Integer pageNo;
    //每页数量
    private Integer pageCount;
    
	public Integer getPageNo() {
		return pageNo;
	}
	
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	
	public Integer getPageCount() {
		return pageCount;
	}
	
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
}
