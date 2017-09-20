package com.essential.management.system.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.management.system.model.auto.AboutAuto;
import com.essential.management.system.service.IAboutAutoService;
import com.essential.utils.CommonResponseUtils;

/**
 * 关于我们
 * 
 * @author czm
 *
 */
@Controller
@RequestMapping(value = "aboutAutoController")
public class AboutAutoController {
	private static Logger logger = LoggerFactory.getLogger(AboutAutoController.class);

	@Autowired
	IAboutAutoService aboutAutoService;

	/**
	 * 保存或更新关于我们信息
	 * 
	 * @param aboutAuto
	 * @return
	 */
	@RequestMapping(value = "saveOrUpdateAbout")
	@ResponseBody
	public Map<String, Object> saveOrUpdateAbout(AboutAuto aboutAuto) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return aboutAutoService.saveOrUpdateAbout(aboutAuto);
		} catch (Exception e) {
			logger.info("======>>>>>>关于我们信息添加失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("关于我们信息添加失败!"));
		}
		return map;
	}
	
	/**
	 * 添加关于我们信息
	 * 
	 * @param aboutAuto
	 * @return
	 */
	@RequestMapping(value = "addAbout")
	@ResponseBody
	public Map<String, Object> addAbout(AboutAuto aboutAuto) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return aboutAutoService.addAbout(aboutAuto);
		} catch (Exception e) {
			logger.info("======>>>>>>关于我们信息添加失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("关于我们信息添加失败!"));
		}
		return map;
	}

	/**
	 * 查询关于我们信息
	 * 
	 * @param aboutAuto
	 * @return
	 */
	@RequestMapping(value = "queryAbout")
	@ResponseBody
	public Map<String, Object> queryAbout(AboutAuto aboutAuto) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return aboutAutoService.queryAbout(aboutAuto);
		} catch (Exception e) {
			logger.info("======>>>>>>关于我们信息查询失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("关于我们信息查询失败!"));
		}
		return map;
	}

	/**
	 * 更新关于我们信息
	 * 
	 * @param aboutAuto
	 * @return
	 */
	@RequestMapping(value = "updateAbout")
	@ResponseBody
	public Map<String, Object> updateAbout(AboutAuto aboutAuto) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return aboutAutoService.updateAbout(aboutAuto);
		} catch (Exception e) {
			logger.info("======>>>>>>关于我们信息更新失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("关于我们信息更新失败!"));
		}
		return map;
	}

	/**
	 * 删除关于我们信息
	 * 
	 * @param aboutAuto
	 * @return
	 */
	@RequestMapping(value = "deleteAbout")
	@ResponseBody
	public Map<String, Object> deleteAbout(Long[] aboutId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return aboutAutoService.deleteAbout(aboutId);
		} catch (Exception e) {
			logger.info("======>>>>>>关于我们信息删除失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("关于我们信息删除失败!"));
		}
		return map;
	}
}
