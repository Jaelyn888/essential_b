package com.essential.bussiness.shop.model.auto;

public class ShopBankCardAuto {
	private Long id;

	private Long shopId;

	private String theCardNumber;

	private String openAccount;

	private Long isSame;

	private Long type;

	private String createTime;

	private Long createUser;

	private String modifyTime;

	private Long modifyUser;

	private Integer isDelete;

	private Integer status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getTheCardNumber() {
		return theCardNumber;
	}

	public void setTheCardNumber(String theCardNumber) {
		this.theCardNumber = theCardNumber == null ? null : theCardNumber.trim();
	}

	public String getOpenAccount() {
		return openAccount;
	}

	public void setOpenAccount(String openAccount) {
		this.openAccount = openAccount == null ? null : openAccount.trim();
	}

	public Long getIsSame() {
		return isSame;
	}

	public void setIsSame(Long isSame) {
		this.isSame = isSame;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime == null ? null : createTime.trim();
	}

	public Long getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime == null ? null : modifyTime.trim();
	}

	public Long getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(Long modifyUser) {
		this.modifyUser = modifyUser;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}