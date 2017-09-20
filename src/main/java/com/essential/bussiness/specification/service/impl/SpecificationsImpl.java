package com.essential.bussiness.specification.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.bussiness.product.dao.ProductSkuAutoMapper;
import com.essential.bussiness.product.dao.ProductSkuRelationAutoMapper;
import com.essential.bussiness.product.model.auto.ProductSkuAuto;
import com.essential.bussiness.product.service.impl.ProductServiceImpl;
import com.essential.bussiness.promotion.controller.PromotionAutoController;
import com.essential.bussiness.promotion.model.vo.PromotionProductInfoVo;
import com.essential.bussiness.specification.dao.SpecificationValueAutoMapper;
import com.essential.bussiness.specification.dao.SpecificationkeyAutoMapper;
import com.essential.bussiness.specification.model.auto.SpecificationValueAuto;
import com.essential.bussiness.specification.model.auto.SpecificationkeyAuto;
import com.essential.bussiness.specification.model.vo.CategoryVo;
import com.essential.bussiness.specification.model.vo.ProductSkuSpecificationThreeVo;
import com.essential.bussiness.specification.model.vo.ProductSkuSpecificationTwoVo;
import com.essential.bussiness.specification.model.vo.SpecificationKeyVoItem;
import com.essential.bussiness.specification.model.vo.SpecificationListVo;
import com.essential.bussiness.specification.model.vo.SpecificationValueVo;
import com.essential.bussiness.specification.service.ISpecificationsService;
import com.essential.common.constants.SUConstants;
import com.essential.utils.CommonResponseUtils;

@Service
public class SpecificationsImpl implements ISpecificationsService {
	private static Logger logger = LoggerFactory
			.getLogger(SpecificationsImpl.class);
	@Autowired
	ProductSkuAutoMapper productSkuAutoMapper;
	@Autowired
	SpecificationValueAutoMapper specificationValueAutoMapper;
	// 注入商品sku规格关系dao
	@Autowired
	ProductSkuRelationAutoMapper productSkuRelationAutoMapper;
	@Autowired
	SpecificationkeyAutoMapper specificationkeyAutoMapper;
	@Autowired
	PromotionAutoController promotionAutoController;

