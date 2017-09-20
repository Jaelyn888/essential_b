package com.essential.find.controller;

import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.common.constants.SUConstants;
import com.essential.find.model.auto.SpecialAuto;
import com.essential.find.service.ISpecialService;

@Controller
@RequestMapping(value="special")
public class SpecialController {
	@Autowired
	ISpecialService specialService;
	
	/**
	 * 查询精选详情
	 * @param req
	 * @return
	 */
	@RequestMapping(value="get")
	@ResponseBody
	public HashMap<String, Object> getSpecial(SpecialAuto req) {
		if (req.getSpecialId() == null) return failureResponse(null, "查询不到参数");
		SpecialAuto specialAuto = specialService.selectSpecial(req);
		if (specialAuto == null) return failureResponse(null, "查询失败");
		return successResponse(specialAuto, null);
	}
	
	/**
	 * 创建一条新的 精选
	 * @param req
	 * @return
	 */
	@RequestMapping(value="create")
	@ResponseBody
	public HashMap<String, Object> createSpecial(SpecialAuto req) {
		Date nowDate = new Date();
		req.setCreateTime(nowDate);
		req.setSendTime("" + System.currentTimeMillis());
		req.setModifyTime(nowDate);
		req.setModifyUserId(req.getCreateUserId());
		req.setIsDelete(SUConstants.IS_NOT_DELETE);
		boolean flag = specialService.createSpecial(req);
		if (!flag) return failureResponse("创建失败", "创建失败");
		return successResponse("创建成功", SUConstants.MSG_SUCCESS_VALUE);
	}
	
	/**
	 * 更新 精选 内容
	 * @param req
	 * @return
	 */
	@RequestMapping(value="update")
	@ResponseBody
	public HashMap<String, Object> updateSpecial(SpecialAuto req) {
		req.setModifyTime(new Date());
		boolean flag = specialService.updateSpecial(req);
		if (!flag) return failureResponse("创建失败", "创建失败");
		return successResponse("更新成功", SUConstants.CODE_SUCCESS_VALUE);
	}
	
	
	/**
	 * 删除 精选
	 * @param req
	 * @return
	 */
	@RequestMapping(value="delete")
	@ResponseBody
	public HashMap<String, Object> deleteSpecial(SpecialAuto req) {
		req.setModifyTime(new Date());
		req.setIsDelete(SUConstants.IS_DELETE);
		boolean flag = specialService.deleteSpecial(req);
		if (!flag) failureResponse("删除失败", "删除失败");
		return successResponse("删除成功", SUConstants.CODE_FAIL_VALUE);
	}
	
	/**
	 * 获取精选列表
	 * @param req
	 * @return
	 */
	@RequestMapping(value="list")
	@ResponseBody
	public HashMap<String, Object> selectSpecialList(HttpServletRequest req) {
		HashMap<String, Object> reqMap = new HashMap<String, Object>();
		reqMap.put("requestType", req.getParameter("requestType"));
		reqMap.put("sendTime", req.getParameter("sendTime"));
		reqMap.put("groupId", req.getParameter("groupId"));
		
		return successResponse(specialService.selectSpecialList(reqMap), null);
	}
	
	//成功请求反参
	private HashMap<String, Object> successResponse(Object object, String msg) {
		HashMap<String, Object> resMap = new HashMap<String, Object>();
		resMap.put(SUConstants.CODE_KEY, SUConstants.CODE_SUCCESS_VALUE);
		if (msg != null) {
			resMap.put(SUConstants.MSG_KEY, msg);
		}
		resMap.put(SUConstants.MSG_KEY, SUConstants.MSG_SUCCESS_VALUE);
		resMap.put(SUConstants.INFO_KEY, object);
		return resMap;
	}
	
	//失败请求反参
	private HashMap<String, Object> failureResponse(Object object, String message) {
		HashMap<String, Object> resMap = new HashMap<String, Object>();
		resMap.put(SUConstants.CODE_KEY, SUConstants.CODE_FAIL_VALUE);
		resMap.put(SUConstants.MSG_KEY, message);
		resMap.put(SUConstants.INFO_KEY, object);
		return resMap;
	}
}
