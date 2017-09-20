package com.essential.bussiness.address.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.bussiness.address.model.auto.DistrictAuto;
import com.essential.bussiness.address.service.IDistrictService;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.TmDateUtil;
import com.essential.common.utils.WebUtils;
import com.essential.utils.CommonResponseUtils;

/**
 * DistrictController
 * @author Jaelyn
 *
 */
@Controller
@RequestMapping(value="district")
public class DistrictController {

	@Autowired
	@Qualifier("districtServiceImpl")
	private IDistrictService districtServiceImpl;
	
	/**
	 * 查询所有区、县
	 * @param request
	 * @return
	 */
	@RequestMapping(value="queryDistrictListByParentId")
	@ResponseBody
	public Map<String,Object> queryDistrictListByParentId(DistrictAuto districtAuto,HttpServletRequest request){
		try {
			//Map<String,Object> requstMap=WebUtils.getParameterMap(request);
			return districtServiceImpl.queryDistrictVoListByParentId(districtAuto);
			
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}
		
	}
	
	/**
	 * 新增区、县
	 * @param District
	 * @return
	 */
	@RequestMapping(value="saveDistrict")
	@ResponseBody
	public Map<String,Object> saveDistrict(DistrictAuto district){
		try {
			district.setCreateTime(TmDateUtil.getTimeStamp());
			district.setModifyTime(TmDateUtil.getTimeStamp());
			district.setModifyUserId(district.getCreateUserId());
			district.setIsDelete(SUConstants.IS_NOT_DELETE);
			return districtServiceImpl.saveDistrict(district);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}

		

	}

	/**
	 * update District
	 * 
	 * @param District
	 * @return
	 */
	@RequestMapping(value="updateDistrict")
	@ResponseBody
	public Map<String, Object> updateDistrict(DistrictAuto district){
		try {
			district.setModifyTime(TmDateUtil.getTimeStamp());
			return districtServiceImpl.updateDistrict(district);

		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}
	}

	/**
	 * delete District
	 * 
	 * @param District
	 *            更新后的评论信息
	 * @return
	 */
	@RequestMapping(value="deleteDistrict")
	@ResponseBody
	public 	Map<String, Object> deleteDistrict(DistrictAuto district){
		try {
			district.setModifyTime(TmDateUtil.getTimeStamp());
			district.setIsDelete(SUConstants.IS_DELETE);
			return districtServiceImpl.deleteDistrict(district);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}

	}

	/**
	 * select by DistrictId
	 * 
	 * @param DistrictId
	 * @return
	 */
	@RequestMapping(value="queryDistrictById")
	@ResponseBody
	public Map<String, Object> queryDistrictById(long districtId) {
		try {
			return districtServiceImpl.queryDistrictById(districtId);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}

	}
	
}
