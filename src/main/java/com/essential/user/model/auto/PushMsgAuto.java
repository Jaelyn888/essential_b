package com.essential.user.model.auto;

public class PushMsgAuto {
    private Long msgId;

    private String msgTitle;

    private String msgContent;

    private String createTime;

    private String modifyTime;

    //退送时间  定时任务
    private String pushTime;

    //退送消息类型（0：文章，1：精选，2：店铺，3：商品，4：日志，5：品牌,6：日志评论，7：文章评论，8：订单，9：退款退货订单）
    private Integer pushTypeId;

    private String mainId;
    
    private String secondId;

    private String threeId;

    //推送范围（0:所有，1:个人，2：普通用户**）
    private Integer pushStrategy;

    private Long createUserId;

    private Long modifyUserId;

    private Integer isDelete;

    private String attr1;
    private String attr2;
    private String attr3;
    private String attr4;
    private String attr5;
    private String attr6;
    
 

	public String getAttr1() {
		return attr1;
	}

	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}

	public String getAttr2() {
		return attr2;
	}

	public void setAttr2(String attr2) {
		this.attr2 = attr2;
	}

	public String getAttr3() {
		return attr3;
	}

	public void setAttr3(String attr3) {
		this.attr3 = attr3;
	}

	public String getAttr4() {
		return attr4;
	}

	public void setAttr4(String attr4) {
		this.attr4 = attr4;
	}

	public String getAttr5() {
		return attr5;
	}

	public void setAttr5(String attr5) {
		this.attr5 = attr5;
	}

	public String getAttr6() {
		return attr6;
	}

	public void setAttr6(String attr6) {
		this.attr6 = attr6;
	}

	public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    public String getMsgTitle() {
        return msgTitle;
    }

    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle == null ? null : msgTitle.trim();
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent == null ? null : msgContent.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime == null ? null : modifyTime.trim();
    }

    public String getPushTime() {
        return pushTime;
    }

    public void setPushTime(String pushTime) {
        this.pushTime = pushTime == null ? null : pushTime.trim();
    }

    public Integer getPushTypeId() {
        return pushTypeId;
    }

    public void setPushTypeId(Integer pushTypeId) {
        this.pushTypeId = pushTypeId;
    }

    public String getMainId() {
        return mainId;
    }

    public void setMainId(String mainId) {
        this.mainId = mainId == null ? null : mainId.trim();
    }

    public String getSecondId() {
        return secondId;
    }

    public void setSecondId(String secondId) {
        this.secondId = secondId == null ? null : secondId.trim();
    }

    public String getThreeId() {
        return threeId;
    }

    public void setThreeId(String threeId) {
        this.threeId = threeId == null ? null : threeId.trim();
    }

    public Integer getPushStrategy() {
        return pushStrategy;
    }

    public void setPushStrategy(Integer pushStrategy) {
        this.pushStrategy = pushStrategy;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Long getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Long modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}