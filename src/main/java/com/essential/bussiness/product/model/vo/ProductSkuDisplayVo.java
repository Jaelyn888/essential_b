package com.essential.bussiness.product.model.vo;

import java.math.BigDecimal;

/**
 * 商品及规格信息模型(用于前端已定规格的商品信息展示)
 * 
 * @author essential-gfs
 *
 */
public class ProductSkuDisplayVo {

	// 商品skuId
	private Long productSkuId;
	// 商品id
	private Long productId;
	// 商品名称
	private String productName;
	// 品牌id
	private Long brandId;
	// 商品品类id
	private Long categoryId;
	// 商品分类id
	private Long productTypeId;
	// 商品价格
	private BigDecimal price;
	// 商品关键字
	private String keyword;
	// 是否为推荐
	private Integer isRecommd;
	// 商品出售名称
	private String salesName;
	// 售后
	private String afterService;
	// 商品售卖总数量
	private Long saleNum;
	// 配送时间
	private String deliveryTime;
	// 上架下架,0为下架，1为上架
	private Integer saleStatus;
	// 商品图片路径
	private String path;
	// 商品规格
	private String specificationValue;
	// 购买数量
	private Integer buyCount;

	public Long getProductSkuId() {
		return productSkuId;
	}

	public void setProductSkuId(Long productSkuId) {
		this.productSkuId = productSkuId;
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

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(Long productTypeId) {
		this.productTypeId = productTypeId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getIsRecommd() {
		return isRecommd;
	}

	public void setIsRecommd(Integer isRecommd) {
		this.isRecommd = isRecommd;
	}

	public String getSalesName() {
		return salesName;
	}

	public void setSalesName(String salesName) {
		this.salesName = salesName;
	}

	public String getAfterService() {
		return afterService;
	}

	public void setAfterService(String afterService) {
		this.afterService = afterService;
	}

	public Long getSaleNum() {
		return saleNum;
	}

	public void setSaleNum(Long saleNum) {
		this.saleNum = saleNum;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public Integer getSaleStatus() {
		return saleStatus;
	}

	public void setSaleStatus(Integer saleStatus) {
		this.saleStatus = saleStatus;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSpecificationValue() {
		return specificationValue;
	}

	public void setSpecificationValue(String specificationValue) {
		this.specificationValue = specificationValue;
	}

	public Integer getBuyCount() {
		return buyCount;
	}

	public void setBuyCount(Integer buyCount) {
		this.buyCount = buyCount;
	}

}
