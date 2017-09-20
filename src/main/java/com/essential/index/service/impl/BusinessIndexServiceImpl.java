package com.essential.index.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.essential.bussiness.product.service.IProductManageService;
import com.essential.bussiness.statistics.service.IBuyOrderStatisticsService;
import com.essential.common.constants.SUConstants;
import com.essential.index.service.IBusinessIndexService;
import com.essential.user.dao.UserBaseInfoAutoMapper;
import com.essential.utils.CommonResponseUtils;

/**
 * 商家首页service实现类
 * 
 * @author essential-gfs
 *
 */
@Service
public class BusinessIndexServiceImpl implements IBusinessIndexService {

	// 注入用户基础信息dao
	@Autowired
	UserBaseInfoAutoMapper userDao;
	// 注入商家统计service
	@Autowired
	@Qualifier("buyOrderStatisticsServiceImpl")
	IBuyOrderStatisticsService buyOrderStatisticsService;
	// 商品统计
	@Autowired
	IProductManageService productManageService;

	@Override
	public Map<String, Object> queryIndexInfo(Long shopId) {

		try {
			// 商家待处理订单
			Map<String, Object> businessPendingProccessOrdersMap = buyOrderStatisticsService.businessPendingProccessOrders(shopId);
			if (SUConstants.CODE_FAIL_VALUE.equals(businessPendingProccessOrdersMap.get(SUConstants.CODE_KEY).toString())) {
				return CommonResponseUtils.failureResponse(businessPendingProccessOrdersMap.get(SUConstants.MSG_KEY));
			}

			// 商家运营数据
			Map<String, Object> businessOperationDataMap = buyOrderStatisticsService.businessOperationData(shopId);
			if (SUConstants.CODE_FAIL_VALUE.equals(businessOperationDataMap.get(SUConstants.CODE_KEY).toString())) {
				return CommonResponseUtils.failureResponse(businessPendingProccessOrdersMap.get(SUConstants.MSG_KEY) + "," + businessOperationDataMap.get(SUConstants.CODE_KEY));
			}

			// 商品统计 productCount
			Map<String, Object> productCountMap = productManageService.productCount(shopId);
			if (SUConstants.CODE_FAIL_VALUE.equals(productCountMap.get(SUConstants.CODE_KEY).toString())) {
				return CommonResponseUtils.failureResponse(productCountMap.get(SUConstants.MSG_KEY));
			}

			Map<String, Object> resMap = new HashMap<String, Object>();
			resMap.put("pendingProccessOrders", businessPendingProccessOrdersMap.get(SUConstants.INFO_KEY));
			resMap.put("operationData", businessOperationDataMap.get(SUConstants.INFO_KEY));
			resMap.put("productCoun", productCountMap.get(SUConstants.INFO_KEY));

			return CommonResponseUtils.successResponse(resMap);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
