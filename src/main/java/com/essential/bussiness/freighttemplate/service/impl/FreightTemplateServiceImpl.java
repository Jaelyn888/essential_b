package com.essential.bussiness.freighttemplate.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.bussiness.address.service.IProvinceService;
import com.essential.bussiness.freighttemplate.dao.FreightGroupNameAutoMapper;
import com.essential.bussiness.freighttemplate.dao.FreightTemplateAutoMapper;
import com.essential.bussiness.freighttemplate.model.auto.FreightGroupNameAuto;
import com.essential.bussiness.freighttemplate.model.auto.FreightTemplateAuto;
import com.essential.bussiness.freighttemplate.model.vo.FreightGroupNameVo;
import com.essential.bussiness.freighttemplate.model.vo.FreightTemplateVo;
import com.essential.bussiness.freighttemplate.service.IFreightTemplateService;
import com.essential.bussiness.product.service.IProductService;
import com.essential.bussiness.product.service.impl.ProductServiceImpl;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.TmDateUtil;
import com.essential.common.utils.WebUtils;
import com.essential.user.model.vo.UserReceiptAddressVo;
import com.essential.utils.CommonResponseUtils;
import com.essential.utils.DTOUtils;

/**
 * 运费模板基本信息
 * 
 * @author Jaelyn
 *
 */
@Service
public class FreightTemplateServiceImpl implements IFreightTemplateService {

	/**
	 * mapper
	 */
	@Autowired
	private FreightTemplateAutoMapper freightTemplateMapper;

	/**
	 * 运费分组
	 */
	@Autowired
	private FreightGroupNameAutoMapper freightGroupNameAutoMapper;

	@Autowired
	@Qualifier("provinceServiceImpl")
	private IProvinceService provinceServiceImpl;

	@Autowired
	@Qualifier("productServiceImpl")
	private IProductService productServiceImpl;

	/**
	 * 保存/更新运费模板
	 * 
	 * @param requestMap
	 * @return
	 */
	@Override
	public HashMap<String, Object> saveOrUpdateFreightTemplateAndGroup(FreightGroupNameAuto freightGroupNameAuto) {
		try {
			// 如果是更新 删除原来的
			String timeStamp = TmDateUtil.getTimeStamp();
			Long freightGroupId = freightGroupNameAuto.getFreightGroupId();
			if (freightGroupId != null) {
				freightGroupNameAuto.setIsDelete(SUConstants.IS_DELETE);
				freightGroupNameAuto.setModifyTime(timeStamp);
				freightGroupNameAuto.setModifyUser(freightGroupNameAuto.getCreateUser());
				freightGroupNameAuto.setCreateUser(null);
				int num = freightGroupNameAutoMapper.updateByPrimaryKeySelective(freightGroupNameAuto);
				if (num <= 0) {
					return CommonResponseUtils.failureResponse("保存失败");
				}
			} else {
				freightGroupNameAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
				freightGroupNameAuto.setModifyTime(timeStamp);
				freightGroupNameAuto.setModifyUser(freightGroupNameAuto.getCreateUser());
				freightGroupNameAuto.setCreateTime(timeStamp);
			}

			// 保存
			int num = freightGroupNameAutoMapper.insert(freightGroupNameAuto);
			if (num > 0) {
				num = freightTemplateMapper.insertSelectiveList(freightGroupNameAuto);
				if (num > 0) {
					return CommonResponseUtils.successResponse("保存成功");
				} else {
					return CommonResponseUtils.failureResponse("保存失败");
				}
			} else {
				return CommonResponseUtils.failureResponse("保存失败");
			}

		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("保存失败");
		}

	}

