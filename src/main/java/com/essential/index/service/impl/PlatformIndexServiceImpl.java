package com.essential.index.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.essential.bussiness.product.service.IProductManageService;
import com.essential.bussiness.statistics.service.IBuyOrderStatisticsService;
import com.essential.common.constants.SUConstants;
import com.essential.index.service.IPlatformIndexService;
import com.essential.utils.CommonResponseUtils;

/**
 * 平台首页service实现类
 * 
 * @author essential-gfs
 *
 */
@Service
public class PlatformIndexServiceImpl implements IPlatformIndexService {

	// 注入平台统计service
	@Autowired
	@Qualifier("buyOrderStatisticsServiceImpl")
	IBuyOrderStatisticsService buyOrderStatisticsService;

	// 商品统计
	@Autowired
	IProductManageService productManageService;

	@Override
	public Map<String, Object> queryIndexInfo() {

		try {
			// 平台待处理订单
			Map<String, Object> platformPendingProccessOrdersMap = buyOrderStatisticsService.platformPendingProccessOrders();
			if (SUConstants.CODE_FAIL_VALUE.equals(platformPendingProccessOrdersMap.get(SUConstants.CODE_KEY).toString())) {
				return CommonResponseUtils.failureResponse(platformPendingProccessOrdersMap.get(SUConstants.MSG_KEY));
			}

			// 平台运营数据
			Map<String, Object> platformOperationDataMap = buyOrderStatisticsService.platformOperationData();
			if (SUConstants.CODE_FAIL_VALUE.equals(platformOperationDataMap.get(SUConstants.CODE_KEY).toString())) {
				return CommonResponseUtils.failureResponse(platformPendingProccessOrdersMap.get(SUConstants.MSG_KEY) + "," + platformOperationDataMap.get(SUConstants.CODE_KEY));
			}

			// 商品统计/商家/用户
			Map<String, Object> productCountMap = productManageService.productCountPlatform();
			if(SUConstants.CODE_FAIL_VALUE.equals(productCountMap.get(SUConstants.CODE_KEY).toString())){
				return CommonResponseUtils.failureResponse(platformPendingProccessOrdersMap.get(SUConstants.MSG_KEY));
			}

			Map<String, Object> resMap = new HashMap<String, Object>();
			resMap.put("pendingProccessOrders", platformPendingProccessOrdersMap.get(SUConstants.INFO_KEY));
			resMap.put("operationData", platformOperationDataMap.get(SUConstants.INFO_KEY));
			resMap.put("productCount", productCountMap.get(SUConstants.INFO_KEY));

			return CommonResponseUtils.successResponse(resMap);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
