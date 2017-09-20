package com.essential.bussiness.shopcart.model.vo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 购物袋业务模型
 * @author essential-gfs
 *
 */
public class ShopCartVo {
	
	private Long shopId;

    private String name;
    
    private String logoPath;
    
    private String shoptypeName;
    
    private double shopFreight;
    
    private BigDecimal shopSelectedProductPrice;
    
    private List<SkuShopCartVo> skuShopCartVo = new ArrayList<SkuShopCartVo>();
    
    private Integer isAllSelected;
    
    private int shopProductCount;
    
    private BigDecimal shopSelectedTotalActivityPrice;

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	public List<SkuShopCartVo> getSkuShopCartVo() {
		return skuShopCartVo;
	}

	public void setSkuShopCartVo(List<SkuShopCartVo> skuShopCartVo) {
		this.skuShopCartVo = skuShopCartVo;
	}

	public String getShoptypeName() {
		return shoptypeName;
	}

	public void setShoptypeName(String shoptypeName) {
		this.shoptypeName = shoptypeName;
	}

	public double getShopFreight() {
		return shopFreight;
	}

	public void setShopFreight(double shopFreight) {
		this.shopFreight = shopFreight;
	}

	public BigDecimal getShopSelectedProductPrice() {
		return shopSelectedProductPrice;
	}

	public void setShopSelectedProductPrice(BigDecimal shopSelectedProductPrice) {
		this.shopSelectedProductPrice = shopSelectedProductPrice;
	}

	public Integer getIsAllSelected() {
		return isAllSelected;
	}

	public void setIsAllSelected(Integer isAllSelected) {
		this.isAllSelected = isAllSelected;
	}

	public int getShopProductCount() {
		return shopProductCount;
	}

	public void setShopProductCount(int shopProductCount) {
		this.shopProductCount = shopProductCount;
	}

	public BigDecimal getShopSelectedTotalActivityPrice() {
		return shopSelectedTotalActivityPrice;
	}

	public void setShopSelectedTotalActivityPrice(BigDecimal shopSelectedTotalActivityPrice) {
		this.shopSelectedTotalActivityPrice = shopSelectedTotalActivityPrice;
	}

}
