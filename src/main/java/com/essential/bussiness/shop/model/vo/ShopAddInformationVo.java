package com.essential.bussiness.shop.model.vo;

import com.essential.bussiness.shop.model.auto.ShopAddInformationAuto;

public class ShopAddInformationVo extends ShopAddInformationAuto {

	//类型 0-启用，1-禁用
	private Integer type;

	private Long logenUser;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getLogenUser() {
		return logenUser;
	}

	public void setLogenUser(Long logenUser) {
		this.logenUser = logenUser;
	}
}
