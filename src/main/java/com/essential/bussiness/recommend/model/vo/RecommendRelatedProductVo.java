package com.essential.bussiness.recommend.model.vo;

import java.math.BigDecimal;

import com.essential.bussiness.product.model.auto.ProductAuto;

/**
 * 推荐相关商品Vo
 * @author essential-gfs
 *
 */
public class RecommendRelatedProductVo extends ProductAuto {
	// 品牌名称
	private String brandName;
	// 分类名称
	private String categoryName;
	// 店铺名称
	private String shopName;
	//活动价
	private BigDecimal activityPrice;
	//活动标识
	private Integer activityFlag;
	//推荐相关商品id
	private Long recommendRelatedProductId;
	//商品主图
	private String path;
	
	public String getBrandName() {
		return brandName;
	}
	
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public String getShopName() {
		return shopName;
	}
	
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	
	public BigDecimal getActivityPrice() {
		return activityPrice;
	}
	
	public void setActivityPrice(BigDecimal activityPrice) {
		this.activityPrice = activityPrice;
	}

	public Long getRecommendRelatedProductId() {
		return recommendRelatedProductId;
	}

	public void setRecommendRelatedProductId(Long recommendRelatedProductId) {
		this.recommendRelatedProductId = recommendRelatedProductId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getActivityFlag() {
		return activityFlag;
	}

	public void setActivityFlag(Integer activityFlag) {
		this.activityFlag = activityFlag;
	}
}
