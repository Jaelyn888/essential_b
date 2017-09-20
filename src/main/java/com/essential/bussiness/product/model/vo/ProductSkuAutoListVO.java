package com.essential.bussiness.product.model.vo;

import java.math.BigDecimal;
import java.util.List;

/**
 * 商品sku 信息
 * 
 * @author czm
 *
 */
public class ProductSkuAutoListVO {
	/*** skuId */
	private Long productskuId;
	/*** 商品代码 */
	private String articleNumber;
	/*** 价格 */
	private BigDecimal prices;
	/*** 商品Id */
	private Long productId;
	/*** 库存 */
	private Long productskuCount;
	/*** sku规格关系List */
	private List<ProductSkuRelationVO> productSkuRelationList;

	public Long getProductskuId() {
		return productskuId;
	}

	public void setProductskuId(Long productskuId) {
		this.productskuId = productskuId;
	}

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

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getProductskuCount() {
		return productskuCount;
	}

	public void setProductskuCount(Long productskuCount) {
		this.productskuCount = productskuCount;
	}

	public List<ProductSkuRelationVO> getProductSkuRelationList() {
		return productSkuRelationList;
	}

	public void setProductSkuRelationList(List<ProductSkuRelationVO> productSkuRelationList) {
		this.productSkuRelationList = productSkuRelationList;
	}
}
