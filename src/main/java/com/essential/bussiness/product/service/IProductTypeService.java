package com.essential.bussiness.product.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.bussiness.product.model.auto.ProductCategoryAuto;
import com.essential.bussiness.product.model.auto.ProductTypeAuto;

/**
 * 商品分类
 * 
 * @author essential-gfs
 *
 */
@Service
public interface IProductTypeService {

	public Map<String, Object> saveProductType(ProductTypeAuto productTypeModel);

	public Map<String, Object> updateProductType(
			ProductTypeAuto productTypeModel);

	public Map<String, Object> queryProductTypeForList(
			ProductTypeAuto productTypeModel);

	// 查询大分类和小分类列表
	public Map<String, Object> queryCategoryProuductTypeList();
	//修改大分类的图片
	public Map<String,Object> modifyCategoryImage(ProductCategoryAuto productCategoryAuto);
}
