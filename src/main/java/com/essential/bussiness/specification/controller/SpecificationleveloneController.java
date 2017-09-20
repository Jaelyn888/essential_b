package com.essential.bussiness.specification.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.bussiness.product.dao.ProductSkuAutoMapper;
import com.essential.bussiness.specification.model.auto.SpecificationleveloneAuto;
import com.essential.bussiness.specification.service.SpecificationLeveloneService;

/**
 * 
 * @author gty 一级规格键的业务
 *
 */
@Controller
@RequestMapping(value = "specificationlevelone")
public class SpecificationleveloneController {
	@Autowired
	SpecificationLeveloneService specificationLeveloneService;
	ProductSkuAutoMapper productSkuAutoMapper;
	
	/**
	 * 新增一级规格
	 * @param specificationleveloneauto 一级业务实体
	 * @return
	 */
	@RequestMapping(value = "insert")
	@ResponseBody
	public Map<String,Object> add(SpecificationleveloneAuto specificationLeveloneAuto) {

		return specificationLeveloneService.insertSpecificationLevelone(specificationLeveloneAuto);

	}
/**
 * 更新一级规格
 * @param specificationleveloneAuto 一级规格实体
 * @return
 */
	
	@RequestMapping(value = "updateById")
	@ResponseBody
	public Map<String,Object> updateById(SpecificationleveloneAuto specificationLeveloneAuto) {
		
		return specificationLeveloneService	.updateById(specificationLeveloneAuto);

	}
/**删除一级规格逻辑删除
 * 
 * @param specificationleveloneAuto 一级规格实体
 * @return
 */
	
	@RequestMapping(value = "deteleById")
	@ResponseBody
	public  Map<String,Object> deteleById(SpecificationleveloneAuto specificationLeveloneAuto) {
		
		return specificationLeveloneService.deleteById(specificationLeveloneAuto);

	}
/**查询一级规格数据返回为list
 * 
 * @param specificationleveloneAutoid 一级规格实体
 * @return
 */
	@RequestMapping(value = "query")
	@ResponseBody
	public  Map<String,Object> query(SpecificationleveloneAuto specificationLeveloneAuto) {
		
		
		return specificationLeveloneService.query(specificationLeveloneAuto);

	}
	@RequestMapping(value = "querySpecification")
	@ResponseBody
	public  Map<String,Object> query(@RequestParam(value="productId") Long productId) {
		
		
		System.out.print(productId);
		return specificationLeveloneService.querySpecification(productId);
	}
	}

