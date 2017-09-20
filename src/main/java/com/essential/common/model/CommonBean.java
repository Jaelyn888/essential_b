
  
package com.essential.common.model;  

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.OrderBy;
 
/**  
 * ClassName: Common 
 * Function:实体公有属性. 
 * date: 2015年2月4日 下午1:55:13 
 *  
 * @author xush  
 * @version V1.0
 */
public class CommonBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**  
	 * createUser:创建人.  
	 */
	@Column(name="create_user")
	private String createUser;
	
	/**  
	 * createDate:创建时间.  
	 */
	@Column(name="create_date")
	@OrderBy("DESC")
	private String createDate;
	
	/**  
	 * updateUser:最后更新人.  
	 */
	@Column(name="update_user")
	private String updateUser;
	
	/**  
	 * updateDate:最后更新时间.  
	 */
	@Column(name="update_date")
	private String updateDate;
	
	@Column(name="enable_flag")
	private String enableFlag;

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getEnableFlag() {
		return enableFlag;
	}

	public void setEnableFlag(String enableFlag) {
		this.enableFlag = enableFlag;
	}
	
}
  
