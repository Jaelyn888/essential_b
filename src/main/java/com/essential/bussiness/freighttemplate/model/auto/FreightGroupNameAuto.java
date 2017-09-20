package com.essential.bussiness.freighttemplate.model.auto;

import java.util.List;

public class FreightGroupNameAuto {
	
	public List<FreightTemplateAuto> freightTemplateAutoList;

	/**
	 * @return the freightTemplateAutoList
	 */
	public List<FreightTemplateAuto> getFreightTemplateAutoList() {
		return freightTemplateAutoList;
	}

	/**
	 * @param freightTemplateAutoList the freightTemplateAutoList to set
	 */
	public void setFreightTemplateAutoList(List<FreightTemplateAuto> freightTemplateAutoList) {
		this.freightTemplateAutoList = freightTemplateAutoList;
	}
	
	
    private Long freightGroupId;

    private String freightGroupName;

    private Long shopId;

    private Long createUser;

    private String createTime;

    private String modifyTime;

    private Long modifyUser;

    private Integer isDelete;

    public Long getFreightGroupId() {
        return freightGroupId;
    }

    public void setFreightGroupId(Long freightGroupId) {
        this.freightGroupId = freightGroupId;
    }

    public String getFreightGroupName() {
        return freightGroupName;
    }

    public void setFreightGroupName(String freightGroupName) {
        this.freightGroupName = freightGroupName == null ? null : freightGroupName.trim();
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
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
}