package com.essential.user.model.vo;

public class PushMsgVo {
	private long msgId;

	private String msgTitle;

	private String msgContent;

	private String createTime;
	// 退送消息类型（0：文章，1：精选，2：店铺，3：商品，4：日志，5：品牌,6：日志评论，7：文章评论，8：订单发货，9：退款，10：退货）
	private int pushTypeId;

	private String mainId;

	private String secondId;

	private String threeId;

	// 消息已读
	private int isRead;

	// 对应的内容
	private Object data;


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

	
	public String getMainId() {
		return mainId;
	}

	public void setMainId(String mainId) {
		this.mainId = mainId;
	}

	public String getSecondId() {
		return secondId;
	}

	public void setSecondId(String secondId) {
		this.secondId = secondId;
	}

	public String getThreeId() {
		return threeId;
	}

	public void setThreeId(String threeId) {
		this.threeId = threeId;
	}

	public long getMsgId() {
		return msgId;
	}

	public void setMsgId(long msgId) {
		this.msgId = msgId;
	}

	public String getMsgTitle() {
		return msgTitle;
	}

	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public int getPushTypeId() {
		return pushTypeId;
	}

	public void setPushTypeId(int pushTypeId) {
		this.pushTypeId = pushTypeId;
	}

	public int getIsRead() {
		return isRead;
	}

	public void setIsRead(int isRead) {
		this.isRead = isRead;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
