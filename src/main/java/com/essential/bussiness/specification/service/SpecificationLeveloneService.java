package com.essential.bussiness.specification.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.bussiness.specification.model.auto.SpecificationleveloneAuto;
/**
 * 一级规格业务
 * @author cpx
 *
 *SpecificationleveloneAuto 一级业务实体
 *
 *insertSpecificationLevelone 插入一级规格
 *updateById 修改一级规格
 *deleteById 删除一级规格
 *query 查询一级规格
 */
@Service
public interface SpecificationLeveloneService {
	public Map<String,Object> insertSpecificationLevelone(SpecificationleveloneAuto specificationleveloneauto);
	public Map<String,Object> updateById(SpecificationleveloneAuto specificationleveloneauto);
	public Map<String,Object> deleteById(SpecificationleveloneAuto  specificationLevelid);
	public  Map<String,Object> query(SpecificationleveloneAuto SpecificationLeveloneAuto);
	public  Map<String,Object> querySpecification(Long productId);
	

}
