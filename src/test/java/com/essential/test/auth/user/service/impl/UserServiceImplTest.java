
  
package com.essential.test.auth.user.service.impl;  

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import com.essential.auth.model.User;
import com.essential.auth.model.UserVo;
import com.essential.auth.service.UserService;
import com.essential.common.constants.SUConstants;
import com.essential.common.model.DataTable;
import com.essential.common.utils.StringCommonUtils;
import com.essential.common.utils.UUIDUtil;
import com.essential.test.common.BaseTest;
 
/**
 * @ClassName: UserServiceImplTest
 * @Description:  用户测试类
 * @author: xush
 * @date: 2015年3月18日 下午2:39:11
 */ 
public class UserServiceImplTest extends BaseTest{
	
	@Resource
	private UserService UserService;
	
	@Before
	public void beforeEveryTest() {
	}
	
	/**
	 * @Description: 创建一个公用的User对象
	 * @author: xush
	 * @param: @return
	 * @return: User
	 * @throws
	 */ 
	public User CreateUser(){
		String userId=UUIDUtil.getUUID();
		String dateNowStr = StringCommonUtils.nowDateStr();
		User user = new User();
		user.setUserCode("xshxsh200035");
		user.setUserName("qwerty");
		user.setPassword("xshxsh200035");
		user.setEnableFlag("1");
		user.setEmail("xshcom@163.com");
		user.setCreateUser("xsh");
		user.setUpdateUser("xsh");
		user.setTelephone("13856056666");
		user.setCreateDate(dateNowStr);
		user.setUpdateDate(dateNowStr);
		user.setUserId(userId);
		return user;
	}
	
	/**
	 * @Description: 查询用户
	 * @author: xush
	 * @param: 
	 * @return: void
	 * @throws
	 */ 
	@Test
	@Transactional
	public void findAllUserTest(){
		User user = CreateUser();
		UserService.saveUser(user);
		DataTable<UserVo> dataTable = new DataTable<UserVo>();
		User queryuser=new User();
		DataTable<UserVo> result = UserService.findAllUser(dataTable, queryuser);
		Assert.assertTrue(result.getData().size() >= 1);
	};
	
	/**
	 * @Description: 新增用户测试
	 * @author: xush
	 * @param: 
	 * @return: void
	 * @throws
	 */ 
	@Test
	@Transactional
	public void saveUserTest(){
		User user = CreateUser();
		String userId = UserService.saveUser(user);
		Assert.assertTrue(userId.length() == 17);
	}
	
	/**
	 * @Description: 查询用户
	 * @author: xush
	 * @param: 
	 * @return: void
	 * @throws
	 */ 
	@Test
	@Transactional
	public void findUserByKeyTest(){
		saveUserTest();
		List<UserVo> result = UserService.findUserByKey("userCode","xshxsh200035");
		assertNotNull(result);
		Assert.assertTrue(result.size() == 1);
	}
	
	/**
	 * @Description: 更新用户
	 * @author: xush
	 * @param: 
	 * @return: void
	 * @throws
	 */ 
	@Test
	@Transactional
	public void updateUserTest(){
		User user = CreateUser();
		String userId = UserService.saveUser(user);
		user.setUserId(userId);
		user.setUserName("litteCoder");
		UserService.updateUser(user);
		List<UserVo> resultList = UserService.findUserByKey("userId",userId);
		String result = resultList.get(0).getUserName();
		String success="litteCoder";
		assertEquals(result,success);//实际结果 预期结果 
	}
	
	/**
	 * @Description: 删除用户
	 * @author: xush
	 * @param: 
	 * @return: void
	 * @throws
	 */ 
	@Test
	@Transactional
	public void deleteUserTest(){
		User user = CreateUser();
		String userId = UserService.saveUser(user);
		String result  =UserService.deleteUser(userId);
		String success = SUConstants.RETURN_TRUE;
		assertEquals(result,success);//实际结果 预期结果 
	}
}
  
