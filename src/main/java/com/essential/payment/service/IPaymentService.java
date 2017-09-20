package com.essential.payment.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.payment.model.AlipayProcedureAuto;
import com.essential.payment.model.UnionpayProcedureAuto;
import com.essential.payment.model.WechatProcedureAuto;
@Service
public interface IPaymentService {

	// 用支付宝支付
	public Map<String, Object> aliPayment();
	
	// 插入到支付宝表的支付宝回调的信息
	public  boolean insertAlipayInfo(AlipayProcedureAuto alipayProcedureAuto );
	// 查询信息通过trade_no的问题
	public boolean  queryAlipayInfo(AlipayProcedureAuto alipayProcedureAuto);

	// 用微信支付
    public Map<String, Object> WeChatPayment();
    
  //得到微信的预支付单号
  	public Map<String, Object> queryWeChatPreNumber(String orderNum, String totalFee,String createIp,String orderId);
  	//查询微信的info
  	public boolean queryWechatInfo(WechatProcedureAuto wechatProcedureAuto);
  	//插入微信的info
  	public boolean  insertWechatInfo(WechatProcedureAuto wechatProcedureAuto);
  	//得到银联预支付单号
  	public Map<String,Object>queryUnionPay(String orderNum,String amount,String orderId);
  	//查询银联是否存在此条订单
  	public boolean  queryUnionOrderId(UnionpayProcedureAuto unionpayProcedureAuto);
  	//插入银联的info
  	public boolean insertUnionPay(UnionpayProcedureAuto unionpayProcedureAuto);
  	
    //获取支付宝参数加密过程
  	public Map<String,Object>obtainAlipaySign(String orderId,String orderNum);
    
  	//更新订单支付状态
  	public Map<String,Object> updateOrderPay(String orderId,String queryId);

}
