package com.essential.bussiness.address.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.bussiness.address.model.auto.ProvinceAuto;
import com.essential.bussiness.address.service.IProvinceService;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.TmDateUtil;
import com.essential.common.utils.WebUtils;
import com.essential.utils.CommonResponseUtils;

/**
 * ProvinceController
 * @author Jaelyn
 *
 */
@Controller
@RequestMapping(value="province")
public class ProvinceController {

	@Autowired
	@Qualifier("provinceServiceImpl")
	private IProvinceService provinceServiceImpl;
	
	
	/**
	 * 查询所有省市区
	 * @param request
	 * @return
	 */
	@RequestMapping(value="queryAreaList")
	@ResponseBody
	public Map<String,Object> queryAreaList(HttpServletRequest request){
		try {
			Map<String,Object> requstMap=WebUtils.getParameterMap(request);
			return provinceServiceImpl.queryAreaList(requstMap);
			
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}
		
	}
	
	/**
	 * 查询所有省
	 * @param request
	 * @return
	 */
	@RequestMapping(value="queryProvinceList")
	@ResponseBody
	public Map<String,Object> queryProvinceList(HttpServletRequest request){
		try {
			Map<String,Object> requstMap=WebUtils.getParameterMap(request);
			return provinceServiceImpl.queryProvinceList(requstMap);
			
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}
		
	}
	
	/**
	 * 新增省
	 * @param Province
	 * @return
	 */
	@RequestMapping(value="saveProvince")
	@ResponseBody
	public Map<String,Object> saveProvince(ProvinceAuto province){
		try {
			province.setCreateTime(TmDateUtil.getTimeStamp());
			province.setModifyTime(TmDateUtil.getTimeStamp());
			province.setModifyUserId(province.getCreateUserId());
			province.setIsDelete(SUConstants.IS_NOT_DELETE);
			return provinceServiceImpl.saveProvince(province);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}

		

	}

	/**
	 * update Province
	 * 
	 * @param Province
	 * @return
	 */
	@RequestMapping(value="updateProvince")
	@ResponseBody
	public Map<String, Object> updateProvince(ProvinceAuto province){
		try {
			province.setModifyTime(TmDateUtil.getTimeStamp());
			return provinceServiceImpl.updateProvince(province);

		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}
	}

	/**
	 * delete Province
	 * 
	 * @param Province
	 *            更新后的评论信息
	 * @return
	 */
	@RequestMapping(value="deleteProvince")
	@ResponseBody
	public 	Map<String, Object> deleteProvince(ProvinceAuto province){
		try {
			province.setModifyTime(TmDateUtil.getTimeStamp());
			province.setIsDelete(SUConstants.IS_DELETE);
			return provinceServiceImpl.deleteProvince(province);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}

	}

	/**
	 * select by provinceId
	 * 
	 * @param provinceId
	 * @return
	 */
	@RequestMapping(value="queryProvinceById")
	@ResponseBody
	public Map<String, Object> queryProvinceById(long provinceId) {
		try {
			return provinceServiceImpl.queryProvinceById(provinceId);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}

	}
	
}
