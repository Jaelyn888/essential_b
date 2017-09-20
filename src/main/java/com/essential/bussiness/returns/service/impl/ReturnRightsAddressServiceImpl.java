package com.essential.bussiness.returns.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.bussiness.returns.controller.ReturnRightsAddressController;
import com.essential.bussiness.returns.dao.ReturnAddressAutoMapper;
import com.essential.bussiness.returns.model.auto.ReturnAddressAuto;
import com.essential.bussiness.returns.service.IReturnRightsAddressService;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.TmDateUtil;
import com.essential.utils.CommonResponseUtils;

/**
 * 退货维权 （商家后台）
 * 
 * @author czm
 *
 */
@Service
public class ReturnRightsAddressServiceImpl implements IReturnRightsAddressService {
	private static Logger logger = LoggerFactory.getLogger(ReturnRightsAddressServiceImpl.class);

	@Autowired
	ReturnAddressAutoMapper returnAddressAutoMapper;

	/**
	 * 添加新地址
	 */
	@Override
	public Map<String, Object> addReturnRightsAddress(ReturnAddressAuto returnAddressAuto) {
		Map<String, Object> outputMap = new HashMap<String, Object>();
		Map<String, Object> inputMap = new HashMap<String, Object>();
		try {
			// 获取当前时间
			String dateTime = TmDateUtil.getTimeStamp();
			// 创建用户
			returnAddressAuto.setCreateUser(returnAddressAuto.getCreateUser());
			// 创建时间
			returnAddressAuto.setCreateTime(dateTime);
			// 是否删除标记：0-未删除；1-已删除
			returnAddressAuto.setIsDelete(SUConstants.IS_NOT_DELETE);

			inputMap.put("shopId", returnAddressAuto.getShopId());
			inputMap.put("isDelete", SUConstants.IS_NOT_DELETE);
			List<ReturnAddressAuto> returnAddressList = returnAddressAutoMapper.queryReturnRightsAddress(inputMap);

			// 是否是默认地址设置 ：0-非默认地址，1-是默认地址
			if (returnAddressList != null && returnAddressList.size() > 0) {
				returnAddressAuto.setStatus(0);
			} else {
				returnAddressAuto.setStatus(1);
			}

			int i = returnAddressAutoMapper.insertSelective(returnAddressAuto);
			if (i <= 0) {
				outputMap.putAll(CommonResponseUtils.failureResponse("添加新地址失败"));
			} else {
				outputMap.putAll(CommonResponseUtils.successResponse());
			}
			return outputMap;
		} catch (Exception e) {
			logger.info("=====>>>>>添加新地址失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	/**
	 * 查询地址信息
	 */
	@Override
	public Map<String, Object> queryReturnRightsAddress(ReturnAddressAuto returnAddressAuto) {
		// 返回结果
		Map<String, Object> outputMap = new HashMap<String, Object>();
		// 参数传入
		Map<String, Object> inputMap = new HashMap<String, Object>();
		List<ReturnAddressAuto> returnRightsAddressList = new ArrayList<ReturnAddressAuto>();
		try {
			// 店铺Id
			inputMap.put("shopId", returnAddressAuto.getShopId());
			// 是否删除标记：0-未删除；1-已删除
			inputMap.put("isDelete", SUConstants.IS_NOT_DELETE);
			returnRightsAddressList = returnAddressAutoMapper.queryReturnRightsAddress(inputMap);
			outputMap.putAll(CommonResponseUtils.successResponse(returnRightsAddressList));
			return outputMap;
		} catch (Exception e) {
			logger.info("=====>>>>>退货地址信息查询失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 更新地址信息
	 */
	@Override
	public Map<String, Object> updateReturnRightsAddress(ReturnAddressAuto returnAddressAuto) {
		Map<String, Object> outputMap = new HashMap<String, Object>();
		try {
			// 修改时间
			returnAddressAuto.setModifyTime(TmDateUtil.getTimeStamp());
			int i = returnAddressAutoMapper.updateByPrimaryKeySelective(returnAddressAuto);
			if (i <= 0) {
				outputMap.putAll(CommonResponseUtils.failureResponse("更新地址信息失败"));
			} else {
				outputMap.putAll(CommonResponseUtils.successResponse());
			}
			return outputMap;
		} catch (Exception e) {
			logger.info("=====>>>>>更新地址信息失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 删除地址信息
	 */
	@Override
	public Map<String, Object> deleteReturnRightsAddress(Long returnaddressId) {
		Map<String, Object> outputMap = new HashMap<String, Object>();
		Map<String, Object> inputMap = new HashMap<String, Object>();
		try {

			ReturnAddressAuto returnAddressAuto = new ReturnAddressAuto();
			// 退货地址id
			returnAddressAuto.setReturnaddressId(returnaddressId);
			// 是否删除标记：0-未删除；1-已删除
			returnAddressAuto.setIsDelete(SUConstants.IS_DELETE);
			int i = returnAddressAutoMapper.updateByPrimaryKeySelective(returnAddressAuto);
			if (i <= 0) {
				throw new Exception("=========>>>>>>修改退货地址信息状态失败");
			}

			returnAddressAuto = returnAddressAutoMapper.selectByPrimaryKey(returnaddressId);
			Integer status = returnAddressAuto.getStatus();
			if (status == 1) {

				// 店铺Id
				inputMap.put("shopId", returnAddressAuto.getShopId());
				// 是否删除标记：0-未删除；1-已删除
				inputMap.put("isDelete", SUConstants.IS_NOT_DELETE);
				List<ReturnAddressAuto> returnAddressList = returnAddressAutoMapper.queryReturnRightsAddress(inputMap);
				if (returnAddressList != null && returnAddressList.size() > 0) {
					int j = returnAddressAutoMapper.updateStatusWhendeleteByShopId(returnAddressAuto.getShopId());
					if (j <= 0) {
						throw new Exception("=========>>>>>>删除默认地址时先自动设置默认地址失败");
					}
				}
			}

			outputMap.putAll(CommonResponseUtils.successResponse("退货地址信息删除成功!"));
			return outputMap;
		} catch (Exception e) {
			logger.info("=====>>>>>退货地址信息删除失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 默认地址设置
	 */
	@Override
	public Map<String, Object> defaultAddress(long returnaddressId, long shopId) {
		Map<String, Object> outputmap = new HashMap<String, Object>();
		int j = 0;
		try {
			ReturnAddressAuto returnAddressAuto = new ReturnAddressAuto();
			// 店铺Id
			returnAddressAuto.setShopId(shopId);
			// 是否是默认地址设置 ：0-非默认地址，1-是默认地址
			returnAddressAuto.setStatus(0);
			int i = returnAddressAutoMapper.updateStatusByPrimaryKeySelective(returnAddressAuto);
			if (i > 0) {
				ReturnAddressAuto returnAddress = new ReturnAddressAuto();
				// 退货地址Id
				returnAddress.setReturnaddressId(returnaddressId);
				// 是否是默认地址设置 ：0-非默认地址，1-是默认地址
				returnAddress.setStatus(1);
				j = returnAddressAutoMapper.updateByPrimaryKeySelective(returnAddress);
			}
			if (i > 0 && j > 0) {
				outputmap.putAll(CommonResponseUtils.successResponse());
			} else {
				outputmap.putAll(CommonResponseUtils.failureResponse("默认地址设置失败"));
			}
			return outputmap;
		} catch (Exception e) {
			logger.info("=====>>>>>默认地址设置失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Map<String, Object> queryDefaultAddress(ReturnAddressAuto returnAddressAuto) {
		returnAddressAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
		returnAddressAuto.setStatus(SUConstants.Default_Address);
		ReturnAddressAuto returnAddressTmp = returnAddressAutoMapper.queryDefaultAddress(returnAddressAuto);
		if (returnAddressTmp == null) {
			returnAddressAuto.setStatus(null);
			returnAddressTmp = returnAddressAutoMapper.queryNewestAddress(returnAddressAuto);
		}
		if (returnAddressTmp == null) {
			return CommonResponseUtils.failureResponse("没有查到地址,请联系商家");
		} else {
			return CommonResponseUtils.successResponse(returnAddressTmp);
		}
	}

}
