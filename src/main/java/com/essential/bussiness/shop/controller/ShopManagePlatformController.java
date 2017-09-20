package com.essential.bussiness.shop.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.bussiness.shop.model.vo.ShopAddInformationVo;
import com.essential.bussiness.shop.model.vo.ShopAuditingVo;
import com.essential.bussiness.shop.model.vo.ShopInformationPlatformVo;
import com.essential.bussiness.shop.model.vo.ShopPayMoneyVo;
import com.essential.bussiness.shop.service.IShopManagePlatformService;
import com.essential.utils.CommonResponseUtils;

/**
 * 商家管理（平台）
 * 
 * @author czm
 *
 */
@Controller
@RequestMapping(value = "shopManagePlatform")
public class ShopManagePlatformController {
	private static Logger logger = LoggerFactory.getLogger(ShopManagePlatformController.class);

	@Autowired
	IShopManagePlatformService shopPlatformManageService;

	/**
	 * 查询商家列表
	 * 
	 * @param shopInformationPlatformVo
	 * @return
	 */
	@RequestMapping(value = "queryShopList")
	@ResponseBody
	public Map<String, Object> queryShopList(ShopInformationPlatformVo shopInformationPlatformVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return shopPlatformManageService.queryShopList(shopInformationPlatformVo);
		} catch (Exception e) {
			logger.info("=====>>>>>查询商家列表失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("查询商家列表失败!"));
		}
		return map;
	}

	/**
	 * 查看店铺详情
	 * 
	 * @param shopId
	 * @return
	 */
	@RequestMapping(value = "queryDetialShopInfo")
	@ResponseBody
	public Map<String, Object> queryDetialShopInfo(Long shopId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (shopId == null) {
				return CommonResponseUtils.failureResponse("店铺Id不能为空!");
			}
			return shopPlatformManageService.queryDetialShopInfo(shopId);
		} catch (Exception e) {
			logger.info("=====>>>>>查看店铺详情失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("查看店铺详情失败!"));
		}
		return map;
	}

	/**
	 * 禁用/启用店铺
	 * 
	 * @param shopAddInformationVo
	 * @param type
	 *            0-正常，1-禁用
	 * @return
	 */
	@RequestMapping(value = "disableOrEnableShop")
	@ResponseBody
	public Map<String, Object> disableOrEnableShop(ShopAddInformationVo shopAddInformationVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer type = shopAddInformationVo.getType();
		try {
			Long shopId = shopAddInformationVo.getShopId();
			if (shopId == null) {
				return CommonResponseUtils.failureResponse("店铺Id不能为空!");
			}
			if (type == null) {
				return CommonResponseUtils.failureResponse("操作类别不能为空!");
			}
			return shopPlatformManageService.disableOrEnableShop(shopAddInformationVo);
		} catch (Exception e) {
			logger.info("=====>>>>>禁用/启用店铺失败:" + e);
			e.printStackTrace();
			if (type == 0) {
				map.putAll(CommonResponseUtils.failureResponse("启用店铺失败!"));
			} else {
				map.putAll(CommonResponseUtils.failureResponse("禁用店铺失败!"));
			}
		}
		return map;
	}

	/**
	 * 店铺所销售的品牌
	 * 
	 * @param shopId
	 * 
	 * @return
	 */
	@RequestMapping(value = "shopBrand")
	@ResponseBody
	public Map<String, Object> shopBrand(Long shopId, Integer pageIndex, Integer pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (shopId == null) {
				return CommonResponseUtils.failureResponse("店铺Id不能为空!");
			}
			return shopPlatformManageService.shopBrand(shopId, pageIndex, pageSize);
		} catch (Exception e) {
			logger.info("=====>>>>>查询店铺所销售的品牌失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("查询店铺所销售的品牌失败!"));
		}
		return map;
	}

	/**
	 * 修改店铺保证金额
	 * 
	 * @param shopId
	 * 
	 * @return
	 */
	@RequestMapping(value = "updateShopPayMoney")
	@ResponseBody
	public Map<String, Object> updateShopPayMoney(ShopPayMoneyVo shopPayMoneyVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 店铺Id
			if (shopPayMoneyVo.getShopId() == null) {
				return CommonResponseUtils.failureResponse("店铺Id不能为空!");
			}

			// 店铺保证金
			if (shopPayMoneyVo.getPayMoney() == null) {
				return CommonResponseUtils.failureResponse("店铺保证金不能为空!");
			}

			return shopPlatformManageService.updateShopPayMoney(shopPayMoneyVo);
		} catch (Exception e) {
			logger.info("=====>>>>>店铺保证金额修改失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("店铺保证金额修改失败!"));
		}
		return map;
	}

	/**
	 * 通过/驳回
	 * 
	 * @param shopId
	 * 
	 * @return
	 */
	@RequestMapping(value = "auditingShop")
	@ResponseBody
	public Map<String, Object> auditingShop(ShopAuditingVo shopAuditingVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer type = shopAuditingVo.getType();
		try {
			if (shopAuditingVo.getShopId() == null) {
				return CommonResponseUtils.failureResponse("店铺Id不能为空!");
			}
			return shopPlatformManageService.auditingShop(shopAuditingVo);
		} catch (Exception e) {
			if (type == 0) {
				logger.info("=====>>>>>店铺审核通过失败:" + e);
			} else {
				logger.info("=====>>>>>店铺审核驳回失败:" + e);
			}
			e.printStackTrace();
			if (type == 0) {
				map.putAll(CommonResponseUtils.failureResponse("店铺审核通过失败!"));
			} else {
				map.putAll(CommonResponseUtils.failureResponse("店铺审核驳回失败!"));
			}
		}
		return map;
	}

	/**
	 * 审核商家列表
	 * 
	 * @param shopPayMoneyVo
	 * @return
	 */
	@RequestMapping(value = "auditingShopList")
	@ResponseBody
	public Map<String, Object> auditingShopList(ShopInformationPlatformVo shopInformationPlatformVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return shopPlatformManageService.auditingShopList(shopInformationPlatformVo);
		} catch (Exception e) {
			logger.info("=====>>>>>审核商家列表查询失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("审核商家列表查询失败!"));
		}
		return map;
	}

}
