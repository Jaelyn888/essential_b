/**
 * 
 */
package com.essential.find.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.find.service.IDiscoverTopGroupService;
import com.essential.utils.CommonResponseUtils;

/**
 * 手机端 发现页 顶部 文章和精选分组
 * @author Jaelyn 
 */
@Controller
@RequestMapping(value = "discoverTopGroup")
public class DiscoverTopGroupController {

	/**
	 * 获取文章分组
	 */
	@Autowired
	@Qualifier(value="discoverTopGroupServiceImpl")
	private IDiscoverTopGroupService discoverTopGroupServiceImpl;
	
	/**
	 * 查询文章和精选所有数据
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "queryGroupList")
	public Map<String, Object> queryGroupData() {
		try {
			return discoverTopGroupServiceImpl.queryFindTopGroup();
		} catch (Exception e) {
			return CommonResponseUtils.failureResponse();
		}
	}

}
