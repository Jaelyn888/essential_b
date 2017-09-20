package com.essential.bussiness.order.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.bussiness.order.model.auto.OrderProductAuto;
import com.essential.bussiness.order.model.auto.ReturnRefundOrderAuto;
import com.essential.bussiness.order.model.auto.ReturnRefundStatusAuto;
import com.essential.bussiness.order.model.vo.GenerateRefundOrderVo;
import com.essential.bussiness.order.model.vo.ReturnRefundOrderVo;
import com.essential.bussiness.order.model.vo.SubmitReturnRefundOrderVo;
import com.essential.bussiness.order.service.IReturnRefundOrderService;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.MyException;
import com.essential.common.utils.TmDateUtil;
import com.essential.utils.CommonResponseUtils;
import com.essential.utils.OrderUtils;

/**
 * 退货、退款业务
 * @author essential-gfs
 *
 */
@Controller
@RequestMapping(value="refundOrder")
public class ReturnRefundOrderController {
	
	private Logger logger = LoggerFactory.getLogger(ReturnRefundOrderController.class);
	
	//注入退货、退款service
	@Autowired
	@Qualifier("returnRefundOrderServiceImpl")
	IReturnRefundOrderService returnRefundOrderService;
	
	/**
	 * 新增退货退款订单
	 * @param returnRefundOrderAuto 退货退款实体 
	 * @param pics 图片
	 * @return
	 */
	@RequestMapping("add")
	@ResponseBody
	public Map<String, Object> addRefundOrder(@RequestBody SubmitReturnRefundOrderVo submitReturnRefundOrderVo){
		if(submitReturnRefundOrderVo.getReturnRefundOrderAuto().getUserId() == null){
			return CommonResponseUtils.failureResponse("用户id不能为空");
		}
		
		StringBuilder sb = new StringBuilder();
		if(submitReturnRefundOrderVo.getReturnRefundOrderAuto().getReturnRefundType().intValue() == 1){
			sb.append("退货");
		}else if(submitReturnRefundOrderVo.getReturnRefundOrderAuto().getReturnRefundType().intValue() == 2){
			sb.append("退款");
		}else{
			Map<String, Object> resMap = new HashMap<String, Object>();
			resMap.putAll(CommonResponseUtils.failureResponse("退货退款标识不能为空"));
			return resMap;
		}
		
		try {
			String nowDate = TmDateUtil.getTimeStamp();
			String refundOrderNumber = OrderUtils.getOrderNumber(submitReturnRefundOrderVo
					.getReturnRefundOrderAuto().getUserId().toString());
			
			//封装退货、退款实体
			submitReturnRefundOrderVo.getReturnRefundOrderAuto().setCreateTime(nowDate);
			submitReturnRefundOrderVo.getReturnRefundOrderAuto().setCreateUser(submitReturnRefundOrderVo.getReturnRefundOrderAuto().getUserId());
			submitReturnRefundOrderVo.getReturnRefundOrderAuto().setModifyTime(nowDate);
			submitReturnRefundOrderVo.getReturnRefundOrderAuto().setMofifyUser(submitReturnRefundOrderVo.getReturnRefundOrderAuto().getUserId());
			submitReturnRefundOrderVo.getReturnRefundOrderAuto().setReturnRefundLatestStatus(SUConstants.RETURN_REFUND_ORDER_STATUS_ONE);
			submitReturnRefundOrderVo.getReturnRefundOrderAuto().setIsDelete(SUConstants.IS_NOT_DELETE);
			submitReturnRefundOrderVo.getReturnRefundOrderAuto().setReturnRefundOrderNumber(refundOrderNumber);
			
			//退货、退款状态实体
			ReturnRefundStatusAuto returnRefundStatusAuto = new ReturnRefundStatusAuto();
			returnRefundStatusAuto.setCreateTime(nowDate);
			returnRefundStatusAuto.setCreateUser(submitReturnRefundOrderVo.getReturnRefundOrderAuto().getUserId());
			returnRefundStatusAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			returnRefundStatusAuto.setModifyTime(nowDate);
			returnRefundStatusAuto.setMofifyUser(submitReturnRefundOrderVo.getReturnRefundOrderAuto().getUserId());
			returnRefundStatusAuto.setOperator(submitReturnRefundOrderVo.getReturnRefundOrderAuto().getUserId().intValue());
			returnRefundStatusAuto.setReturnRefundStatusItemId(SUConstants.RETURN_REFUND_ORDER_STATUS_ONE);
			returnRefundStatusAuto.setReturnRefundStatusTime(nowDate);
			
			return returnRefundOrderService.addRefundOrder(submitReturnRefundOrderVo.getReturnRefundOrderAuto(),
					returnRefundStatusAuto, submitReturnRefundOrderVo.getPics(), sb.toString());
		} catch(MyException me){
			me.printStackTrace();
			return CommonResponseUtils.failureResponse(me.getMessage());
		} catch (Exception e) {
			logger.info("==================" + sb.toString() + "业务结束===============");
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("申请" + sb.toString() + "失败");
		}
		
	}
	
