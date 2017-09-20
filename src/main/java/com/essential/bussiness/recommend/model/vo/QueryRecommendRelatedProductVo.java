package com.essential.bussiness.recommend.model.vo;

import com.essential.bussiness.recommend.model.auto.RecommendRelatedProductAuto;


/**
 * 查询推荐相关商品Vo
 * @author essential-gfs
 *
 */
public class QueryRecommendRelatedProductVo extends RecommendRelatedProductAuto {
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
