package com.essential.bussiness.order.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.bussiness.order.dao.OrderAutoMapper;
import com.essential.bussiness.order.dao.OrderProductAutoMapper;
import com.essential.bussiness.order.dao.OrderStatusAutoMapper;
import com.essential.bussiness.order.model.auto.OrderProductAuto;
import com.essential.bussiness.order.model.vo.OrderCommentVo;
import com.essential.bussiness.order.model.vo.OrderProductVo;
import com.essential.bussiness.order.model.vo.QueryOrderCommentVo;
import com.essential.bussiness.order.model.vo.SearchOrderVo;
import com.essential.bussiness.order.service.IQueryOrderService;
import com.essential.bussiness.product.dao.ProductCommentAutoMapper;
import com.essential.bussiness.product.model.auto.ProductCommentAuto;
import com.essential.common.constants.SUConstants;
import com.essential.user.dao.UserBaseInfoAutoMapper;
import com.essential.user.model.auto.UserBaseInfoAuto;
import com.essential.utils.CommonResponseUtils;

/**
 * 查询订单service
 * @author essential-gfs
 *
 */
@Service
public class QueryOrderServiceImpl implements IQueryOrderService {

	private Logger logger = LoggerFactory.getLogger(QueryOrderServiceImpl.class);
	
	//装配订单dao
	@Autowired
	OrderAutoMapper orderDao;
	//装配订单商品dao
	@Autowired
	OrderProductAutoMapper orderProductDao;
	//装配订单状态dao
	@Autowired
	OrderStatusAutoMapper orderStatusDao;
	//注入用户基础信息dao
	@Autowired
	UserBaseInfoAutoMapper userDao;
	//查询评价dao
	@Autowired
	ProductCommentAutoMapper productCommentAutoDao;
	
