package com.essential.management.opinon.controller;

import java.util.HashMap;
import java.util.Map;

import org.omg.CORBA.COMM_FAILURE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.bussiness.shop.controller.ShopBackstageInfoController;
import com.essential.management.opinon.model.auto.OpinonAuto;
import com.essential.management.opinon.service.IOpinonAutoService;
import com.essential.utils.CommonResponseUtils;

/**
 * 意见反馈
 * 
 * @author czm
 *
 */
@Controller
@RequestMapping(value = "opinonAutoController")
public class OpinonAutoController {
	private static Logger logger = LoggerFactory.getLogger(OpinonAutoController.class);

	@Autowired
	IOpinonAutoService opinonAutoService;

	/**
	 * 添加意见信息
	 * 
	 * @param oinonAuto
	 * @return
	 */
	@RequestMapping(value = "addOpinion")
	@ResponseBody
	public Map<String, Object> addOpinion(OpinonAuto opinonAuto) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return opinonAutoService.addOpinion(opinonAuto);
		} catch (Exception e) {
			logger.info("====>>>>添加意见信息失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("提交失败!"));
		}
		return map;
	}

	/**
	 * 更新意见
	 * 
	 * @param oinonAuto
	 * @return
	 */
	@RequestMapping(value = "updateOpinion")
	@ResponseBody
	public Map<String, Object> updateOpinion(OpinonAuto opinonAuto) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return opinonAutoService.updateOpinion(opinonAuto);
		} catch (Exception e) {
			logger.info("====>>>>更新意见信息失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("更新意见信息失败!"));
		}
		return map;
	}

	/**
	 * 删除意见
	 * 
	 * @param oinonAuto
	 * @return
	 */
	@RequestMapping(value = "deleteOpinion")
	@ResponseBody
	public Map<String, Object> deleteOpinion(OpinonAuto opinonAuto) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return opinonAutoService.deleteOpinion(opinonAuto);
		} catch (Exception e) {
			logger.info("====>>>>删除意见信息失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("删除意见信息失败!"));
		}
		return map;
	}

	/**
	 * 查询意见列表
	 * 
	 * @param oinonAuto
	 * @return
	 */
	@RequestMapping(value = "queryOpinion")
	@ResponseBody
	public Map<String, Object> queryOpinion(Integer pageIndex, Integer pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			return opinonAutoService.queryOpinion(pageIndex,pageSize);
		} catch (Exception e) {
			logger.info("====>>>>查询意见信息失败:" + e);
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("查询意见信息失败!"));
		}
		return map;
	}
}
