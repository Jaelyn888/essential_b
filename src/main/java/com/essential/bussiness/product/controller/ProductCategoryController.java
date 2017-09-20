package com.essential.bussiness.product.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.essential.bussiness.product.model.auto.ProductCategoryAuto;
import com.essential.bussiness.product.service.IProductCategoryService;
import com.essential.bussiness.product.service.IProductTypeService;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.TmDateUtil;
import com.essential.utils.CommonResponseUtils;

/**
 * 商品品类
 * @author essential-gfs
 *
 */
@Controller
@RequestMapping(value="productCategory")
public class ProductCategoryController {
	private Logger logger = LoggerFactory.getLogger(ProductCategoryController.class);

	//装配商品品类service
	@Autowired
	IProductCategoryService productCategoryService;
	@Autowired 
	IProductTypeService iProductTypeService;
	
	/**
	 * 新增商品品类
	 * @param model
	 * @return
	 */
	@RequestMapping(value="add")
	@ResponseBody
	public Map<String,Object> saveProductCategory(ProductCategoryAuto productCategoryModel){
		try {
			String nowDate = TmDateUtil.getTimeStamp();
			productCategoryModel.setCreateTime(nowDate);
			productCategoryModel.setModifyTime(nowDate);
			productCategoryModel.setIsDeleted(SUConstants.IS_NOT_DELETE);
			return productCategoryService.saveProductCategory(productCategoryModel);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("新增商品品类失败");
		}
	}
	
	/**
	 * 删除商品品类(逻辑删除)
	 * @param categoryId
	 * @return
	 */
	@RequestMapping(value="delete")
	@ResponseBody
	public Map<String,Object> deleteProductCategory(Long categoryId){
		try {
			ProductCategoryAuto productCategoryModel = new ProductCategoryAuto();
			
			productCategoryModel.setModifyTime(TmDateUtil.getTimeStamp());
			productCategoryModel.setCategoryId(categoryId);
			productCategoryModel.setIsDeleted(SUConstants.IS_DELETE);
			
			return productCategoryService.updateProductCategory(productCategoryModel);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("删除商品品类");
		}
	}
	
	/**
	 * 更新商品品类信息
	 * @param model
	 * @return
	 */
	@RequestMapping(value="update")
	@ResponseBody
	public Map<String,Object> updateProductCategory(ProductCategoryAuto productCategoryModel){
		try {
			productCategoryModel.setModifyTime(TmDateUtil.getTimeStamp());
			return productCategoryService.updateProductCategory(productCategoryModel);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("更新商品品类失败");
		}
	}
	
	/**
	 *  查询商品品类
	 * @param model
	 * @return
	 */
	@RequestMapping(value="query")
	@ResponseBody
	public Map<String,Object> queryProductCategory(ProductCategoryAuto productCategoryModel){
		productCategoryModel.setIsDeleted(SUConstants.IS_NOT_DELETE);
		return productCategoryService.queryProductCategoryForList(productCategoryModel);
	}
	
	/**
	 * 插入大分类和小分类
	 * @return
	 */
	@RequestMapping(value="saveCategoryAndType")
	@ResponseBody
	public Map<String,Object> saveCategoryAndTypes(String categoryName,String typeName,String path){
		try {
			return productCategoryService.saveCategoryAndType(categoryName, typeName,path);
			
		} catch (Exception e) {
			logger.info("插入大分类小分类失败");
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("插入小分类大分类失败");
			
		}
		
	}
	
	@RequestMapping(value="modifyCategory")
	@ResponseBody
	public Map<String,Object> modifyCategory(ProductCategoryAuto productCategoryAuto){
		try {
			return iProductTypeService.modifyCategoryImage(productCategoryAuto);
		} catch (Exception e) {
			logger.info("修改商品品类失败");
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("修改商品品类失败");
			
		}
	}
}
