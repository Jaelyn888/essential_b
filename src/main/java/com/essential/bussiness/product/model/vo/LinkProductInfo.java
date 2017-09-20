package com.essential.bussiness.product.model.vo;

import java.math.BigDecimal;

/**
 * 外链商品信息
 * @author Jaelyn
 *
 */
public class LinkProductInfo {
    private Long linkId;

    private String linkFrom;

    private String productName;

    private String brandName;

    private String path;

    private BigDecimal marketPrice;

    private BigDecimal price;

    private String linkUrl;

    private String createTime;

    private BigDecimal costPrice;

	public Long getLinkId() {
		return linkId;
	}

	public void setLinkId(Long linkId) {
		this.linkId = linkId;
	}

	public String getLinkFrom() {
		return linkFrom;
	}

	public void setLinkFrom(String linkFrom) {
		this.linkFrom = linkFrom;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}
    
    
}
