package com.essential.bussiness.specification.controller;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.essential.bussiness.specification.model.auto.SpecificationLevelThreeAuto;
import com.essential.bussiness.specification.service.ISpecificationLevelThreeService;

/**
 * 
 * @author cpx 三级规格业务
 *
 */

@Controller
@RequestMapping(value = "SpecificationLevelThree")
public class SpecificationLevelThreeController {

	@Autowired
	ISpecificationLevelThreeService specificationLevelThreeService;

	/**
	 * 增加一个三级分类的实体
	 * 
	 * @param specificationLevelThreeAuto
	 *            规格三级的实体
	 * @return
	 */
	@RequestMapping(value = "add")
	@ResponseBody
	public  Map<String,Object> addSpecificationLevelThree(
			SpecificationLevelThreeAuto specificationLevelThreeAuto) {
		return specificationLevelThreeService.add(specificationLevelThreeAuto);
	}

	/**
	 * 删除三级规格逻辑删除通过id
	 * 
	 * @param specificationLevelThreeAuto
	 *            三级规格实体
	 * @return
	 */

	@RequestMapping(value = "delete")
	@ResponseBody
	public  Map<String,Object> deteleSpecificationLevelThree(
			SpecificationLevelThreeAuto specificationLevelThreeAuto) {
		return  specificationLevelThreeService.delete(specificationLevelThreeAuto);

	}

	/**
	 * 更新一条三级规格的数据通过三级规格id
	 * 
	 * @param specificationLevelThreeAuto
	 *            三级规格实体
	 * @return
	 */
	// 更新一条数据 通过 specificationLevelThreeAuto传入的实体
	@RequestMapping(value = "update")
	@ResponseBody
	public  Map<String,Object> updateSpecificationLevelThree(
			SpecificationLevelThreeAuto specificationLevelThreeAuto) {	
		return specificationLevelThreeService.update(specificationLevelThreeAuto);

	}

	/**
	 * 查询一条数据 通过 通过 oneid一级id specification_id和二级id 从表三级规格表
	 * 
	 * @param specificationLevelThreeAuto
	 *            三级规格实体
	 * @return
	 */

	@RequestMapping(value = "query")
	@ResponseBody
	public  Map<String,Object> querySpecificationLevelThree(
			SpecificationLevelThreeAuto specificationLevelThreeAuto) {		 
		return specificationLevelThreeService.query(specificationLevelThreeAuto);
	}

}
