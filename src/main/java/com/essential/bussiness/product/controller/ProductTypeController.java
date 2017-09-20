package com.essential.bussiness.product.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.bussiness.product.model.auto.ProductTypeAuto;
import com.essential.bussiness.product.service.IProductTypeService;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.TmDateUtil;
import com.essential.utils.CommonResponseUtils;

/**
 * 商品分类
 * @author essential-gfs
 *
 */
@Controller
@RequestMapping(value="productType")
public class ProductTypeController {
private Logger logger=LoggerFactory.getLogger(ProductTypeController.class);
	//装配商品分类业务service
	@Autowired
	IProductTypeService productTypeService;
	
	/**
	 * 新增商品分类
	 * @param model
	 * @return
	 */
	@RequestMapping(value="add")
	@ResponseBody
	public Map<String,Object> saveProdctType(ProductTypeAuto productTypeModel){
		String nowDate = TmDateUtil.getTimeStamp();
		productTypeModel.setCreateTime(nowDate);
		productTypeModel.setModifyTime(nowDate);
		productTypeModel.setIsDeleted(SUConstants.IS_NOT_DELETE);
		return productTypeService.saveProductType(productTypeModel);
	}
	
	/**
	 * 删除商品分类(逻辑删除)
	 * @param productTypeId
	 * @return
	 */
	@RequestMapping(value="delete")
	@ResponseBody
	public Map<String,Object> deleteProductType(Long productTypeId){
		ProductTypeAuto productTypeModel = new ProductTypeAuto();
		
		productTypeModel.setModifyTime(TmDateUtil.getTimeStamp());
		productTypeModel.setProductTypeId(productTypeId);
		productTypeModel.setIsDeleted(SUConstants.IS_DELETE);
		
		return productTypeService.updateProductType(productTypeModel);
	}
	
	/**
	 * 更新商品分类信息
	 * @param model
	 * @return
	 */
	@RequestMapping(value="update")
	@ResponseBody
	public Map<String,Object> updateProductType(ProductTypeAuto productTypeModel){
		productTypeModel.setModifyTime(TmDateUtil.getTimeStamp());
		return productTypeService.updateProductType(productTypeModel);
	}
	
	/**
	 * 查询商品分类信息
	 * @param model
	 * @return
	 */
	@RequestMapping(value="query")
	@ResponseBody
	public Map<String,Object> queryProductType(ProductTypeAuto productTypeModel){
		try {
			
			return productTypeService.queryProductTypeForList(productTypeModel);
			
		} catch (Exception e) {
			logger.info("查询商品分类信息失败");
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("查询商品分类信息失败");
			
		}
		
	}
	
	
	
	/**
	 * 
	 * @param 查询大分类和小分类的列表
	 * @return
	 */
	@RequestMapping(value="queryCategoryTypeList")
	@ResponseBody
	public Map<String,Object> queryProductType(){
		try {
			return productTypeService.queryCategoryProuductTypeList();
			
		} catch (Exception e) {
			logger.info("查询大分类和小分类列表失败");
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("查询大分类和小分类的列表失败");
			
			
		}
		
	}
	
	
}
