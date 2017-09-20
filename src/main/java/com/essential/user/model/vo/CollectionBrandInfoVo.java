package com.essential.user.model.vo;

import com.essential.bussiness.brand.model.vo.BrandBaseInfoVo;

public class CollectionBrandInfoVo extends BrandBaseInfoVo {

	private int isCollected=1;

	public int getIsCollected() {
		return isCollected;
	}

	public void setIsCollected(int isCollected) {
		this.isCollected = isCollected;
	}	
	
}
