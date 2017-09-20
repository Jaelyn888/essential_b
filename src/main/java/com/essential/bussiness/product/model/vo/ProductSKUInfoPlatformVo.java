package com.essential.bussiness.product.model.vo;

import java.math.BigDecimal;
import java.util.List;

public class ProductSKUInfoPlatformVo {
	/*** SKU Id */
	private Long productskuId;
	/*** 商品代码 */
	private String articleNumber;
	/*** 价格 */
	private BigDecimal prices;
	/*** 库存 */
	private Long productskuCount;
	/*** sku规格关系List */
	private List<ProductSKURelationInfoPlatformVo> productSkuRelationList;

	public String getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(String articleNumber) {
		this.articleNumber = articleNumber;
	}

	public BigDecimal getPrices() {
		return prices;
	}

	public void setPrices(BigDecimal prices) {
		this.prices = prices;
	}

	public Long getProductskuCount() {
		return productskuCount;
	}

	public void setProductskuCount(Long productskuCount) {
		this.productskuCount = productskuCount;
	}

	public List<ProductSKURelationInfoPlatformVo> getProductSkuRelationList() {
		return productSkuRelationList;
	}

	public void setProductSkuRelationList(List<ProductSKURelationInfoPlatformVo> productSkuRelationList) {
		this.productSkuRelationList = productSkuRelationList;
	}

	public Long getProductskuId() {
		return productskuId;
	}

	public void setProductskuId(Long productskuId) {
		this.productskuId = productskuId;
	}
}
