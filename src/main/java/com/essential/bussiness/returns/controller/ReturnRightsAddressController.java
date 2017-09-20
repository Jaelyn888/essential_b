package com.essential.bussiness.returns.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.bussiness.returns.model.auto.ReturnAddressAuto;
import com.essential.bussiness.returns.service.IReturnRightsAddressService;
import com.essential.bussiness.shop.service.impl.StoreManagementServiceImpl;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.StringCommonUtils;
import com.essential.utils.CommonResponseUtils;

/**
 * 退货维权 （商家后台）
 * 
 * @author czm
 *
 */
@Controller
@RequestMapping(value = "returnRightsAddressController")
public class ReturnRightsAddressController {
	private static Logger logger = LoggerFactory.getLogger(ReturnRightsAddressController.class);

	@Autowired
	IReturnRightsAddressService returnRightsAddressService;

	/**
	 * 添加新地址
	 * 
	 * @param returnAddressAuto
	 * @return
	 */
	@RequestMapping(value = "addReturnRightsAddress")
	@ResponseBody
	public Map<String, Object> addReturnRightsAddress(ReturnAddressAuto returnAddressAuto) {
		try {
			if(returnAddressAuto.getShopId() == null){
				return CommonResponseUtils.failureResponse("店铺Id不能为空!");
			}
			if(returnAddressAuto.getContactPerson() == null || "".equals(returnAddressAuto.getContactPerson())){
				return CommonResponseUtils.failureResponse("收货人不能为空!");
			}
			if(returnAddressAuto.getPhone() == null || "".equals(returnAddressAuto.getPhone())){
				return CommonResponseUtils.failureResponse("联系电话不能为空!");
			}
			if(returnAddressAuto.getReturnAddress() == null || "".equals(returnAddressAuto.getReturnAddress())){
				return CommonResponseUtils.failureResponse("退货地址不能为空!");
			}
			return returnRightsAddressService.addReturnRightsAddress(returnAddressAuto);
		} catch (Exception e) {
			logger.info("======>>>>>>添加新地址失败:" + e);
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("添加新地址失败!");
		}
	}

	/**
	 * 查询退货地址
	 * 
	 * @param returnAddressAuto
	 * @return
	 */
	@RequestMapping(value = "queryReturnRightsAddress")
	@ResponseBody
	public Map<String, Object> queryReturnRightsAddress(ReturnAddressAuto returnAddressAuto) {
		try {
			if(returnAddressAuto.getShopId() == null){
				return CommonResponseUtils.failureResponse("店铺Id不能为空!");
			}
			return returnRightsAddressService.queryReturnRightsAddress(returnAddressAuto);
		} catch (Exception e) {
			logger.info("======>>>>>>查询退货地址失败:" + e);
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("查询退货地址失败!");
		}
	}

	/**
	 * 更新地址
	 * 
	 * @param returnAddressAuto
	 * @return
	 */
	@RequestMapping(value = "updateReturnRightsAddress")
	@ResponseBody
	public Map<String, Object> updateReturnRightsAddress(ReturnAddressAuto returnAddressAuto) {
		try {
			if(returnAddressAuto.getReturnaddressId() == null){
				return CommonResponseUtils.failureResponse("退货地址Id不能为空!");
			}
			if(returnAddressAuto.getContactPerson() == null || "".equals(returnAddressAuto.getContactPerson())){
				return CommonResponseUtils.failureResponse("收货人不能为空!");
			}
			if(returnAddressAuto.getPhone() == null || "".equals(returnAddressAuto.getPhone())){
				return CommonResponseUtils.failureResponse("联系电话不能为空!");
			}
			if(returnAddressAuto.getReturnAddress() == null || "".equals(returnAddressAuto.getReturnAddress())){
				return CommonResponseUtils.failureResponse("退货地址不能为空!");
			}
			return returnRightsAddressService.updateReturnRightsAddress(returnAddressAuto);
		} catch (Exception e) {
			logger.info("======>>>>>>更新地址失败:" + e);
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("更新地址失败!");
		}
	}

	/**
	 * 删除地址
	 * 
	 * @param returnAddressAuto
	 * @return
	 */
	@RequestMapping(value = "deleteReturnRightsAddress")
	@ResponseBody
	public Map<String, Object> deleteReturnRightsAddress(Long returnaddressId) {
		try {
			if(returnaddressId == null){
				return CommonResponseUtils.failureResponse("退货地址Id不能为空!");
			}
			return returnRightsAddressService.deleteReturnRightsAddress(returnaddressId);
		} catch (Exception e) {
			logger.info("======>>>>>>删除地址失败:" + e);
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("删除地址失败!");
		}
	}

	/**
	 * 默认地址设置
	 * 
	 * @param returnAddressAuto
	 * @return
	 */
	@RequestMapping(value = "defaultAddress")
	@ResponseBody
	public Map<String, Object> defaultAddress(HttpServletRequest request) {
		try {
			long returnaddressId = Long.valueOf(request.getParameter("returnaddressId"));
			long shopId = Long.valueOf(request.getParameter("shopId"));
			return returnRightsAddressService.defaultAddress(returnaddressId, shopId);
		} catch (Exception e) {
			logger.info("======>>>>>>默认地址设置失败:" + e);
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("默认地址设置失败!");
		}
	}
	
	/**
	 * app 查询收货地址
	 */
	@RequestMapping(value = "queryDefaultAddress")
	@ResponseBody
	public Map<String,Object> queryDefaultAddress(ReturnAddressAuto returnAddressAuto){
		try {
			Long shopId = returnAddressAuto.getShopId();
			if(StringCommonUtils.isInvalidateId(shopId)){
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			return returnRightsAddressService.queryDefaultAddress(returnAddressAuto);
		} catch (Exception e) {
			logger.info("======>>>>>>默认地址设置失败:" + e);
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}
	}
}
