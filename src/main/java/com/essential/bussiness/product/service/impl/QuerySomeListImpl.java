package com.essential.bussiness.product.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.bussiness.brand.dao.BrandAutoMapper;
import com.essential.bussiness.brand.model.auto.BrandAuto;
import com.essential.bussiness.product.dao.ProductCategoryAutoMapper;
import com.essential.bussiness.product.model.auto.ProductCategoryAuto;
import com.essential.bussiness.product.service.IQuerySomeList;
import com.essential.bussiness.shop.dao.ShopAutoMapper;
import com.essential.bussiness.shop.model.auto.ShopAuto;
import com.essential.common.constants.SUConstants;
import com.essential.utils.CommonResponseUtils;

@Service
public class QuerySomeListImpl implements IQuerySomeList {
	private Logger logger = LoggerFactory.getLogger(QuerySomeListImpl.class);

	@Autowired
	BrandAutoMapper brandAutoMapper;

	@Autowired
	ProductCategoryAutoMapper productCategoryAutoMapper;

	@Autowired
	ShopAutoMapper shopAutoMapper;

	/**
	 * 商品分类列表
	 */
	@Override
	public Map<String, Object> queryCategoryList() {
		Map<String, Object> map = new HashMap<String, Object>();
//		List<Map<String, Object>> categoryList = new ArrayList<Map<String,Object>>();
		try {
			ProductCategoryAuto productCategoryAuto = new ProductCategoryAuto();
			productCategoryAuto.setIsDeleted(SUConstants.IS_NOT_DELETE);
			List<ProductCategoryAuto> productCategoryList = productCategoryAutoMapper.queryForList(productCategoryAuto);
			map.putAll(CommonResponseUtils.successResponse(productCategoryList));
			return map;
		} catch (Exception e) {
			logger.info("====>>>>>:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 商品品牌列表
	 */
	@Override
	public Map<String, Object> queryBrandList() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			BrandAuto brandAuto = new BrandAuto();
			brandAuto.setStatus(1);
			List<BrandAuto> brandList = brandAutoMapper.queryAllBrand(brandAuto);
			map.putAll(CommonResponseUtils.successResponse(brandList));
			return map;
		} catch (Exception e) {
			logger.info("====>>>>>:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 商家列表
	 */
	@Override
	public Map<String, Object> queryShopList() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ShopAuto shopAuto = new ShopAuto();
			shopAuto.setStatus(SUConstants.IS_NOT_DELETE);
			List<ShopAuto> shopList = shopAutoMapper.queryShop(shopAuto);
			map.putAll(CommonResponseUtils.successResponse(shopList));
			return map;
		} catch (Exception e) {
			logger.info("====>>>>>商家列表查询失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
