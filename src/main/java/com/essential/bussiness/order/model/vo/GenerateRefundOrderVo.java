package com.essential.bussiness.order.model.vo;

import java.math.BigDecimal;

public class GenerateRefundOrderVo extends ReturnRefundOrderVo {
	private String returnAddress;

    private String contactPerson;

    private String phone;
    
    private String returnRefundAttr3;

    private String returnRefundAttr4;

    private String returnRefundAttr5;

    private String returnRefundAttr6;
    
    private BigDecimal refundFinalMoney;
    
    private String refundUser;
    
    private String returnRefundModifyTime;
    
    private String refundAccount;

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

	public String getReturnRefundAttr3() {
		return returnRefundAttr3;
	}

	public void setReturnRefundAttr3(String returnRefundAttr3) {
		this.returnRefundAttr3 = returnRefundAttr3;
	}

	public String getReturnRefundAttr4() {
		return returnRefundAttr4;
	}

	public void setReturnRefundAttr4(String returnRefundAttr4) {
		this.returnRefundAttr4 = returnRefundAttr4;
	}

	public String getReturnRefundAttr5() {
		return returnRefundAttr5;
	}

	public void setReturnRefundAttr5(String returnRefundAttr5) {
		this.returnRefundAttr5 = returnRefundAttr5;
	}

	public String getReturnRefundAttr6() {
		return returnRefundAttr6;
	}

	public void setReturnRefundAttr6(String returnRefundAttr6) {
		this.returnRefundAttr6 = returnRefundAttr6;
	}

	public BigDecimal getRefundFinalMoney() {
		return refundFinalMoney;
	}

	public void setRefundFinalMoney(BigDecimal refundFinalMoney) {
		this.refundFinalMoney = refundFinalMoney;
	}

	public String getRefundUser() {
		return refundUser;
	}

	public void setRefundUser(String refundUser) {
		this.refundUser = refundUser;
	}

	public String getReturnRefundModifyTime() {
		return returnRefundModifyTime;
	}

	public void setReturnRefundModifyTime(String returnRefundModifyTime) {
		this.returnRefundModifyTime = returnRefundModifyTime;
	}

	public String getRefundAccount() {
		return refundAccount;
	}

	public void setRefundAccount(String refundAccount) {
		this.refundAccount = refundAccount;
	}
}