	// 通过产品id查询出此sup下面的所有的规格名
	@Override
	public Map<String, Object> querySpecificationByProductId(Long productId) {

		// 返回的map
		Map<String, Object> resMap = new HashMap<String, Object>();
		// 分组list
		// List<Object> productSkuSpecGroupList = new ArrayList<Object>();
		// 顶级分组map
		Map<String, Object> tempMap = new HashMap<String, Object>();
		// 二级分组map
		Map<String, Object> tempTwoMap = new HashMap<String, Object>();
		// 三级分组map
		Map<String, ProductSkuSpecificationTwoVo> tempThreeNameMap = new HashMap<String, ProductSkuSpecificationTwoVo>();
		// 三级分组map
		Map<String, Object> tempThreeValueMap = new HashMap<String, Object>();

		try {

			// 通过产品id得到所有的skuid(数组)
			Long[] skuIds = productSkuAutoMapper
					.selectSkuIdByProductId(productId);
			// 查询当前skuid商品规格 list
			List<Map<String, Object>> productSkuSpecList = productSkuRelationAutoMapper
					.selectSpecificationBySkuIds(skuIds);

			for (Map<String, Object> productSkuSpecMap : productSkuSpecList) {
				// 遍历顶级
				if ("0".equals(productSkuSpecMap.get("uplevel").toString())) {

					if ("2".equals(productSkuSpecMap.get("keytype").toString())) {

						ProductSkuSpecificationTwoVo proSkuSpecTwoVo;
						List<SpecificationValueVo> specificationValueVos;
						if (!tempMap.containsKey(productSkuSpecMap.get("keyid")
								.toString())) {
							proSkuSpecTwoVo = new ProductSkuSpecificationTwoVo();
							specificationValueVos = new ArrayList<SpecificationValueVo>();
							proSkuSpecTwoVo
									.setSpecificationValueVos(specificationValueVos);

							tempMap.put(productSkuSpecMap.get("keyid")
									.toString(), proSkuSpecTwoVo);
						}
						proSkuSpecTwoVo = (ProductSkuSpecificationTwoVo) tempMap
								.get(productSkuSpecMap.get("keyid").toString());
						specificationValueVos = proSkuSpecTwoVo
								.getSpecificationValueVos();

						proSkuSpecTwoVo
								.setSpecificationNameId((Long) productSkuSpecMap
										.get("keyid"));
						proSkuSpecTwoVo
								.setSpecificationName((String) productSkuSpecMap
										.get("keyname"));

						for (Map<String, Object> productSkuSpecTwoMap : productSkuSpecList) {
							if (!"2".equals(productSkuSpecTwoMap.get("keytype")
									.toString())
									|| "0".equals(productSkuSpecTwoMap.get(
											"uplevel").toString())) {
								continue;
							}
							if (proSkuSpecTwoVo
									.getSpecificationNameId()
									.toString()
									.equals(productSkuSpecTwoMap.get("uplevel")
											.toString())) {

								if (!tempTwoMap
										.containsKey(productSkuSpecTwoMap.get(
												"keyid").toString())) {
									SpecificationValueVo specificationValueVo = new SpecificationValueVo();

									specificationValueVo
											.setSpecificationValueId((Long) productSkuSpecTwoMap
													.get("keyid"));
									specificationValueVo
											.setSpecificationValue((String) productSkuSpecTwoMap
													.get("keyname"));
									specificationValueVos
											.add(specificationValueVo);

									proSkuSpecTwoVo
											.setSpecificationValueVos(specificationValueVos);

									tempTwoMap.put(specificationValueVo
											.getSpecificationValueId()
											.toString(), specificationValueVo);
								}
							}
						}
						// productSkuSpecGroupList.add(tempMap.values());
					} else if ("3".equals(productSkuSpecMap.get("keytype")
							.toString())) {

						ProductSkuSpecificationThreeVo proSkuSpecThreeVo;
						List<ProductSkuSpecificationTwoVo> productSkuSpecificationTwoVos;

						if (!tempMap.containsKey(productSkuSpecMap.get("keyid")
								.toString())) {
							proSkuSpecThreeVo = new ProductSkuSpecificationThreeVo();
							productSkuSpecificationTwoVos = new ArrayList<ProductSkuSpecificationTwoVo>();
							proSkuSpecThreeVo
									.setProductSkuSpecificationTwoVos(productSkuSpecificationTwoVos);

							proSkuSpecThreeVo
									.setSpecificationNameId((Long) productSkuSpecMap
											.get("keyid"));
							proSkuSpecThreeVo
									.setSpecificationName((String) productSkuSpecMap
											.get("keyname"));

							tempMap.put(productSkuSpecMap.get("keyid")
									.toString(), proSkuSpecThreeVo);
						}
						proSkuSpecThreeVo = (ProductSkuSpecificationThreeVo) tempMap
								.get(productSkuSpecMap.get("keyid").toString());
						productSkuSpecificationTwoVos = proSkuSpecThreeVo
								.getProductSkuSpecificationTwoVos();

						for (Map<String, Object> productSkuSpecThreeMap : productSkuSpecList) {
							if ((!"3".equals(productSkuSpecThreeMap.get(
									"keytype").toString()))
									|| "0".equals(productSkuSpecThreeMap.get(
											"uplevel").toString())) {
								continue;
							}
							ProductSkuSpecificationTwoVo proSkuSpecTwoVo;
							List<SpecificationValueVo> specificationValueVos;

							if ((!tempThreeNameMap
									.containsKey(productSkuSpecThreeMap.get(
											"keyid").toString()))
									&& proSkuSpecThreeVo
											.getSpecificationNameId()
											.toString()
											.equals(productSkuSpecThreeMap.get(
													"uplevel").toString())) {

								proSkuSpecTwoVo = new ProductSkuSpecificationTwoVo();
								specificationValueVos = new ArrayList<SpecificationValueVo>();
								proSkuSpecTwoVo
										.setSpecificationNameId((Long) productSkuSpecThreeMap
												.get("keyid"));
								proSkuSpecTwoVo
										.setSpecificationName((String) productSkuSpecThreeMap
												.get("keyname"));

								proSkuSpecTwoVo
										.setSpecificationValueVos(specificationValueVos);

								tempThreeNameMap.put(productSkuSpecThreeMap
										.get("keyid").toString(),
										proSkuSpecTwoVo);

								proSkuSpecTwoVo = tempThreeNameMap
										.get(productSkuSpecThreeMap
												.get("keyid").toString());
								specificationValueVos = proSkuSpecTwoVo
										.getSpecificationValueVos();

								for (Map<String, Object> productSkuSpecTwoMap : productSkuSpecList) {
									if (!"3".equals(productSkuSpecTwoMap.get(
											"keytype").toString())
											|| "0".equals(productSkuSpecTwoMap
													.get("uplevel").toString())) {
										continue;
									}
									if (proSkuSpecTwoVo
											.getSpecificationNameId()
											.toString()
											.equals(productSkuSpecTwoMap.get(
													"uplevel").toString())) {

										if (!tempThreeValueMap
												.containsKey(productSkuSpecTwoMap
														.get("keyid")
														.toString())) {
											SpecificationValueVo specificationValueVo = new SpecificationValueVo();

											specificationValueVo
													.setSpecificationValueId((Long) productSkuSpecTwoMap
															.get("keyid"));
											specificationValueVo
													.setSpecificationValue((String) productSkuSpecTwoMap
															.get("keyname"));

											tempThreeValueMap
													.put(productSkuSpecTwoMap
															.get("keyid")
															.toString(),
															specificationValueVo);

											specificationValueVos
													.add(specificationValueVo);

											proSkuSpecTwoVo
													.setSpecificationValueVos(specificationValueVos);

											// proSkuSpecThreeVo.setProductSkuSpecificationTwoVos(productSkuSpecificationTwoVos);
										}

									}
								}
							}
							productSkuSpecificationTwoVos.clear();
							productSkuSpecificationTwoVos
									.addAll(tempThreeNameMap.values());
							proSkuSpecThreeVo
									.setProductSkuSpecificationTwoVos(productSkuSpecificationTwoVos);
						}

						// productSkuSpecGroupList.add(tempMap.values());
					}
				}
			}

			resMap.putAll(CommonResponseUtils.successResponse(tempMap.values()));
		} catch (Exception e) {
			logger.info("=========>>>>>>查询商品规格失败：" + e);
			resMap.putAll(CommonResponseUtils.failureResponse("查询商品规格失败"));
			throw new RuntimeException(e);
		}

		return resMap;

	}

