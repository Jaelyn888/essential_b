package com.essential.bussiness.specification.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.bussiness.specification.dao.SpecificationLevelTwoAutoMapper;
import com.essential.bussiness.specification.model.auto.SpecificationLevelTwoAuto;
import com.essential.bussiness.specification.service.ISpecificationLevelTwoService;
import com.essential.common.constants.SUConstants;

/**
 * 二级规格
 * @author essential-gfs
 *
 */
@Service
public class SpecificationLevelTwoServiceImpl implements
		ISpecificationLevelTwoService {
	private static Logger logger = LoggerFactory.getLogger(SpecificationLevelTwoServiceImpl.class);
	
	//二级规格dao
	@Autowired
	SpecificationLevelTwoAutoMapper specificationLevelTwodao;
	
	/**
	 * 新增二级规格
	 */
	@Override
	public Map<String,Object> saveSpecificationLevelTwo(SpecificationLevelTwoAuto specificationLevelTwoAuto) {
		Map<String,Object> specificationLevelTwoMap = new HashMap<String,Object>();
		
		try {
			int i = specificationLevelTwodao.insert(specificationLevelTwoAuto);
			if(i>0){
				specificationLevelTwoMap.put(SUConstants.CODE_KEY, SUConstants.CODE_SUCCESS_VALUE);
				specificationLevelTwoMap.put(SUConstants.MSG_KEY, SUConstants.MSG_SUCCESS_VALUE);
				
				return specificationLevelTwoMap;
			}
		} catch (Exception e) {
			logger.info("=============>>>>>>新增二级规格失败:", e);
			e.printStackTrace();
		}
		
		specificationLevelTwoMap.put(SUConstants.CODE_KEY, SUConstants.CODE_FAIL_VALUE);
		specificationLevelTwoMap.put(SUConstants.MSG_KEY, "新增二级规格失败");
		
		return specificationLevelTwoMap;
	}

	/**
	 * 修改二级规格信息
	 */
	@Override
	public Map<String,Object> updateSpecificationLevelTwoById(
			SpecificationLevelTwoAuto specificationLevelTwoModel) {
		Map<String,Object> specificationLevelTwoMap = new HashMap<String,Object>();
		
		if(specificationLevelTwoModel.getSpecificationIdTwolevel()==null){
			specificationLevelTwoMap.put(SUConstants.MSG_KEY, "二级规格ID为空,修改二级规格信息失败");
			specificationLevelTwoMap.put(SUConstants.CODE_KEY, SUConstants.CODE_FAIL_VALUE);
			
			return specificationLevelTwoMap;
		}
		
		try {
			int i = specificationLevelTwodao.updateByPrimaryKeySelective(specificationLevelTwoModel);
			if(i>0){
				specificationLevelTwoMap.put(SUConstants.MSG_KEY, SUConstants.MSG_SUCCESS_VALUE);
				specificationLevelTwoMap.put(SUConstants.CODE_KEY, SUConstants.CODE_SUCCESS_VALUE);
				
				return specificationLevelTwoMap;
			}
			
		} catch (Exception e) {
			logger.info("=============>>>>>>修改二级规格信息失败:", e);
			e.printStackTrace();
		}
		
		specificationLevelTwoMap.put(SUConstants.MSG_KEY, "修改二级规格信息失败");
		specificationLevelTwoMap.put(SUConstants.CODE_KEY, SUConstants.CODE_FAIL_VALUE);
		
		return specificationLevelTwoMap;
	}


	/**
	 * 查询二级规格
	 */
	@Override
	public Map<String, Object> querySpecificationLevelTwo(SpecificationLevelTwoAuto specificationLevelTwoAuto) {
		Map<String,Object> specificationLevelTwoMap = new HashMap<String,Object>();
		List<SpecificationLevelTwoAuto> specificationLevelTwoList = new ArrayList<SpecificationLevelTwoAuto>();
		
		try {
			
			specificationLevelTwoList = specificationLevelTwodao.queryList(specificationLevelTwoAuto);
			
			specificationLevelTwoMap.put(SUConstants.MSG_KEY, SUConstants.MSG_SUCCESS_VALUE);
			specificationLevelTwoMap.put(SUConstants.CODE_KEY, SUConstants.CODE_SUCCESS_VALUE);
			specificationLevelTwoMap.put("info", specificationLevelTwoList);
			
		} catch (Exception e) {
			logger.info("=============>>>>>>查询二级规格失败:", e);
			
			specificationLevelTwoMap.put(SUConstants.MSG_KEY, "查询二级规格失败");
			specificationLevelTwoMap.put(SUConstants.CODE_KEY, SUConstants.CODE_FAIL_VALUE);
			
			e.printStackTrace();
		}
		
		return specificationLevelTwoMap;
	}

}
