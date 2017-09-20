package com.essential.bussiness.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.essential.bussiness.product.model.vo.Count;
import com.essential.bussiness.product.model.vo.ProductOrShopCountVo;
import com.essential.bussiness.shop.model.auto.ShopAuto;
import com.essential.bussiness.shop.model.vo.ShopInformationPlatformVo;
import com.essential.bussiness.shopcart.model.vo.ShopCartShopVo;

public interface ShopAutoMapper {
	int deleteByPrimaryKey(Long shopId);

	int insert(ShopAuto record);

	int insertSelective(ShopAuto record);

	ShopAuto selectByPrimaryKey(Long shopId);

	int updateByPrimaryKeySelective(ShopAuto record);

	int updateByPrimaryKey(ShopAuto record);

	ShopCartShopVo selectShopCartShopVoByPrimaryKey(@Param("shopId") Long shopId);

	// 查询店铺信息
	ShopAuto queryShopInfo(ShopAuto record);

	// 商家统计
	ProductOrShopCountVo shopCount();

	List<ShopAuto> queryShop(ShopAuto record);

	// 商家列表（平台）
	List<ShopInformationPlatformVo> queryShopList(ShopInformationPlatformVo record);
	Count queryShopListCount(ShopInformationPlatformVo record);
	
	//通过shopId更新（平台）
	int updateByShopId(ShopAuto record);
	
	// 审核商家列表（平台）
	List<ShopInformationPlatformVo> queryAuditingShopList(ShopInformationPlatformVo record);
	Count queryAuditingShopListCount(ShopInformationPlatformVo record);
}