package com.essential.bussiness.shopcart.model.vo;

import java.math.BigDecimal;

import com.essential.bussiness.shopcart.model.auto.ShopCartAuto;

/**
 * 商品sku购物袋业务模型
 * @author essential-gfs
 *
 */
public class SkuShopCartVo extends ShopCartAuto {
	private String specificationValue;
	
	private BigDecimal prices;
	
	private String path;
	
	private String productName;
	
	private Integer saleStatus;
	
	private BigDecimal activityPrices;
	
	private String articleNumber;
	
	private Integer productSkuIsDeleted;
	
	private Integer productSpuIsDeleted;
	
	private Long productskuCount;
	
	public String getSpecificationValue() {
		return specificationValue;
	}

	public void setSpecificationValue(String specificationValue) {
		this.specificationValue = specificationValue;
	}

	public BigDecimal getPrices() {
		return prices;
	}

	public void setPrices(BigDecimal prices) {
		this.prices = prices;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getSaleStatus() {
		return saleStatus;
	}

	public void setSaleStatus(Integer saleStatus) {
		this.saleStatus = saleStatus;
	}

	public BigDecimal getActivityPrices() {
		return activityPrices;
	}

	public void setActivityPrices(BigDecimal activityPrices) {
		this.activityPrices = activityPrices;
	}

	public String getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(String articleNumber) {
		this.articleNumber = articleNumber;
	}

	public Integer getProductSkuIsDeleted() {
		return productSkuIsDeleted;
	}

	public void setProductSkuIsDeleted(Integer productSkuIsDeleted) {
		this.productSkuIsDeleted = productSkuIsDeleted;
	}

	public Integer getProductSpuIsDeleted() {
		return productSpuIsDeleted;
	}

	public void setProductSpuIsDeleted(Integer productSpuIsDeleted) {
		this.productSpuIsDeleted = productSpuIsDeleted;
	}

	public Long getProductskuCount() {
		return productskuCount;
	}

	public void setProductskuCount(Long productskuCount) {
		this.productskuCount = productskuCount;
	}
	
}
