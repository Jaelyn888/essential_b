package com.essential.bussiness.freighttemplate.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.essential.bussiness.freighttemplate.model.auto.FreightGroupNameAuto;
import com.essential.bussiness.freighttemplate.model.vo.FreightGroupNameVo;
import com.essential.bussiness.freighttemplate.service.IFreightTemplateService;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.StringCommonUtils;
import com.essential.common.utils.TmDateUtil;
import com.essential.common.utils.WebUtils;
import com.essential.user.model.vo.UserReceiptAddressVo;
import com.essential.utils.CommonResponseUtils;

/**
 * 运费模板基本信息
 * @author Jaelyn
 *
 */
@Controller
@RequestMapping(value="freightTemplate")
public class FreightTemplateController {
	
	@Autowired
	@Qualifier("freightTemplateServiceImpl")
	private IFreightTemplateService freightTemplateServiceImpl;
	
	@RequestMapping(value="index")
	public ModelAndView index(){
		return new ModelAndView("demo/demo_freight_template");
	}
	
	/**
	 * 根据页码分页
	 */
	@RequestMapping(value="saveOrUpdateFreightTemplateAndGroup")
	@ResponseBody
	public Map<String, Object> saveOrUpdateFreightTemplateAndGroup(FreightGroupNameAuto freightGroupNameAuto) {
		try {
			
			return freightTemplateServiceImpl.saveOrUpdateFreightTemplateAndGroup(freightGroupNameAuto);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}

	}
	/**
	 * 根据店铺id 查询运费模板
	 * 
	 * @param freightGroupNameAuto
	 * @return
	 */
	
	@RequestMapping(value="deleteFreightGroup")
	@ResponseBody
	public HashMap<String, Object> deleteFreightGroup(FreightGroupNameAuto freightGroupNameAuto) {
		try {
			return freightTemplateServiceImpl.deleteFreightGroupList(freightGroupNameAuto);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("删除失败");
		}
	}
	/**
	 * 查询运费 模板分组
	 * @param request
	 * @return
	 */
	@RequestMapping(value="queryFreightGroupList")
	@ResponseBody
	public Map<String, Object> queryFreightGroupList(HttpServletRequest request) {
		try {
			Map<String,Object> requstMap=WebUtils.getParameterMap(request);
			List<FreightGroupNameVo> freightGroupNameVoList =freightTemplateServiceImpl.queryFreightGroupList(requstMap);
			return CommonResponseUtils.successResponse(freightGroupNameVoList);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}
	}
	
	/**
	 * 查询运费模板
	 * @param request
	 * @return
	 */
	@RequestMapping(value="queryFreightTemplateList")
	@ResponseBody
	public Map<String, Object> queryFreightTemplateList(HttpServletRequest request) {
		try {
			Map<String,Object> requstMap=WebUtils.getParameterMap(request);
			return freightTemplateServiceImpl.queryFreightTemplateList(requstMap);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}
	}
	
	/**
	 * 查询运费价格
	 * @param userReceiptAddressVo
	 * @return
	 */
	@RequestMapping(value="queryFreightByAddressId")
	@ResponseBody
	public Map<String,Object> queryFreightByAddressId(@RequestBody UserReceiptAddressVo userReceiptAddressVo){
		try {
			if(userReceiptAddressVo==null){
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			Long userId=userReceiptAddressVo.getUserId();
			Long provinceId=userReceiptAddressVo.getProvinceId();
			Long cityId=userReceiptAddressVo.getCityId();
			Long districtId=userReceiptAddressVo.getDistrictId();
			if(StringCommonUtils.isInvalidateId(userId)||StringCommonUtils.isInvalidateId(provinceId)||StringCommonUtils.isInvalidateId(cityId)||StringCommonUtils.isInvalidateId(districtId)){
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			return freightTemplateServiceImpl.queryFreightByAddressId(userReceiptAddressVo);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}
	}
}
