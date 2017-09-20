package com.essential.bussiness.address.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.bussiness.address.model.auto.CityAuto;
import com.essential.bussiness.address.service.ICityService;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.TmDateUtil;
import com.essential.common.utils.WebUtils;
import com.essential.utils.CommonResponseUtils;

/**
 * CityController
 * @author Jaelyn
 *
 */
@Controller
@RequestMapping(value="city")
public class CityController {

	@Autowired
	private ICityService cityService;
	
	/**
	 * 查询所有省
	 * @param request
	 * @return
	 */
	@RequestMapping(value="queryCityListByParentId")
	@ResponseBody
	public Map<String,Object> queryCityListByParentId(CityAuto cityAuto,HttpServletRequest request){
		try {
			return cityService.queryCityVoListByParentId(cityAuto);
			
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}
		
	}
	
	/**
	 * 新增省
	 * @param City
	 * @return
	 */
	@RequestMapping(value="saveCity")
	@ResponseBody
	public Map<String,Object> saveCity(CityAuto city){
		try {
			city.setCreateTime(TmDateUtil.getTimeStamp());
			city.setModifyTime(TmDateUtil.getTimeStamp());
			city.setModifyUserId(city.getCreateUserId());
			city.setIsDelete(SUConstants.IS_NOT_DELETE);
			return cityService.saveCity(city);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}

		

	}

	/**
	 * update City
	 * 
	 * @param City
	 * @return
	 */
	@RequestMapping(value="updateCity")
	@ResponseBody
	public Map<String, Object> updateCity(CityAuto city){
		try {
			city.setModifyTime(TmDateUtil.getTimeStamp());
			return cityService.updateCity(city);

		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}
	}

	/**
	 * delete City
	 * 
	 * @param City
	 *            更新后的评论信息
	 * @return
	 */
	@RequestMapping(value="deleteCity")
	@ResponseBody
	public 	Map<String, Object> deleteCity(CityAuto city){
		try {
			city.setModifyTime(TmDateUtil.getTimeStamp());
			city.setIsDelete(SUConstants.IS_DELETE);
			return cityService.deleteCity(city);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}

	}

	/**
	 * select by CityId
	 * 
	 * @param CityId
	 * @return
	 */
	@RequestMapping(value="queryById")
	@ResponseBody
	public Map<String, Object> queryByCityById(long cityId) {
		try {
			return cityService.selectCityById(cityId);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}

	}
	
}
