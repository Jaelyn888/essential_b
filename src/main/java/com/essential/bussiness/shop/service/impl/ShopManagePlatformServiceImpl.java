package com.essential.bussiness.shop.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.bussiness.brand.dao.BrandAutoMapper;
import com.essential.bussiness.brand.model.auto.BrandAuto;
import com.essential.bussiness.product.dao.ProductAutoMapper;
import com.essential.bussiness.product.model.auto.ProductAuto;
import com.essential.bussiness.product.model.vo.Count;
import com.essential.bussiness.product.model.vo.ProductAutoAddField;
import com.essential.bussiness.returns.dao.ReturnAddressAutoMapper;
import com.essential.bussiness.returns.model.auto.ReturnAddressAuto;
import com.essential.bussiness.shop.dao.ShopAddInformationAutoMapper;
import com.essential.bussiness.shop.dao.ShopAutoMapper;
import com.essential.bussiness.shop.dao.ShopBankCardAutoMapper;
import com.essential.bussiness.shop.dao.ShopToContactAutoMapper;
import com.essential.bussiness.shop.model.auto.ShopAddInformationAuto;
import com.essential.bussiness.shop.model.auto.ShopAuto;
import com.essential.bussiness.shop.model.auto.ShopBankCardAuto;
import com.essential.bussiness.shop.model.auto.ShopToContactAuto;
import com.essential.bussiness.shop.model.vo.ShopAddInformationVo;
import com.essential.bussiness.shop.model.vo.ShopAuditingVo;
import com.essential.bussiness.shop.model.vo.ShopBrandPlatformVo;
import com.essential.bussiness.shop.model.vo.ShopDetaileInfoVo;
import com.essential.bussiness.shop.model.vo.ShopInfoListVo;
import com.essential.bussiness.shop.model.vo.ShopInformationPlatformVo;
import com.essential.bussiness.shop.model.vo.ShopPayMoneyVo;
import com.essential.bussiness.shop.service.IShopManagePlatformService;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.TmDateUtil;
import com.essential.utils.CommonResponseUtils;
import com.essential.utils.DTOUtils;

@Service
public class ShopManagePlatformServiceImpl implements IShopManagePlatformService {
	private static Logger logger = LoggerFactory.getLogger(ShopManagePlatformServiceImpl.class);

	// 店铺信息表
	@Autowired
	ShopAutoMapper shopAutoMapper;

	// 店铺信息补充表
	@Autowired
	ShopAddInformationAutoMapper shopAddInformationAutoMapper;

	// 店铺联系人表
	@Autowired
	ShopToContactAutoMapper shopToContactAutoMapper;

	// 退货地址表
	@Autowired
	ReturnAddressAutoMapper returnAddressAutoMapper;

	// 店铺银行信息表
	@Autowired
	ShopBankCardAutoMapper shopBankCardAutoMapper;

	// 商品表
	@Autowired
	ProductAutoMapper productAutoMapper;

	// 品牌表
	@Autowired
	BrandAutoMapper brandAutoMapper;