	/**
	 * App查询退货退款订单
	 * @param orderProductVo 订单商品vo 
	 * @return
	 */
	@RequestMapping("queryList")
	@ResponseBody
	public Map<String, Object> queryRefundOrder(ReturnRefundOrderVo returnRefundOrderVo){
		if(returnRefundOrderVo.getUserId() == null){
			return CommonResponseUtils.failureResponse("userId不能为空");
		}
		
		try {
			return returnRefundOrderService.queryRefundOrderForList(returnRefundOrderVo, 1, returnRefundOrderVo.getUserId(), "退货退款");
		} catch(MyException me){
			me.printStackTrace();
			return CommonResponseUtils.failureResponse(me.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("查询退货订单失败");
		}
	}
	
	
	
	/**
	 * 商家查询退货退款订单
	 * @param orderProductVo 订单商品vo 
	 * @return
	 */
	@RequestMapping("queryListByShopId")
	@ResponseBody
	public Map<String, Object> queryRefundOrderByShopId(ReturnRefundOrderVo returnRefundOrderVo, 
			Integer preDate, Long loginUserId, String productName){
		if(loginUserId == null){
			return CommonResponseUtils.failureResponse("用户id不能为空");
		}
		StringBuilder sb = new StringBuilder();
		if(returnRefundOrderVo.getReturnRefundType().intValue() == 1){
			sb.append("退货");
		}else if(returnRefundOrderVo.getReturnRefundType().intValue() == 2){
			sb.append("退款");
		}else{
			return CommonResponseUtils.failureResponse("退货退款标识不能为空");
		}
		
		try {
			if(preDate != null){
				Date nowDate = new Date();
				StringBuffer modifyStartTime = new StringBuffer();
				modifyStartTime.append(TmDateUtil.dateToString("yyyy-MM-dd",TmDateUtil.getPreDate(nowDate, "d", -(preDate-1))));
				modifyStartTime.append(" 00:00:00.000");
				StringBuffer modifyEndTime = new StringBuffer();
				modifyEndTime.append(TmDateUtil.dateToString("yyyy-MM-dd",nowDate));
				modifyEndTime.append(" 23:59:59.999");
				returnRefundOrderVo.setModifyStartTime(modifyStartTime.toString());
				returnRefundOrderVo.setModifyEndTime(modifyEndTime.toString());
			}
			if(StringUtils.isNotEmpty(productName)){
				OrderProductAuto orderProductAuto = new OrderProductAuto();
				orderProductAuto.setProductName(productName);
				returnRefundOrderVo.getOrderProducts().add(orderProductAuto);
			}
			return returnRefundOrderService.queryRefundOrderForList(returnRefundOrderVo, 2, loginUserId, sb.toString());
		} catch(MyException me){
			me.printStackTrace();
			return CommonResponseUtils.failureResponse(me.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("查询退货订单失败");
		}
	}
	
	
	
	/**
	 * 平台查询退货退款订单
	 * @param orderProductVo 订单商品vo 
	 * @return
	 */
	@RequestMapping("queryListByPlatformId")
	@ResponseBody
	public Map<String, Object> queryRefundOrderByPlatformId(ReturnRefundOrderVo returnRefundOrderVo, 
			Integer preDate, Long loginUserId, String productName){
		if(loginUserId == null){
			return CommonResponseUtils.failureResponse("用户id不能为空");
		}
		StringBuilder sb = new StringBuilder();
		if(returnRefundOrderVo.getReturnRefundType().intValue() == 1){
			sb.append("退货");
		}else if(returnRefundOrderVo.getReturnRefundType().intValue() == 2){
			sb.append("退款");
		}else{
			return CommonResponseUtils.failureResponse("退货退款标识不能为空");
		}
		
		try {
			if(preDate != null){
				Date nowDate = new Date();
				StringBuffer modifyStartTime = new StringBuffer();
				modifyStartTime.append(TmDateUtil.dateToString("yyyy-MM-dd",TmDateUtil.getPreDate(nowDate, "d", -(preDate-1))));
				modifyStartTime.append(" 00:00:00.000");
				StringBuffer modifyEndTime = new StringBuffer();
				modifyEndTime.append(TmDateUtil.dateToString("yyyy-MM-dd",nowDate));
				modifyEndTime.append(" 23:59:59.999");
				returnRefundOrderVo.setModifyStartTime(modifyStartTime.toString());
				returnRefundOrderVo.setModifyEndTime(modifyEndTime.toString());
			}
			if(StringUtils.isNotEmpty(productName)){
				OrderProductAuto orderProductAuto = new OrderProductAuto();
				orderProductAuto.setProductName(productName);
				returnRefundOrderVo.getOrderProducts().add(orderProductAuto);
			}
			return returnRefundOrderService.queryRefundOrderForList(returnRefundOrderVo, 3, loginUserId, sb.toString());
		} catch(MyException me){
			me.printStackTrace();
			return CommonResponseUtils.failureResponse(me.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("查询退货订单失败");
		}
	}
	
	
	/**
	 * App更新退货退款订单状态
	 * @param returnRefundOrderAuto 退货退款实体
	 * @return
	 */
	@RequestMapping("update")
	@ResponseBody
	public Map<String, Object> updateRefundOrderForApp(ReturnRefundOrderAuto returnRefundOrderAuto){
		if(returnRefundOrderAuto.getUserId() == null){
			return CommonResponseUtils.failureResponse("用户id不能为空");
		}
		if(returnRefundOrderAuto.getReturnRefundLatestStatus() == SUConstants.RETURN_REFUND_ORDER_STATUS_EIGHT
			&&(StringUtils.isEmpty(returnRefundOrderAuto.getReturnAddress())
				|| StringUtils.isEmpty(returnRefundOrderAuto.getContactPerson())
				|| StringUtils.isEmpty(returnRefundOrderAuto.getPhone()))){
			return CommonResponseUtils.failureResponse("发货失败，退货参数输入不全");
		}
		
		StringBuilder sb = new StringBuilder();
		if(returnRefundOrderAuto.getReturnRefundType().intValue() == 1){
			sb.append("退货");
		}else if(returnRefundOrderAuto.getReturnRefundType().intValue() == 2){
			sb.append("退款");
		}else{
			Map<String, Object> resMap = new HashMap<String, Object>();
			resMap.putAll(CommonResponseUtils.failureResponse("退货退款标识不能为空"));
			return resMap;
		}
		
		try {
			String nowDate = TmDateUtil.getTimeStamp();
			
			//封装退货、退款实体
			returnRefundOrderAuto.setModifyTime(nowDate);
			returnRefundOrderAuto.setMofifyUser(returnRefundOrderAuto.getUserId());
			
			return returnRefundOrderService.updateRefundOrderForApp(returnRefundOrderAuto, sb.toString());
		} catch(MyException me){
			me.printStackTrace();
			return CommonResponseUtils.failureResponse(me.getMessage());
		} catch (Exception e) {
			logger.info("==================" + sb.toString() + "业务结束===============");
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("申请" + sb.toString() + "失败");
		}
		
	}
	
	
	/**
	 * 商家更新退货退款订单状态
	 * @param returnRefundOrderAuto 退货退款实体
	 * @return
	 */
	@RequestMapping("bussiness/update")
	@ResponseBody
	public Map<String, Object> updateRefundOrderForBussiness(ReturnRefundOrderAuto returnRefundOrderAuto, 
			Long loginUserId){
		if(loginUserId == null){
			return CommonResponseUtils.failureResponse("用户id不能为空");
		}
		
		StringBuilder sb = new StringBuilder();
		if(returnRefundOrderAuto.getReturnRefundType().intValue() == 1){
			sb.append("退货");
		}else if(returnRefundOrderAuto.getReturnRefundType().intValue() == 2){
			sb.append("退款");
		}else{
			Map<String, Object> resMap = new HashMap<String, Object>();
			resMap.putAll(CommonResponseUtils.failureResponse("退货退款标识不能为空"));
			return resMap;
		}
		
		try {
			String nowDate = TmDateUtil.getTimeStamp();
			
			//封装退货、退款实体
			returnRefundOrderAuto.setModifyTime(nowDate);
			returnRefundOrderAuto.setMofifyUser(loginUserId);
			
			return returnRefundOrderService.updateRefundOrderForBussiness(returnRefundOrderAuto, sb.toString(), loginUserId);
		} catch(MyException me){
			me.printStackTrace();
			return CommonResponseUtils.failureResponse(me.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("==================" + sb.toString() + "业务结束===============");
			return CommonResponseUtils.failureResponse("申请" + sb.toString() + "失败");
		}
		
	}
	
	
	
	
	/**
	 * 平台更新退货退款订单状态
	 * @param returnRefundOrderAuto 退货退款实体
	 * @return
	 */
	@RequestMapping("platform/update")
	@ResponseBody
	public Map<String, Object> updateRefundOrderForPlatform(ReturnRefundOrderAuto returnRefundOrderAuto,
			Long loginUserId){
		if(loginUserId == null){
			return CommonResponseUtils.failureResponse("用户id不能为空");
		}
		
		StringBuilder sb = new StringBuilder();
		if(returnRefundOrderAuto.getReturnRefundType().intValue() == 1){
			sb.append("退货");
		}else if(returnRefundOrderAuto.getReturnRefundType().intValue() == 2){
			sb.append("退款");
		}else{
			Map<String, Object> resMap = new HashMap<String, Object>();
			resMap.putAll(CommonResponseUtils.failureResponse("退货退款标识不能为空"));
			return resMap;
		}
		
		try {
			String nowDate = TmDateUtil.getTimeStamp();
			
			//封装退货、退款实体
			returnRefundOrderAuto.setModifyTime(nowDate);
			returnRefundOrderAuto.setMofifyUser(loginUserId);
			
			return returnRefundOrderService.updateRefundOrderForPlatform(returnRefundOrderAuto, sb.toString(), loginUserId);
		} catch(MyException me){
			me.printStackTrace();
			return CommonResponseUtils.failureResponse(me.getMessage());
		} catch (Exception e) {
			logger.info("==================" + sb.toString() + "业务结束===============");
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("申请" + sb.toString() + "失败");
		}
		
	}
	
	
	/**
	 * 查询退货退款订单图片
	 * @param returnRefundOrderId 退货退款订单id
	 * @return
	 */
	@RequestMapping("queryReturnRefundPic")
	@ResponseBody
	public Map<String, Object> queryReturnRefundPic(Long returnRefundOrderId){
		if(returnRefundOrderId == null){
			return CommonResponseUtils.failureResponse("退货退款订单id不能为空");
		}
		
		try {
			return returnRefundOrderService.queryReturnRefundPicForList(returnRefundOrderId);
		} catch(MyException me){
			me.printStackTrace();
			return CommonResponseUtils.failureResponse(me.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("查询退货退款订单图片失败");
		}
	}
	
	
	/**
	 * 查询退款单
	 * @param returnRefundOrderId 退货退款订单id
	 * @return
	 */
	@RequestMapping("queryRefundOrderInfo")
	@ResponseBody
	public Map<String, Object> queryRefundOrderInfo(Long returnRefundOrderId,Long loginUserId){
		if(returnRefundOrderId == null){
			return CommonResponseUtils.failureResponse("退货退款订单id不能为空");
		}
		if(loginUserId == null){
			return CommonResponseUtils.failureResponse("用户id不能为空");
		}
		
		try {
			return returnRefundOrderService.queryRefundOrder(returnRefundOrderId, loginUserId);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("查询退款单信息失败");
		}
	}
	
	
	
	/**
	 * 商家通过订单商品id查找最新售后订单
	 * @param returnRefundOrderId 退货退款订单id
	 * @return
	 */
	@RequestMapping("business/queryByOrderProductId")
	@ResponseBody
	public Map<String, Object> queryReturnRefundOrderByOrderProductIdForBusiness(Long orderProductId,Long loginUserId){
		if(orderProductId == null){
			return CommonResponseUtils.failureResponse("订单商品id不能为空");
		}
		if(loginUserId == null){
			return CommonResponseUtils.failureResponse("用户id不能为空");
		}
		
		try {
			return returnRefundOrderService.queryReturnRefundOrderByOrderProductIdForBusiness(orderProductId, loginUserId);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("查询售后订单失败");
		}
	}
	
	
	
	/**
	 * 平台通过订单商品id查找最新售后订单
	 * @param returnRefundOrderId 退货退款订单id
	 * @return
	 */
	@RequestMapping("platform/queryByOrderProductId")
	@ResponseBody
	public Map<String, Object> queryReturnRefundOrderByOrderProductIdForPlatform(Long orderProductId,Long loginUserId){
		if(orderProductId == null){
			return CommonResponseUtils.failureResponse("订单商品id不能为空");
		}
		if(loginUserId == null){
			return CommonResponseUtils.failureResponse("用户id不能为空");
		}
		
		try {
			return returnRefundOrderService.queryReturnRefundOrderByOrderProductIdForPlatform(orderProductId, loginUserId);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("查询售后订单失败");
		}
	}
	
	
	
	
	
	/**
	 * 平台查询历史退款单/未生成退款单
	 * @param orderProductVo 订单商品vo 
	 * @param type 查询类型 1：未生成退款单，2：历史退款单
	 * @return
	 */
	@RequestMapping("queryGenerateRefundOrder")
	@ResponseBody
	public Map<String, Object> queryGenerateRefundOrder(GenerateRefundOrderVo generateRefundOrderVo, 
			Integer preDate, Long loginUserId, String productName, Integer type){
		if(loginUserId == null){
			return CommonResponseUtils.failureResponse("用户id不能为空");
		}
		
		if(type == null){
			return CommonResponseUtils.failureResponse("参数异常");
		}else if(type == 1){
			generateRefundOrderVo.setReturnRefundLatestStatus(SUConstants.RETURN_REFUND_ORDER_STATUS_FOUR);
		}else if(type == 2){
			generateRefundOrderVo.setReturnRefundLatestStatus(SUConstants.RETURN_REFUND_ORDER_STATUS_SIX);
		}else{
			return CommonResponseUtils.failureResponse("参数异常");
		}
		
		try {
			if(preDate != null){
				Date nowDate = new Date();
				StringBuffer modifyStartTime = new StringBuffer();
				modifyStartTime.append(TmDateUtil.dateToString("yyyy-MM-dd",TmDateUtil.getPreDate(nowDate, "d", -(preDate-1))));
				modifyStartTime.append(" 00:00:00.000");
				StringBuffer modifyEndTime = new StringBuffer();
				modifyEndTime.append(TmDateUtil.dateToString("yyyy-MM-dd",nowDate));
				modifyEndTime.append(" 23:59:59.999");
				generateRefundOrderVo.setModifyStartTime(modifyStartTime.toString());
				generateRefundOrderVo.setModifyEndTime(modifyEndTime.toString());
			}
			if(StringUtils.isNotEmpty(productName)){
				OrderProductAuto orderProductAuto = new OrderProductAuto();
				orderProductAuto.setProductName(productName);
				generateRefundOrderVo.getOrderProducts().add(orderProductAuto);
			}
			return returnRefundOrderService.queryGenerateRefundOrderForList(generateRefundOrderVo, loginUserId, "退款单");
		} catch(MyException me){
			me.printStackTrace();
			return CommonResponseUtils.failureResponse(me.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("查询退货订单失败");
		}
	}
}
