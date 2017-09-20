package com.essential.utils;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.auth.model.UserInfo;
import com.essential.auth.service.UserService;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.EncryptPassWord;
import com.essential.user.model.vo.UserInfoRequestVo;
import com.essential.user.model.vo.UserInfoVo;
import com.essential.user.service.IUserInfoService;

@Service("monitorRealm")
public class MonitorRealm extends AuthorizingRealm {

	@Autowired
	UserService userService;
	
	@Autowired
	IUserInfoService userInfoServiceImpl;

	public MonitorRealm() {
		super();

	}

	/*	*//**
	 * 授权信息
	 */
	/*
	 * @Override protected AuthorizationInfo doGetAuthorizationInfo(
	 * PrincipalCollection principals) { 这里编写授权代码 Set<String> roleNames = new
	 * HashSet<String>(); Set<String> permissions = new HashSet<String>();
	 * roleNames.add("admin"); permissions.add("user.do?myjsp");
	 * permissions.add("login.do?main"); permissions.add("login.do?logout");
	 * SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
	 * info.setStringPermissions(permissions); return info;
	 * 
	 * }
	 */

	/**
	 * 授权信息
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		// ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
		// Personnel personnel =
		// accountService.findPersonnelByLoginName(shiroUser.loginName);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// //查询用户拥有的角色
		// List<Role> roles =
		// accountService.findRoleDaoByPersonnelId(personnel.getId());
		// List<String> rolesLabel = new ArrayList<String>();
		// for (Role role : roles) {
		// rolesLabel.add(role.getLabel());
		// }
		// info.addRoles(rolesLabel);
		// //查询用户拥有的资源标示
		// List<Resource> resources =
		// accountService.findResourceByPersonnelId(personnel.getId());
		// List<String> resourcesLabel = new ArrayList<String>();
		// for (Resource resource : resources) {
		// resourcesLabel.add(resource.getLabel());
		// }
		// info.addStringPermissions(resourcesLabel);
		return info;
	}

	/**
	 * 认证用户信息
	 */

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authenticationToken)
			throws AuthenticationException {
		ExtendsUsernamePasswordToken token = (ExtendsUsernamePasswordToken) authenticationToken;
		token.setRememberMe(true);
		String userCode = token.getUsername();
//		String password = String.valueOf(token.getPassword());
		String password = EncryptPassWord.EncryptStr(String.valueOf(token.getPassword()));
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>加密前"+String.valueOf(token.getPassword()));
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>加密后"+password);
		Long userTypeId = token.getUserType();
		if (userCode != null && !"".equals(userCode)) {
			UserInfoRequestVo userBaseInfo = new UserInfoRequestVo();
			userBaseInfo.setUserName(userCode);
			userBaseInfo.setUserPwd(password);
			userBaseInfo.setUserTypeId(userTypeId);
			userBaseInfo.setIsDelete(SUConstants.IS_NOT_DELETE);
			List<UserInfoVo> list = userInfoServiceImpl.queryUserInfoByParams(userBaseInfo);
			UserInfoVo user = list.size()>0?(UserInfoVo)list.get(0):null;
			
			if (user != null) {
					UserInfo userInfo = setUser(user);
					Subject subject = SecurityUtils.getSubject();
					subject.getSession().setTimeout(300 * 10 * 1000);// 设置30分钟不做任何操作超时
					try {
						return new SimpleAuthenticationInfo(userInfo,
								String.valueOf(token.getPassword()), getName());
						
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					
			} else {
				// 如果用户名错误
//				throw new UnknownAccountException();
				throw new IncorrectCredentialsException();
			}
		}
		return null;
	}

	/**
	 * 更新用户授权信息缓存.
	 */
	public void clearCachedAuthorizationInfo(UserInfo principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(
				principal, getName());
		clearCachedAuthorizationInfo(principals);
	}

	/**
	 * 清除所有用户授权信息缓存
	 */
	public void clearAllCachedAuthorizationInfo() {
		Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
		if (cache != null) {
			for (Object key : cache.keys()) {
				cache.remove(key);
			}
		}
	}

	public UserInfo setUser(UserInfoVo user) {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(user.getUserId()==null?"":user.getUserId().toString());
		userInfo.setUserCode(user.getUserName());
		userInfo.setUserName(user.getUserName());
		userInfo.setEmail(user.getUserEmail());
		return userInfo;

	}

}
