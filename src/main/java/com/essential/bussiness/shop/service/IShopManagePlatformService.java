package com.essential.bussiness.shop.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.bussiness.shop.model.vo.ShopAddInformationVo;
import com.essential.bussiness.shop.model.vo.ShopAuditingVo;
import com.essential.bussiness.shop.model.vo.ShopInformationPlatformVo;
import com.essential.bussiness.shop.model.vo.ShopPayMoneyVo;

@Service
public interface IShopManagePlatformService {
	// 查询商家列表
	public Map<String, Object> queryShopList(ShopInformationPlatformVo shopInformationPlatformVo);

	// 查看店铺详情
	public Map<String, Object> queryDetialShopInfo(Long shopId);

	// 禁用/启用店铺
	public Map<String, Object> disableOrEnableShop(ShopAddInformationVo shopAddInformationVo);

	// 店铺所销售的品牌
	public Map<String, Object> shopBrand(Long shopId, Integer pageIndex, Integer pageSize);

	// 修改店铺保证金额
	public Map<String, Object> updateShopPayMoney(ShopPayMoneyVo shopPayMoneyVo);

	// 通过/驳回
	public Map<String, Object> auditingShop(ShopAuditingVo shopAuditingVo);

	// 审核商家列表
	public Map<String, Object> auditingShopList(ShopInformationPlatformVo shopInformationPlatformVo);
}
