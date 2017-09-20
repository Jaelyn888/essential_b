package com.essential.management.version.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.management.version.model.auto.VersionAuto;
import com.essential.management.version.service.IVersionAutoService;
import com.essential.utils.CommonResponseUtils;

/**
 * 版本信息
 * 
 * @author czm
 *
 */
@Controller
@RequestMapping(value = "versionAutoController")
public class VersionAutoController {
	private static Logger logger = LoggerFactory.getLogger(VersionAutoController.class);

	@Autowired
	IVersionAutoService versionAutoService;

	/**
	 * 添加版本信息
	 * 
	 * @param versionAuto
	 * @return
	 */
	@RequestMapping(value = "addVersion")
	@ResponseBody
	public Map<String, Object> addVersion(VersionAuto versionAuto) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return versionAutoService.addVersion(versionAuto);
		} catch (Exception e) {
			logger.info("====>>>>版本信息添加失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("版本信息添加失败!"));
		}
		return map;
	}

	/**
	 * 更新版本信息
	 * 
	 * @param versionAuto
	 * @return
	 */
	@RequestMapping(value = "updateVersion")
	@ResponseBody
	public Map<String, Object> updateVersion(VersionAuto versionAuto) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return versionAutoService.updateVersion(versionAuto);
		} catch (Exception e) {
			logger.info("====>>>>版本信息更新失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("版本信息更新失败!"));
		}
		return map;
	}

	/**
	 * 查询版本信息
	 * 
	 * @param versionAuto
	 * @return
	 */
	@RequestMapping(value = "queryVersion")
	@ResponseBody
	public Map<String, Object> queryVersion(VersionAuto versionAuto, Integer pageIndex, Integer pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return versionAutoService.queryVersion(versionAuto, pageIndex, pageSize);
		} catch (Exception e) {
			logger.info("====>>>>版本信息查询失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("版本信息查询失败!"));
		}
		return map;
	}

	/**
	 * 删除版本信息
	 * 
	 * @param versionAuto
	 * @return
	 */
	@RequestMapping(value = "deleteVersion")
	@ResponseBody
	public Map<String, Object> deleteVersion(Long versionId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return versionAutoService.deleteVersion(versionId);
		} catch (Exception e) {
			logger.info("====>>>>版本信息删除失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("版本信息删除失败!"));
		}
		return map;
	}

	/**
	 * 查询最新版本信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "queryNewVersion")
	@ResponseBody
	public Map<String, Object> queryNewVersion() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return versionAutoService.queryNewVersion();
		} catch (Exception e) {
			logger.info("====>>>>最新版本信息查询失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("最新版本信息查询失败!"));
		}
		return map;
	}
}
