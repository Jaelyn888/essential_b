
  
package com.essential.auth.dao;  

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.essential.auth.model.User;
import com.essential.auth.model.UserVo;
import com.essential.common.core.Mapper;

 
/**  
 * ClassName: UserDao 
 * Function: 用户管理持久化. 
 * date: 2015年2月4日 上午10:29:11 
 *  
 * @author xush  
 * @version  V1.0 
 */
@Repository
public interface UserDao extends Mapper<User>{

	/**  
	 * findAllUser:查询所有用户. 
	 * @param List<User>.
	 * @author xush  
	 * @param queryMap 
	 */
	public List<UserVo> findAllUser(Map<String, Object> queryMap);

	/**
	 * 
	 * @Description: 用户登录
	 * @author: panjc
	 * @param: @param user
	 * @param: @return
	 * @return: List<UserVo>
	 * @throws
	 */
	public List<UserVo> findLoginUser(User user);

	/**
	 * @Description: 保存新增用户
	 * @author: xush
	 * @param: @param user
	 * @return: void
	 * @throws
	 */ 
	public void saveUser(User user);
	
	/**
	 * 
	 * @Description: 根据userCode查找User
	 * @author: wangchao
	 * @param userCode
	 * @return User
	 * @throws
	 */
	public List<User> findUserByCode(String userCode);

	/**
	 * @Description: 根据条件查询用户
	 * @author: xush
	 * @param: @param queryMapCode
	 * @param: @return
	 * @return: List<UserVo>
	 * @throws
	 */ 
	public List<UserVo> findUserStrict(Map<String, Object> queryMapCode);

	public void updateUser(User user);

	public void deleteUser(String userId);

}
  
