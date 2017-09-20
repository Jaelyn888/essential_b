package com.essential.bussiness.order.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.essential.bussiness.order.dao.OrderAutoMapper;
import com.essential.bussiness.order.dao.OrderProductAutoMapper;
import com.essential.bussiness.order.dao.ReturnRefundOrderAutoMapper;
import com.essential.bussiness.order.dao.ReturnRefundOrderPicAutoMapper;
import com.essential.bussiness.order.dao.ReturnRefundStatusAutoMapper;
import com.essential.bussiness.order.model.auto.OrderAuto;
import com.essential.bussiness.order.model.auto.OrderProductAuto;
import com.essential.bussiness.order.model.auto.ReturnRefundOrderAuto;
import com.essential.bussiness.order.model.auto.ReturnRefundOrderAutoExample;
import com.essential.bussiness.order.model.auto.ReturnRefundOrderPicAuto;
import com.essential.bussiness.order.model.auto.ReturnRefundOrderPicAutoExample;
import com.essential.bussiness.order.model.auto.ReturnRefundStatusAuto;
import com.essential.bussiness.order.model.vo.GenerateRefundOrderVo;
import com.essential.bussiness.order.model.vo.ReturnRefundOrderVo;
import com.essential.bussiness.order.service.IOrderService;
import com.essential.bussiness.order.service.IReturnRefundOrderService;
import com.essential.bussiness.returns.model.auto.ReturnAddressAuto;
import com.essential.bussiness.returns.service.IReturnRightsAddressService;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.MyException;
import com.essential.common.utils.TmDateUtil;
import com.essential.user.dao.UserBaseInfoAutoMapper;
import com.essential.user.model.auto.UserBaseInfoAuto;
import com.essential.utils.CommonResponseUtils;

/**
 * 退款service
 * @author essential-gfs
 *
 */
@Service
public class ReturnRefundOrderServiceImpl implements IReturnRefundOrderService {

	private static Logger logger = LoggerFactory.getLogger(ReturnRefundOrderServiceImpl.class);
	
	//注入退货退款dao
	@Autowired
	ReturnRefundOrderAutoMapper returnRefundOrderDao;
	//注入退货退款状态dao
	@Autowired
	ReturnRefundStatusAutoMapper returnRefundStatusDao;
	//注入退货退款图片dao
	@Autowired
	ReturnRefundOrderPicAutoMapper returnRefundOrderPicDao;
	//注入购买订单dao
	@Autowired
	OrderAutoMapper orderDao;
	//注入订单商品dao
	@Autowired
	OrderProductAutoMapper orderProductDao;
	//注入用户基础信息dao
	@Autowired
	UserBaseInfoAutoMapper userDao;
	//注入购买订单serivce
	@Autowired
	@Qualifier("orderServiceImpl")
	IOrderService orderService;
	//注入店铺售后地址信息dao
	@Autowired
	@Qualifier("returnRightsAddressServiceImpl")
	IReturnRightsAddressService returnAddressService;
	
	
	/**
	 * 新增退货、退款订单
	 */
	@Override
	public Map<String, Object> addRefundOrder(ReturnRefundOrderAuto returnRefundOrderAuto,
			ReturnRefundStatusAuto returnRefundStatusAuto, String[] pics, String orderType) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		
		try {
			//校验传入参数及订单信息  是否满足退货、退款条件
			checkParamAndOrderInfo(returnRefundOrderAuto, resMap, orderType);
			if(resMap.containsKey(SUConstants.CODE_KEY) && SUConstants.CODE_FAIL_VALUE.equals(resMap.get(SUConstants.CODE_KEY))){
				return resMap;
			}
			
			//校验订单商品状态
			OrderProductAuto orderProduct = orderProductDao
					.selectByPrimaryKey(returnRefundOrderAuto.getOrderProductId());
			returnRefundOrderAuto.setReturnOrderProductCount(orderProduct.getProductCount());
			if(orderProduct.getReturnRefundStatus() != 0 && orderProduct.getReturnRefundStatus() < 30 
					&& orderProduct.getReturnRefundStatus()%10 != SUConstants.RETURN_REFUND_ORDER_STATUS_TWO
					&& orderProduct.getReturnRefundStatus()%10 != SUConstants.RETURN_REFUND_ORDER_STATUS_FIVE
					&& orderProduct.getReturnRefundStatus()%10 != SUConstants.RETURN_REFUND_ORDER_STATUS_SIX
					&& orderProduct.getReturnRefundStatus()%10 != SUConstants.RETURN_REFUND_ORDER_STATUS_NINE){
				throw new MyException(orderType + "失败，当前订单商品正在售后中");
			}else if(orderProduct.getReturnRefundStatus() > 30){
				throw new MyException(orderType + "失败，当前订单商品已申请两次售后");
			}
			ReturnRefundOrderAutoExample returnRefundOrderexample = new ReturnRefundOrderAutoExample();
			returnRefundOrderexample.createCriteria().andOrderProductIdEqualTo(returnRefundOrderAuto.getOrderProductId());
			List<ReturnRefundOrderAuto> returnRefundOrderList = returnRefundOrderDao.selectByExample(returnRefundOrderexample);
			int i = 0;
			
			if(returnRefundOrderList == null || returnRefundOrderList.size() == 0 || (returnRefundOrderList.size() == 1 
					&& (returnRefundOrderList.get(0).getReturnRefundLatestStatus().intValue() == SUConstants.RETURN_REFUND_ORDER_STATUS_TWO
					|| returnRefundOrderList.get(0).getReturnRefundLatestStatus().intValue() == SUConstants.RETURN_REFUND_ORDER_STATUS_FIVE
					|| returnRefundOrderList.get(0).getReturnRefundLatestStatus().intValue() == SUConstants.RETURN_REFUND_ORDER_STATUS_SIX
					|| returnRefundOrderList.get(0).getReturnRefundLatestStatus().intValue() == SUConstants.RETURN_REFUND_ORDER_STATUS_NINE))){
				i = 0;
				if(returnRefundOrderAuto.getReturnRefundType().intValue() == 1){
					if(returnRefundOrderList.size() == 0){
						orderProduct.setReturnRefundStatus(returnRefundOrderAuto.getReturnRefundLatestStatus()+10);//第一次退货申请
					}else{
						orderProduct.setReturnRefundStatus(returnRefundOrderAuto.getReturnRefundLatestStatus()+30);//第二次退货申请
					}
				}else{
					if(returnRefundOrderList.size() == 0){
						orderProduct.setReturnRefundStatus(returnRefundOrderAuto.getReturnRefundLatestStatus()+20);//第一次退款申请
					}else{
						orderProduct.setReturnRefundStatus(returnRefundOrderAuto.getReturnRefundLatestStatus()+40);//第二次退款申请
					}
				}
				//更新订单商品状态
				i = orderProductDao.updateByPrimaryKeySelective(orderProduct);
				if(i <= 0){
					throw new MyException(orderType + "失败，更新订单商品信息失败");
				}
			}else{
				throw new MyException(orderType + "失败，当前订单商品信息，正在售后审核中");
			}
			
			//退货商家地址
//			returnRefundOrderAuto.setContactPerson("奕赏售后组");
//			returnRefundOrderAuto.setReturnAddress("上海市徐汇区安福路288号话剧大厦15楼");
//			returnRefundOrderAuto.setPhone("13248033291");
			
			ReturnAddressAuto returnAddressAuto = new ReturnAddressAuto();
			returnAddressAuto.setShopId(returnRefundOrderAuto.getShopId());
			Map<String, Object> returnAddressMap = returnAddressService.queryDefaultAddress(returnAddressAuto);
			
			if(SUConstants.CODE_FAIL_VALUE.equals(returnAddressMap.get(SUConstants.CODE_KEY).toString())){
				logger.info("查询店铺id为：" + returnRefundOrderAuto.getShopId() + "的售后地址信息失败");
				throw new MyException("查询店铺id为：" + returnRefundOrderAuto.getShopId() + "的售后地址信息失败");
			}else{
				ReturnAddressAuto defaultReturnAddress = (ReturnAddressAuto) returnAddressMap.get(SUConstants.INFO_KEY);
				
				returnRefundOrderAuto.setContactPerson(defaultReturnAddress.getContactPerson());
				returnRefundOrderAuto.setReturnAddress(defaultReturnAddress.getReturnAddress());
				returnRefundOrderAuto.setPhone(defaultReturnAddress.getPhone());
			}
			
			
			//新增退货、退款订单
			i = returnRefundOrderDao.insert(returnRefundOrderAuto);
			if(i <= 0){
				logger.info("新增" + orderType + "订单失败：数据库生成" + orderType + "订单失败，执行insert返回影响行i为：" + i);
				throw new MyException("新增" + orderType + "订单失败：数据库生成" + orderType + "订单失败，执行insert返回影响行i为：" + i);
			}
			
			//新增退货、退款状态信息
			addReturnRefundStatus(returnRefundStatusAuto, returnRefundOrderAuto, orderType);
					
			if(returnRefundOrderAuto.getPicIdentity().intValue() == 1){//存在图片
				//新增退货、退款图片信息
				addReturnOrderPic(returnRefundOrderAuto, pics, orderType);
			}
			
			resMap.putAll(CommonResponseUtils.successResponse());
		} catch(MyException me){
			throw me;
		} catch (Exception e) {
			logger.info("新增" + orderType + "订单失败" );
			throw new RuntimeException(e);
		}
		