	/**
	 * 根据店铺id 查询运费模板
	 * 
	 * @param freightGroupNameAuto
	 * @return
	 */
	@Override
	public HashMap<String, Object> deleteFreightGroupList(FreightGroupNameAuto freightGroupNameAuto) {
		try {
			String timeStamp = TmDateUtil.getTimeStamp();
			Long freightGroupId = freightGroupNameAuto.getFreightGroupId();

			if (freightGroupId != null) {
				int useNum = productServiceImpl.queryProductByFreightGroupId(freightGroupId).size();// 商品占用数
				if (useNum == 0) {
					freightGroupNameAuto.setIsDelete(SUConstants.IS_DELETE);
					freightGroupNameAuto.setModifyTime(timeStamp);
					freightGroupNameAuto.setModifyUser(freightGroupNameAuto.getCreateUser());
					freightGroupNameAuto.setCreateUser(null);
					int num = freightGroupNameAutoMapper.updateByPrimaryKeySelective(freightGroupNameAuto);
					if (num > 0) {
						return CommonResponseUtils.failureResponse("删除成功");
					} else {
						return CommonResponseUtils.failureResponse("删除失败");
					}
				} else {
					return CommonResponseUtils.failureResponse("此模板被商品使用，无法删除");
				}
			}else{
				return CommonResponseUtils.failureResponse("模板id不能为空，删除失败");	
			}
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("删除失败");
		}
	}

