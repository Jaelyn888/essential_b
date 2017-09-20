/**
 * 
 */
package com.essential.user.controller;

import java.util.HashMap;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.user.model.auto.UserCollectionAuto;
import com.essential.user.service.IUserCollectionService;
import com.essential.utils.CommonResponseUtils;

/**
 * @author Jaelyn 用户收藏
 */
@Controller
@RequestMapping(value = "userCollection")
public class UserCollectionController {
	@Autowired
	@Qualifier("userCollectionServiceImpl")
	private IUserCollectionService userCollectionService;

	/**
	 * 查找用户收藏表   未实现分页功能
	 * @param httpRequest
	 * @return
	 */
	@RequestMapping(value = "saveOrCancleCollection")
	@ResponseBody
	public Map<String, Object> saveOrDeleteCollection(UserCollectionAuto userCollectionAuto) {
		try {
			//Map<String, Object> requestMap = WebUtils.getParameterMap(httpRequest);
			return userCollectionService.savaOrCancelCollection(userCollectionAuto);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}

	}
	
	
	/**
	 * 根据收藏类别等   获取收藏列表
	 * @param httpRequest
	 * @return
	 */
	@RequestMapping(value = "queryCollectionByType")
	@ResponseBody
	public Map<String, Object> queryCollectionByType(UserCollectionAuto userCollectionAuto) {
		try {
			//Map<String, Object> requestMap = WebUtils.getParameterMap(httpRequest);
			return userCollectionService.queryByParamSelective(userCollectionAuto);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}
	}
	
	/**
	 * 用户统计
	 * @return
	 */
	@RequestMapping(value = "userCount")
	@ResponseBody
	public Map<String, Object> userCount() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			
			return userCollectionService.userCount();
		} catch (Exception e) {
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("用户统计失败!"));
		}
		return map;
	}
}
