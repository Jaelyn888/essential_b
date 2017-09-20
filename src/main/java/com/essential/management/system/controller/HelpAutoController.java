package com.essential.management.system.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.management.system.model.auto.HelpAuto;
import com.essential.management.system.service.IHelpAutoService;
import com.essential.utils.CommonResponseUtils;

/**
 * 帮助中心
 * 
 * @author czm
 *
 */
@Controller
@RequestMapping(value = "helpAutoController")
public class HelpAutoController {
	private static Logger logger = LoggerFactory.getLogger(HelpAutoController.class);

	@Autowired
	IHelpAutoService helpAutoService;

	/**
	 * 添加帮助中心信息
	 * 
	 * @param helpAuto
	 * @return
	 */
	@RequestMapping(value = "addHelp")
	@ResponseBody
	public Map<String, Object> addHelp(HelpAuto helpAuto) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return helpAutoService.addHelp(helpAuto);
		} catch (Exception e) {
			logger.info("=====>>>>>>>帮助中心信息添加失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("帮助中心信息添加失败!"));
		}
		return map;
	}

	/**
	 * 更新帮助中心信息
	 * @param helpAuto
	 * @return
	 */
	@RequestMapping(value = "updateHelp")
	@ResponseBody
	public Map<String, Object> updateHelp(HelpAuto helpAuto) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return helpAutoService.updateHelp(helpAuto);
		} catch (Exception e) {
			logger.info("=====>>>>>>>帮助中心信息更新失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("帮助中心信息更新失败!"));
		}
		return map;
	}

	/**
	 * 查询帮助中心信息
	 * @param helpAuto
	 * @return
	 */
	@RequestMapping(value = "queryHelp")
	@ResponseBody
	public Map<String, Object> queryHelp(HelpAuto helpAuto) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return helpAutoService.queryHelp(helpAuto);
		} catch (Exception e) {
			logger.info("=====>>>>>>>帮助中心信息查询失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("帮助中心信息查询失败!"));
		}
		return map;
	}

	/**
	 * 删除帮助中心信息
	 * @param helpAuto
	 * @return
	 */
	@RequestMapping(value = "deleteHelp")
	@ResponseBody
	public Map<String, Object> deleteHelp(Long helpAutoId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return helpAutoService.deleteHelp(helpAutoId);
		} catch (Exception e) {
			logger.info("=====>>>>>>>帮助中心信息删除失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("帮助中心信息删除失败!"));
		}
		return map;
	}

}
