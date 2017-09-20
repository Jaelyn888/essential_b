package com.essential.find.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.common.constants.SUConstants;
import com.essential.find.model.auto.SpecialGroupAuto;
import com.essential.find.service.ISpecialGroupService;

@Controller
@RequestMapping(value = "specialGroup")
public class SpecialGroupController {
	@Autowired
	ISpecialGroupService specialGroupService;

	/**
	 * query one special group info by specialGroupId
	 * 
	 * @param groupId
	 * @return
	 */
	@RequestMapping(value = "groupId")
	@ResponseBody
	public Map<String, Object> getSpecialGroupInfoById(SpecialGroupAuto specialGroupAuto) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (specialGroupAuto != null) {
				SpecialGroupAuto respose = specialGroupService.querySpecialGroupById(specialGroupAuto);
				map.put(SUConstants.CODE_KEY, SUConstants.CODE_SUCCESS_VALUE);
				map.put(SUConstants.MSG_KEY, SUConstants.MSG_SUCCESS_VALUE);
				map.put(SUConstants.INFO_KEY, respose);
			} else {
				map.put(SUConstants.CODE_KEY, SUConstants.CODE_FAIL_VALUE);
				map.put(SUConstants.MSG_KEY, "分组不存在");
			}
		} catch (Exception e) {
			map.put(SUConstants.CODE_KEY, SUConstants.CODE_FAIL_VALUE);
			map.put(SUConstants.MSG_KEY, "分组查询失败");
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * save one special group info to db
	 * 
	 * @param groupName
	 * @param userID
	 * @return
	 */
	@RequestMapping(value = "save")
	@ResponseBody
	public Map<String, Object> saveSpecialGroup(SpecialGroupAuto specialGroupAuto) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Date date = new Date();
			specialGroupAuto.setModifyTime(date);
			specialGroupAuto.setModifyUserId(specialGroupAuto.getCreateUserId());
			specialGroupAuto.setCreateTime(date);
			specialGroupAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			boolean flag = specialGroupService.saveSpecialGroup(specialGroupAuto);
			map.put(SUConstants.CODE_KEY, SUConstants.CODE_SUCCESS_VALUE);
			map.put(SUConstants.MSG_KEY, "保存成功");
		} catch (Exception e) {
			map.put(SUConstants.CODE_KEY, SUConstants.CODE_FAIL_VALUE);
			map.put(SUConstants.MSG_KEY, "保存失败");
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * update someone special group
	 * 
	 * @param groupName
	 * @param groupId
	 * @param modifyUserId
	 * @return
	 */
	@RequestMapping(value = "update")
	@ResponseBody
	public Map<String, Object> updateSpecialGroup(SpecialGroupAuto specialGroupAuto) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			specialGroupAuto.setModifyTime(new Date());

			boolean flag = specialGroupService.updateSpecialGroup(specialGroupAuto);
			map.put(SUConstants.CODE_KEY, SUConstants.CODE_SUCCESS_VALUE);
			map.put(SUConstants.MSG_KEY, "更新成功");

		} catch (Exception e) {
			map.put(SUConstants.CODE_KEY, SUConstants.CODE_FAIL_VALUE);
			map.put(SUConstants.MSG_KEY, "更新文章分组失败");
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * delete one special group
	 * 
	 * @param userID
	 * @param groupId
	 * @return
	 */
	@RequestMapping(value = "delete")
	@ResponseBody
	public Map<String, Object> deleteSpecialGroup(SpecialGroupAuto specialGroupAuto) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			specialGroupAuto.setIsDelete(SUConstants.IS_DELETE);
			boolean flag = specialGroupService
					.deleteSpecialGroup(specialGroupAuto);
			map.put(SUConstants.CODE_KEY, SUConstants.CODE_SUCCESS_VALUE);
			map.put(SUConstants.MSG_KEY, "删除成功");
		} catch (Exception e) {
			map.put(SUConstants.CODE_KEY, SUConstants.CODE_FAIL_VALUE);
			map.put(SUConstants.MSG_KEY, "删除失败");
		}
		return map;
	}

	/**
	 * query all special group
	 * 
	 * @return
	 */
	@RequestMapping(value = "querySpecialGroupList")
	@ResponseBody
	public Map<String, Object> querySpecialGroupList() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<SpecialGroupAuto> list = specialGroupService.queryAllSpecialGroup();
			map.put(SUConstants.INFO_KEY, list);
			map.put(SUConstants.CODE_KEY, SUConstants.CODE_SUCCESS_VALUE);
			map.put(SUConstants.MSG_KEY, "查询成功");
		} catch (Exception e) {
			map.put(SUConstants.CODE_KEY, SUConstants.CODE_FAIL_VALUE);
			map.put(SUConstants.MSG_KEY, "查询失败");
		}
		return map;
	}
}
