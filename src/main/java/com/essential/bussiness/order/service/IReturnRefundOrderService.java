package com.essential.bussiness.order.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.bussiness.order.model.auto.ReturnRefundOrderAuto;
import com.essential.bussiness.order.model.auto.ReturnRefundStatusAuto;
import com.essential.bussiness.order.model.vo.GenerateRefundOrderVo;
import com.essential.bussiness.order.model.vo.ReturnRefundOrderVo;

/**
 * 退款service接口
 * @author essential-gfs
 *
 */
@Service
public interface IReturnRefundOrderService {
	
	public Map<String, Object> addRefundOrder(ReturnRefundOrderAuto returnRefundOrderAuto,
			ReturnRefundStatusAuto returnRefundStatusAuto, String[] pics, String orderType);
	
	public Map<String, Object> queryRefundOrderForList(ReturnRefundOrderVo returnRefundOrderVo, 
			int type, Long loginUserId, String returnRefundType);
	
	public Map<String, Object> updateRefundOrderForApp(ReturnRefundOrderAuto returnRefundOrderAuto, String busiType);
	
	public Map<String, Object> updateRefundOrderForBussiness(ReturnRefundOrderAuto returnRefundOrderAuto, String busiType, Long loginUserId);
	
	public Map<String, Object> updateRefundOrderForPlatform(ReturnRefundOrderAuto returnRefundOrderAuto, String busiType, Long loginUserId);
	
	public Map<String, Object> queryReturnRefundPicForList(Long returnRefundOrderId);
	
	public Map<String, Object> queryRefundOrder(Long returnRefundOrderId, Long loginUserId);
	
	public Map<String, Object> queryReturnRefundOrderByOrderProductIdForBusiness(Long orderProductId, Long loginUserId);
	
	public Map<String, Object> queryReturnRefundOrderByOrderProductIdForPlatform(Long orderProductId, Long loginUserId);
	
	public Map<String, Object> queryGenerateRefundOrderForList(GenerateRefundOrderVo generateRefundOrderVo, 
			Long loginUserId, String returnRefundType);
}