	@Override
	public Map<String, Object> querySpecificationValueByPidKId(Long productId,
			Long keyId) {
		int flag = 0;
		// 规格值得Id
		Map<String, Object> valueStringMap = new HashMap<String, Object>();
		// 返回的Mainmap
		Map<String, Object> Mainmap = new HashMap<String, Object>();
		// Mybatis输入的map
		// 查询规格key的级别
		if (specificationkeyAutoMapper.selectByPrimaryKey(keyId).getType() == 2) {
			flag = 2;
		} else {
			flag = 3;

		}

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 输入参数两个（一个是产品Id，一个是一级规格的Id）
			// 通过产品Id查出skuId(数组)
			Long[] skuIds = productSkuAutoMapper
					.selectSkuIdByProductId(productId);

			// 通过skuId数组，查出来specificationValueIds(数组)
			map.clear();
			map.put("skuIds", skuIds);
			Long[] ValueIds = productSkuRelationAutoMapper
					.selectValueidBySkuid(map);

			if (flag == 2) {

				// 如果就有两级
				// 通过specificationValueIds 查出valueName和key
				map.clear();
				map.put("ValueIds", ValueIds);
				map.put("keyId", keyId);
				List<SpecificationValueAuto> specificationValueAutolis = specificationValueAutoMapper
						.selectNameValue(map);
				if (specificationValueAutolis.size() > 0) {
					for (int i = 0; i < specificationValueAutolis.size(); i++) {
						valueStringMap
								.put(specificationValueAutolis.get(i)
										.getSpecificationValueid().toString(),
										specificationValueAutolis.get(i)
												.getValueName());
					}
				}

			}

			// 如果是三级
			if (flag == 3)

			{
				map.clear();
				map.put("ValueIds", ValueIds);
				map.put("type", keyId);
				//

				List<Map<String, Object>> specificationValueAutoMapList = specificationValueAutoMapper
						.selectNameValueI3unite(map);
				for (Map<String, Object> tempMap : specificationValueAutoMapList) {
					valueStringMap.put(tempMap.get("specification_valueid")
							.toString(), tempMap.get("keyname").toString()
							+ "-" + tempMap.get("value_name").toString());
				}

			}

			Mainmap.putAll(CommonResponseUtils.successResponse(valueStringMap));

		} catch (Exception e) {
			logger.info("查询规格失败：" + e);
			Mainmap.putAll(CommonResponseUtils.failureResponse("查询规格失败"));
			throw new RuntimeException(e);
		}

