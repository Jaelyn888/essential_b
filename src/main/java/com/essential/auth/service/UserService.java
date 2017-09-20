
  
package com.essential.auth.service;  

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.essential.auth.model.User;
import com.essential.auth.model.UserVo;
import com.essential.common.model.DataTable;

 
/**  
 * ClassName: UserService 
 * Function: 用户接口. 
 * date: 2015年2月4日 上午10:28:08 
 *  
 * @author xush  
 * @version   V1.0
 */
@Service
public interface UserService {

	DataTable<UserVo> findAllUser(DataTable<UserVo> dataTable, User user);
	
	List<UserVo> findLoginUser(User user);
	
	String saveUser(User user);
	
	User findUserByCode(String userCode);

	List<UserVo> findUserByKey(String key, String value);

	String updateUser(User user);

	String deleteUser(String userId);

	/**
	 * 通过主键查找user实体
	 * @param user
	 * @return
	 */
	public User findUserById(User user);

}

  
