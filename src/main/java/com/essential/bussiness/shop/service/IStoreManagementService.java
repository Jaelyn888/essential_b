package com.essential.bussiness.shop.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.essential.bussiness.shop.model.auto.EntityShopAuto;

/**
 * 门店管理（商家后台） interface
 * 
 * @author czm
 *
 */
@Service
public interface IStoreManagementService {

	// 添加
	public Map<String, Object> addStoreAddressInfo(EntityShopAuto entityshopAuto);

	// 查询
	public Map<String, Object> queryStoreInfo(HttpServletRequest request);

	// 删除
	public Map<String, Object> deleteStoreAddressInfo(Long[] entityshopIds);
}
