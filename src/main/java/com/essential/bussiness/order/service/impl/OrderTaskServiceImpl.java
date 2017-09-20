package com.essential.bussiness.order.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.bussiness.order.dao.OrderTaskMapper;
import com.essential.bussiness.order.model.vo.OrderTaskQueryOrderVo;
import com.essential.bussiness.order.model.vo.QueryOrderAccordingToTheConditionsVo;
import com.essential.bussiness.order.model.vo.QueryReturnRefundOrderAccordingToTheConditionsVo;
import com.essential.bussiness.order.model.vo.ReturnRefundOrderTaskQueryOrderVo;
import com.essential.bussiness.order.service.IOrderTaskService;
import com.essential.common.utils.MyException;

/**
 * 订单相关定时任务service实现类
 * @author essential-gfs
 *
 */
@Service
public class OrderTaskServiceImpl implements IOrderTaskService {
	private static final Logger logger = LoggerFactory.getLogger(OrderTaskServiceImpl.class);
	
	//注入订单定时任务dao
	@Autowired
	OrderTaskMapper orderTaskDao;

	/**
	 * 未支付 超过72小时取消订单
	 */
	@Override
	public boolean canleOrderWhereMoreThanSeventyTwoHour() {
		try {
			// 查询  未支付 超过72小时的订单
			OrderTaskQueryOrderVo orderTaskQueryOrderVo = new OrderTaskQueryOrderVo();
			orderTaskQueryOrderVo.setQueryField("create_time");
			orderTaskQueryOrderVo.setQueryOrderStatus1(1);
			orderTaskQueryOrderVo.setSubDateTime(3600);
			orderTaskQueryOrderVo.setLimitDateTime(72);
			orderTaskQueryOrderVo.setUpdateOrderStatus1(0);
			
			List<OrderTaskQueryOrderVo> orderTaskQueryOrderVoList = orderTaskDao.selectOrderAccordingToTheConditions(orderTaskQueryOrderVo);
			if(orderTaskQueryOrderVoList == null || orderTaskQueryOrderVoList.size() <= 0){
				return true;
			}
			QueryOrderAccordingToTheConditionsVo moreThanSeventyTwoHourOrderVo = new QueryOrderAccordingToTheConditionsVo();
			moreThanSeventyTwoHourOrderVo.setOrderTaskQueryOrderVos(orderTaskQueryOrderVoList);
			// 恢复订单Sku商品的库存 未支付 超过72小时取消订单
			int i = orderTaskDao.updateOrderToAddProductCountWhereMoreThanSeventyTwoHour(moreThanSeventyTwoHourOrderVo);
			if(i <= 0){
				logger.info("=========>>>>>>更新Sku商品库存失败，未查到订单商品的信息或执行update异常，返回i值为:"+i);
				throw new MyException();
			}
			// 恢复订单Spu商品的库存 未支付 超过72小时取消订单
			i = orderTaskDao.updateProductCountWhereMoreThanSeventyTwoHour(moreThanSeventyTwoHourOrderVo);
			if(i <= 0){
				logger.info("=========>>>>>>更新Spu商品库存失败，未查到订单商品的信息或执行update异常，返回i值为:"+i);
				throw new MyException();
			}
			// 更新订单状态 未支付 超过72小时取消订单
			i = 0;
			i = orderTaskDao.updateOrderToCancleStatusWhereMoreThanSeventyTwoHour(moreThanSeventyTwoHourOrderVo);
			if(i <= 0){
				logger.info("=========>>>>>>更新订单状态为取消状态失败，未查到订单信息或执行update异常，返回i值为:"+i);
				throw new MyException();
			}
			// 新增订单状态改变记录
			i = 0;
			i = orderTaskDao.insertOrderStatus(moreThanSeventyTwoHourOrderVo);
			if(i <= 0){
				logger.info("=========>>>>>>新增订单状态改变记录失败，执行insert异常，返回i值为:"+i);
				throw new MyException();
			}
		} catch (MyException me) {
			throw me;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return true;
	}

	/**
	 * 商家发货之后10天 自动确认收货 订单完成
	 */
	@Override
	public boolean completeOrderWhereMoreThanTenDay() {
		try {
			// 查询 商家发货之后10天 未自动确认收货订单
			OrderTaskQueryOrderVo orderTaskQueryOrderVo = new OrderTaskQueryOrderVo();
			orderTaskQueryOrderVo.setQueryField("modify_time");
			orderTaskQueryOrderVo.setQueryOrderStatus1(3);
			orderTaskQueryOrderVo.setSubDateTime(86400);
			orderTaskQueryOrderVo.setLimitDateTime(10);
			orderTaskQueryOrderVo.setUpdateOrderStatus1(4);
			
			List<OrderTaskQueryOrderVo> orderTaskQueryOrderVoList = orderTaskDao.selectOrderAccordingToTheConditions(orderTaskQueryOrderVo);
			if(orderTaskQueryOrderVoList == null || orderTaskQueryOrderVoList.size() <= 0){
				return true;
			}
			QueryOrderAccordingToTheConditionsVo moreThanSeventyTwoHourOrderVo = new QueryOrderAccordingToTheConditionsVo();
			moreThanSeventyTwoHourOrderVo.setOrderTaskQueryOrderVos(orderTaskQueryOrderVoList);
			// 商家发货之后10天 自动确认收货 订单完成
			int i = orderTaskDao.updateOrderToCompleteStatusWhereMoreThanTenDay(moreThanSeventyTwoHourOrderVo);
			if(i <= 0){
				logger.info("=========>>>>>>更新订单状态为订单完成失败，未查到订单信息或执行update异常，返回i值为:"+i);
				throw new MyException();
			}
			// 新增订单状态改变记录
			i = 0;
			i = orderTaskDao.insertOrderStatus(moreThanSeventyTwoHourOrderVo);
			if(i <= 0){
				logger.info("=========>>>>>>新增订单状态改变记录失败，执行insert异常，返回i值为:"+i);
				throw new MyException();
			}
		} catch (MyException me) {
			throw me;
		}  catch (Exception e) {
			throw new RuntimeException(e);
		}
		return true;
	}

	/**
	 * 买家确认收货 之后15天 不可售后
	 */
	@Override
	public boolean cannotAfterSaleWhereMoreThanTentyFiveDay() {
		try {
			// 查询 买家确认收货 之后15天 的订单
			OrderTaskQueryOrderVo orderTaskQueryOrderVo = new OrderTaskQueryOrderVo();
			orderTaskQueryOrderVo.setQueryField("modify_time");
			orderTaskQueryOrderVo.setQueryOrderStatus1(4);
			orderTaskQueryOrderVo.setSubDateTime(86400);
			orderTaskQueryOrderVo.setLimitDateTime(15);
			orderTaskQueryOrderVo.setUpdateOrderStatus1(999);
			
			List<OrderTaskQueryOrderVo> orderTaskQueryOrderVoList = orderTaskDao.selectOrderAccordingToTheConditions(orderTaskQueryOrderVo);
			if(orderTaskQueryOrderVoList == null || orderTaskQueryOrderVoList.size() <= 0){
				return true;
			}
			QueryOrderAccordingToTheConditionsVo moreThanSeventyTwoHourOrderVo = new QueryOrderAccordingToTheConditionsVo();
			moreThanSeventyTwoHourOrderVo.setOrderTaskQueryOrderVos(orderTaskQueryOrderVoList);
			
			// 查询买家确认收货 之后15天 不可售后
			Long[] orderProductIds = orderTaskDao.selectOrderProductToCannotAfterSaleWhereMoreThanTentyFiveDay(moreThanSeventyTwoHourOrderVo);
			if(orderProductIds == null || orderProductIds.length <= 0){
				return true;
			}
			
			// 更新买家确认收货 之后15天 不可售后
			int i = orderTaskDao.updateOrderProductToCannotAfterSaleWhereMoreThanTentyFiveDay(moreThanSeventyTwoHourOrderVo);
			if(i <= 0){
				logger.info("=========>>>>>>更新订单状态商品状态为不可售后失败，未查到订单商品的信息或执行update异常，返回i值为:"+i);
				throw new MyException();
			}
			
		} catch (MyException me) {
			throw me;
		}  catch (Exception e) {
			throw new RuntimeException(e);
		}
		return true;
	}
	
	
	/**
	 * 需要商家处理的动作超过10天 自动同意 
	 */
	@Override
	public boolean agreeWhereBusinessNoCheckThanTenDay() {
		try {
			// 查询 需要商家处理的动作超过10天
			ReturnRefundOrderTaskQueryOrderVo returnRefundOrderTaskQueryOrderVo = new ReturnRefundOrderTaskQueryOrderVo();
			returnRefundOrderTaskQueryOrderVo.setQueryField("modify_time");
			returnRefundOrderTaskQueryOrderVo.setQueryReturnRefundOrderStatus1(1);
			returnRefundOrderTaskQueryOrderVo.setQueryReturnRefundOrderStatus2(8);
			returnRefundOrderTaskQueryOrderVo.setSubDateTime(86400);
			returnRefundOrderTaskQueryOrderVo.setLimitDateTime(10);
			
			List<ReturnRefundOrderTaskQueryOrderVo> returnRefundOrderTaskQueryOrderVoList = orderTaskDao.selectReturnRefundOrderAccordingToTheConditions(returnRefundOrderTaskQueryOrderVo);
			if(returnRefundOrderTaskQueryOrderVoList == null || returnRefundOrderTaskQueryOrderVoList.size() <= 0){
				return true;
			}
			
			QueryReturnRefundOrderAccordingToTheConditionsVo queryReturnRefundOrderAccordingToTheConditionsVo = new QueryReturnRefundOrderAccordingToTheConditionsVo();
			queryReturnRefundOrderAccordingToTheConditionsVo.setReturnRefundOrderTaskQueryOrderVos(returnRefundOrderTaskQueryOrderVoList);
			
			// 需要商家处理的动作超过10天 自动同意 
			int i = orderTaskDao.updateAgreeWhereBusinessNoCheckThanTenDay(queryReturnRefundOrderAccordingToTheConditionsVo);
			if(i <= 0){
				logger.info("=========>>>>>>更新退货退款订单商家审核状态为下一通过状态失败，未查到退货退款订单信息或执行update异常，返回i值为:"+i);
				throw new MyException();
			}
			
			// 更新需要商家处理的动作超过10天的退货退款订单商品的退货退款状态
			i = 0;
			i = orderTaskDao.updateOrderProductReturnRefundStatus(queryReturnRefundOrderAccordingToTheConditionsVo);
			// 新增退货退款订单状态改变记录
			if(i <= 0){
				logger.info("=========>>>>>>更新退货退款订单商品退货退款状态失败，执行update异常，返回i值为:"+i);
				throw new MyException();
			}
			
			i = 0;
			i = orderTaskDao.insertReturnRefundOrderStatus(queryReturnRefundOrderAccordingToTheConditionsVo);
			if(i <= 0){
				logger.info("=========>>>>>>新增退货退款订单状态改变记录失败，执行insert异常，返回i值为:"+i);
				throw new MyException();
			}
		} catch (MyException me) {
			throw me;
		}  catch (Exception e) {
			throw new RuntimeException(e);
		}
		return true;
	}
}
