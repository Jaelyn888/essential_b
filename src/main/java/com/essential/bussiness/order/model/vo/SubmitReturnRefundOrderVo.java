package com.essential.bussiness.order.model.vo;

import com.essential.bussiness.order.model.auto.ReturnRefundOrderAuto;

public class SubmitReturnRefundOrderVo {
	private ReturnRefundOrderAuto returnRefundOrderAuto;
	
	private String[] pics;

	public ReturnRefundOrderAuto getReturnRefundOrderAuto() {
		return returnRefundOrderAuto;
	}

	public void setReturnRefundOrderAuto(ReturnRefundOrderAuto returnRefundOrderAuto) {
		this.returnRefundOrderAuto = returnRefundOrderAuto;
	}

	public String[] getPics() {
		return pics;
	}

	public void setPics(String[] pics) {
		this.pics = pics;
	}
	
}
