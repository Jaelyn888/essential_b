package com.essential.bussiness.specification.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.bussiness.specification.model.auto.SpecificationLevelTwoAuto;

/**
 * 二级规格
 * @author essential-gfs
 *
 */
@Service
public interface ISpecificationLevelTwoService {
	public Map<String,Object> saveSpecificationLevelTwo(SpecificationLevelTwoAuto specificationLevelTwoAuto);
	
	public Map<String,Object> updateSpecificationLevelTwoById(SpecificationLevelTwoAuto specificationLevelTwoAuto);
	
	public Map<String,Object> querySpecificationLevelTwo(SpecificationLevelTwoAuto specificationLevelTwoAuto);
}
