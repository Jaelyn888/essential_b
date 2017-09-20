package com.essential.bussiness.product.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.bussiness.product.model.auto.ProductCategoryAuto;

/**
 * 商品品类接口
 * @author essential-gfs
 *
 */
@Service
public interface IProductCategoryService {

	public Map<String,Object> saveProductCategory(ProductCategoryAuto productCategoryModel);
	
	public Map<String,Object> updateProductCategory(ProductCategoryAuto productCategoryModel);
	
	public Map<String,Object> queryProductCategoryForList(ProductCategoryAuto productCategoryModel);
	public Map<String,Object> saveCategoryAndType(String categoryName,String typeName,String path);
}