	/*
	 * 根据页码分页查询店铺模板
	 * 
	 * @see
	 * com.essential.bussiness.freighttemplate.service.impl.IFreightTemplateService
	 * #queryFreightTemplateList(java.util.Map)
	 */
	@Override
	public HashMap<String, Object> queryFreightTemplateList(Map<String, Object> requestMap) {
		List<HashMap<String, Object>> resultMapList = new ArrayList<HashMap<String, Object>>();
		try {
			// 分页查询模板组
			requestMap.put(SUConstants.KEY_IS_DELETE, SUConstants.IS_NOT_DELETE);
			int pageIndex = Integer.parseInt((String) requestMap.getOrDefault("pageIndex", "" + 1));

			requestMap.put("pageIndex", (pageIndex - 1) * SUConstants.PAGE_COUNT);
			requestMap.put("pageSize", SUConstants.PAGE_COUNT);
			List<FreightGroupNameAuto> freightGroupNameAutoList = queryFreightGroupAutoList(requestMap);

			// 查询模板
			for (int i = 0; i < freightGroupNameAutoList.size(); i++) {
				HashMap<String, Object> resultItemMap = new HashMap<String, Object>();
				FreightGroupNameAuto freightGroupNameAuto = freightGroupNameAutoList.get(i);
				resultItemMap.put("freightGroupName", freightGroupNameAuto.getFreightGroupName());
				resultItemMap.put("freightGroupId", freightGroupNameAuto.getFreightGroupId());

				long freightGroupId = freightGroupNameAuto.getFreightGroupId();
				List<FreightTemplateAuto> freightTemplateList = queryFreightTemplateList(freightGroupId);
				List<FreightTemplateVo> freightTemplateVoList = DTOUtils.map(freightTemplateList, FreightTemplateVo.class);
				resultItemMap.put("freightTemplateAutoList", freightTemplateVoList);
				resultMapList.add(resultItemMap);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("查询失败");
		}
		return CommonResponseUtils.successResponse(resultMapList);
	}

	/**
	 * 根据店铺id 查询运费模板
	 * 
	 * @param freightGroupNameAuto
	 * @return
	 */
	@Override
	public List<FreightGroupNameVo> queryFreightGroupList(Map<String, Object> requstMap) {
		try {
			List<FreightGroupNameAuto> freightGroupNameList = queryFreightGroupAutoList(requstMap);
			if (freightGroupNameList.size() > 0) {
				List<FreightGroupNameVo> freightGroupNameVoList = DTOUtils.map(freightGroupNameList, FreightGroupNameVo.class);
				return freightGroupNameVoList;
			} else {
				return new ArrayList<FreightGroupNameVo>();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<FreightGroupNameVo>();
		}
	}

	private List<FreightGroupNameAuto> queryFreightGroupAutoList(Map<String, Object> requstMap) {
		try {
			requstMap.put(SUConstants.KEY_IS_DELETE, SUConstants.IS_NOT_DELETE);
			List<FreightGroupNameAuto> freightGroupNameList = freightGroupNameAutoMapper.queryFreightGroupList(requstMap);
			return freightGroupNameList;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<FreightGroupNameAuto>();
		}
	}

	/*
	 * 根据商品数量，运费模板、收货地址 计算运费总额
	 * 省市区 用户id
	 * @see
	 * com.essential.bussiness.freighttemplate.service.impl.IFreightTemplateService
	 * #
	 * queryFreightByAddressId(com.essential.user.model.auto.UserReceiptAddressAuto
	 * )
	 */
	@Override
	public Map<String, Object> queryFreightByAddressId(UserReceiptAddressVo userReceiptAddressVo) {
		try {
			// 根据用户id 分组 查询 商品运费信息
			List<Map<String, Object>> freightGroupTemplateList = queryShopCartByGroup(userReceiptAddressVo.getUserId());
			int shopCartNum = freightGroupTemplateList.size();
			double freightMoney = 0;// 总运费
			StringBuilder msgBuilder = new StringBuilder();// msg
			String code = SUConstants.CODE_SUCCESS_VALUE;
			// 店铺运费
			HashMap<Long, Object> shopFreightMoneyMap = new HashMap<Long, Object>();
			// 根据运费类型，获取运费
			for (int i = 0; i < shopCartNum; i++) {
				Map<String, Object> mapTemp = freightGroupTemplateList.get(i);
				Integer freightType = (Integer) mapTemp.get("freightType");
				if(freightType==null){
					continue;
				}
				long shopId = (long) mapTemp.get("shopId");
				if (freightType == 1) {// 运费模板
					// 根据分组 获取运费模板
					long freightGroupId = (long) mapTemp.get("freightGroupId");
					List<FreightTemplateAuto> freightTemplateList = queryFreightTemplateList(freightGroupId); // freightTemplateMapper.queryFreightTemplateList(freightTemplateAuto);

					// 迭代模板 定位具体模板
					// 根据省市区地址id 匹配 是否可送达
					int freightTemplateIndex = -1;
					int num = freightTemplateList.size();

					for (int j = 0; j < num; j++) {
						FreightTemplateAuto freightTemplateAuto = freightTemplateList.get(j);
						String addressJsonStr = freightTemplateAuto.getAddressStr();
						boolean bool = querySupportAddress(userReceiptAddressVo, addressJsonStr);
						if (bool) {
							freightTemplateIndex = j;
							break;
						}
					}
					if (freightTemplateIndex > -1) {// 支持配送 计算运费
						FreightTemplateAuto freightTemplateAuto = freightTemplateList.get(freightTemplateIndex);
						int productCount = Integer.parseInt(mapTemp.get("productCount").toString());
						int startNum = freightTemplateAuto.getStartNum();// 起件
						double startFreightCost = freightTemplateAuto.getStartFreightCost().doubleValue();
						// 首件
						freightMoney += startFreightCost;
						double shopFreightMoney = (double) shopFreightMoneyMap.getOrDefault(shopId, 0d);
						shopFreightMoneyMap.put(shopId, shopFreightMoney + startFreightCost);

						int remainCount = productCount - startNum;// 续件
						if (productCount - startNum > 0) {
							int nextNum = freightTemplateAuto.getNextNum();
							int tempCount = remainCount / nextNum;// 向下取值，不足 免邮
							if (tempCount > 0) {
								double nextFreightCost = freightTemplateAuto.getNextFreightCost().doubleValue() * tempCount;
								freightMoney += startFreightCost;
								shopFreightMoney = (double) shopFreightMoneyMap.getOrDefault(shopId, 0d);
								shopFreightMoneyMap.put(shopId, shopFreightMoney + nextFreightCost);
							}
						}

					} else {// 不支持配送
						code = SUConstants.CODE_FAIL_VALUE;
						msgBuilder.append(mapTemp.get("salesName").toString()).append("、");
					}

				} else {// 统一运费
					 double costPrice =  new BigDecimal(mapTemp.get("freightPrice") == null?"0":mapTemp.get("freightPrice").toString()).doubleValue();
					freightMoney += costPrice;
					double shopFreightMoney = (double) shopFreightMoneyMap.getOrDefault(shopId, 0d);
					shopFreightMoneyMap.put(shopId, shopFreightMoney + costPrice);
					// shopFreightMoney.get("shopId").get
				}
			}
			if (code.equals(SUConstants.CODE_SUCCESS_VALUE)) {

				Map<String, Object> freightInfo = new HashMap<String, Object>();
				freightInfo.put("totleFreight", freightMoney);
				freightInfo.put("shopFreight", shopFreightMoneyMap);
				return CommonResponseUtils.successResponse(freightInfo);
			} else {
				msgBuilder.append("商品不支持配送");
				return CommonResponseUtils.failureResponse(msgBuilder.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}

	}

	private List<FreightTemplateAuto> queryFreightTemplateList(long freightGroupId) {
		FreightTemplateAuto freightTemplateAuto = new FreightTemplateAuto();
		freightTemplateAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
		freightTemplateAuto.setFreightGroupId(freightGroupId);
		List<FreightTemplateAuto> freightTemplateList = freightTemplateMapper.queryFreightTemplateList(freightTemplateAuto);
		return freightTemplateList;
	}

	/**
	 * 根据店铺id，运费类型和运费模板id 分组查询商品
	 * 
	 * @param userId
	 * @return
	 */
	private List<Map<String, Object>> queryShopCartByGroup(Long userId) {
		Map<String, Object> requstMap = new HashMap<String, Object>();
		requstMap.put("userId", userId);
		requstMap.put(SUConstants.KEY_IS_DELETE, SUConstants.IS_NOT_DELETE);
		requstMap.put("isSelected", SUConstants.IS_SELECT);
		List<Map<String, Object>> freightGroupTemplateList = freightGroupNameAutoMapper.queryShopCartByGroupList(requstMap);
		return freightGroupTemplateList;
	}

	/**
	 * 查询是否支持配送
	 * 
	 * @param userReceiptAddressAuto
	 *            收货地址
	 * @param addressJsonStr
	 *            运费模板字串
	 * @return
	 */
	private boolean querySupportAddress(UserReceiptAddressVo userReceiptAddressVo, String addressJsonStr) {
		JSONArray addressJsonArray = JSONArray.fromObject(addressJsonStr);
		boolean isSupport = false;
		HH: for (int k = 0; k < addressJsonArray.size(); k++) {
			JSONObject addressJson = addressJsonArray.getJSONObject(k);
			int provinceId = addressJson.getInt("provinceId");
			if (provinceId == userReceiptAddressVo.getProvinceId().intValue()) {// 省
				boolean isAll = addressJson.getBoolean("isAll");
				if (isAll) {
					isSupport = true;
					break;
				} else {
					JSONArray cityJsonArray = addressJson.getJSONArray("cityList");
					for (int l = 0; l < cityJsonArray.size(); l++) {
						JSONObject cityJson = cityJsonArray.getJSONObject(k);
						long cityId = cityJson.getLong("cityId");
						if (cityId == userReceiptAddressVo.getCityId().longValue()) {// 市
							boolean isCityAll = cityJson.getBoolean("isAll");
							if (isCityAll) {
								isSupport = true;
								break HH;
							} else {
								JSONArray districtJsonArray = cityJson.getJSONArray("districtList");
								for (int m = 0; m < districtJsonArray.size(); m++) {// 区
									JSONObject districtJson = districtJsonArray.getJSONObject(m);
									long districtId = districtJson.getLong("districtId");
									if (districtId == userReceiptAddressVo.getDistrictId().longValue()) {
										isSupport = true;
										break HH;
									}
								}
							}

						}
					}

				}
			}
		}

		return isSupport;
	}

}
