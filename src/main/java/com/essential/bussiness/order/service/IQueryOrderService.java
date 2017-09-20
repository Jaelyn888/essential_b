package com.essential.bussiness.order.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.bussiness.order.model.auto.OrderProductAuto;
import com.essential.bussiness.order.model.vo.OrderProductVo;
import com.essential.bussiness.product.model.auto.ProductCommentAuto;

/**
 * 订单查询service接口
 * @author essential-gfs
 *
 */
@Service
public interface IQueryOrderService {

	public Map<String, Object> queryOrderForList(OrderProductVo orderProductVo, String productName, int type, Long loginUserId);
	
	public Map<String, Object> searchOrderByProductName(OrderProductAuto orderProductAuto);
	
	public Map<String, Object> queryOrderComment(ProductCommentAuto productCommentAuto);
	
	public Map<String, Object> queryMyOrderNumberPerLabelCount(Long userId);
}
