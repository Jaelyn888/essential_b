package com.essential.bussiness.product.model.vo;

import java.math.BigDecimal;
import java.util.List;

public class ProductDetaileInfoPlatformVo {
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

	private Integer isDelete;

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

	private String createTime;

	private Long createUser;

	private String modifyTime;

	private Long modifyUser;

	private Integer status;
	// 品牌名称
	private String brandName;
	// 分类名称
	private String categoryName;
	// 小分类名称
	private String productTypeName;
	// 商品主图路径
	private List<String> picturePathList;
	// SKU  List
	private List<ProductSKUInfoPlatformVo> productSkuList;

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
		this.productName = productName == null ? null : productName.trim();
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
		this.keyword = keyword == null ? null : keyword.trim();
	}

	public String getProductDescribe() {
		return productDescribe;
	}

	public void setProductDescribe(String productDescribe) {
		this.productDescribe = productDescribe == null ? null : productDescribe.trim();
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
		this.articleNumber = articleNumber == null ? null : articleNumber.trim();
	}

	public String getSalesName() {
		return salesName;
	}

	public void setSalesName(String salesName) {
		this.salesName = salesName == null ? null : salesName.trim();
	}

	public String getPackingList() {
		return packingList;
	}

	public void setPackingList(String packingList) {
		this.packingList = packingList == null ? null : packingList.trim();
	}

	public String getAfterService() {
		return afterService;
	}

	public void setAfterService(String afterService) {
		this.afterService = afterService == null ? null : afterService.trim();
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
		this.twoDimensionPath = twoDimensionPath == null ? null : twoDimensionPath.trim();
	}

	public String getPncode() {
		return pncode;
	}

	public void setPncode(String pncode) {
		this.pncode = pncode == null ? null : pncode.trim();
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
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
		this.linkUrl = linkUrl == null ? null : linkUrl.trim();
	}

	public String getLinkFrom() {
		return linkFrom;
	}

	public void setLinkFrom(String linkFrom) {
		this.linkFrom = linkFrom == null ? null : linkFrom.trim();
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
		this.productDetailPics = productDetailPics == null ? null : productDetailPics.trim();
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point == null ? null : point.trim();
	}

	public String getReturnProductExplain() {
		return returnProductExplain;
	}

	public void setReturnProductExplain(String returnProductExplain) {
		this.returnProductExplain = returnProductExplain == null ? null : returnProductExplain.trim();
	}

	public String getReturnProductExplainPics() {
		return returnProductExplainPics;
	}

	public void setReturnProductExplainPics(String returnProductExplainPics) {
		this.returnProductExplainPics = returnProductExplainPics == null ? null : returnProductExplainPics.trim();
	}

	public String getWords() {
		return words;
	}

	public void setWords(String words) {
		this.words = words == null ? null : words.trim();
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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Long getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Long getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(Long modifyUser) {
		this.modifyUser = modifyUser;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName == null ? null : brandName.trim();
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName == null ? null : categoryName.trim();
	}

	public String getProductTypeName() {
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName == null ? null : productTypeName.trim();
	}

	public List<String> getPicturePathList() {
		return picturePathList;
	}

	public void setPicturePathList(List<String> picturePathList) {
		this.picturePathList = picturePathList;
	}

	public List<ProductSKUInfoPlatformVo> getProductSkuList() {
		return productSkuList;
	}

	public void setProductSkuList(List<ProductSKUInfoPlatformVo> productSkuList) {
		this.productSkuList = productSkuList;
	}
}
