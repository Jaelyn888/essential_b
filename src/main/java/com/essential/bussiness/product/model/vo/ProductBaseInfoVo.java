package com.essential.bussiness.product.model.vo;

import java.math.BigDecimal;

/**
 * 商品基本信息vo，商品列表显示
 * @author Jaelyn
 *
 */
public class ProductBaseInfoVo {
	/*** 商品id */
	private Long productId;
	/*** 商品名称 */
	private String productName;
	/*** 商品图片路径 */
	private String path;
	/*** 品牌Id */
	private Long brandId;
	/*** 品牌名称 */
	private String brandName;
	/*** 原价*/
    private double costPrice;
    /*** 市场价格 */
    private double marketPrice;
    /**
     * 打折价格
     */
    private double discountPrice; 
    /*** 活动标签   不为空表示有活动*/
    private String tag;
    /**
     * 是否打折
     */
    private int isDiscount;
    /**
     * 是否为自营  1：自营，0：非自营
     */
    private String linkFrom;
    /**
     * 创建时间
     */
    private String createTime;
    
    
    
	public int getIsDiscount() {
		return isDiscount;
	}
	public void setIsDiscount(int isDiscount) {
		this.isDiscount = isDiscount;
	}
	public double getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getLinkFrom() {
		return linkFrom;
	}
	public void setLinkFrom(String linkFrom) {
		this.linkFrom = linkFrom;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
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
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Long getBrandId() {
		return brandId;
	}
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	
	public double getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}
	public double getMarketPrice() {
		return marketPrice;
	}
	public void setMarketPrice(double marketPrice) {
		this.marketPrice = marketPrice;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
}
