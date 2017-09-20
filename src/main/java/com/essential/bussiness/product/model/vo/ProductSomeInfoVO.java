package com.essential.bussiness.product.model.vo;

import java.math.BigDecimal;

/**
 * 专栏文章的相关商品的信息
 * 
 * @author czm
 *
 */
public class ProductSomeInfoVO {
	private Long mainId;

	/*** 商品id */
	private Long productId;
	/*** 商品名称 */
	private String productName;
	/*** 商品市场价格 */
	private BigDecimal marketPrice;
	private float costPrice;
	public float getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(float costPrice) {
		this.costPrice = costPrice;
	}

	private String brandName;
	/*** 是否为外链 */
	private int isLinkProduct;
	/*** 商品链接地址 */
	private String linkUrl;
	/*** 商品外链渠道 */
	private String linkFrom;
	/*** 商品图片链接 */
	private String path;
	// gty新加字段start
	private float discountPrice;
	private String isDiscount;

	// gty新加字段end
	public float getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(float discountPrice) {
		this.discountPrice = discountPrice;
	}

	public String getIsDiscount() {
		return isDiscount;
	}

	public void setIsDiscount(String isDiscount) {
		this.isDiscount = isDiscount;
	}

	public Long getMainId() {
		return mainId;
	}

	public void setMainId(Long mainId) {
		this.mainId = mainId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public BigDecimal getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}
}
