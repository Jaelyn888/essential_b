package com.essential.bussiness.product.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.bussiness.product.dao.ProductCategoryAutoMapper;
import com.essential.bussiness.product.dao.ProductTypeAutoMapper;
import com.essential.bussiness.product.model.auto.ProductCategoryAuto;
import com.essential.bussiness.product.model.auto.ProductTypeAuto;
import com.essential.bussiness.product.service.IProductCategoryService;
import com.essential.common.constants.SUConstants;
import com.essential.utils.CommonResponseUtils;

/**
 * 商品品类service
 * @author essential-gfs
 *
 */
@Service
public class ProductCategoryServiceImpl implements IProductCategoryService {

	private static Logger logger = LoggerFactory.getLogger(ProductCategoryServiceImpl.class);
	
	//装配商品品类dao
	@Autowired
	private ProductCategoryAutoMapper productCategoryDao;
	@Autowired
	private ProductTypeAutoMapper   productTypeAutoMapper;
	
	/**
	 * 新增商品品类信息
	 */
	@Override
	public Map<String,Object> saveProductCategory(ProductCategoryAuto productCategoryModel) {
		
		try {
			
			int i = productCategoryDao.insert(productCategoryModel);
			if(i>0){
				return CommonResponseUtils.successResponse();
			}
			
			return CommonResponseUtils.failureResponse("新增商品品类失败");
		} catch (Exception e) {
			logger.info("=============>>>>>>新增商品品类失败");
			throw new RuntimeException(e);
		}
		
	}


	/**
	 * 修改商品品类信息
	 */
	@Override
	public Map<String,Object> updateProductCategory(ProductCategoryAuto productCategoryModel) {
		
		try {
			int i = productCategoryDao.updateByPrimaryKeySelective(productCategoryModel);
			if(i>0){
				return CommonResponseUtils.successResponse();
			}
			
			return CommonResponseUtils.failureResponse("修改商品品类失败");
		} catch (Exception e) {
			logger.info("=============>>>>>>修改商品品类失败:");
			throw new RuntimeException(e);
		}
		
	}

	/**
	 * 查询商品品类信息
	 */
	@Override
	public Map<String,Object> queryProductCategoryForList(ProductCategoryAuto productCategoryModel) {
		Map<String,Object> productCategoryMap = new HashMap<String, Object>();
		List<ProductCategoryAuto> productCategoryList = new ArrayList<ProductCategoryAuto>();
		
		try {
			productCategoryList = productCategoryDao.queryForList(productCategoryModel);
			productCategoryMap.put(SUConstants.CODE_KEY, SUConstants.CODE_SUCCESS_VALUE);
			productCategoryMap.put(SUConstants.MSG_KEY, SUConstants.MSG_SUCCESS_VALUE);
			productCategoryMap.put("info", productCategoryList);
		} catch (Exception e) {
			logger.info("=============>>>>>>查询商品品类失败:",e);
			productCategoryMap.put(SUConstants.CODE_KEY, SUConstants.CODE_FAIL_VALUE);
			productCategoryMap.put(SUConstants.MSG_KEY, "查询商品品类失败");
			e.printStackTrace();
		}
		
		return productCategoryMap;
	}

//插入大分类和小分类
	@Override
	public Map<String, Object> saveCategoryAndType(String categoryName,String typeName,String path) throws RuntimeException {
		
		try {
			
			ProductCategoryAuto productCategoryAuto=new ProductCategoryAuto();
			//小分类实体类
			ProductTypeAuto productTypeAuto=new ProductTypeAuto();
			
			productCategoryAuto.setIsDeleted(SUConstants.IS_NOT_DELETE);
			
			productCategoryAuto.setCategoryName(categoryName);
			productCategoryAuto.setPic(path);
			
			//如果大分类插入成功
			if(productCategoryDao.insertSelective(productCategoryAuto)>0)
			{
				//得到第一次插入的id
				
				productTypeAuto.setCategoryId(productCategoryAuto.getCategoryId());
				productTypeAuto.setIsDeleted(SUConstants.IS_NOT_DELETE);
				productTypeAuto.setProductypeName(typeName);
				
				if(productTypeAutoMapper.insert(productTypeAuto)>0)
				{
					
					
					return CommonResponseUtils.successResponse();
					
				}
				
				
				
			}
			
		} catch (Exception e) {
			   logger.info("插入大分类和小分类");
			   throw new RuntimeException(e);
			
			
		}
		//大分类实体类
		
		return CommonResponseUtils.failureResponse("插入大小分类失败");	
		
		
  }
	

	
	
}