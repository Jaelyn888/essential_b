package com.essential.bussiness.shop.model.auto;

public class ShopToContactAuto {
	private Long contactId;
	
    private Long shopId;

    private String contactEmail;

    private String contactQq;

    private String contactPhone;

    private String contactCarrNumber;

    private String contactPosition;

    private String contactName;

    private String mapImage;

    private Integer customService;

    private String createTime;

    private Long createUser;

    private String modifyTime;

    private Long modifyUser;

    private Long status;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail == null ? null : contactEmail.trim();
    }

    public String getContactQq() {
        return contactQq;
    }

    public void setContactQq(String contactQq) {
        this.contactQq = contactQq == null ? null : contactQq.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public String getContactCarrNumber() {
        return contactCarrNumber;
    }

    public void setContactCarrNumber(String contactCarrNumber) {
        this.contactCarrNumber = contactCarrNumber == null ? null : contactCarrNumber.trim();
    }

    public String getContactPosition() {
        return contactPosition;
    }

    public void setContactPosition(String contactPosition) {
        this.contactPosition = contactPosition == null ? null : contactPosition.trim();
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getMapImage() {
        return mapImage;
    }

    public void setMapImage(String mapImage) {
        this.mapImage = mapImage == null ? null : mapImage.trim();
    }

    public Integer getCustomService() {
        return customService;
    }

    public void setCustomService(Integer customService) {
        this.customService = customService;
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

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}
}