package com.essential.bussiness.product.model.vo;

public class RejectProductReasonVo {
	// 登录用户
	private Long logenUserId;
	// 商品Id
	private Long productId;
	// 类型
	private Integer type;
	// 原因
	private String rejectReasonContent;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getRejectReasonContent() {
		return rejectReasonContent;
	}

	public void setRejectReasonContent(String rejectReasonContent) {
		this.rejectReasonContent = rejectReasonContent == null ? null : rejectReasonContent.trim();
	}

	public Long getLogenUserId() {
		return logenUserId;
	}

	public void setLogenUserId(Long logenUserId) {
		this.logenUserId = logenUserId;
	}
}
