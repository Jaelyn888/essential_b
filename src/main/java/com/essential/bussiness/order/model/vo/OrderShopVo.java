package com.essential.bussiness.order.model.vo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.essential.bussiness.shopcart.model.vo.SkuShopCartVo;

/**
 * 提交订单店铺Vo
 * @author essential-gfs
 *
 */
public class OrderShopVo {

	private Long shopId;

	private String buyerNote;
	
	private BigDecimal shopFreight;

	private List<SkuShopCartVo> skuShopCartVos = new ArrayList<SkuShopCartVo>();

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getBuyerNote() {
		return buyerNote;
	}

	public void setBuyerNote(String buyerNote) {
		this.buyerNote = buyerNote;
	}

	public BigDecimal getShopFreight() {
		return shopFreight;
	}

	public void setShopFreight(BigDecimal shopFreight) {
		this.shopFreight = shopFreight;
	}

	public List<SkuShopCartVo> getSkuShopCartVos() {
		return skuShopCartVos;
	}

	public void setSkuShopCartVos(List<SkuShopCartVo> skuShopCartVos) {
		this.skuShopCartVos = skuShopCartVos;
	}

}
