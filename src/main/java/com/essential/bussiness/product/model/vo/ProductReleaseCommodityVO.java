package com.essential.bussiness.product.model.vo;

import java.math.BigDecimal;
import java.util.List;

public class ProductReleaseCommodityVO {

	private Long productId;

	private Long brandId;

	private Long categoryId;

	private Long productTypeId;

	private Long shopId;

	private String productName;

	private BigDecimal price;

	private String keyword;

	private String productDescribe;

	private String productintro;

	private Long stock;

	private Integer isRecommd;

	private BigDecimal costPrice;

	private BigDecimal marketPrice;

	private String articleNumber;

	private String salesName;

	private String packingList;

	private String afterService;

	private Long saleNum;

	private String deliveryTime;

	private Integer checkStatusid;

	private String twoDimensionPath;

	private String pncode;

	private Integer status;

	private Integer isLinkProduct;

	private String linkUrl;

	private String linkFrom;

	private Long totalStoreNum;

	private Long bookStoreNum;

	private Integer saleStatus;

	private String productDetailPics;

	private String point;

	private String returnProductExplain;

	private String returnProductExplainPics;

	private String words;

	private Integer freightType;

	private BigDecimal freightPrice;

	private Long freightGroupId;

	private Long loginUser;

	/*** 商品图片路径 */
	private List<String> picturePathList;

	/*** sku List */
	private List<ProductSkuAutoListVO> productSkuAutoList;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
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

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public String getProductDescribe() {
		return productDescribe;
	}

	public void setProductDescribe(String productDescribe) {
		this.productDescribe = productDescribe;
	}

	public String getProductintro() {
		return productintro;
	}

	public void setProductintro(String productintro) {
		this.productintro = productintro;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public Integer getIsRecommd() {
		return isRecommd;
	}

	public void setIsRecommd(Integer isRecommd) {
		this.isRecommd = isRecommd;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	public BigDecimal getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}

	public String getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(String articleNumber) {
		this.articleNumber = articleNumber;
	}

	public String getSalesName() {
		return salesName;
	}

	public void setSalesName(String salesName) {
		this.salesName = salesName;
	}

	public String getPackingList() {
		return packingList;
	}

	public void setPackingList(String packingList) {
		this.packingList = packingList;
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

	public Integer getCheckStatusid() {
		return checkStatusid;
	}

	public void setCheckStatusid(Integer checkStatusid) {
		this.checkStatusid = checkStatusid;
	}

	public String getTwoDimensionPath() {
		return twoDimensionPath;
	}

	public void setTwoDimensionPath(String twoDimensionPath) {
		this.twoDimensionPath = twoDimensionPath;
	}

	public String getPncode() {
		return pncode;
	}

	public void setPncode(String pncode) {
		this.pncode = pncode;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsLinkProduct() {
		return isLinkProduct;
	}

	public void setIsLinkProduct(Integer isLinkProduct) {
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

	public Long getTotalStoreNum() {
		return totalStoreNum;
	}

	public void setTotalStoreNum(Long totalStoreNum) {
		this.totalStoreNum = totalStoreNum;
	}

	public Long getBookStoreNum() {
		return bookStoreNum;
	}

	public void setBookStoreNum(Long bookStoreNum) {
		this.bookStoreNum = bookStoreNum;
	}

	public Integer getSaleStatus() {
		return saleStatus;
	}

	public void setSaleStatus(Integer saleStatus) {
		this.saleStatus = saleStatus;
	}

	public String getProductDetailPics() {
		return productDetailPics;
	}

	public void setProductDetailPics(String productDetailPics) {
		this.productDetailPics = productDetailPics;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public String getReturnProductExplain() {
		return returnProductExplain;
	}

	public void setReturnProductExplain(String returnProductExplain) {
		this.returnProductExplain = returnProductExplain;
	}

	public String getReturnProductExplainPics() {
		return returnProductExplainPics;
	}

	public void setReturnProductExplainPics(String returnProductExplainPics) {
		this.returnProductExplainPics = returnProductExplainPics;
	}

	public String getWords() {
		return words;
	}

	public void setWords(String words) {
		this.words = words;
	}

	public Integer getFreightType() {
		return freightType;
	}

	public void setFreightType(Integer freightType) {
		this.freightType = freightType;
	}

	public BigDecimal getFreightPrice() {
		return freightPrice;
	}

	public void setFreightPrice(BigDecimal freightPrice) {
		this.freightPrice = freightPrice;
	}

	public Long getFreightGroupId() {
		return freightGroupId;
	}

	public void setFreightGroupId(Long freightGroupId) {
		this.freightGroupId = freightGroupId;
	}

	public Long getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(Long loginUser) {
		this.loginUser = loginUser;
	}

	public List<String> getPicturePathList() {
		return picturePathList;
	}

	public void setPicturePathList(List<String> picturePathList) {
		this.picturePathList = picturePathList;
	}

	public List<ProductSkuAutoListVO> getProductSkuAutoList() {
		return productSkuAutoList;
	}

	public void setProductSkuAutoList(List<ProductSkuAutoListVO> productSkuAutoList) {
		this.productSkuAutoList = productSkuAutoList;
	}
}
