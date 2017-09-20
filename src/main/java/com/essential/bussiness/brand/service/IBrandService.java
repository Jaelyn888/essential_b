package com.essential.bussiness.brand.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.bussiness.brand.model.auto.BrandAuto;
import com.essential.bussiness.brand.model.auto.ShopandbrandAuto;
import com.essential.bussiness.brand.model.vo.BrandVo;
import com.essential.bussiness.product.model.auto.ProductTypeAuto;

/**
 * 商品品牌
 * 
 * @author essential-gfs
 *
 */
@Service
public interface IBrandService {
	
	public Map<String, Object> queryTotalBrand(BrandVo brandVo);
	
	public Map<String, Object> queryTotalBrandForPage(BrandVo brandVo);

	public Map<String,Object> queryTotalBrandOrHotBrandForList(BrandAuto bussinessBrandModel,String requestType);
	
	public Map<String,Object> saveBussinessBrand(BrandAuto bussinessBrandModel,Long[] categoryIds);
	
	public Map<String,Object> updateBussinessBrand(BrandAuto bussinessBrandModel,Long[] categoryIds);
	
	public Map<String,Object> queryBussinessBrandByPrimaryKey(Long bussinessBrandModel);
	
	public Map<String,Object> queryBrandAndProductTypeForList(BrandAuto brandModel,ProductTypeAuto productTypeModel);
	//通过品牌id得到品牌的详情
	public Map<String,Object> queryBrandandProductList(BrandAuto bussinessBrandAuto,Integer pageIndex, Integer pageSize, Long userId);
	//根据shopId查询品牌list
	public Map<String,Object> queryBrandandList(Long shopId,Long pageIndex,Long checked,String brandName);
	
	public Map<String,Object> updateHotBrand(BrandAuto bussinessBrandModel);
	//通过shopId和categoryId得到品牌
	public Map<String,Object> queryBrandbyCategoryidShopId(Long shopId,Long categoryId);
	
	//品牌申请
	public Map<String,Object>brandApply(ShopandbrandAuto shopandbrandAuto);
	//品牌审核
	public Map<String,Object>brandAudit(ShopandbrandAuto shopandbrandAuto);
	
	
	
	
}
