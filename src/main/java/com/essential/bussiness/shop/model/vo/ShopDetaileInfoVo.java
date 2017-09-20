package com.essential.bussiness.shop.model.vo;

import java.util.List;

import com.essential.bussiness.shop.model.auto.ShopAuto;
import com.essential.bussiness.shop.model.auto.ShopBankCardAuto;

public class ShopDetaileInfoVo extends ShopAuto {
	// 联系人手机
	private String contactPhone;
	// 收货人
	private String contactPerson;
	// 退货联系电话
	private String phone;
	// 退货地址
	private String returnAddress;
	// 银行开户信息
	List<ShopBankCardAuto> openingBankInfomationList;

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone == null ? null : contactPhone.trim();
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson == null ? null : contactPerson.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getReturnAddress() {
		return returnAddress;
	}

	public void setReturnAddress(String returnAddress) {
		this.returnAddress = returnAddress == null ? null : returnAddress.trim();
	}

	public List<ShopBankCardAuto> getOpeningBankInfomationList() {
		return openingBankInfomationList;
	}

	public void setOpeningBankInfomationList(List<ShopBankCardAuto> openingBankInfomationList) {
		this.openingBankInfomationList = openingBankInfomationList;
	}
}
