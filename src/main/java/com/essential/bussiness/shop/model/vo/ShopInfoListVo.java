package com.essential.bussiness.shop.model.vo;

import java.util.List;

public class ShopInfoListVo {
	// 总数
	private Integer pageCount;
	// 商家列表List
	private List<ShopInformationPlatformVo> shopInforList;

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public List<ShopInformationPlatformVo> getShopInforList() {
		return shopInforList;
	}

	public void setShopInforList(List<ShopInformationPlatformVo> shopInforList) {
		this.shopInforList = shopInforList;
	}
}
