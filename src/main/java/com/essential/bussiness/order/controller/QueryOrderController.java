package com.essential.bussiness.order.controller;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.bussiness.order.model.auto.OrderProductAuto;
import com.essential.bussiness.order.model.vo.OrderProductVo;
import com.essential.bussiness.order.service.IQueryOrderService;
import com.essential.bussiness.product.model.auto.ProductCommentAuto;
import com.essential.common.utils.MyException;
import com.essential.common.utils.TmDateUtil;
import com.essential.utils.CommonResponseUtils;

/**
 * 查询订单信息
 * @author essential-gfs
 *
 */
@Controller
@RequestMapping(value="queryOrder")
public class QueryOrderController {

	//注入查询订单业务service
	@Autowired
	@Qualifier("queryOrderServiceImpl")
	IQueryOrderService queryOrderService;
	
	/**
	 * 通过userId查询订单
	 * @param orderProductVo 订单商品vo
	 * @return
	 */
	@RequestMapping(value="queryOrderByUserId")
	@ResponseBody
	public Map<String, Object> queryOrderByUserId(OrderProductVo orderProductVo, String productName){
		try {
			if(orderProductVo.getUserId() == null){
				return CommonResponseUtils.failureResponse("查询订单失败,userId不能为空");
			}
			
			return queryOrderService.queryOrderForList(orderProductVo,productName, 1, orderProductVo.getUserId());
		} catch (MyException me) {
			me.printStackTrace();
			return CommonResponseUtils.failureResponse(me.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("查询订单失败");
		}
	}
	
	/**
	 * 商家通过店铺id查询订单
	 * @param orderProductVo 订单商品vo
	 * @return
	 */
	@RequestMapping(value="bussiness/queryOrderByShopId")
	@ResponseBody
	public Map<String, Object> queryOrderByShopIdForBussiness(OrderProductVo orderProductVo, 
			String productName, Integer preDate, Long loginUserId){
		try {
			if(loginUserId == null){
				return CommonResponseUtils.failureResponse("查询订单失败,用户id不能为空");
			}
			
			if(preDate != null){
				Date nowDate = new Date();
				StringBuffer modifyStartTime = new StringBuffer();
				modifyStartTime.append(TmDateUtil.dateToString("yyyy-MM-dd",TmDateUtil.getPreDate(nowDate, "d", -(preDate-1))));
				modifyStartTime.append(" 00:00:00.000");
				StringBuffer modifyEndTime = new StringBuffer();
				modifyEndTime.append(TmDateUtil.dateToString("yyyy-MM-dd",nowDate));
				modifyEndTime.append(" 23:59:59.999");
				orderProductVo.setModifyStartTime(modifyStartTime.toString());
				orderProductVo.setModifyEndTime(modifyEndTime.toString());
			}
			if(StringUtils.isNotEmpty(productName)){
				OrderProductAuto orderProductAuto = new OrderProductAuto();
				orderProductAuto.setProductName(productName);
				orderProductVo.getOrderProducts().add(orderProductAuto);
			}
			
			return queryOrderService.queryOrderForList(orderProductVo, productName,2,loginUserId);
		} catch (MyException me) {
			me.printStackTrace();
			return CommonResponseUtils.failureResponse(me.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("查询订单失败");
		}
	}
	
	
	/**
	 * 平台查询订单
	 * @param orderProductVo 订单商品vo
	 * @return
	 */
	@RequestMapping(value="platform/queryOrderByShopId")
	@ResponseBody
	public Map<String, Object> queryOrderByShopIdForPlatform(OrderProductVo orderProductVo, 
			String productName, Integer preDate, Long loginUserId){
		try {
			if(loginUserId == null){
				return CommonResponseUtils.failureResponse("查询订单失败,用户id不能为空");
			}
			
			if(preDate != null){
				Date nowDate = new Date();
				StringBuffer modifyStartTime = new StringBuffer();
				modifyStartTime.append(TmDateUtil.dateToString("yyyy-MM-dd",TmDateUtil.getPreDate(nowDate, "d", -(preDate-1))));
				modifyStartTime.append(" 00:00:00.000");
				StringBuffer modifyEndTime = new StringBuffer();
				modifyEndTime.append(TmDateUtil.dateToString("yyyy-MM-dd",nowDate));
				modifyEndTime.append(" 23:59:59.999");
				orderProductVo.setModifyStartTime(modifyStartTime.toString());
				orderProductVo.setModifyEndTime(modifyEndTime.toString());
			}
			if(StringUtils.isNotEmpty(productName)){
				OrderProductAuto orderProductAuto = new OrderProductAuto();
				orderProductAuto.setProductName(productName);
				orderProductVo.getOrderProducts().add(orderProductAuto);
			}
			
			return queryOrderService.queryOrderForList(orderProductVo, productName,3,loginUserId);
		} catch (MyException me) {
			me.printStackTrace();
			return CommonResponseUtils.failureResponse(me.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("查询订单失败");
		}
	}
	
	
	/**
	 * 通过商品名称搜索订单信息
	 * @param productName 订单商品名称
	 * @return
	 */
	@RequestMapping(value="searchOrderByProductName")
	@ResponseBody
	public Map<String, Object> searchOrderByProductName(String productName){
		try {
			OrderProductAuto orderProduct = new OrderProductAuto();
			orderProduct.setProductName(productName);
			return queryOrderService.searchOrderByProductName(orderProduct);
		} catch (MyException me) {
			me.printStackTrace();
			return CommonResponseUtils.failureResponse(me.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("搜索订单信息失败");
		}
	}
	
	
	
	/**
	 * 查看订单评价
	 * @param productCommentAuto 商品评价实体
	 * @return
	 */
	@RequestMapping(value="queryOrderComment")
	@ResponseBody
	public Map<String, Object> queryOrderComment(ProductCommentAuto productCommentAuto){
		try {
			
			return queryOrderService.queryOrderComment(productCommentAuto);
		} catch (MyException me) {
			me.printStackTrace();
			return CommonResponseUtils.failureResponse(me.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("搜索订单信息失败");
		}
	}
	
	
	
	/**
	 * 我的订单每个标签页的订单数量
	 * @param userId 用户id
	 * @return
	 */
	@RequestMapping(value="queryMyOrderNumberPerLabelCount")
	@ResponseBody
	public Map<String, Object> queryMyOrderNumberPerLabelCount(Long userId){
		if(userId == null){
			return CommonResponseUtils.failureResponse("userId不能为空");
		}
		try {
			
			return queryOrderService.queryMyOrderNumberPerLabelCount(userId);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("查询订单数量失败");
		}
	}
}