	/**
	 * 查询全部订单
	 * type 1:App 通过userId 查询  2：商家通过shopId查询  3：平台通过shopId查询
	 */
	@Override
	public Map<String, Object> queryOrderForList(OrderProductVo orderProductVo, 
			String productName, int type, Long loginUserId) {
		
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
				orderProductVo.setShopId(userBaseInfo.getShopId());
				if(orderProductVo.getShopId() == null){
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
				orderProductVo.setShopId(null);
			}else{
				return CommonResponseUtils.failureResponse("参数异常");
			}
			
			return queryOrderList(orderProductVo, productName, type);
		} catch (Exception e) {
			logger.info("查询订单失败");
			throw new RuntimeException(e);
		}
	}

	
	/**
	 * 获取订单及商品信息
	 * @param orderProductVos 订单商品vo集合
	 * @param orderProductVo  订单商品vo
	 * @return 
	 * @throws Exception
	 */
	public List<OrderProductVo> buildOrderProductVos(OrderProductVo orderProductVo, String productName, int type) throws Exception{
		
		List<OrderProductVo> orderProductVos = new ArrayList<OrderProductVo>();
		List<OrderProductVo> resOrderProductVos = new ArrayList<OrderProductVo>();
		if(type == 2 || type == 3){
			orderProductVo.setTotalPageCount(orderDao.selectOrderForListCount(orderProductVo));
			if(orderProductVo.getTotalPageCount() > 0){
				if(orderProductVo.getPageNo() != null){
					if(orderProductVo.getPageCount() == null){
						orderProductVo.setPageCount(SUConstants.PAGE_COUNT);
					}
					orderProductVo.setPageNo((orderProductVo.getPageNo()-1)*orderProductVo.getPageCount());
				}
				
				orderProductVos = orderDao.selectOrderForList(orderProductVo);
				
				for (int i = 0; i < orderProductVos.size(); i++) {
					OrderProductAuto orderProduct = new OrderProductAuto();
					orderProduct.setProductName(productName);
					orderProduct.setOrderId(orderProductVos.get(i).getOrderId());
					List<OrderProductAuto> orderProducts = orderProductDao.selectForList(orderProduct);
					orderProductVos.get(i).setOrderProducts(orderProducts);
					resOrderProductVos.add(orderProductVos.get(i));
				}
			}
			
		}else{
			if(orderProductVo.getPageNo() != null){
				if(orderProductVo.getPageCount() == null){
					orderProductVo.setPageCount(SUConstants.PAGE_COUNT);
				}
				orderProductVo.setPageNo((orderProductVo.getPageNo()-1)*orderProductVo.getPageCount());
			}
			if(StringUtils.isEmpty(productName)){
				productName = null;
			}
			orderProductVos = orderDao.selectOrderForList(orderProductVo);
			
			for (int i = 0; i < orderProductVos.size(); i++) {
				orderProductVos.get(i).setOrderProducts(null);
				OrderProductAuto orderProduct = new OrderProductAuto();
				orderProduct.setOrderId(orderProductVos.get(i).getOrderId());
				orderProduct.setProductName(productName);
				List<OrderProductAuto> orderProducts = orderProductDao.selectForList(orderProduct);
				if(orderProducts != null && orderProducts.size() > 0){
					orderProductVos.get(i).setOrderProducts(orderProducts);
					resOrderProductVos.add(orderProductVos.get(i));
				}
			}
		}
		return resOrderProductVos;
	}
	
	
	/**
	 * 通过商品名搜索订单
	 */
	@Override
	public Map<String, Object> searchOrderByProductName(
			OrderProductAuto orderProductAuto) {
		
		try {
			List<SearchOrderVo> searchOrderVos = new ArrayList<SearchOrderVo>();
			searchOrderVos = orderProductDao.searchOrderByProductName(orderProductAuto);
			
			return CommonResponseUtils.successResponse(searchOrderVos);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	/**
	 * 查看订单评价
	 * @param productCommentAuto 商品评价实体
	 * @return
	 */
	@Override
	public Map<String, Object> queryOrderComment(ProductCommentAuto productCommentAuto){
		try {
			QueryOrderCommentVo queryOrderCommentVo = orderDao.queryOrderShopInfo(productCommentAuto.getOrderId());
			
			if(queryOrderCommentVo == null){
				return CommonResponseUtils.failureResponse("未查到当前订单信息");
			}
			
			List<OrderCommentVo> orderCommentVos = productCommentAutoDao.queryOrderCommentForList(productCommentAuto);
			
			if(orderCommentVos == null || orderCommentVos.size() <= 0){
				return CommonResponseUtils.failureResponse("未查到当前订单评价信息");
			}
			queryOrderCommentVo.setOrderId(productCommentAuto.getOrderId());
			
			queryOrderCommentVo.setOrderCommentVos(orderCommentVos);
			
			return CommonResponseUtils.successResponse(queryOrderCommentVo);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	
	/**
	 * 我的订单每个标签页的订单数量
	 */
	@Override
	public Map<String, Object> queryMyOrderNumberPerLabelCount(Long userId) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		try {
			//我的订单每个标签页的订单数量
			List<HashMap<String, Integer>> myOrderNumberPerLabelCounts = orderDao.queryMyOrderNumberPerLabelCount(userId);
			if(myOrderNumberPerLabelCounts != null && myOrderNumberPerLabelCounts.size() == 2){
				resMap.put("totalOrderCount", myOrderNumberPerLabelCounts.get(0).get("totalCount"));
				resMap.put("pendingPaymentCount", myOrderNumberPerLabelCounts.get(0).get("pendingPaymentCount"));
				resMap.put("waitReciveGoodsCount", myOrderNumberPerLabelCounts.get(0).get("waitReciveGoodsCount"));
				resMap.put("waitEvaluateCount", myOrderNumberPerLabelCounts.get(0).get("waitEvaluateCount"));
				resMap.put("totalReturnRefundOrderCount", myOrderNumberPerLabelCounts.get(1).get("totalCount"));
				
				return CommonResponseUtils.successResponse(resMap);
			}else{
				return CommonResponseUtils.failureResponse("查询订单数量失败");
			}
		} catch (Exception e) {
			logger.info("=========>>>>>>查询订单数量异常");
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * 查询全部订单
	 * type 1:App 通过userId 查询  2：商家通过shopId查询  3：平台通过shopId查询
	 */
	public Map<String, Object> queryOrderList(OrderProductVo orderProductVo, 
			String productName, int type) throws Exception {
		
		List<OrderProductVo> orderProductVos = new ArrayList<OrderProductVo>();
		
		orderProductVos = buildOrderProductVos(orderProductVo, productName, type);
		if(type == 2 || type == 3){
			Map<String, Object> resMap = new HashMap<String, Object>();
			resMap.put("totalPageCount", orderProductVo.getTotalPageCount());
			resMap.put("orderProductVos", orderProductVos);
			return CommonResponseUtils.successResponse(resMap);
		}else{
			return CommonResponseUtils.successResponse(orderProductVos);
		}
			
	}
}