	/**
	 * 查询商家列表
	 */
	@Override
	public Map<String, Object> queryShopList(ShopInformationPlatformVo shopInformationPlatformVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Integer pageIndex = shopInformationPlatformVo.getPageIndex();
			Integer pageSize = shopInformationPlatformVo.getPageSize();
			if (pageIndex == null) {
				pageIndex = 1;
			}
			if (pageSize == null) {
				pageSize = 10;
			}
			if ("".equals(shopInformationPlatformVo.getName())) {
				shopInformationPlatformVo.setName(null);
			}
			pageIndex = (pageIndex - 1) * pageSize;
			shopInformationPlatformVo.setPageIndex(pageIndex);
			shopInformationPlatformVo.setPageSize(pageSize);
			shopInformationPlatformVo.setStatus(SUConstants.IS_NOT_DELETE);
			List<ShopInformationPlatformVo> shopList = shopAutoMapper.queryShopList(shopInformationPlatformVo);
			if (shopList != null && shopList.size() > 0) {
				for (int i = 0; i < shopList.size(); i++) {
					ShopInformationPlatformVo shopInfo = shopList.get(i);
					// 审核状态，0-待审核，1-已审核，2-已驳回
					Integer checkStatus = shopInfo.getCheckStatus();
					// 店铺状态，0-正常，1-禁用
					Integer shopStatus = shopInfo.getShopStatus();
					// 审核状态名称
					if (checkStatus == 0) {
						shopInfo.setCheckStatusName("待审核");
					} else if (checkStatus == 1) {
						shopInfo.setCheckStatusName("已审核");
					} else {
						shopInfo.setCheckStatusName("已驳回");
					}
					// 店铺状态名称
					if (shopStatus == 0) {
						shopInfo.setShopStatusName("正常");
					} else {
						shopInfo.setShopStatusName("禁用");
					}
				}
			}
			ShopInfoListVo shopInfoList = new ShopInfoListVo();
			Count pageCount = shopAutoMapper.queryShopListCount(shopInformationPlatformVo);
			shopInfoList.setPageCount(pageCount.getCount());
			shopInfoList.setShopInforList(shopList);
			map.putAll(CommonResponseUtils.successResponse(shopInfoList));
			return map;
		} catch (Exception e) {
			logger.info("=====>>>>>>商家列表查询失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 查看店铺详情
	 */
	@Override
	public Map<String, Object> queryDetialShopInfo(Long shopId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ShopDetaileInfoVo shopDetaileInfo = new ShopDetaileInfoVo();
			// 查询店铺信息
			ShopAuto shopAuto = new ShopAuto();
			shopAuto.setShopId(shopId);
			shopAuto = shopAutoMapper.selectByPrimaryKey(shopId);
			DTOUtils.map(shopAuto, shopDetaileInfo);

			// 查询店铺联系人
			ShopToContactAuto shopToContactAuto = shopToContactAutoMapper.queryInfoByShopId(shopId);
			if (shopToContactAuto != null) {
				// 店铺联系人
				shopDetaileInfo.setContactPhone(shopToContactAuto.getContactPhone());
			}

			// 查询退货地址
			ReturnAddressAuto returnAddressAuto = new ReturnAddressAuto();
			// 店铺Id
			returnAddressAuto.setShopId(shopId);
			// 是否删除
			returnAddressAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			// 默认地址
			returnAddressAuto.setStatus(1);
			returnAddressAuto = returnAddressAutoMapper.queryDefaultAddress(returnAddressAuto);
			if (returnAddressAuto != null) {
				// 退货联系电话
				shopDetaileInfo.setPhone(returnAddressAuto.getPhone());
				// 退货联系人
				shopDetaileInfo.setContactPerson(returnAddressAuto.getContactPerson());
				// 退货地址
				shopDetaileInfo.setReturnAddress(returnAddressAuto.getReturnAddress());
			} else {
				Map<String, Object> inputMap = new HashMap<String, Object>();
				inputMap.put("shopId", shopId);
				inputMap.put("isDelete", SUConstants.IS_NOT_DELETE);
				List<ReturnAddressAuto> returnAddressList = returnAddressAutoMapper.queryReturnRightsAddress(inputMap);
				if (returnAddressList != null && returnAddressList.size() > 0) {
					// 退货联系电话
					shopDetaileInfo.setPhone(returnAddressList.get(0).getPhone());
					// 退货联系人
					shopDetaileInfo.setContactPerson(returnAddressList.get(0).getContactPerson());
					// 退货地址
					shopDetaileInfo.setReturnAddress(returnAddressList.get(0).getReturnAddress());
				}
			}

			// 银行开户信息
			ShopBankCardAuto shopBankCardAuto = new ShopBankCardAuto();
			// 店铺Id
			shopBankCardAuto.setShopId(shopId);
			// 是否删除标记：0-未删除；1-已删除
			shopBankCardAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			List<ShopBankCardAuto> openingBankInfomationList = shopBankCardAutoMapper.queryByPrimaryKey(shopBankCardAuto);
			shopDetaileInfo.setOpeningBankInfomationList(openingBankInfomationList);

			map.putAll(CommonResponseUtils.successResponse(shopDetaileInfo));
			return map;
		} catch (Exception e) {
			logger.info("=====>>>>>>查看店铺详情失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 禁用/启用店铺
	 */
	@Override
	public Map<String, Object> disableOrEnableShop(ShopAddInformationVo shopAddInformationVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer type = shopAddInformationVo.getType();
		try {
			Long shopId = shopAddInformationVo.getShopId();
			Long logenUser = shopAddInformationVo.getLogenUser();
			ShopAddInformationAuto shopAddInformationAuto = new ShopAddInformationAuto();
			shopAddInformationAuto.setShopId(shopId);
			DTOUtils.map(shopAddInformationVo, shopAddInformationAuto);
			// type 0-启用，1-禁用
			if (type == 0) {
				// 启用 0-启用，1-禁用
				shopAddInformationAuto.setShopStatus(0);
				// 修改用户
				shopAddInformationAuto.setModifyUser(logenUser);
				// 修改时间
				shopAddInformationAuto.setModifyTime(TmDateUtil.getTimeStamp());
				// 是否删除
				shopAddInformationAuto.setIsDelelte(SUConstants.IS_NOT_DELETE);
				int i = shopAddInformationAutoMapper.update(shopAddInformationAuto);
				if (i <= 0) {
					throw new Exception("店铺启用失败!");
				}
				map.putAll(CommonResponseUtils.successResponse("店铺启用成功!"));
			} else {
				// 0-启用，1-禁用
				shopAddInformationAuto.setShopStatus(1);
				// 修改用户
				shopAddInformationAuto.setModifyUser(logenUser);
				// 修改时间
				shopAddInformationAuto.setModifyTime(TmDateUtil.getTimeStamp());
				// 是否删除
				shopAddInformationAuto.setIsDelelte(SUConstants.IS_NOT_DELETE);
				int i = shopAddInformationAutoMapper.update(shopAddInformationAuto);
				if (i <= 0) {
					throw new Exception("店铺禁用失败!");
				}

				// 商品下架
				ProductAuto productInfo = new ProductAuto();
				productInfo.setShopId(shopId);
				productInfo.setIsDelete(SUConstants.IS_NOT_DELETE);
				List<ProductAutoAddField> productList = productAutoMapper.queryProductList(productInfo);
				if (productList != null && productList.size() > 0) {
					ProductAuto productAuto = new ProductAuto();
					// 店铺Id
					productAuto.setShopId(shopId);
					// 是否删除
					productAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
					// 商品状态 0-下架，1-上架，2-强制下架
					productAuto.setSaleStatus(0);
					// 修改用户
					productAuto.setModifyUser(logenUser);
					// 修改时间
					productAuto.setModifyTime(TmDateUtil.getTimeStamp());
					int j = productAutoMapper.updateProductStatusByShopId(productAuto);
					if (j <= 0) {
						throw new Exception("禁用店铺时，店铺商品下架失败!");
					}
				}
				map.putAll(CommonResponseUtils.successResponse("店铺禁用成功!"));
			}
			return map;
		} catch (Exception e) {
			logger.info("=====>>>>>>商家列表查询失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 店铺所销售的品牌
	 */
	@Override
	public Map<String, Object> shopBrand(Long shopId, Integer pageIndex, Integer pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (pageIndex == null) {
				pageIndex = 1;
			}
			if (pageSize == null) {
				pageSize = 10;
			}
			pageIndex = (pageIndex - 1) * pageSize;
			ShopBrandPlatformVo shopBrandInfo = new ShopBrandPlatformVo();
			// 查询品牌
			Map<String, Object> inputMap = new HashMap<String, Object>();
			inputMap.put("shopId", shopId);
			inputMap.put("isDelete", SUConstants.IS_NOT_DELETE);
			inputMap.put("pageIndex", pageIndex);
			inputMap.put("pageSize", pageSize);
			List<BrandAuto> brandList = brandAutoMapper.queryShopBrand(inputMap);
			// 获取总条数
			Count pageCount = brandAutoMapper.queryShopBrandCount(inputMap);

			shopBrandInfo.setPageCount(pageCount.getCount());
			shopBrandInfo.setShopBrandList(brandList);

			map.putAll(CommonResponseUtils.successResponse(shopBrandInfo));
			return map;
		} catch (Exception e) {
			logger.info("=====>>>>>>商家列表查询失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 修改店铺保证金额
	 */
	@Override
	public Map<String, Object> updateShopPayMoney(ShopPayMoneyVo shopPayMoneyVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 支付时间
			String ispaytime = shopPayMoneyVo.getIspaytime();
			if ("".equals(ispaytime)) {
				ispaytime = null;
			}
			ShopAuto shopAuto = new ShopAuto();
			// 店铺Id
			shopAuto.setShopId(shopPayMoneyVo.getShopId());
			// 保证金额
			shopAuto.setPayMoney(shopPayMoneyVo.getPayMoney());
			// 支付时间
			shopAuto.setIspaytime(ispaytime);
			// 修改人
			shopAuto.setModifyUser(shopPayMoneyVo.getLogenUser());
			// 修改时间
			shopAuto.setModifyTime(TmDateUtil.getTimeStamp());
			// 是否支付 ，0-未支付，1-已支付
			shopAuto.setIsPay(1);
			int i = shopAutoMapper.updateByShopId(shopAuto);
			if (i <= 0) {
				throw new Exception("店铺保证金额修改失败!");
			}
			
			if(shopPayMoneyVo.getShopServiceMoney() != null && !"".equals(shopPayMoneyVo.getShopServiceMoney())){
				ShopAddInformationAuto shopAddInformationAuto = new ShopAddInformationAuto();
				// 店铺Id
				shopAddInformationAuto.setShopId(shopPayMoneyVo.getShopId());
				// 店铺服务费
				String money = shopPayMoneyVo.getShopServiceMoney();
				BigDecimal shopServiceMoney = new BigDecimal(money).divide(new BigDecimal("100"));
				shopAddInformationAuto.setRemark1(shopServiceMoney.toString());
				// 修改人
				shopAddInformationAuto.setModifyUser(shopPayMoneyVo.getLogenUser());
				// 修改时间
				shopAddInformationAuto.setModifyTime(TmDateUtil.getTimeStamp());
				// 是否删除
				shopAddInformationAuto.setIsDelelte(SUConstants.IS_NOT_DELETE);
				int j = shopAddInformationAutoMapper.update(shopAddInformationAuto);
				if(j <= 0){
					throw new Exception("店铺服务费修改失败!");
				}
			}
			
			map.putAll(CommonResponseUtils.successResponse("店铺保证金额修改成功!"));
			return map;
		} catch (Exception e) {
			logger.info("=====>>>>>>店铺保证金额修改失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 通过/驳回
	 */
	@Override
	public Map<String, Object> auditingShop(ShopAuditingVo shopAuditingVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer type = shopAuditingVo.getType();
		try {
			Long logenUser = shopAuditingVo.getLogenUser();
			ShopAuto shopAuto = new ShopAuto();
			String dateTime = TmDateUtil.getTimeStamp();
			// 店铺Id
			shopAuto.setShopId(shopAuditingVo.getShopId());
			// 审核时间
			shopAuto.setCheckTime(dateTime);
			// 修改时间
			shopAuto.setModifyTime(dateTime);
			// 修改人
			shopAuto.setModifyUser(logenUser);
			int i = shopAutoMapper.updateByShopId(shopAuto);
			if (i <= 0) {
				if (type == 0) {
					throw new Exception("店铺审核通过失败!");
				} else {
					throw new Exception("店铺审核驳回失败!");
				}
			}
			ShopAddInformationAuto shopAddInformationAuto = new ShopAddInformationAuto();
			// 店铺Id
			shopAddInformationAuto.setShopId(shopAuditingVo.getShopId());
			// 修改时间
			shopAddInformationAuto.setModifyTime(dateTime);
			// 修改人
			shopAddInformationAuto.setModifyUser(logenUser);
			// 是否删除
			shopAddInformationAuto.setIsDelelte(SUConstants.IS_NOT_DELETE);
			if (type == 0) {
				// 审核状态，0-待审核，1-已审核，2-已驳回
				shopAddInformationAuto.setCheckStatus(1);
			} else {
				shopAddInformationAuto.setCheckStatus(2);
				// 驳回原因
				shopAddInformationAuto.setRejectReason(shopAuditingVo.getRejectReason());
			}
			int j = shopAddInformationAutoMapper.update(shopAddInformationAuto);
			if (j <= 0) {
				if (type == 0) {
					throw new Exception("店铺审核通过状态失败!");
				} else {
					throw new Exception("店铺审核驳回状态失败!");
				}
			}
			if (type == 0) {
				map.putAll(CommonResponseUtils.successResponse("店铺审核通过成功!"));
			} else {
				map.putAll(CommonResponseUtils.successResponse("店铺审核驳成功!"));
			}
			return map;
		} catch (Exception e) {
			if (type == 0) {
				logger.info("=====>>>>>>店铺审核通过失败:" + e);
			} else {
				logger.info("=====>>>>>>店铺审核驳回失败:" + e);
			}
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 审核商家列表
	 */

	@Override
	public Map<String, Object> auditingShopList(ShopInformationPlatformVo shopInformationPlatformVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Integer pageIndex = shopInformationPlatformVo.getPageIndex();
			Integer pageSize = shopInformationPlatformVo.getPageSize();
			if (pageIndex == null) {
				pageIndex = 1;
			}
			if (pageSize == null) {
				pageSize = 10;
			}
			if ("".equals(shopInformationPlatformVo.getName())) {
				shopInformationPlatformVo.setName(null);
			}
			pageIndex = (pageIndex - 1) * pageSize;
			// 当前页数
			shopInformationPlatformVo.setPageIndex(pageIndex);
			// 每页条数
			shopInformationPlatformVo.setPageSize(pageSize);
			// 是否删除
			shopInformationPlatformVo.setStatus(SUConstants.IS_NOT_DELETE);
			// 审核状态，0-待审核，1-已审核，2-已驳回
			shopInformationPlatformVo.setCheckStatus(0);
			List<ShopInformationPlatformVo> shopList = shopAutoMapper.queryAuditingShopList(shopInformationPlatformVo);
			if (shopList != null && shopList.size() > 0) {
				for (int i = 0; i < shopList.size(); i++) {
					ShopInformationPlatformVo shopInfo = shopList.get(i);
					// 审核状态，0-待审核，1-已审核，2-已驳回
					Integer checkStatus = shopInfo.getCheckStatus();
					// 店铺状态，0-正常，1-禁用
					Integer shopStatus = shopInfo.getShopStatus();
					// 审核状态名称
					if (checkStatus == 0) {
						shopInfo.setCheckStatusName("待审核");
					} else if (checkStatus == 1) {
						shopInfo.setCheckStatusName("已审核");
					} else {
						shopInfo.setCheckStatusName("已驳回");
					}
					// 店铺状态名称
					if (shopStatus == 0) {
						shopInfo.setShopStatusName("正常");
					} else {
						shopInfo.setShopStatusName("禁用");
					}
				}
			}
			ShopInfoListVo shopInfoList = new ShopInfoListVo();
			Count pageCount = shopAutoMapper.queryAuditingShopListCount(shopInformationPlatformVo);
			shopInfoList.setPageCount(pageCount.getCount());
			shopInfoList.setShopInforList(shopList);
			map.putAll(CommonResponseUtils.successResponse(shopInfoList));
			return map;
		} catch (Exception e) {
			logger.info("=====>>>>>>审核商家列表查询失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
