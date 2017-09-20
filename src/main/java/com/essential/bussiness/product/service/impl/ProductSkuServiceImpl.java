package com.essential.bussiness.product.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.bussiness.product.dao.ProductSkuAutoMapper;
import com.essential.bussiness.product.dao.ProductSkuRelationAutoMapper;
import com.essential.bussiness.product.model.auto.ProductSkuAuto;
import com.essential.bussiness.product.model.auto.ProductSkuRelationAuto;
import com.essential.bussiness.product.model.vo.ProductSkuAutoListVO;
import com.essential.bussiness.product.model.vo.ProductSkuAutoVO;
import com.essential.bussiness.product.model.vo.ProductSkuRelationVO;
import com.essential.bussiness.product.service.IProductSkuService;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.TmDateUtil;
import com.essential.utils.CommonResponseUtils;
import com.essential.utils.DTOUtils;

/**
 * 商品SKU业务
 * 
 * @author cpx
 *
 */
@Service
public class ProductSkuServiceImpl implements IProductSkuService {
	private static Logger logger = LoggerFactory.getLogger(ProductSkuServiceImpl.class);
	@Autowired
	ProductSkuAutoMapper productSkuAutoMapper;

	@Autowired
	ProductSkuRelationAutoMapper productSkuRelationAutoMapper;

