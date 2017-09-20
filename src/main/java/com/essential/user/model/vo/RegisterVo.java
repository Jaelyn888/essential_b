package com.essential.user.model.vo;

import com.essential.user.model.auto.UserBaseInfoAuto;

public class RegisterVo extends UserBaseInfoAuto {
	 private String smsCode;

	    private Long userTypeId;

	    private Integer serviceType;

		public String getSmsCode() {
			return smsCode;
		}

		public void setSmsCode(String smsCode) {
			this.smsCode = smsCode;
		}

		public Long getUserTypeId() {
			return userTypeId;
		}

		public void setUserTypeId(Long userTypeId) {
			this.userTypeId = userTypeId;
		}

		public Integer getServiceType() {
			return serviceType;
		}

		public void setServiceType(Integer serviceType) {
			this.serviceType = serviceType;
		}
	    
	    

}
