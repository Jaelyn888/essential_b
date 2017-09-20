package com.essential.user.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.common.constants.SUConstants;
import com.essential.user.model.auto.UserReceiptAddressAuto;
import com.essential.user.service.IUserReceiptAddressService;
import com.essential.utils.CommonResponseUtils;

/**
 * 用户收货地址
 * @author Jaelyn
 *
 */
@Controller
@RequestMapping(value="userReceiptAddress")
public class UserReceiptAddressController {

	/**
	 * mapper
	 */
	@Autowired
	private IUserReceiptAddressService userReceiptAddressService;
	
	/**
	 * query all UserReceiptAddressAuto
	 * 
	 * @param userReceiptAddressAuto
	 *            获取所有收货信息
	 * @return
	 */
	@RequestMapping(value="queryAddressListByUserId")
	@ResponseBody
	public Map<String, Object> queryAllReceiptAddressByUserId(UserReceiptAddressAuto userReceiptAddressAuto) {
		
		try {
			userReceiptAddressAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			return userReceiptAddressService.queryAllAddressByUserId(userReceiptAddressAuto);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}
	}
	
	
	/**
	 * 保存 更改 用户收货地址
	 * @param userReceiptAddressAuto
	 * @return
	 */
	@RequestMapping(value="saveOrUpdateAddress")
	@ResponseBody
	public Map<String, Object> saveOrUpdateAddress(UserReceiptAddressAuto userReceiptAddressAuto) {	
		try {
			return  userReceiptAddressService.saveOrUpdateAddress(userReceiptAddressAuto);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}
	}
	/**
	 * 保存 用户收货地址
	 * @param userReceiptAddressAuto
	 * @return
	 */
	@RequestMapping(value="saveAddress")
	@ResponseBody
	public Map<String, Object> saveAddress(UserReceiptAddressAuto userReceiptAddressAuto) {	
		try {
			return  userReceiptAddressService.saveAddress(userReceiptAddressAuto);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}
	}

	/**
	 * update userReceiptAddressAuto
	 * 
	 * @param userReceiptAddressAuto
	 *            更新后收货地址
	 * @return
	 */
	@RequestMapping(value="updateAddress")
	@ResponseBody
	public Map<String, Object> updateAddress(UserReceiptAddressAuto userReceiptAddressAuto) {
		try {
			return  userReceiptAddressService.updateAddress(userReceiptAddressAuto);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}
	}

	/**
	 * delete userReceiptAddressAuto
	 * 
	 * @param userReceiptAddressAuto
	 *            删除收货地址
	 * @return
	 */
	@RequestMapping(value="deleteAddress")
	@ResponseBody
	public 	Map<String, Object> deleteAddress(UserReceiptAddressAuto userReceiptAddressAuto) {
		
		try {
			return userReceiptAddressService.deleteAddress(userReceiptAddressAuto);
			
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}

	}

	/**
	 * select by userReceiptAddressAuto id
	 * 
	 * @param addressId
	 * @return
	 */
	@RequestMapping(value="queryAddressById")
	@ResponseBody
	public Map<String, Object> queryAddressById(long addressId) {
		try {
			return userReceiptAddressService.queryAddressById(addressId);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}

	}
	
	
	/**
	 * 设置默认收货地址
	 * 
	 * @param addressId
	 * @return
	 */
	@RequestMapping(value="setDefaultAddress")
	@ResponseBody
	public Map<String, Object> setDefaultAddress(UserReceiptAddressAuto userReceiptAddressAuto) {
		try {
			return userReceiptAddressService.setDefaultAddress(userReceiptAddressAuto);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}

	}
	
	
}
