package com.essential.bussiness.brand.model.vo;

import java.util.ArrayList;
import java.util.List;

import com.essential.bussiness.brand.model.auto.BrandAuto;

/**
 * 平台查询品牌列表Vo
 * @author essential-gfs
 *
 */
public class BrandVo extends BrandAuto {
	private Integer pageCount;
	
	private Integer pageNo;
	
	private List<BrandCategoryVo> brandCategoryVoList = new ArrayList<BrandCategoryVo>();

	public List<BrandCategoryVo> getBrandCategoryVoList() {
		return brandCategoryVoList;
	}

	public void setBrandCategoryVoList(List<BrandCategoryVo> brandCategoryVoList) {
		this.brandCategoryVoList = brandCategoryVoList;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

}
