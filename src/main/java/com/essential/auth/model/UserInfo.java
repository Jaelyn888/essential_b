
  
package com.essential.auth.model;  

import java.io.Serializable;


/**  
 * ClassName: UserInfo 
 * Function: 用户对象. 
 * date: 2015年2月4日 上午10:33:21 
 *  
 * @author wangchao  
 * @version V1.0
 */
public class UserInfo implements Serializable{
	/**
	 * (用一句话描述这个变量表示什么)
	 */ 
	private static final long serialVersionUID = 1L;

	private String  userId;
	
	private String userCode;
	
	private String userName;
	
	private String password;
	
	private String employeeNo;
	
	private String sex;
	
	private String headImage;
	
	/**  
	 * status:状态：是否在线.  
	 */
	private String status;
	
	private String email;
	
	/**  
	 * celephone:电话.  
	 */
	private String celephone;
	
	/**  
	 * telephone:手机.  
	 */
	private String telephone;
	
	/**  
	 * isSysAdm:是否管理员.  
	 */
	private String isSysAdm;
	
	private String attr1;
	
	private String attr2;
	
	private String attr3;
	
	private String attr4;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getHeadImage() {
		return headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelephone() {
		return celephone;
	}

	public void setCelephone(String celephone) {
		this.celephone = celephone;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getIsSysAdm() {
		return isSysAdm;
	}

	public void setIsSysAdm(String isSysAdm) {
		this.isSysAdm = isSysAdm;
	}

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
	
	
	/**
	 * 本函数输出将作为默认的<shiro:principal/>输出.
	 */
	@Override
	public String toString() {
		return userCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((userCode == null) ? 0 : userCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfo other = (UserInfo) obj;
		if (userCode == null) {
			if (other.userCode != null)
				return false;
		} else if (!userCode.equals(other.userCode))
			return false;
		return true;
	}
	
}
  
