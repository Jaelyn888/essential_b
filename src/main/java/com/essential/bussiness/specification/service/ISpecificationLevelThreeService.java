package com.essential.bussiness.specification.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.bussiness.specification.model.auto.SpecificationLevelThreeAuto;
/**
 * 
 * @author cpx
 * 规格三级业务
 *
 */
@Service
public interface ISpecificationLevelThreeService {
	/**
	 * 
	 * @param specificationLevelThreeAuto
	 * @return
	 * specificationLevelThreeAuto  三级业务实体
	 * add 增加三级规格
	 * delete 删除三级规格
	 * update修改三级规格
	 * query查询三级规格
	 */
	public Map<String,Object> add(SpecificationLevelThreeAuto specificationLevelThreeAuto);
	
	public Map<String,Object>  delete(SpecificationLevelThreeAuto specificationLevelThreeAuto);
	
	public Map<String,Object>  update(SpecificationLevelThreeAuto specificationLevelThreeAuto);
	
	public Map<String,Object>  query(SpecificationLevelThreeAuto specificationLevelThreeAuto);
	
}
