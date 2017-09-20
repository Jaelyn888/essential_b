package com.essential.bussiness.order.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.bussiness.order.model.auto.OrderStatusAuto;
import com.essential.bussiness.order.model.vo.ReturnRefundOrderStatusVo;
import com.essential.bussiness.order.service.IQueryOrderStatusService;
import com.essential.common.utils.MyException;
import com.essential.utils.CommonResponseUtils;


/**
 * 查询订单状态流水信息
 * @author essential-gfs
 *
 */
@Controller
@RequestMapping(value="queryOrderStatus")
public class QueryOrderStatusController {
	
	//注入订单状态流水service
	@Autowired
	@Qualifier("queryOrderStatusServiceImpl")
	IQueryOrderStatusService queryOrderStatusService;
	
	
	/**
	 * 查询退货退款订单状态流水
	 * @param returnRefundOrderId 退货退款订单id
	 * @return
	 */
	@RequestMapping(value="queryReturnRefundStatus")
	@ResponseBody
	public Map<String, Object> queryReturnRefundStatus(Long returnRefundOrderId){
		try {
			ReturnRefundOrderStatusVo returnRefundOrderStatusVo = new ReturnRefundOrderStatusVo();
			returnRefundOrderStatusVo.setReturnRefundOrderId(returnRefundOrderId);
			return queryOrderStatusService.queryReturnRefundOrderStatusForList(returnRefundOrderStatusVo);
		} catch (MyException me) {
			me.printStackTrace();
			return CommonResponseUtils.failureResponse(me.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("查询进度失败");
		}
	}
	
	
	/**
	 * 查询主订单状态流水
	 * @param orderId 主订单id
	 * @return
	 */
	@RequestMapping(value="queryOrderStatus")
	@ResponseBody
	public Map<String, Object> queryOrderStatus(Long orderId){
		try {
			OrderStatusAuto orderStatusAuto = new OrderStatusAuto();
			orderStatusAuto.setOrderId(orderId);
			return queryOrderStatusService.queryOrderStatusForList(orderStatusAuto);
		} catch (MyException me) {
			me.printStackTrace();
			return CommonResponseUtils.failureResponse(me.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("查询订单进度失败");
		}
	}
	
}
