package com.essential.bussiness.specification.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.bussiness.specification.model.auto.SpecificationLevelTwoAuto;
import com.essential.bussiness.specification.service.ISpecificationLevelTwoService;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.TmDateUtil;


/**
 * 二级规格
 * @author gfs
 *
 */
@Controller
@RequestMapping(value="SpecificationLevelTwo")
public class SpecificationLevelTwoComtroller {
	
	//加载二级规格service
	@Autowired
	@Qualifier("specificationLevelTwoServiceImpl")
	ISpecificationLevelTwoService specificationLevelTwoService;
	
	/**
	 * 新增二级规格
	 * @param model
	 * @return
	 */
	@RequestMapping(value="add")
	@ResponseBody
	public Map<String,Object> saveSpecificationLevelTwo(SpecificationLevelTwoAuto specificationLevelTwoModel){
		String nowDate = TmDateUtil.getTimeStamp();
		specificationLevelTwoModel.setCreateTime(nowDate);
		specificationLevelTwoModel.setModifyTime(nowDate);
		specificationLevelTwoModel.setIsDeleted(SUConstants.IS_NOT_DELETE);
		return specificationLevelTwoService.saveSpecificationLevelTwo(specificationLevelTwoModel);
			
	}
	
	/**
	 * 修改二级规格
	 * @param model
	 * @return
	 */
	@RequestMapping(value="update")
	@ResponseBody
	public Map<String,Object> updateSpecificationLevelTwo(SpecificationLevelTwoAuto specificationLevelTwoModel){
		specificationLevelTwoModel.setModifyTime(TmDateUtil.getTimeStamp());
		return specificationLevelTwoService.updateSpecificationLevelTwoById(specificationLevelTwoModel);
	}
	
	/**
	 * 通过二级规格ID删除规格
	 * @param specificationLevelTwoId
	 * @return
	 */
	@RequestMapping(value="delete")
	@ResponseBody
	public Map<String,Object> deleteSpecificationLevelTwo(String specificationLevelTwoId){
		Map<String,Object> specificationLevelTwoMap = new HashMap<String,Object>();
		SpecificationLevelTwoAuto specificationLevelTwoModel = new SpecificationLevelTwoAuto();
		
		try {
			specificationLevelTwoModel.setModifyTime(TmDateUtil.getTimeStamp());
			specificationLevelTwoModel.setSpecificationIdTwolevel(Long.valueOf(specificationLevelTwoId));
			specificationLevelTwoModel.setIsDeleted(SUConstants.IS_DELETE);
			specificationLevelTwoMap = specificationLevelTwoService.updateSpecificationLevelTwoById(specificationLevelTwoModel);
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return specificationLevelTwoMap;
	}
	
	
	/**
	 * 通过一级规格ID查询二级规格
	 * @param specificationLevelTwoId
	 * @return
	 */
	@RequestMapping(value="query")
	@ResponseBody
	public Map<String,Object> querySpecificationLevelTwo(SpecificationLevelTwoAuto specificationLevelTwoModel){
		
		return specificationLevelTwoService.querySpecificationLevelTwo(specificationLevelTwoModel);
	}
}
