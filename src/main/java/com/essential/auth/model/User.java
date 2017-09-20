
  
package com.essential.auth.model;  

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.essential.common.model.CommonBean;
 
/**  
 * ClassName: User 
 * Function: 用户对象. 
 * date: 2015年2月4日 上午10:33:21 
 *  
 * @author xush  
 * @version V1.0
 */
@Table(name="t_auth_user")
public class User extends CommonBean implements Serializable{
	/**
	 * 序列号
	 */ 
	private static final long serialVersionUID = 1L;

	@Id
	private String  userId;
	
	/**  
	 * userCode:登录账户.  
	 */
	@Column(name="user_code")
	private String userCode;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	/**  
	 * employeeNo:工号或微信成员替代字段weixinid：
	 */
	@Column(name="employee_no")
	private Integer employeeNo;
	
	@Column(name="sex")
	private String sex;
	
	@Column(name="head_image")
	private String headImage;
	
	/**  
	 * status:状态：是否在线.  
	 */
	@Column(name="status")
	private String status;
	
	@Column(name="email")
	private String email;
	
	/**  
	 * celephone:电话.  
	 */
	@Column(name="cellphone")
	private String celephone;
	
	/**  
	 * telephone:手机.  
	 */
	@Column(name="telephone")
	private String telephone;
	
	/**  
	 * isSysAdm:是否管理员.  
	 */
	@Column(name="is_sysadm")
	private String isSysAdm;
	
	/**  
	 * temp:临时积分.  
	 */
	@Column(name="temp")
	private String temp;
	
	/**
	 * 用户表示积分：
	 */ 
	@Column(name="attr1")
	private String attr1;
	
	/**
	 * 微信成员替代字段weixinid：
	 */ 
	@Column(name="attr2")
	private String attr2;
	
	/**
	 * 微信成员替代字段avatar头像：
	 */ 
	@Column(name="attr3")
	private String attr3;
	
	/**
	 * 用户表示积分：
	 */ 
	@Column(name="attr4")
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

	public Integer getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(Integer employeeNo) {
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

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}
	
	
}
  
