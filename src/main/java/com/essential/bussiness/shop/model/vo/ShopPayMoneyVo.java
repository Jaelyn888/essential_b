package com.essential.bussiness.shop.model.vo;

import java.math.BigDecimal;

public class ShopPayMoneyVo {
	// 店铺Id
	private Long shopId;
	// 店铺保证金
	private BigDecimal payMoney;
	// 保证金缴纳时间
	private String ispaytime;
	// 店铺服务费
	private String shopServiceMoney;
	// 登录用户
	private Long logenUser;

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public BigDecimal getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(BigDecimal payMoney) {
		this.payMoney = payMoney;
	}

	public String getIspaytime() {
		return ispaytime;
	}

	public void setIspaytime(String ispaytime) {
		this.ispaytime = ispaytime == null ? null : ispaytime.trim();
	}

	public Long getLogenUser() {
		return logenUser;
	}

	public void setLogenUser(Long logenUser) {
		this.logenUser = logenUser;
	}

	public String getShopServiceMoney() {
		return shopServiceMoney;
	}

	public void setShopServiceMoney(String shopServiceMoney) {
		this.shopServiceMoney = shopServiceMoney;
	}
}
