package com.essential.bussiness.promotion.model.vo;

import java.util.List;

import com.essential.bussiness.promotion.model.auto.PromotionProductAuto;

public class PromotionRevokeProductVo {
	// 登录用户
	private Long loginUser;
	// 活动Id
	private Long promotionId;
	// 商品Id
	List<PromotionProductAuto> revokeProductIdList;

	public List<PromotionProductAuto> getRevokeProductIdList() {
		return revokeProductIdList;
	}

	public void setRevokeProductIdList(List<PromotionProductAuto> revokeProductIdList) {
		this.revokeProductIdList = revokeProductIdList;
	}

	public Long getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(Long loginUser) {
		this.loginUser = loginUser;
	}

	public Long getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(Long promotionId) {
		this.promotionId = promotionId;
	}
}
