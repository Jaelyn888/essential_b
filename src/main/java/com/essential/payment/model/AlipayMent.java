package com.essential.payment.model;

public class AlipayMent {
	// 支付宝账号
	private String SellerAccount = "zhifubao@essential01.com";
	// 合作id
	private String PartnerId = "2088021233016325";
	// key
	private String PartnerKey = "915ent1plvl8i0qhdozqjlt1ds3o049p";
	// 加密方式
	private String SignType = "MD5";
	// 编码
	private String InputCharSet = "utf-8";
	// 网关
	private String Gateway = "https://mapi.alipay.com/gateway.do?";
	// 商户私钥
	private String PrivateKey = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBANcfCNPZO39kE4jOSLIc3skINZh+dSa+bKpWio1Oqhk3IE4r+j0bXH243bbJewJ3SkyWiT/WuxNKZdrCJ+Nhzg2+RJafNCKnPDh8IaMvK9zA0+ADfy1xZOAM6qif+32izkytZtcXi5ovjePMeJM4iwYk6tq+eyM2cnpA+h9QGp9BAgMBAAECgYBsaLxnHotoWIOrpuFluTzgrJ1t2xSo0MAsW255ZdI84NYL7wetsdM7nGVHT2QJSxqLXDWQkWM3hn+r7bpyUYCn6cfXYaSrb8KvQ7D7apTVz0ZgkAOszixJJ/0w2VePHEoWh2ZXV668JwOZfcY2v5pnEbpFJwK4byRGnXCTWtUFkQJBAPCkoh0QeG4zLXVS/1/pCN16cB404hkPZ/5sP4CbCpW82g+ePXuKgQwiaFfZOEknzCO5OMv+dhgQJ641EKfJ3q0CQQDk2XPXhM2CxZlx4X1zv37ZM5jJw4RrJzUBncX8aGQTq7Dg0zSqNjIHjlvfxx9sLG2KptESkgMOxIBmnAgUznllAkEAtUqCaz0GTZc2rwXZKItqR1i/cLJMh66onO82JBApuEcvTMbc8N6We+rMCyq1kb9utpcK5/wLQfOhwUdvBck6fQJBAMhFiLweC1+bH5rqs8f82LyqC9beVN8VM60TbrVigdo5EZTfIKKoxQWZzss6TkRzaPXC4Qq4XxaoXpntiKD0xIUCQQDwjuXWd792KHXPJxcSDFRZTszdYkzVOPzHisvzxh3oBPf2awnMNHpfl+CCEsUL0Q9D/t9rneOfp6RAoi/6sCvc";
	// 支付宝公钥
	/*private String AlipayPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn7UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";*/
	private String AlipayPublicKey =  "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";
	// 回调页面
	private String NotifyPage = "http://b.essential01.com.cn/essential/payment/aliPayNotifyjsp";

	public String getSellerAccount() {
		return SellerAccount;
	}

	public void setSellerAccount(String sellerAccount) {
		SellerAccount = sellerAccount;
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

	public String getSignType() {
		return SignType;
	}

	public void setSignType(String signType) {
		SignType = signType;
	}

	public String getInputCharSet() {
		return InputCharSet;
	}

	public void setInputCharSet(String inputCharSet) {
		InputCharSet = inputCharSet;
	}

	public String getGateway() {
		return Gateway;
	}

	public void setGateway(String gateway) {
		Gateway = gateway;
	}

	public String getPrivateKey() {
		return PrivateKey;
	}

	public void setPrivateKey(String privateKey) {
		PrivateKey = privateKey;
	}

	public String getAlipayPublicKey() {
		return AlipayPublicKey;
	}

	public void setAlipayPublicKey(String alipayPublicKey) {
		AlipayPublicKey = alipayPublicKey;
	}

	public String getNotifyPage() {
		return NotifyPage;
	}

	public void setNotifyPage(String notifyPage) {
		NotifyPage = notifyPage;
	}

}
