package com.essential.bussiness.promotion.model.vo;

import java.math.BigDecimal;

public class PromotionProductVo {
	/*** 商品Id */
	private Long productId;
	/*** 商品名称 */
	private String productName;
	/*** 原价 */
	private BigDecimal costPrice;
	/*** 折扣价 */
	private BigDecimal discountPrice;
	/*** 折扣 */
	private Float discountPercent;
	/*** 商品图片 */
	private String path;
	/*** 商品代码 */
	private String articleNumber;
	/*** 商品最大价格 */
	private String productintro;
	/*** 库存 */
	private Long stock;
	/*** 参加活动类型 */
	private Integer promotionType;
	/*** 商品活动状态名 */
	private String producteStatusName;
	/*** 商品与活动关联Id */
	private Long productRomotionId;
	/*** 活动Id */
	private Long promotionId;
	/*** 活动价 */
	private BigDecimal discountMoney;
	/***  登录用户 */
	private Long loginUser;
	private Integer isValidate;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName == null ? null : productName.trim();
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path == null ? null : path.trim();
	}

	public String getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(String articleNumber) {
		this.articleNumber = articleNumber == null ? null : articleNumber.trim();
	}

	public String getProductintro() {
		return productintro;
	}

	public void setProductintro(String productintro) {
		this.productintro = productintro == null ? null : productintro.trim();
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public Integer getPromotionType() {
		return promotionType;
	}

	public void setPromotionType(Integer promotionType) {
		this.promotionType = promotionType;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public BigDecimal getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(BigDecimal discountPrice) {
		this.discountPrice = discountPrice;
	}

	public String getProducteStatusName() {
		return producteStatusName;
	}

	public void setProducteStatusName(String producteStatusName) {
		this.producteStatusName = producteStatusName == null ? null : producteStatusName.trim();
	}

	public Float getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(Float discountPercent) {
		this.discountPercent = discountPercent;
	}

	public Long getProductRomotionId() {
		return productRomotionId;
	}

	public void setProductRomotionId(Long productRomotionId) {
		this.productRomotionId = productRomotionId;
	}

	public Long getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(Long promotionId) {
		this.promotionId = promotionId;
	}

	public BigDecimal getDiscountMoney() {
		return discountMoney;
	}

	public void setDiscountMoney(BigDecimal discountMoney) {
		this.discountMoney = discountMoney;
	}

	public Long getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(Long loginUser) {
		this.loginUser = loginUser;
	}

	public Integer getIsValidate() {
		return isValidate;
	}

	public void setIsValidate(Integer isValidate) {
		this.isValidate = isValidate;
	}

}