	/**
	 * 增加一个商品SKU
	 */
	@Override
	public Map<String, Object> addProductSku(ProductSkuAutoVO productSkuAutoVO) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			int y = 0;
			int j = 0;
			long loginUser = productSkuAutoVO.getLoginUser();
			List<ProductSkuAutoListVO> productSkuAutoList = productSkuAutoVO.getProductSkuAutoList();
			ProductSkuAuto productAuto = new ProductSkuAuto();
			ProductSkuRelationAuto productSkuRelationAuto = new ProductSkuRelationAuto();
			for (int i = 0; i < productSkuAutoList.size(); i++) {

				String dateTime = TmDateUtil.getTimeStamp();
				ProductSkuAutoListVO productSkuVO = productSkuAutoList.get(i);

				// 获取规格List
				List<ProductSkuRelationVO> productSkuRelationList = productSkuVO.getProductSkuRelationList();

				// 向SKU表插入数据
				// 因在插入数据时会返回主键，新插入时把主键设置空以防主键冲突
				productAuto.setProductskuId(null);
				// 商品代码
				productAuto.setArticleNumber(productSkuVO.getArticleNumber());
				// 价格
				productAuto.setPrices(productSkuVO.getPrices());
				// 商品Id
				productAuto.setProductId(productSkuVO.getProductId());
				// 库存
				productAuto.setProductskuCount(productSkuVO.getProductskuCount());
				// 创建用户
				productAuto.setCreateIser(loginUser);
				// 创建时间
				productAuto.setCreateTime(dateTime);
				// 是否删除
				productAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
				j = productSkuAutoMapper.insertSelective(productAuto);

				// 插入失败 跳出循环
				if (j <= 0){
					throw new Exception("商品规格添加失败!");
				}
				// 获取SKU Id
				long productskuId = productAuto.getProductskuId();

				// 向SKU关系表插入数据
				// SKU Id
				productSkuRelationAuto.setProductskuId(productskuId);
				// 商品Id
				productSkuRelationAuto.setProductId(productSkuVO.getProductId());
				// 创建用户
				productSkuRelationAuto.setCreateUser(loginUser);
				// 创建时间
				productSkuRelationAuto.setCreateTime(dateTime);
				// 是否删除
				productSkuRelationAuto.setIsDelete(SUConstants.IS_NOT_DELETE);

				for (int k = 0; k < productSkuRelationList.size(); k++) {
					ProductSkuRelationVO productSkuRelation = productSkuRelationList.get(k);
					// keyId
					productSkuRelationAuto.setSpecificationKeyId(productSkuRelation.getSpecificationKeyId());
					// valueId
					productSkuRelationAuto.setSpecificationValueId(productSkuRelation.getSpecificationValueId());
					// 层级
					productSkuRelationAuto.setType(productSkuRelation.getType());
					// 因在插入数据时会返回主键，新插入时把主键设置空以防主键冲突
					productSkuRelationAuto.setProductskuRelation(null);

					y = productSkuRelationAutoMapper.insertSelective(productSkuRelationAuto);
					if (y <= 0){
						throw new Exception("商品规格关系添加失败!");
					}
						
				}
			}
			map.putAll(CommonResponseUtils.successResponse("商品规格关系添加成功"));
		} catch (Exception e) {
			logger.info("增加商品sku失败");
			e.printStackTrace();
			throw new RuntimeException(e);

		}
		return map;
	}

	/**
	 * 删除一个商品SKU
	 */
	@Override
	public Map<String, Object> deleteProductSku(ProductSkuAuto productAuto) {
		Map<String, Object> map = new HashMap<String, Object>();

		if (productAuto.getProductskuId() == null) {
			map.put(SUConstants.CODE_KEY, SUConstants.CODE_FAIL_VALUE);
			map.put(SUConstants.MSG_KEY, "商品id不能为空");
			return map;

		}
		try {
			// 是否删除
			productAuto.setIsDelete(SUConstants.IS_DELETE);
			int i = productSkuAutoMapper.updateByPrimaryKeySelective(productAuto);
			if (i > 0) {
				ProductSkuRelationAuto productSkuRelationAuto = new ProductSkuRelationAuto();
				// SKU Id
				productSkuRelationAuto.setProductskuId(productAuto.getProductskuId());
				// 是否删除
				productSkuRelationAuto.setIsDelete(SUConstants.IS_DELETE);
				int j = productSkuRelationAutoMapper.updateIsdeleteByProductId(productSkuRelationAuto);
				if (j > 0) {
					map.put(SUConstants.CODE_KEY, SUConstants.CODE_SUCCESS_VALUE);
					map.put(SUConstants.MSG_KEY, SUConstants.MSG_SUCCESS_VALUE);
					return map;
				}

			}

		} catch (Exception e) {
			logger.info("删除商品sku失败");
			e.printStackTrace();
		}
		map.put(SUConstants.CODE_KEY, SUConstants.CODE_FAIL_VALUE);
		map.put(SUConstants.MSG_KEY, "删除商品sku失败");

		return map;
	}

	/**
	 * 修改一个商品SKU
	 */
	@Override
	public Map<String, Object> updateProductSku(ProductSkuAutoVO productSkuAutoVO) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<ProductSkuAutoListVO> productSkuAutoList = productSkuAutoVO.getProductSkuAutoList();
		// 获取商铺Id
		long productId = productSkuAutoList.get(0).getProductId();

		try {
			//先删除已存在的SKU
			ProductSkuAuto productSkuAuto = new ProductSkuAuto();
			productSkuAuto.setProductId(productId);
			map = deleteProductSku(productSkuAuto);
			
			if (SUConstants.CODE_SUCCESS_VALUE.equals(map.get(SUConstants.CODE_KEY))){
				//增加新的SKU
				Map<String, Object> productSkuMap = addProductSku(productSkuAutoVO);
				if (SUConstants.CODE_SUCCESS_VALUE.equals(productSkuMap.get(SUConstants.CODE_KEY))){
					map.put(SUConstants.CODE_KEY, SUConstants.CODE_SUCCESS_VALUE);
					map.put(SUConstants.MSG_KEY, SUConstants.MSG_SUCCESS_VALUE);
					return map;
				}
			}
		} catch (Exception e) {
			logger.info("修改商品规格失败");
			e.printStackTrace();
		}
		map.put(SUConstants.CODE_KEY, SUConstants.CODE_FAIL_VALUE);
		map.put(SUConstants.MSG_KEY, "修改商品规格失败");
		return map;
	}

	/**
	 * 查询一个商品SKU
	 */
	@Override
	public Map<String, Object> queryProductSku(ProductSkuAuto productAuto, int pageIndex) {
		Map<String, Object> map = new HashMap<String, Object>();

		Map<String, Object> inputParameterMap = new HashMap<String, Object>();
		List<ProductSkuAuto> list = new ArrayList<ProductSkuAuto>();
		try {
			// 返回页
			int pageSize = 2;
			// 当前页
			inputParameterMap = DTOUtils.beanToMap(productAuto);
			inputParameterMap.put("pageSize", pageSize);
			inputParameterMap.put("pageIndex", (pageIndex - 1) * pageSize);
			inputParameterMap.put("isDelete", SUConstants.IS_NOT_DELETE);

			list = productSkuAutoMapper.queryAll(inputParameterMap);
			map.put(SUConstants.CODE_KEY, SUConstants.CODE_SUCCESS_VALUE);
			map.put(SUConstants.MSG_KEY, SUConstants.MSG_SUCCESS_VALUE);
			map.put("info", list);
			return map;

		} catch (Exception e) {
			logger.info("查询商品sku失败");
			e.printStackTrace();
		}

		map.put(SUConstants.CODE_KEY, SUConstants.CODE_FAIL_VALUE);
		map.put(SUConstants.MSG_KEY, "查询商品sku失败");
		return map;
	}
}
