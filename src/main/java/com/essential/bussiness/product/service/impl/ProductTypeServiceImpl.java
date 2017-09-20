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
import com.essential.bussiness.product.model.vo.CategoryTypeListVo;
import com.essential.bussiness.product.model.vo.ProductCategoryTypeListVo;
import com.essential.bussiness.product.model.vo.ProductTypeVo;
import com.essential.bussiness.product.service.IProductTypeService;
import com.essential.common.constants.SUConstants;
import com.essential.utils.CommonResponseUtils;

/**
 * 商品分类
 * 
 * @author essential-gfs
 *
 */
@Service
public class ProductTypeServiceImpl implements IProductTypeService {

	private static Logger logger = LoggerFactory
			.getLogger(ProductTypeServiceImpl.class);

	// 装配商品分类dao
	@Autowired
	ProductTypeAutoMapper productTypeDao;
	@Autowired
	ProductCategoryAutoMapper productCategoryAutoMapper;

	/**
	 * 新增商品分类信息
	 */
	@Override
	public Map<String, Object> saveProductType(ProductTypeAuto productTypeModel) {
		Map<String, Object> productTypeMap = new HashMap<String, Object>();

		try {
			int i = productTypeDao.insert(productTypeModel);
			if (i > 0) {
				productTypeMap.put(SUConstants.CODE_KEY,
						SUConstants.CODE_SUCCESS_VALUE);
				productTypeMap.put(SUConstants.MSG_KEY,
						SUConstants.MSG_SUCCESS_VALUE);

				return productTypeMap;
			}
		} catch (Exception e) {
			logger.info("=============>>>>>>新增商品分类失败");
			throw new RuntimeException(e);
		}
		productTypeMap.put(SUConstants.CODE_KEY, SUConstants.CODE_FAIL_VALUE);
		productTypeMap.put(SUConstants.MSG_KEY, "新增商品分类失败");

		return productTypeMap;
	}

	/**
	 * 修改商品分类信息
	 */
	@Override
	public Map<String, Object> updateProductType(
			ProductTypeAuto productTypeModel) {
		Map<String, Object> productTypeMap = new HashMap<String, Object>();

		try {
			int i = productTypeDao
					.updateByPrimaryKeySelective(productTypeModel);
			if (i > 0) {
				productTypeMap.put(SUConstants.CODE_KEY,
						SUConstants.CODE_SUCCESS_VALUE);
				productTypeMap.put(SUConstants.MSG_KEY,
						SUConstants.MSG_SUCCESS_VALUE);

				return productTypeMap;
			}
		} catch (Exception e) {
			logger.info("=============>>>>>>更新商品分类失败");
			throw new RuntimeException(e);
		}
		productTypeMap.put(SUConstants.CODE_KEY, SUConstants.CODE_FAIL_VALUE);
		productTypeMap.put(SUConstants.MSG_KEY, "更新商品分类失败");

		return productTypeMap;
	}

	/**
	 * 查询商户信息
	 */
	@Override
	public Map<String, Object> queryProductTypeForList(
			ProductTypeAuto productTypeModel) {
		Map<String, Object> productTypeMap = new HashMap<String, Object>();
		List<ProductTypeAuto> productTypeList = new ArrayList<ProductTypeAuto>();

		try {
			productTypeList = productTypeDao.queryForList(productTypeModel);
			productTypeMap.put(SUConstants.CODE_KEY,
					SUConstants.CODE_SUCCESS_VALUE);
			productTypeMap.put(SUConstants.MSG_KEY,
					SUConstants.MSG_SUCCESS_VALUE);
			productTypeMap.put("info", productTypeList);
		} catch (Exception e) {
			logger.info("=============>>>>>>查询商品分类信息失败");
			productTypeMap.put(SUConstants.CODE_KEY,
					SUConstants.CODE_FAIL_VALUE);
			productTypeMap.put(SUConstants.MSG_KEY, "查询商品分类信息失败");
			throw new RuntimeException(e);
		}

		return productTypeMap;
	}

	// 查询大分类和小分类列表

	@Override
	public Map<String, Object> queryCategoryProuductTypeList()
			throws RuntimeException {

		try {
			// 返回给前段的实体
			List<ProductCategoryTypeListVo> ProductCategoryTypeListVoi = new ArrayList<ProductCategoryTypeListVo>();

			Map<Long, Object> tempMap = new HashMap<Long, Object>();

			List<CategoryTypeListVo> categoryTypeList = productTypeDao
					.selectCategoryProductTypeList();
			// 第一层遍历
			for (CategoryTypeListVo categoryTypeListVo : categoryTypeList) {
				ProductCategoryTypeListVo productCategoryTypeListVo = new ProductCategoryTypeListVo();
				if (!tempMap.containsKey(categoryTypeListVo.getCategoryId())) {

					productCategoryTypeListVo.setCategoryId(categoryTypeListVo
							.getCategoryId().toString());
					productCategoryTypeListVo.setCategoryName(categoryTypeListVo
							.getCategoryName());
					productCategoryTypeListVo.setCategoryImgPath(categoryTypeListVo
							.getPic());

					tempMap.put(categoryTypeListVo.getCategoryId(),
							categoryTypeListVo.getCategoryName());

				}

				List<ProductTypeVo> productTypeVoList = new ArrayList<ProductTypeVo>();
				for (CategoryTypeListVo categoryTypeListVo2 : categoryTypeList) {

					if (categoryTypeListVo2.getCategoryId().equals(
							categoryTypeListVo.getCategoryId())) {
						ProductTypeVo productTypeVo = new ProductTypeVo();
						productTypeVo.setTypeId(categoryTypeListVo2
								.getProductTypeId().toString());
						productTypeVo.setTypeName(categoryTypeListVo2
								.getProductypeName());

						productTypeVoList.add(productTypeVo);
					}

				}

				productCategoryTypeListVo.setProductTypeVoList(productTypeVoList);
				if (productCategoryTypeListVo.getCategoryId() != null) {
					ProductCategoryTypeListVoi.add(productCategoryTypeListVo);

				}

			}
			
			return CommonResponseUtils.successResponse(ProductCategoryTypeListVoi);
		} catch (Exception e) {
			logger.info("查询大分类和小分类列表");
			throw new RuntimeException(e);
			
		}
		

		

	}

	// 修改大分类的图片
	@Override
	public Map<String, Object> modifyCategoryImage(
			ProductCategoryAuto productCategoryAuto) {
		try {
			productCategoryAutoMapper.updatePic(productCategoryAuto);
			return CommonResponseUtils.successResponse();

		} catch (Exception e) {
			logger.info("修改大分类图片");
			throw new RuntimeException(e);

		}

	}
}
