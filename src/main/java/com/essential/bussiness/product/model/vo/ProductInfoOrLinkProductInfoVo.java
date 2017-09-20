package com.essential.bussiness.product.model.vo;


public class ProductInfoOrLinkProductInfoVo extends ProductSerchInfoVo {
	// 商品状态名称
	private String saleStatusNume;

	private Long mainId;

	/*** 是否为外链 */
	private int isLinkProduct;
	/*** 商品链接地址 */
	private String linkUrl;
	/*** 商品外链渠道 */
	private String linkFrom;
	public String getSaleStatusNume() {
		return saleStatusNume;
	}
	public void setSaleStatusNume(String saleStatusNume) {
		this.saleStatusNume = saleStatusNume;
	}
	public Long getMainId() {
		return mainId;
	}
	public void setMainId(Long mainId) {
		this.mainId = mainId;
	}
	public int getIsLinkProduct() {
		return isLinkProduct;
	}
	public void setIsLinkProduct(int isLinkProduct) {
		this.isLinkProduct = isLinkProduct;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public String getLinkFrom() {
		return linkFrom;
	}
	public void setLinkFrom(String linkFrom) {
		this.linkFrom = linkFrom;
	}

	
}
