
  
package com.essential.auth.service.impl;  

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.auth.dao.UserDao;
import com.essential.auth.model.User;
import com.essential.auth.model.UserVo;
import com.essential.auth.service.UserService;
import com.essential.common.constants.SUConstants;
import com.essential.common.model.DataTable;
import com.essential.common.utils.DataTableUtils;
import com.essential.common.utils.StringCommonUtils;
import com.essential.common.utils.UUIDUtil;
 
/**  
 * ClassName: UserServiceImpl 
 * Function: 用户业务逻辑实现. 
 * date: 2015年2月4日 上午10:28:27 
 *  
 * @author xush  
 * @version   V1.0
 */

@Service(value = "userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	/**
	 * @Description: 查询所有用户 如果有值则将UserVo中的count取出传递到前台用于分页
	 * @author: xush
	 * @param: @param dataTable
	 * @param: @param user 查询条件
	 * @param: @return 查询结果
	 * @throws
	 */ 
	 
	public DataTable<UserVo> findAllUser(DataTable<UserVo> dataTable,User user) {
		  Map<String, Object> queryMap = DataTableUtils.dataTableToMap(dataTable);
		  queryMap.put("userName", user.getUserName());
		  queryMap.put("isSysAdm", user.getIsSysAdm());
		  queryMap.put("sex","-1".equals(user.getSex())?"":user.getSex());
		  queryMap.put("userCode", user.getUserCode());
		  queryMap.put("orderField", "create_date");
		  queryMap.put("Sorting", "desc");
		  List<UserVo> userList = userDao.findAllUser(queryMap);
		  int count = 0;
		  if(userList.size()!=0){
			  count = userList.get(0).getCount();
		  }
		  dataTable.setData(userList);
		  dataTable.setRecordsFiltered(count);
		  dataTable.setStart(count);
		return dataTable;
	}

	 
	public List<UserVo> findLoginUser(User user) {
		List<UserVo> list = userDao.findLoginUser(user);
		return list;
	}
	
	/**
	 * 通过主键查找user实体
	 * @param user
	 * @return
	 */
	public User findUserById(User user){
		return userDao.selectByPrimaryKey(user);
	}


	/**
	 * @Description:保存新增用户
	 * @author: xush
	 * @param: @param user 保存用户
	 * @param: @return userNull用户信息不完整  employeeNoRepeat工号已存在 userCodeRepeat账号已存在  userCodeRepeat-employeeNoRepeat工号账号都已存在  true保存成功  error 保存失败
	 * @throws
	 */ 
	 
	public String saveUser(User user) {
		String msg = "";
		try {
			String dateNowStr = StringCommonUtils.nowDateStr();
			String userId=UUIDUtil.getUUID();
			user.setUserId(userId);
			user.setCreateDate(dateNowStr);
			user.setUpdateDate(dateNowStr);
			userDao.saveUser(user);
			msg = userId;
		} catch (Exception e) {
			e.printStackTrace();  
			msg = SUConstants.RETURN_ERROR;
		}
		return msg;
	}

	/**
	 * @Description: 校验 判断user是否为空
	 * @author: xush
	 * @param: @param user
	 * @param: @return
	 * @return: String
	 * @throws
	 */ 
	public Boolean validateUser(User user){
		if(StringUtils.isNotEmpty(user.getUserName())&&StringUtils.isNotEmpty(user.getUserCode())){
			return true;
		}
		return false;
	}

	/**
	 * @Description: 根据userCode查找User
	 * @author: wangchao
	 * @param:  userCode
	 * @return: user
	 * @throws
	 */
	 
	public User findUserByCode(String userCode) {
		List<User> userList =userDao.findUserByCode(userCode);
		if(null !=userList && !userList.isEmpty()){
			return userList.get(0);
		}
		return null;
	}

	/**
	 * @Description: 根据单个字段查询用户 
	 * @author: xush
	 * @param: @param key 字段名
	 * @param: @param value 字段值
	 * @param: @return
	 * @throws
	 */ 
	 
	public List<UserVo> findUserByKey(String key, String value) {
		Map<String, Object> queryMapCode = new HashMap<String, Object>();
		queryMapCode.put(key, value);
		return userDao.findUserStrict(queryMapCode);
	}

	/**
	 * @Description: 更新用户
	 * @author: xush
	 * @param: @param user
	 * @param: @return
	 * @throws
	 */ 
	 
	public String updateUser(User user) {
		String msg="";
		try {
			String dateNowStr = StringCommonUtils.nowDateStr();
			//入库前先判断是否被修改过 如果被修改过则返回失败
//			List<UserVo> userListById = findUserByKey("userId",user.getUserId());
//			if(!user.getUpdateUser().equals(userListById.get(0).getUserId())){
				//List<UserVo> userListByNo = findUserByKey("employeeNo",user.getEmployeeNo());
				//if(userListByNo.size() == 0 ||(userListByNo.size() == 1 && userListByNo.get(0).getUserId().equals(user.getUserId()))){
			if(user.getUserId()!=null){
					user.setUpdateDate(dateNowStr);
					userDao.updateUser(user);
					msg = user.getUserId();
				}else{
					msg = SUConstants.RETURN_FALSE;
				}
//			}else{
//				msg = SUConstants.RETURN_REPEAT;
//			}
		} catch (Exception e) {
			e.printStackTrace();  
			msg = SUConstants.RETURN_ERROR;
		}
		return msg;
	}
	
	/**
	 * @Description: 删除用户
	 * @author: xush
	 * @param: @param userId
	 * @param: @return
	 * @throws
	 */ 
	 
	public String deleteUser(String userId) {
		String msg = "";
		try {
			userDao.deleteUser(userId);
			msg = SUConstants.RETURN_TRUE;
		} catch (Exception e) {
			e.printStackTrace();  
			msg = SUConstants.RETURN_ERROR;
		}
		return msg;
	}

}
  