		return Mainmap;
	}

	/**
	 * 通过商品skuid 查询商品规格信息
	 */
	@Override
	public Map<String, Object> querySpecificationBySkuId(Long skuId) {
		// 主map（返回给控制器的map）
		Map<String, Object> mainMap = new HashMap<String, Object>();
		// skuid为空，返回失败
		if (skuId != null) {
			mainMap.put("skuId", skuId);
		} else {
			return CommonResponseUtils.failureResponse("商品skuid不能为空");
		}

		try {
			// 通过商品skuid 查询该商品规格valueid集合
			List<Long> valueIdList = productSkuRelationAutoMapper
					.selectValueIdsBySkuSingle(mainMap);
			mainMap.clear();

			// 返回前端规格字符串
			StringBuilder specificationStr = new StringBuilder();

			// 遍历规格valueid查询规格value并封装规格字符串
			buildSpecificationStr(valueIdList, specificationStr);

			mainMap.putAll(CommonResponseUtils
					.successResponse(specificationStr));
		} catch (Exception e) {
			logger.info("通过skuid查询规格失败");
			mainMap.putAll(CommonResponseUtils.failureResponse("查询规格信息失败"));
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return mainMap;

	}

	/**
	 * 封装规格字符串
	 * 
	 * @param valueIdList
	 *            某sku商品的规格值
	 * @param specificationStr
	 *            规格字符串
	 */
	public void buildSpecificationStr(List<Long> valueIdList,
			StringBuilder specificationStr) throws Exception {
		// 遍历这个集合valueId转到表（specificationValue）判断两级或者三级
		for (Long valueId : valueIdList) {
			Long upLevelId = specificationkeyAutoMapper.selectKeyLevel(valueId);
			if (upLevelId == 0) {
				if (specificationStr.length() > 0) {
					specificationStr.append("  ");
				}
				// 判断为二级
				Map<String, Object> levelTwoMap = specificationkeyAutoMapper
						.selectKeyLevel2(valueId);

				specificationStr.append(levelTwoMap.get("keyname"));
				specificationStr.append(":");
				specificationStr.append(levelTwoMap.get("value_name"));
			} else {
				// 先得到三级的key自己拼
				if (specificationStr.length() > 0) {
					specificationStr.append("  ");
				}

				// String topNam = specificationkeyAutoMapper
				// .selectTopKeyName(upLevelId);
				// 判断为三级

				Map<String, Object> levelThressMap = specificationkeyAutoMapper
						.selectKeyLevel3(valueId);

				specificationStr.append(levelThressMap.get("keyname"));
				specificationStr.append(":");
				specificationStr.append(levelThressMap.get("value_name"));
			}

		}
	}

	/**
	 * 增加规格的键
	 */
	@Override
	public Map<String, Object> addSpecificationKey(String categoryId,
			String keyName, String value) {
		try {

			SpecificationValueAuto secificationValueAuto = new SpecificationValueAuto();
			SpecificationkeyAuto specificationkeyAuto = new SpecificationkeyAuto();
			// type为大分类的id
			specificationkeyAuto.setType(Integer.parseInt(categoryId));
			// 上级的id，如果是0就是为顶级
			specificationkeyAuto.setUpLevelId(Long.parseLong("0"));
			specificationkeyAuto.setIsDeleted(SUConstants.IS_NOT_DELETE);
			// keyname规格键的名称
			specificationkeyAuto.setKeyname(keyName);
			if (specificationkeyAutoMapper
					.insertSelective(specificationkeyAuto) > 0) {

				secificationValueAuto.setKeyId(specificationkeyAuto
						.getSpecificationId());
				secificationValueAuto.setValueName(value);
				secificationValueAuto.setIsDeleted(SUConstants.IS_NOT_DELETE);

				specificationValueAutoMapper
						.insertSelective(secificationValueAuto);

				return CommonResponseUtils.successResponse();

			}

			
		} catch (Exception e) {
			logger.info("增加规格的键");
			throw new RuntimeException(e);

		}
		return CommonResponseUtils.failureResponse("增加规格键失败");

	}

	/**
	 * 增加规格的值
	 */
	@Override
	public Map<String, Object> addSpecificationValue(
			SpecificationValueAuto specificationValueAuto) {

		try {
			// 规格值表的值
			specificationValueAuto.setValueName(specificationValueAuto
					.getValueName());
			specificationValueAuto.setIsDeleted(SUConstants.IS_NOT_DELETE);

			// 规格键的Id（传最低级的键id）
			specificationValueAuto.setKeyId(specificationValueAuto.getKeyId());
			if (specificationValueAutoMapper
					.insertSelective(specificationValueAuto) > 0) {
				return CommonResponseUtils.successResponse();

			}

		} catch (Exception e) {
			logger.info("增加规格值失败");
			throw new RuntimeException(e);

		}

		return CommonResponseUtils.failureResponse("增加规格键失败");
	}

	/**
	 * 删除规格键
	 */
	@Override
	public Map<String, Object> deleteSpecificationKey(
			SpecificationkeyAuto specificationkeyAuto) {
		try {
			// 逻辑删除
			specificationkeyAuto.setIsDeleted(SUConstants.IS_DELETE);

			if (specificationkeyAutoMapper
					.updateByPrimaryKeySelective(specificationkeyAuto) > 0) {
				// 删除规格键的时候也顺便删除这个规格键下面的所有的规格值
				// 声明规格值实体
				SpecificationValueAuto specificationValue = new SpecificationValueAuto();
				// 逻辑删除
				specificationValue.setIsDeleted(SUConstants.IS_DELETE);
				// 设置删除值得id
				specificationValue.setKeyId((specificationkeyAuto
						.getSpecificationId()));
				// 删除
				specificationValueAutoMapper
						.updateByPrimaryKey(specificationValue);

				return CommonResponseUtils.successResponse();
			}

		} catch (Exception e) {
			logger.info("删除规格键失败");
			throw new RuntimeException(e);
		}

		return CommonResponseUtils.failureResponse("删除规格键失败");

	}

	/**
	 * 修改规格键
	 */
	@Override
	public Map<String, Object> updateSpecificationKey(
			SpecificationkeyAuto specificationkeyAuto) {

		try {

			if (specificationkeyAutoMapper
					.updateByPrimaryKeySelective(specificationkeyAuto) > 0) {
				return CommonResponseUtils.successResponse();
			}

		} catch (Exception e) {
			logger.info("修改规格键失败");
			throw new RuntimeException(e);
		}

		return CommonResponseUtils.failureResponse("修改规格键失败");
	}

	/**
	 * 删除规格值
	 */
	@Override
	public Map<String, Object> deleteSpecificationValue(
			SpecificationValueAuto specificationValueAuto) {
		try {
			specificationValueAuto.setIsDeleted(SUConstants.IS_DELETE);

			if (specificationValueAutoMapper
					.updateByPrimaryKeySelective(specificationValueAuto) > 0) {

				return CommonResponseUtils.successResponse();

			}

		} catch (Exception e) {
			logger.info("删除规格值失败");
			throw new RuntimeException(e);

		}

		return CommonResponseUtils.failureResponse("删除规格值失败");
	}

	/**
	 * 修改规格值
	 */
	@Override
	public Map<String, Object> updateSpecificationValue(
			SpecificationValueAuto specificationValueAuto) {
		try {
			if (specificationValueAutoMapper
					.updateByPrimaryKeySelective(specificationValueAuto) > 0) {
				return CommonResponseUtils.successResponse();

			}

		} catch (Exception e) {
			logger.info("修改规格值失败");
			throw new RuntimeException(e);
		}

		return CommonResponseUtils.failureResponse("修改规格值失败");
	}

	/**
	 * 根据valueIds和productId查询库存和price 和skuId
	 */
	@Override
	public Map<String, Object> selectSkuCount(Long productId, Long[] valueIds) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		// 返回的map
		Map<String, Object> MybatisMap = new HashMap<String, Object>();
		// 通过商品得到skuid(数组)
		Long[] skuIds = productSkuAutoMapper.selectSkuIdByProductId(productId);
		// 插入skuIds
		MybatisMap.put("skuIds", skuIds);
		// 插入valueIds
		MybatisMap.put("valueIds", valueIds);
		// 插入skus的值
		MybatisMap.put("skus", valueIds.length);

		try {
			Map<String, Object> map = productSkuRelationAutoMapper
					.selectskuCount(MybatisMap);
			// 如果map等于null直接返回成功给库存为0
			if (map == null) {

				returnMap.put("count", 0);
				return CommonResponseUtils.successResponse(returnMap);

			}

			else {
				// 如果map没空但是productskuId为空，那说明没有这个skuId当然库存也为0返回
				if (map.get("productsku_id") == null) {
					returnMap.put("count", 0);
					return CommonResponseUtils.successResponse(returnMap);

				}
			}

			Long productSkuId = Long.parseLong(map.get("productsku_id")
					.toString());
			String skuConut = productSkuAutoMapper
					.selectByPrimaryKey(productSkuId).getProductskuCount()
					.toString();
			String skuId = productSkuAutoMapper
					.selectByPrimaryKey(productSkuId).getProductskuId()
					.toString();
			String prices = productSkuAutoMapper
					.selectByPrimaryKey(productSkuId).getPrices().toString();
			//加上折扣价 --start
			
			// 查询活动
			Map<String, Object> mappromotion = promotionAutoController.productPromotion(productId);
			PromotionProductInfoVo promotionProductInfoVo = (PromotionProductInfoVo) mappromotion.get("info");

			returnMap.put("costPrice",prices);
			returnMap.put("prices",prices);
			// code=3就是没有活动
			if (mappromotion.get("code").equals("3")) {

				// 没有活动.
				returnMap.put("isDiscount",0);
				returnMap.put("discountPrice",0);

			}else if (mappromotion.get("code").equals("1")) {// code=1就是有活动
				returnMap.put("isDiscount", 1);
				for (String o : mappromotion.keySet())

				{
					float costPrice = Float.parseFloat(prices);// 原价 
					float percent = promotionProductInfoVo.getDiscountPercent();// 打折的百分比
					float discountCostprice = (costPrice * percent) / 10;

					discountCostprice = (float) (Math.round(discountCostprice * 100))/100;
					returnMap.put("discountPrice", discountCostprice);
				}

			}
			//加上折扣价 --end
			

			
			returnMap.put("count", skuConut);
			returnMap.put("skuId", skuId);
			/*returnMap.put("prices", prices);*/
			if (skuConut.equals(null)) {
				return CommonResponseUtils.successResponse(returnMap);

			} else {
				return CommonResponseUtils.successResponse(returnMap);

			}

		} catch (Exception e) {
			logger.info("查询库存失败");
			throw new RuntimeException(e);

		}
	}

	// 通过skuId和商品的数量去判断库存
	@Override
	public Map<String, Object> selectStock(Long skuId, Long productCount) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 通过skuId去查询库存
			ProductSkuAuto productSkuAuto = productSkuAutoMapper
					.selectByPrimaryKey(skuId);
			// 得到库存
			Long stock = (productSkuAuto.getProductskuCount() - productCount);

			if (stock >= 0) {
				// 返回具体的库存
				map.put("stock", stock);
				return CommonResponseUtils.successResponse(map);

			}
			// 返回-1会库存不足
			map.put("stock", -1);
			return CommonResponseUtils.successResponse(map);
		} catch (Exception e) {
			logger.info("查询库存失败");
			throw new RuntimeException(e);
		}

	}

	// 查询所有的规格key
	@Override
	public Map<String, Object> selectAllSpecificationKey() {
		try {

			List<SpecificationkeyAuto> SpecificationkeyAutoList = specificationkeyAutoMapper
					.selectAllKey();
			if (SpecificationkeyAutoList.size() > 0) {

				return CommonResponseUtils
						.successResponse(SpecificationkeyAutoList);
			}
			return CommonResponseUtils.failureResponse("查询全部的key失败");

		} catch (Exception e) {
			logger.info("查询所有的规格是的Key");
			throw new RuntimeException(e);

		}
	}

	// 通过keyId查询下面所有的values
	@Override
	public Map<String, Object> selectAllValues(Long keyId) {
		try {

			List<SpecificationValueAuto> specificationValueAutoList = specificationValueAutoMapper
					.selectAllValues(keyId);
			if (specificationValueAutoList.size() > 0) {

				return CommonResponseUtils
						.successResponse(specificationValueAutoList);
			}

			return CommonResponseUtils.failureResponse("查询某个规格Key下面的所有的规格值");

		} catch (Exception e) {
			logger.info("通过keyId查询下面所有的values失败");
			throw new RuntimeException(e);

		}
	}

	// 查询规格的列表
	@Override
	public Map<String, Object> selectSpecificationLst() throws RuntimeException {

		try {

			// 返回给前段的Datavo
			List<CategoryVo> categoryVoList = new ArrayList<CategoryVo>();

			Map<String, Object> tempMapCategory = new HashMap<String, Object>();

			List<SpecificationListVo> specificationList = specificationkeyAutoMapper
					.selectSpecificationList();
			// 遍历这个list
			for (SpecificationListVo specificationListVo1 : specificationList) {
				CategoryVo categoryVo = new CategoryVo();

				if (!tempMapCategory.containsKey(specificationListVo1.getType()
						.toString())) {
					tempMapCategory
							.put(specificationListVo1.getType().toString(),
									specificationListVo1.getCategoryName());
					categoryVo.setId(specificationListVo1.getType().toString());
					categoryVo.setName(specificationListVo1.getCategoryName());
					List<SpecificationKeyVoItem> specificationKeyVoList = new ArrayList<SpecificationKeyVoItem>();
					for (SpecificationListVo specificationListVo2 : specificationList) {

						if (specificationListVo2.getType().equals(
								specificationListVo1.getType())) {
							SpecificationKeyVoItem specificationKeyVoItem = new SpecificationKeyVoItem();

							specificationKeyVoItem
									.setKeyId(specificationListVo2
											.getSpecificationId().toString());
							specificationKeyVoItem
									.setKeyName(specificationListVo2
											.getKeyname());
							specificationKeyVoList.add(specificationKeyVoItem);

						}

					}

					categoryVo
							.setSpecificationKeyVoItemList(specificationKeyVoList);

				}

				if (categoryVo.getId() != null) {

					categoryVoList.add(categoryVo);
				}

			}

			return CommonResponseUtils.successResponse(categoryVoList);
		}

		catch (Exception e) {
			logger.info("查询规格的列表失败");
			throw new RuntimeException(e);

		}
	}

	/**
	 * 修改规格键 web前段（陈蒙蒙）
	 */
	@Override
	public Map<String, Object> modifySpecificationKey(
			SpecificationkeyAuto specificationkeyAuto) throws RuntimeException {

		try {

			if (specificationkeyAutoMapper
					.updateByPrimaryKeySelective(specificationkeyAuto) > 0) {

				return CommonResponseUtils.successResponse();

			}

		} catch (Exception e) {
			logger.info("修改规格键  web前段（陈蒙蒙）失败");
			throw new RuntimeException(e);

		}
		return CommonResponseUtils.failureResponse("修改规格键失败");

	}
}