		return resMap;
	}

	/**
	 * 查询退货订单列表
	 * 1:App查询，2：商家查询，3：平台查询
	 */
	@Override
	public Map<String, Object> queryRefundOrderForList(ReturnRefundOrderVo returnRefundOrderVo, 
			int type, Long loginUserId, String returnRefundType) {
		
		try {
			//查询当前登录用户信息
			UserBaseInfoAuto userBaseInfo = userDao.selectByPrimaryKey(loginUserId);
			//校验当前用户权限
			if(userBaseInfo ==null || userBaseInfo.getUserTypeId() == null){
				return CommonResponseUtils.failureResponse("当前登录用户无此操作权限");
			}
			
			if(type == 1){
				//校验当前用户权限
				if(SUConstants.USERTYPE_APP != userBaseInfo.getUserTypeId()){
					return CommonResponseUtils.failureResponse("当前登录用户无此操作权限");
				}
			}else if(type == 2){
				returnRefundOrderVo.setShopId(userBaseInfo.getShopId());
				if(returnRefundOrderVo.getShopId() == null){
					return CommonResponseUtils.failureResponse("当前用户店铺id为空");
				}
				//校验当前用户权限
				if(SUConstants.USERTYPE_SHOP != userBaseInfo.getUserTypeId()){
					return CommonResponseUtils.failureResponse("当前登录用户无此操作权限");
				}
			}else if(type == 3){
				//校验当前用户权限
				if(SUConstants.USERTYPE_PATFORM != userBaseInfo.getUserTypeId()){
					return CommonResponseUtils.failureResponse("当前登录用户无此操作权限");
				}
				returnRefundOrderVo.setShopId(null);
			}else{
				return CommonResponseUtils.failureResponse("当前登录用户无此操作权限");
			}
			
			return queryRefundOrderList(returnRefundOrderVo, type, returnRefundType);
		} catch(MyException me){
			logger.info("查询"+returnRefundType+"订单失败：" + me);
			throw me;
		} catch (Exception e) {
			logger.info("查询"+returnRefundType+"订单失败");
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * App更新退款退货订单信息
	 */
	@Override
	public Map<String, Object> updateRefundOrderForApp(
			ReturnRefundOrderAuto returnRefundOrderAuto, String busiType) {
		
		try {
			//查询当前登录用户信息
			UserBaseInfoAuto userBaseInfo = userDao.selectByPrimaryKey(returnRefundOrderAuto.getUserId());
			//校验当前用户权限
			if(userBaseInfo ==null || userBaseInfo.getUserTypeId() == null 
					||  SUConstants.USERTYPE_APP != userBaseInfo.getUserTypeId()){
				return CommonResponseUtils.failureResponse("当前登录用户无此操作权限");
			}
			//查询订单信息
			ReturnRefundOrderAuto returnRefundOrderAutoDb = returnRefundOrderDao.selectByPrimaryKey(returnRefundOrderAuto.getReturnRefundOrderId());
			//校验当前用户对订单的操作权限
			if(returnRefundOrderAuto.getReturnRefundLatestStatus().intValue() != SUConstants.RETURN_REFUND_ORDER_STATUS_EIGHT){
				return CommonResponseUtils.failureResponse("当前登录用户无此操作权限");
			}
			if(returnRefundOrderAuto.getReturnRefundLatestStatus().intValue() == SUConstants.RETURN_REFUND_ORDER_STATUS_EIGHT
					&& returnRefundOrderAutoDb.getReturnRefundLatestStatus().intValue() != SUConstants.RETURN_REFUND_ORDER_STATUS_SERVEN){
				return CommonResponseUtils.failureResponse("订单状态异常，不能发货");
			}
			
			returnRefundOrderAuto.setOrderId(returnRefundOrderAutoDb.getOrderId());
			returnRefundOrderAuto.setOrderProductId(returnRefundOrderAutoDb.getOrderProductId());
			return updateRefundOrder(returnRefundOrderAuto, busiType, returnRefundOrderAuto.getUserId(),returnRefundOrderAutoDb.getReturnRefundOrderNumber());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * 商家更新退款退货订单信息
	 */
	@Override
	public Map<String, Object> updateRefundOrderForBussiness(
			ReturnRefundOrderAuto returnRefundOrderAuto, String busiType, Long loginUserId) {
		
		try {
			//查询当前登录用户信息
			UserBaseInfoAuto userBaseInfo = userDao.selectByPrimaryKey(loginUserId);
			//校验当前用户权限
			if(userBaseInfo ==null || userBaseInfo.getUserTypeId() == null 
					||  SUConstants.USERTYPE_SHOP != userBaseInfo.getUserTypeId()){
				return CommonResponseUtils.failureResponse("当前登录用户无此操作权限");
			}
			returnRefundOrderAuto.setShopId(userBaseInfo.getShopId());
			if(returnRefundOrderAuto.getShopId() == null){
				return CommonResponseUtils.failureResponse("当前用户店铺id为空");
			}
			
			//查询订单信息
			ReturnRefundOrderAuto returnRefundOrderAutoDb = returnRefundOrderDao.selectByPrimaryKey(returnRefundOrderAuto.getReturnRefundOrderId());
			//校验当前用户对订单的操作权限
			if(returnRefundOrderAuto.getReturnRefundType().intValue() == 1){//退货
				if(returnRefundOrderAuto.getReturnRefundLatestStatus().intValue() != SUConstants.RETURN_REFUND_ORDER_STATUS_TWO
						&& returnRefundOrderAuto.getReturnRefundLatestStatus().intValue() != SUConstants.RETURN_REFUND_ORDER_STATUS_THREE
						&& returnRefundOrderAuto.getReturnRefundLatestStatus().intValue() != SUConstants.RETURN_REFUND_ORDER_STATUS_SERVEN
						&& returnRefundOrderAuto.getReturnRefundLatestStatus().intValue() != SUConstants.RETURN_REFUND_ORDER_STATUS_NINE){
					return CommonResponseUtils.failureResponse("当前登录用户无此操作权限");
				}
				
				if(returnRefundOrderAuto.getReturnRefundLatestStatus().intValue() == SUConstants.RETURN_REFUND_ORDER_STATUS_TWO
						&& returnRefundOrderAutoDb.getReturnRefundLatestStatus().intValue() != SUConstants.RETURN_REFUND_ORDER_STATUS_ONE){
					return CommonResponseUtils.failureResponse("订单状态异常，当前"+busiType+"申请不能驳回");
				}else if(returnRefundOrderAuto.getReturnRefundLatestStatus().intValue() == SUConstants.RETURN_REFUND_ORDER_STATUS_THREE
						&& returnRefundOrderAutoDb.getReturnRefundLatestStatus().intValue() != SUConstants.RETURN_REFUND_ORDER_STATUS_EIGHT){
					return CommonResponseUtils.failureResponse("订单状态异常，当前"+busiType+"申请不能审核");
				}else if(returnRefundOrderAuto.getReturnRefundLatestStatus().intValue() == SUConstants.RETURN_REFUND_ORDER_STATUS_SERVEN
						&& returnRefundOrderAutoDb.getReturnRefundLatestStatus().intValue() != SUConstants.RETURN_REFUND_ORDER_STATUS_ONE){
					return CommonResponseUtils.failureResponse("订单状态异常，当前"+busiType+"申请不能审核");
				}else if(returnRefundOrderAuto.getReturnRefundLatestStatus().intValue() == SUConstants.RETURN_REFUND_ORDER_STATUS_NINE
						&& returnRefundOrderAutoDb.getReturnRefundLatestStatus().intValue() != SUConstants.RETURN_REFUND_ORDER_STATUS_EIGHT){
					return CommonResponseUtils.failureResponse("订单状态异常，当前"+busiType+"申请货品不能驳回");
				}
			}else{//退款
				if(returnRefundOrderAuto.getReturnRefundLatestStatus().intValue() != SUConstants.RETURN_REFUND_ORDER_STATUS_TWO
						&& returnRefundOrderAuto.getReturnRefundLatestStatus().intValue() != SUConstants.RETURN_REFUND_ORDER_STATUS_THREE){
					return CommonResponseUtils.failureResponse("当前登录用户无此操作权限");
				}
				
				if(returnRefundOrderAuto.getReturnRefundLatestStatus().intValue() == SUConstants.RETURN_REFUND_ORDER_STATUS_TWO
						&& returnRefundOrderAutoDb.getReturnRefundLatestStatus().intValue() != SUConstants.RETURN_REFUND_ORDER_STATUS_ONE){
					return CommonResponseUtils.failureResponse("订单状态异常，当前"+busiType+"申请不能驳回");
				}else if(returnRefundOrderAuto.getReturnRefundLatestStatus().intValue() == SUConstants.RETURN_REFUND_ORDER_STATUS_THREE
						&& returnRefundOrderAutoDb.getReturnRefundLatestStatus().intValue() != SUConstants.RETURN_REFUND_ORDER_STATUS_ONE){
					return CommonResponseUtils.failureResponse("订单状态异常，当前"+busiType+"申请不能审核");
				}
			}
			
			returnRefundOrderAuto.setShopId(null);
			returnRefundOrderAuto.setOrderId(returnRefundOrderAutoDb.getOrderId());
			returnRefundOrderAuto.setOrderProductId(returnRefundOrderAutoDb.getOrderProductId());
			return updateRefundOrder(returnRefundOrderAuto, busiType, returnRefundOrderAutoDb.getUserId(),returnRefundOrderAutoDb.getReturnRefundOrderNumber());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * 平台更新退款退货订单信息
	 */
	@Override
	public Map<String, Object> updateRefundOrderForPlatform(
			ReturnRefundOrderAuto returnRefundOrderAuto, String busiType, Long loginUserId) {
		
		try {
			//查询当前登录用户信息
			UserBaseInfoAuto userBaseInfo = userDao.selectByPrimaryKey(loginUserId);
			//校验当前用户权限
			if(userBaseInfo ==null || userBaseInfo.getUserTypeId() == null 
					||  SUConstants.USERTYPE_PATFORM != userBaseInfo.getUserTypeId()){
				return CommonResponseUtils.failureResponse("当前登录用户无此操作权限");
			}
			//查询订单信息
			ReturnRefundOrderAuto returnRefundOrderAutoDb = returnRefundOrderDao.selectByPrimaryKey(returnRefundOrderAuto.getReturnRefundOrderId());
			//校验当前用户对订单的操作权限
			if(returnRefundOrderAuto.getReturnRefundLatestStatus().intValue() != SUConstants.RETURN_REFUND_ORDER_STATUS_FOUR
					&& returnRefundOrderAuto.getReturnRefundLatestStatus().intValue() != SUConstants.RETURN_REFUND_ORDER_STATUS_FIVE
					&& returnRefundOrderAuto.getReturnRefundLatestStatus().intValue() != SUConstants.RETURN_REFUND_ORDER_STATUS_SIX){
				return CommonResponseUtils.failureResponse("当前登录用户无此操作权限");
			}
			if(returnRefundOrderAuto.getReturnRefundLatestStatus().intValue() == SUConstants.RETURN_REFUND_ORDER_STATUS_FOUR
					&& returnRefundOrderAutoDb.getReturnRefundLatestStatus().intValue() != SUConstants.RETURN_REFUND_ORDER_STATUS_THREE){
				return CommonResponseUtils.failureResponse("订单状态异常，当前"+busiType+"申请审核不能通过");
			}else if(returnRefundOrderAuto.getReturnRefundLatestStatus().intValue() == SUConstants.RETURN_REFUND_ORDER_STATUS_FIVE
					&& returnRefundOrderAutoDb.getReturnRefundLatestStatus().intValue() != SUConstants.RETURN_REFUND_ORDER_STATUS_THREE){
				return CommonResponseUtils.failureResponse("订单状态异常，当前"+busiType+"申请不能驳回");
			}else if(returnRefundOrderAuto.getReturnRefundLatestStatus().intValue() == SUConstants.RETURN_REFUND_ORDER_STATUS_SIX
					&& returnRefundOrderAutoDb.getReturnRefundLatestStatus().intValue() != SUConstants.RETURN_REFUND_ORDER_STATUS_FOUR){
				return CommonResponseUtils.failureResponse("订单状态异常，当前"+busiType+"申请不能通过");
			}
			
			returnRefundOrderAuto.setShopId(null);
			returnRefundOrderAuto.setOrderId(returnRefundOrderAutoDb.getOrderId());
			returnRefundOrderAuto.setOrderProductId(returnRefundOrderAutoDb.getOrderProductId());
			return updateRefundOrder(returnRefundOrderAuto, busiType, returnRefundOrderAutoDb.getUserId(),returnRefundOrderAutoDb.getReturnRefundOrderNumber());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * 查询退款退货订单图片
	 */
	@Override
	public Map<String, Object> queryReturnRefundPicForList(
			Long returnRefundOrderId) {
		try {
			ReturnRefundOrderPicAutoExample returnRefundOrderPicAutoExample = new ReturnRefundOrderPicAutoExample();
			returnRefundOrderPicAutoExample.createCriteria().andReturnRefundOrderIdEqualTo(returnRefundOrderId);
			List<ReturnRefundOrderPicAuto> returnRefundOrderPics = returnRefundOrderPicDao.selectByExample(returnRefundOrderPicAutoExample);
			return CommonResponseUtils.successResponse(returnRefundOrderPics);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * 查看退款单
	 */
	@Override
	public Map<String, Object> queryRefundOrder(Long returnRefundOrderId, Long loginUserId) {
		try {
			//查询当前登录用户信息
			UserBaseInfoAuto userBaseInfo = userDao.selectByPrimaryKey(loginUserId);
			//校验当前用户权限
			if(userBaseInfo ==null || userBaseInfo.getUserTypeId() == null){
				return CommonResponseUtils.failureResponse("当前登录用户无此操作权限");
			}
			if(SUConstants.USERTYPE_PATFORM != userBaseInfo.getUserTypeId()){
				return CommonResponseUtils.failureResponse("当前登录用户无此操作权限");
			}
			ReturnRefundOrderAuto returnRefundOrderAuto = returnRefundOrderDao.selectByPrimaryKey(returnRefundOrderId);
			return CommonResponseUtils.successResponse(returnRefundOrderAuto);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	/**
	 * 商家通过订单商品id查找最新售后订单
	 */
	@Override
	public Map<String, Object> queryReturnRefundOrderByOrderProductIdForBusiness(Long orderProductId, Long loginUserId) {
		try {
			//查询当前登录用户信息
			UserBaseInfoAuto userBaseInfo = userDao.selectByPrimaryKey(loginUserId);
			//校验当前用户权限
			if(userBaseInfo ==null || userBaseInfo.getUserTypeId() == null){
				return CommonResponseUtils.failureResponse("当前登录用户无此操作权限");
			}
			if(SUConstants.USERTYPE_SHOP != userBaseInfo.getUserTypeId()){
				return CommonResponseUtils.failureResponse("当前登录用户无此操作权限");
			}
			return queryReturnRefundOrderByOrderProductId(orderProductId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * 平台通过订单商品id查找最新售后订单
	 */
	@Override
	public Map<String, Object> queryReturnRefundOrderByOrderProductIdForPlatform(Long orderProductId, Long loginUserId) {
		try {
			//查询当前登录用户信息
			UserBaseInfoAuto userBaseInfo = userDao.selectByPrimaryKey(loginUserId);
			//校验当前用户权限
			if(userBaseInfo ==null || userBaseInfo.getUserTypeId() == null){
				return CommonResponseUtils.failureResponse("当前登录用户无此操作权限");
			}
			if(SUConstants.USERTYPE_PATFORM != userBaseInfo.getUserTypeId()){
				return CommonResponseUtils.failureResponse("当前登录用户无此操作权限");
			}
			return queryReturnRefundOrderByOrderProductId(orderProductId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	/**
	 * 平台查询历史退款单/未生成退款单
	 * @param orderProductVo 订单商品vo 
	 * @param type 查询类型 1：未生成退款单，2：历史退款单
	 */
	@Override
	public Map<String, Object> queryGenerateRefundOrderForList(GenerateRefundOrderVo generateRefundOrderVo, 
			Long loginUserId, String returnRefundType) {
		
		try {
			//查询当前登录用户信息
			UserBaseInfoAuto userBaseInfo = userDao.selectByPrimaryKey(loginUserId);
			//校验当前用户权限
			if(userBaseInfo ==null || userBaseInfo.getUserTypeId() == null){
				return CommonResponseUtils.failureResponse("当前登录用户无此操作权限");
			}
			
			if(generateRefundOrderVo.getPageCount() == null){
				generateRefundOrderVo.setPageCount(SUConstants.PAGE_COUNT);
			}
			
			if(generateRefundOrderVo.getPageNo() != null){
				generateRefundOrderVo.setPageNo((generateRefundOrderVo.getPageNo()-1)*generateRefundOrderVo.getPageCount());
			}else{
				generateRefundOrderVo.setPageNo(0);
			}
			
			generateRefundOrderVo.setTotalPageCount(returnRefundOrderDao.queryGenerateRefundOrderForListCount(generateRefundOrderVo));
			List<GenerateRefundOrderVo> generateRefundOrderVos = new ArrayList<GenerateRefundOrderVo>();
			Map<String, Object> resMap = new HashMap<String, Object>();
			if(generateRefundOrderVo.getTotalPageCount() > 0){
				generateRefundOrderVos = returnRefundOrderDao.queryGenerateRefundOrderForList(generateRefundOrderVo);
				for (int i = 0; i < generateRefundOrderVos.size(); i++) {
					OrderProductAuto orderProductAuto = orderProductDao.selectByPrimaryKey((long)Integer.parseInt(generateRefundOrderVos.get(i).getOrderProductId()));
					generateRefundOrderVos.get(i).getOrderProducts().add(orderProductAuto);
				}
				resMap.put("totalPageCount", generateRefundOrderVo.getTotalPageCount());
				resMap.put("returnRefundOrderVos", generateRefundOrderVos);
			}else{
				resMap.put("totalPageCount", generateRefundOrderVo.getTotalPageCount());
				resMap.put("returnRefundOrderVos", generateRefundOrderVos);
			}
			return CommonResponseUtils.successResponse(resMap);
		} catch(MyException me){
			logger.info("查询"+returnRefundType+"订单失败：" + me);
			throw me;
		} catch (Exception e) {
			logger.info("查询"+returnRefundType+"订单失败");
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * 通过订单商品id查找最新售后订单
	 */
	public Map<String, Object> queryReturnRefundOrderByOrderProductId(Long orderProductId) {
		try {
			ReturnRefundOrderVo returnRefundOrderVo = new ReturnRefundOrderVo();
			returnRefundOrderVo.setOrderProductId(orderProductId.toString());
			returnRefundOrderVo.setIsDelete(SUConstants.IS_NOT_DELETE);
			List<ReturnRefundOrderVo> returnRefundOrderVos = new ArrayList<ReturnRefundOrderVo>();
			List<ReturnRefundOrderVo> resReturnRefundOrderVos = new ArrayList<ReturnRefundOrderVo>();
			returnRefundOrderVos = returnRefundOrderDao.quertReturnRefundForList(returnRefundOrderVo);
			if(returnRefundOrderVos != null && returnRefundOrderVos.size() > 0){
				OrderProductAuto orderProductAuto = orderProductDao.selectByPrimaryKey((long)Integer.parseInt(returnRefundOrderVos.get(0).getOrderProductId()));
				returnRefundOrderVos.get(0).getOrderProducts().add(orderProductAuto);
				resReturnRefundOrderVos.add(returnRefundOrderVos.get(0));
			}
			
			return CommonResponseUtils.successResponse(resReturnRefundOrderVos);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	/**
	 * 校验传入参数及订单信息  是否满足退货、退款条件
	 * 满足条件更新订单表退货、退款次数
	 * @param returnRefundOrderAuto 退货、退款实体
	 * @param orderType 订单类型
	 * @param resMap
	 */
	public void checkParamAndOrderInfo(ReturnRefundOrderAuto returnRefundOrderAuto,
			Map<String, Object> resMap, String orderType) throws Exception{
		//查询当前登录用户信息
		UserBaseInfoAuto userBaseInfo = userDao.selectByPrimaryKey(returnRefundOrderAuto.getUserId());
		//校验当前用户权限
		if(userBaseInfo ==null || userBaseInfo.getUserTypeId() == null 
				||  SUConstants.USERTYPE_APP != userBaseInfo.getUserTypeId()){
			resMap.putAll(CommonResponseUtils.failureResponse("当前登录用户无此操作权限"));
		}
		
		//查询购买订单信息
		OrderAuto orderAuto = orderDao.selectByPrimaryKey(returnRefundOrderAuto.getOrderId());
		//设置退货退款订单店铺id
		returnRefundOrderAuto.setShopId(orderAuto.getShopId());
		if(orderAuto == null || orderAuto.getOrderId() == null){
			resMap.putAll(CommonResponseUtils.failureResponse("未查到当前订单信息，请确认"));
		}else if(orderAuto.getOrderStatus() == null){
			resMap.putAll(CommonResponseUtils.failureResponse("未查到当前订单状态，不能申请" + orderType));
		}else if(returnRefundOrderAuto.getReturnRefundType().intValue() == 1 &&
				orderAuto.getOrderStatus().intValue() != SUConstants.ORDER_STATUS_FOUR){//退货
			resMap.putAll(CommonResponseUtils.failureResponse("当前订单状态，不能申请" + orderType));
		}else if(returnRefundOrderAuto.getReturnRefundType().intValue() == 2 
				&& (orderAuto.getOrderStatus().intValue() < SUConstants.ORDER_STATUS_TWO
				|| orderAuto.getOrderStatus().intValue() > SUConstants.ORDER_STATUS_FOUR)){//退款
			resMap.putAll(CommonResponseUtils.failureResponse("当前订单状态，不能申请" + orderType));
		}else{
			orderAuto.setReturnRefundCount(orderAuto.getReturnRefundCount()==null?0:orderAuto.getReturnRefundCount() + 1);
			int i = orderDao.updateByPrimaryKeySelective(orderAuto);
			if(i <= 0){
				logger.info(orderType + "失败，更新订单状态失败");
				throw new MyException(orderType + "失败，更新订单状态失败");
			}
		}
	}
	
	/**
	 * 新增退货、退款状态信息
	 * @param returnRefundStatus 退货、退款状态实体
	 * @param returnRefundOrder 退货、退款订单实体
	 * @throws Exception
	 */
	public void addReturnRefundStatus(ReturnRefundStatusAuto returnRefundStatus,
			ReturnRefundOrderAuto returnRefundOrder, String orderType) throws Exception{
		//新增退货、退款状态信息
		returnRefundStatus.setReturnRefundOrderId(returnRefundOrder.getReturnRefundOrderId());
		int i = returnRefundStatusDao.insert(returnRefundStatus);
		if(i <= 0){
			throw new MyException("新增" + orderType + "订单状态信息失败：数据库生成" + orderType + "订单状态信息失败，执行insert返回影响行i为：" + i);
		}
	}
	
	/**
	 * 新增退货、退款图片信息
	 * @param returnRefundOrderAuto 退货、退款实体
	 * @param pics 吐火、退款图片数组
	 * @throws Exception
	 */
	public void addReturnOrderPic(ReturnRefundOrderAuto returnRefundOrderAuto,
			String[] pics, String orderType) throws Exception{
		//新增退货、退款图片信息
		for (String pic : pics) {
			ReturnRefundOrderPicAuto returnRefundOrderPic = new ReturnRefundOrderPicAuto();
			returnRefundOrderPic.setCreateTime(returnRefundOrderAuto.getCreateTime());
			returnRefundOrderPic.setCreateUser(returnRefundOrderAuto.getUserId());
			returnRefundOrderPic.setIsDelete(SUConstants.IS_NOT_DELETE);
			returnRefundOrderPic.setModifyTime(returnRefundOrderAuto.getCreateTime());
			returnRefundOrderPic.setMofifyUser(returnRefundOrderAuto.getUserId());
			returnRefundOrderPic.setPic(pic);
			returnRefundOrderPic.setReturnRefundOrderId(returnRefundOrderAuto.getReturnRefundOrderId());
			
			int i = returnRefundOrderPicDao.insert(returnRefundOrderPic);
			if(i <= 0){
				logger.info("=========>>>>>>维护" + orderType + "图片关系失败，insert返回影响行i为"+ i);
				throw new MyException("提交" + orderType + "订单失败：保存" + orderType + "图片信息失败");
			}
		}
	}

	
	/**
	 * 更新订单商品状态
	 * @param orderProductId 订单商品id
	 * @param orderId 订单id
	 * @param returnRefundStatus 退货退款订单状态
	 * @param busiType 业务
	 * @throws Exception
	 */
	public void checkAndUpdateOrderProductStatus(ReturnRefundOrderAuto returnRefundOrderAuto,
			String busiType) throws Exception{
		
		ReturnRefundOrderAutoExample returnRefundOrderAutoExample = new ReturnRefundOrderAutoExample();
		returnRefundOrderAutoExample.createCriteria().andOrderProductIdEqualTo(returnRefundOrderAuto.getOrderProductId());
		List<ReturnRefundOrderAuto> returnRefundOrders = returnRefundOrderDao.selectByExample(returnRefundOrderAutoExample);
		OrderProductAuto orderProduct = new OrderProductAuto();
		orderProduct.setOrderProductId(returnRefundOrderAuto.getOrderProductId());
		if(returnRefundOrders != null && returnRefundOrders.size() == 2){
			if(returnRefundOrderAuto.getReturnRefundType().intValue() == 1){
				orderProduct.setReturnRefundStatus(returnRefundOrderAuto.getReturnRefundLatestStatus()+30);//第二次退货
			}else{
				orderProduct.setReturnRefundStatus(returnRefundOrderAuto.getReturnRefundLatestStatus()+40);//第二次退款
			}
			boolean updateOrderFlag = false;
			for (ReturnRefundOrderAuto tempReturnRefundOrderAuto : returnRefundOrders) {
				if(returnRefundOrderAuto.getReturnRefundOrderId().longValue() == tempReturnRefundOrderAuto.getReturnRefundOrderId().longValue()
						&& returnRefundOrderAuto.getReturnRefundLatestStatus().intValue() != SUConstants.RETURN_REFUND_ORDER_STATUS_SIX){
					
					updateOrderFlag = false;
					break;
				}
				updateOrderFlag = true;
			}
			if(updateOrderFlag){
				checkAndUpdateOrderStatus(returnRefundOrderAuto.getOrderId(), busiType, 
						returnRefundOrderAuto.getOrderProductId(), returnRefundOrderAuto.getReturnRefundLatestStatus());
			}
			
		}else if(returnRefundOrders.size() == 1){
			if(returnRefundOrderAuto.getReturnRefundType().intValue() == 1){
				orderProduct.setReturnRefundStatus(returnRefundOrderAuto.getReturnRefundLatestStatus()+10);//第一次退货
			}else{
				orderProduct.setReturnRefundStatus(returnRefundOrderAuto.getReturnRefundLatestStatus()+20);//第一次退款
			}
			if(returnRefundOrderAuto.getReturnRefundLatestStatus().intValue() == SUConstants.RETURN_REFUND_ORDER_STATUS_SIX){
				checkAndUpdateOrderStatus(returnRefundOrderAuto.getOrderId(), busiType, 
						returnRefundOrderAuto.getOrderProductId(), returnRefundOrderAuto.getReturnRefundLatestStatus());	
			}
		}else{
			throw new MyException("未查到当前退货退款订单");
		}
		int i = orderProductDao.updateByPrimaryKeySelective(orderProduct);
		if(i <= 0){
			logger.info("=========>>>>>>"+busiType+"失败,更新订单商品状态失败：update返回i为：" + i);
			throw new MyException(busiType+"失败,更新订单商品状态失败");
		}
		
	}
	
	
	/**
	 * 更新订单状态
	 * @param orderId 订单id
	 * @param busiType 业务
	 * @throws Exception
	 */
	public void checkAndUpdateOrderStatus(Long orderId, 
			String busiType, Long orderProductId, Integer returnRefundStatus) throws Exception{
		OrderProductAuto orderProductAuto = new OrderProductAuto();
		orderProductAuto.setOrderId(orderId);
		List<OrderProductAuto> orderProductAutos = orderProductDao.selectForList(orderProductAuto);
		int orderStatus = -1;
		if(orderProductAutos.size() == 1){
			orderStatus = SUConstants.ORDER_STATUS_FIVE;
		}else if(orderProductAutos.size() > 1){
			for (OrderProductAuto tempOrderProductAuto : orderProductAutos) {
				if((orderProductId.longValue() != tempOrderProductAuto.getOrderProductId().longValue()
						&& tempOrderProductAuto.getReturnRefundStatus().intValue()%10 != SUConstants.RETURN_REFUND_ORDER_STATUS_SIX)
					|| (orderProductId.longValue() == tempOrderProductAuto.getOrderProductId().longValue()
							&& returnRefundStatus.intValue()%10 != SUConstants.RETURN_REFUND_ORDER_STATUS_SIX)){
					orderStatus = -1;
					break;
				}
				orderStatus = SUConstants.ORDER_STATUS_FIVE;
			}
		}else{
			throw new MyException("订单商品数据异常");
		}
		
		if(orderStatus == SUConstants.ORDER_STATUS_FIVE){
			OrderAuto orderAuto = new OrderAuto();
			orderAuto.setOrderStatus(orderStatus);
			orderAuto.setOrderId(orderId);
			orderAuto.setModifyTime(TmDateUtil.getTimeStamp());
			int i = orderDao.updateByPrimaryKeySelective(orderAuto);
			if(i <= 0){
				logger.info("=========>>>>>>"+busiType+"失败,更新订单状态失败：update返回i为：" + i);
				throw new MyException(busiType+"失败,更新订单状态失败");
			}
		}
		
	}
	
	
	
	
	/**
	 * 查询退货订单列表
	 * 1:App查询，2：商家查询，3：平台查询
	 */
	public Map<String, Object> queryRefundOrderList(ReturnRefundOrderVo returnRefundOrderVo, 
			int type, String returnRefundType) throws Exception {
		
		if(returnRefundOrderVo.getPageCount() == null){
			returnRefundOrderVo.setPageCount(SUConstants.PAGE_COUNT);
		}
		
		if(returnRefundOrderVo.getPageNo() != null){
			returnRefundOrderVo.setPageNo((returnRefundOrderVo.getPageNo()-1)*returnRefundOrderVo.getPageCount());
		}else{
			returnRefundOrderVo.setPageNo(0);
		}
		
		if(type == 2 || type == 3){
			returnRefundOrderVo.setTotalPageCount(returnRefundOrderDao.quertReturnRefundForListCount(returnRefundOrderVo));
			List<ReturnRefundOrderVo> returnRefundOrderVos = new ArrayList<ReturnRefundOrderVo>();
			Map<String, Object> resMap = new HashMap<String, Object>();
			if(returnRefundOrderVo.getTotalPageCount() > 0){
				returnRefundOrderVos = returnRefundOrderDao.quertReturnRefundForList(returnRefundOrderVo);
				for (int i = 0; i < returnRefundOrderVos.size(); i++) {
					OrderProductAuto orderProductAuto = orderProductDao.selectByPrimaryKey((long)Integer.parseInt(returnRefundOrderVos.get(i).getOrderProductId()));
					returnRefundOrderVos.get(i).getOrderProducts().add(orderProductAuto);
				}
				resMap.put("totalPageCount", returnRefundOrderVo.getTotalPageCount());
				resMap.put("returnRefundOrderVos", returnRefundOrderVos);
			}else{
				resMap.put("totalPageCount", returnRefundOrderVo.getTotalPageCount());
				resMap.put("returnRefundOrderVos", returnRefundOrderVos);
			}
			return CommonResponseUtils.successResponse(resMap);
		}else{
			List<ReturnRefundOrderVo> returnRefundOrderVos = returnRefundOrderDao.quertReturnRefundForList(returnRefundOrderVo);
			for (int i = 0; i < returnRefundOrderVos.size(); i++) {
				OrderProductAuto orderProductAuto = orderProductDao.selectByPrimaryKey((long)Integer.parseInt(returnRefundOrderVos.get(i).getOrderProductId()));
				returnRefundOrderVos.get(i).getOrderProducts().add(orderProductAuto);
			}
			return CommonResponseUtils.successResponse(returnRefundOrderVos);
		}
			
	}

	
	/**
	 * 更新退款退货订单信息
	 */
	public Map<String, Object> updateRefundOrder(ReturnRefundOrderAuto returnRefundOrderAuto, 
			String busiType, Long pushUserId, String returnRefundOrderNumber) throws Exception {
		
		checkAndUpdateOrderProductStatus(returnRefundOrderAuto, busiType);
		int i = returnRefundOrderDao.updateByPrimaryKeySelective(returnRefundOrderAuto);
		if(i <= 0){
			logger.info("=========>>>>>>更新退货退款订单状态失败：update返回i为：" + i);
			throw new MyException("更新退货退款订单状态失败");
		}
		ReturnRefundStatusAuto returnRefundStatusAuto = new ReturnRefundStatusAuto();
		returnRefundStatusAuto.setCreateTime(returnRefundOrderAuto.getModifyTime());
		returnRefundStatusAuto.setModifyTime(returnRefundOrderAuto.getModifyTime());
		returnRefundStatusAuto.setCreateUser(returnRefundOrderAuto.getMofifyUser());
		returnRefundStatusAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
		returnRefundStatusAuto.setMofifyUser(returnRefundOrderAuto.getMofifyUser());
		returnRefundStatusAuto.setOperator(returnRefundOrderAuto.getMofifyUser().intValue());
		returnRefundStatusAuto.setReturnRefundOrderId(returnRefundOrderAuto.getReturnRefundOrderId());
		returnRefundStatusAuto.setReturnRefundStatusItemId(returnRefundOrderAuto.getReturnRefundLatestStatus());
		returnRefundStatusAuto.setReturnRefundStatusTime(returnRefundOrderAuto.getModifyTime());
		
		i = returnRefundStatusDao.insert(returnRefundStatusAuto);
		if(i <= 0){
			logger.info("=========>>>>>>新增退货退款订单状态失败：update返回i为：" + i);
			throw new MyException("更新退货退款订单状态失败");
		}
		if((returnRefundOrderAuto.getReturnRefundType().intValue() == 1
				&& (returnRefundOrderAuto.getReturnRefundLatestStatus().intValue() == SUConstants.RETURN_REFUND_ORDER_STATUS_SERVEN
				|| returnRefundOrderAuto.getReturnRefundLatestStatus().intValue() == SUConstants.RETURN_REFUND_ORDER_STATUS_TWO
				|| returnRefundOrderAuto.getReturnRefundLatestStatus().intValue() == SUConstants.RETURN_REFUND_ORDER_STATUS_THREE
				|| returnRefundOrderAuto.getReturnRefundLatestStatus().intValue() == SUConstants.RETURN_REFUND_ORDER_STATUS_NINE
				|| returnRefundOrderAuto.getReturnRefundLatestStatus().intValue() == SUConstants.RETURN_REFUND_ORDER_STATUS_FIVE
				|| returnRefundOrderAuto.getReturnRefundLatestStatus().intValue() == SUConstants.RETURN_REFUND_ORDER_STATUS_SIX))
			||(returnRefundOrderAuto.getReturnRefundType().intValue() == 2
					&& (returnRefundOrderAuto.getReturnRefundLatestStatus().intValue() == SUConstants.RETURN_REFUND_ORDER_STATUS_THREE
					|| returnRefundOrderAuto.getReturnRefundLatestStatus().intValue() == SUConstants.RETURN_REFUND_ORDER_STATUS_TWO
					|| returnRefundOrderAuto.getReturnRefundLatestStatus().intValue() == SUConstants.RETURN_REFUND_ORDER_STATUS_FIVE
					|| returnRefundOrderAuto.getReturnRefundLatestStatus().intValue() == SUConstants.RETURN_REFUND_ORDER_STATUS_SIX))){
			orderService.pushOrderMessage(pushUserId, returnRefundOrderAuto.getReturnRefundOrderId().toString(),  9, 
					returnRefundOrderAuto.getReturnRefundLatestStatus().toString(), 
					"您的退款单号为："+returnRefundOrderNumber+"的"+busiType+"单,"+SUConstants.RETURN_REFUND_ORDER_STATUS_MAP.get(returnRefundOrderAuto.getReturnRefundLatestStatus()));
		}
		return CommonResponseUtils.successResponse(busiType+"成功");
	}
}
