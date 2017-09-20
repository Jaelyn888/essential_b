package com.essential.payment.model;

public class WeChatPayment {
//这些参数配置有id secret秘钥 合作商户id key都来源于微信支付的平台
	String AppId="wx106efe31792496c6";
	String AppSecret="87685f2ca9d54b2dceab8aad3450e989";
	String PaySignKey=null;
	String PartnerId="1376139002";
	String PartnerKey="yishangyishanxiunewversion123456";
	String NotifyUrl="WeiXinPayNotify.jsp";

	public String getAppId() {
		return AppId;
	}

	public void setAppId(String appId) {
		AppId = appId;
	}

	public String getAppSecret() {
		return AppSecret;
	}

	public void setAppSecret(String appSecret) {
		AppSecret = appSecret;
	}

	public String getPaySignKey() {
		return PaySignKey;
	}

	public void setPaySignKey(String paySignKey) {
		PaySignKey = paySignKey;
	}

	public String getPartnerId() {
		return PartnerId;
	}

	public void setPartnerId(String partnerId) {
		PartnerId = partnerId;
	}

	public String getPartnerKey() {
		return PartnerKey;
	}

	public void setPartnerKey(String partnerKey) {
		PartnerKey = partnerKey;
	}

	public String getNotifyUrl() {
		return NotifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		NotifyUrl = notifyUrl;
	}

	

}
