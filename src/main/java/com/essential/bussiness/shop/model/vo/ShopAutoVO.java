package com.essential.bussiness.shop.model.vo;

import java.util.List;

import com.essential.bussiness.returns.model.auto.ReturnAddressAuto;
import com.essential.bussiness.shop.model.auto.ShopAuto;
import com.essential.bussiness.shop.model.auto.ShopBankCardAuto;

public class ShopAutoVO extends ShopAuto{
	/*** 登录用户 */
	private Long loginUser;
	/*** 联系人手机Id */
	private Long contactId;
	/*** 联系人手机 */
	private String contactPhone;
	/*** 审核状态 */
	private String checkStatusName;
	/*** 退货地址信息 */
    List<ReturnAddressAuto> returnAddressAutoList;
    /*** 银行开户信息 */
    List<ShopBankCardAuto> openingBankInfomationList;

	public List<ShopBankCardAuto> getOpeningBankInfomationList() {
		return openingBankInfomationList;
	}

	public void setOpeningBankInfomationList(List<ShopBankCardAuto> openingBankInfomationList) {
		this.openingBankInfomationList = openingBankInfomationList;
	}

	public List<ReturnAddressAuto> getReturnAddressAutoList() {
		return returnAddressAutoList;
	}

	public void setReturnAddressAutoList(List<ReturnAddressAuto> returnAddressAutoList) {
		this.returnAddressAutoList = returnAddressAutoList;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone == null ? null : contactPhone.trim();
	}

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public Long getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(Long loginUser) {
		this.loginUser = loginUser;
	}

	public String getCheckStatusName() {
		return checkStatusName;
	}

	public void setCheckStatusName(String checkStatusName) {
		this.checkStatusName = checkStatusName;
	}

}
