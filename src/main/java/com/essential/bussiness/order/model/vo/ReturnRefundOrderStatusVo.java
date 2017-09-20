package com.essential.bussiness.order.model.vo;

import java.math.BigDecimal;

public class ReturnRefundOrderStatusVo {
	
	// 退货退款订单当前状态时间
	private String returnRefundStatusTime;
	// 退货退款状态id
	private Integer returnRefundStatusItemId;
	// 退款总金额
	private BigDecimal refundTotalMoney;
	// 买家备注/说明
	private String attr1;
	// 商家收货地址
	private String returnAddress;
	// 商家收货人
    private String contactPerson;
    // 商家收货人手机号
    private String phone;
	// 物流公司
	private String logistic;
	// 物流单号
	private String logisticNumber;
	//退货退款标识 1：退货，2：退款
	private Integer returnRefundType;
	//退货退款订单id
	private Long returnRefundOrderId;
	//驳回理由
	private String returnRefundRejectReason;

	public String getReturnRefundStatusTime() {
		return returnRefundStatusTime;
	}

	public void setReturnRefundStatusTime(String returnRefundStatusTime) {
		this.returnRefundStatusTime = returnRefundStatusTime;
	}

	public Integer getReturnRefundStatusItemId() {
		return returnRefundStatusItemId;
	}

	public void setReturnRefundStatusItemId(Integer returnRefundStatusItemId) {
		this.returnRefundStatusItemId = returnRefundStatusItemId;
	}

	public BigDecimal getRefundTotalMoney() {
		return refundTotalMoney;
	}

	public void setRefundTotalMoney(BigDecimal refundTotalMoney) {
		this.refundTotalMoney = refundTotalMoney;
	}

	public String getAttr1() {
		return attr1;
	}

	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}

	public String getLogistic() {
		return logistic;
	}

	public void setLogistic(String logistic) {
		this.logistic = logistic;
	}

	public String getLogisticNumber() {
		return logisticNumber;
	}

	public void setLogisticNumber(String logisticNumber) {
		this.logisticNumber = logisticNumber;
	}

	public Integer getReturnRefundType() {
		return returnRefundType;
	}

	public void setReturnRefundType(Integer returnRefundType) {
		this.returnRefundType = returnRefundType;
	}

	public Long getReturnRefundOrderId() {
		return returnRefundOrderId;
	}

	public void setReturnRefundOrderId(Long returnRefundOrderId) {
		this.returnRefundOrderId = returnRefundOrderId;
	}

	public String getReturnAddress() {
		return returnAddress;
	}

	public void setReturnAddress(String returnAddress) {
		this.returnAddress = returnAddress;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getReturnRefundRejectReason() {
		return returnRefundRejectReason;
	}

	public void setReturnRefundRejectReason(String returnRefundRejectReason) {
		this.returnRefundRejectReason = returnRefundRejectReason;
	}

}
