package com.essential.bussiness.order.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.bussiness.order.dao.OrderStatusAutoMapper;
import com.essential.bussiness.order.dao.ReturnRefundStatusAutoMapper;
import com.essential.bussiness.order.model.auto.OrderStatusAuto;
import com.essential.bussiness.order.model.auto.OrderStatusAutoExample;
import com.essential.bussiness.order.model.vo.ReturnRefundOrderStatusVo;
import com.essential.bussiness.order.service.IQueryOrderStatusService;
import com.essential.utils.CommonResponseUtils;

/**
 * 查询订单状态流水service实现类
 * @author essential-gfs
 *
 */
@Service
public class QueryOrderStatusServiceImpl implements IQueryOrderStatusService {
	
	private Logger logger = LoggerFactory.getLogger(QueryOrderStatusServiceImpl.class);
	
	//注入退货退款订单dao
	@Autowired
	ReturnRefundStatusAutoMapper returnRefundStatusDao;
	//注入主订单dao
	@Autowired
	OrderStatusAutoMapper orderStatusDao;

	
	/**
	 * 查询退货退款订单状态流水
	 */
	@Override
	public Map<String, Object> queryReturnRefundOrderStatusForList(
			ReturnRefundOrderStatusVo returnRefundOrderStatusVo) {
		
		try {
			List<ReturnRefundOrderStatusVo> returnRefundOrderStatusVos = new ArrayList<ReturnRefundOrderStatusVo>();
			returnRefundOrderStatusVos = returnRefundStatusDao.queryByReturnRefundOrderIdForList(returnRefundOrderStatusVo);
			
			return CommonResponseUtils.successResponse(returnRefundOrderStatusVos);
		} catch (Exception e) {
			logger.info("查询售后信息失败");
			throw new RuntimeException(e);
		}
	}

	
	/**
	 * 查询主订单状态流水
	 */
	@Override
	public Map<String, Object> queryOrderStatusForList(
			OrderStatusAuto orderStatusAuto) {
		try {
			OrderStatusAutoExample orderStatusAutoExample = new OrderStatusAutoExample();
			orderStatusAutoExample.createCriteria().andOrderIdEqualTo(orderStatusAuto.getOrderId());
			List<OrderStatusAuto> orderStatusList = orderStatusDao.selectByExample(orderStatusAutoExample);
			return CommonResponseUtils.successResponse(orderStatusList);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
