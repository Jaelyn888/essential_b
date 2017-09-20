package com.essential.bussiness.shop.model.vo;

import java.util.List;

import com.essential.bussiness.brand.model.auto.BrandAuto;

public class ShopBrandPlatformVo {
	// 总数
	private Integer pageCount;
	// 店铺所售品牌List
	private List<BrandAuto> shopBrandList;

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public List<BrandAuto> getShopBrandList() {
		return shopBrandList;
	}

	public void setShopBrandList(List<BrandAuto> shopBrandList) {
		this.shopBrandList = shopBrandList;
	}

}
