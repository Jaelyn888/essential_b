package com.essential.bussiness.shop.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.bussiness.product.controller.ProductController;
import com.essential.bussiness.product.model.vo.ProductOrShopCountVo;
import com.essential.bussiness.returns.dao.ReturnAddressAutoMapper;
import com.essential.bussiness.returns.model.auto.ReturnAddressAuto;
import com.essential.bussiness.shop.controller.ShopQualificationCartificateController;
import com.essential.bussiness.shop.dao.ShopAddInformationAutoMapper;
import com.essential.bussiness.shop.dao.ShopAutoMapper;
import com.essential.bussiness.shop.dao.ShopBankCardAutoMapper;
import com.essential.bussiness.shop.dao.ShopToContactAutoMapper;
import com.essential.bussiness.shop.model.auto.ShopAddInformationAuto;
import com.essential.bussiness.shop.model.auto.ShopAuto;
import com.essential.bussiness.shop.model.auto.ShopBankCardAuto;
import com.essential.bussiness.shop.model.auto.ShopToContactAuto;
import com.essential.bussiness.shop.model.vo.ShopAutoVO;
import com.essential.bussiness.shop.service.IShopBackstageInfoService;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.TmDateUtil;
import com.essential.user.dao.UserBaseInfoAutoMapper;
import com.essential.user.model.auto.UserBaseInfoAuto;
import com.essential.utils.CommonResponseUtils;
import com.essential.utils.DTOUtils;

/**
 * 店铺信息（商家后台）
 * 
 * @author czm
 *
 */
@Service
public class ShopBackstageInfoServiceImpl implements IShopBackstageInfoService {
	private static Logger logger = LoggerFactory.getLogger(ShopBackstageInfoServiceImpl.class);

	// 店铺表
	@Autowired
	ShopAutoMapper shopAutoMapper;
	@Autowired
	ShopAddInformationAutoMapper shopAddInformationAutoMapper;

	// 联系信息表
	@Autowired
	ShopToContactAutoMapper shopToContactAutoMapper;

	// 退货维权表
	@Autowired
	ReturnAddressAutoMapper returnAddressAutoMapper;

	// 开户银行信息表
	@Autowired
	ShopBankCardAutoMapper shopBankCardAutoMapper;
	
	// 用户信息表
	@Autowired
	UserBaseInfoAutoMapper userBaseInfoAutoMapper;

	/**
	 * 注册店铺
	 * 
	 */
	@Override
	public Map<String, Object> addShop(long userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> outputMap = new HashMap<String, Object>();
		try {
			ShopAuto shopAuto = new ShopAuto();
			// 用户Id
			shopAuto.setUserId(userId);
			// 创建时间
			shopAuto.setCreateTime(TmDateUtil.getTimeStamp());
			// 创建用户
			shopAuto.setCreateUser(userId);
			// 是否删除
			shopAuto.setStatus(SUConstants.IS_NOT_DELETE);
			int i = shopAutoMapper.insertSelective(shopAuto);
			Long shopId = shopAuto.getShopId();

			outputMap.put("shopId", shopId);
			if (i <= 0) {
				throw new Exception("注册店铺失败!");
			}

			// 更新用户信息
			UserBaseInfoAuto userBaseInfo = new UserBaseInfoAuto();
			// 用户Id
			userBaseInfo.setUserId(userId);
			// 店铺Id
			userBaseInfo.setShopId(shopId);
			// 用户类型
			userBaseInfo.setUserTypeId(Long.valueOf("1"));
			// 是否删除
			userBaseInfo.setIsDelete(SUConstants.IS_NOT_DELETE);
			int k =  userBaseInfoAutoMapper.updateByPrimaryPassword(userBaseInfo);
			if(k <= 0){
				throw new Exception("更新用户信息失败!");
			}
			
			// 店铺信息（补充表）
			ShopAddInformationAuto shopAddInformationAuto = new ShopAddInformationAuto();
			// 店铺Id
			shopAddInformationAuto.setShopId(shopId);
			// 审核状态
			shopAddInformationAuto.setCheckStatus(0);
			// 店铺状态
			shopAddInformationAuto.setShopStatus(0);
			// 创建用户Id
			shopAddInformationAuto.setCreateUser(userId);
			// 创建时间
			shopAddInformationAuto.setCreatTime(TmDateUtil.getTimeStamp());
			// 是否删除
			shopAddInformationAuto.setIsDelelte(SUConstants.IS_NOT_DELETE);
			int j = shopAddInformationAutoMapper.insertSelective(shopAddInformationAuto);
			if (j <= 0) {
				throw new Exception("添加店铺信息失败!");
			}

			map.putAll(CommonResponseUtils.successResponse(outputMap));
			return map;
		} catch (Exception e) {
			logger.info("======>>>>>>注册店铺失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 店铺信息获取
	 * 
	 */
	@Override
	public Map<String, Object> queryShopInfo(long userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		ShopAuto shopInfo = new ShopAuto();
		ShopAutoVO shopAutoVo = new ShopAutoVO();
		ShopToContactAuto shopToContactAuto = new ShopToContactAuto();
		try {
			// 店铺信息
			shopInfo.setUserId(userId);
			shopInfo.setStatus(SUConstants.IS_NOT_DELETE);
			shopInfo = shopAutoMapper.queryShopInfo(shopInfo);
			if (shopInfo != null) {
				DTOUtils.map(shopInfo, shopAutoVo);

				// 审核状态
				if (shopInfo.getCheckTime() != null && !"".equals(shopInfo.getCheckTime())) {
					shopAutoVo.setCheckStatusName("已审核");
				} else {
					shopAutoVo.setCheckStatusName("待审核");
				}

				Long shopId = shopInfo.getShopId();
				// 获取联系人手机号
				shopToContactAuto = shopToContactAutoMapper.queryInfoByShopId(shopId);
				if (shopToContactAuto != null) {
					// 联系人手机
					shopAutoVo.setContactPhone(shopToContactAuto.getContactPhone());
					// 联系人手机Id contactId
					shopAutoVo.setContactId(shopToContactAuto.getContactId());
				}

				// 退货地址信息
				// 参数传入
				Map<String, Object> inputMap = new HashMap<String, Object>();
				// 店铺Id
				inputMap.put("shopId", shopId);
				// 是否删除标记：0-未删除；1-已删除
				inputMap.put("isDelete", SUConstants.IS_NOT_DELETE);
				List<ReturnAddressAuto> returnAddressAutoList = returnAddressAutoMapper.queryReturnRightsAddress(inputMap);
				shopAutoVo.setReturnAddressAutoList(returnAddressAutoList);

				// 银行开户信息
				ShopBankCardAuto shopBankCardAuto = new ShopBankCardAuto();
				// 店铺Id
				shopBankCardAuto.setShopId(shopId);
				// 是否删除标记：0-未删除；1-已删除
				shopBankCardAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
				List<ShopBankCardAuto> openingBankInfomationList = shopBankCardAutoMapper.queryByPrimaryKey(shopBankCardAuto);
				shopAutoVo.setOpeningBankInfomationList(openingBankInfomationList);

				map.putAll(CommonResponseUtils.successResponse(shopAutoVo));
			} else {
				map.put(SUConstants.CODE_KEY, "2");
				map.put(SUConstants.MSG_KEY, "无店铺信息!");
			}
			return map;
		} catch (Exception e) {
			logger.info("======>>>>>>店铺信息查询失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 店铺信息更新
	 */
	@Override
	public Map<String, Object> updateShopInfo(ShopAutoVO shopAutoVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		ShopAuto shopAuto = new ShopAuto();
		ShopToContactAuto shopToContactAuto = new ShopToContactAuto();
		try {
			// 店铺信息更新
			String dateTime = TmDateUtil.getTimeStamp();
			DTOUtils.map(shopAutoVo, shopAuto);
			shopAuto.setModifyTime(dateTime);
			int i = shopAutoMapper.updateByPrimaryKeySelective(shopAuto);

			if (i <= 0) {
				throw new Exception("店铺信息更新失败!");
			}

			// 登录用户
			Long loginUser = shopAutoVo.getLoginUser();
			// 联系人手机Id
			Long contactId = shopAutoVo.getContactId();
			// 联系人手机
			shopToContactAuto.setContactPhone(shopAutoVo.getContactPhone());
			// 店铺id
			shopToContactAuto.setShopId(shopAutoVo.getShopId());

			if (contactId != null) {
				// 更新时间
				shopToContactAuto.setModifyTime(dateTime);
				// 更新用户
				shopToContactAuto.setModifyUser(loginUser);
				// 联系人手机Id
				shopToContactAuto.setContactId(contactId);
				int j = shopToContactAutoMapper.updateByPrimaryKeySelective(shopToContactAuto);

				if (j <= 0) {
					throw new Exception("店铺联系人手机号信息更新失败!");
				}
			} else {
				// 创建用户
				shopToContactAuto.setCreateUser(loginUser);
				// 创建时间
				shopToContactAuto.setCreateTime(dateTime);
				// 是否删除
				shopToContactAuto.setStatus(Long.valueOf("0"));
				int j = shopToContactAutoMapper.insertSelective(shopToContactAuto);
				if (j <= 0) {
					throw new Exception("店铺联系人手机号信息更新失败!");
				}
			}
			// // 退货地址信息
			// List<ReturnAddressAuto> returnAddressAutoList =
			// shopAutoVo.getReturnAddressAutoList();
			// if (returnAddressAutoList != null) {
			// for (int k = 0; k < returnAddressAutoList.size(); k++) {
			// int f = 0;
			// ReturnAddressAuto returnAddressAuto =
			// returnAddressAutoList.get(i);
			// // 退货地址信息Id
			// Long returnaddressId = returnAddressAuto.getReturnaddressId();
			// if (returnaddressId != null) {
			// // 更新时间
			// returnAddressAuto.setModifyTime(dateTime);
			// // 更新用户
			// returnAddressAuto.setModifyUser(loginUser);
			// f =
			// returnAddressAutoMapper.updateByPrimaryKeySelective(returnAddressAuto);
			//
			// } else {
			// // 创建时间
			// returnAddressAuto.setCreateTime(dateTime);
			// // 创建用户
			// returnAddressAuto.setCreateUser(loginUser);
			// // 店铺Id
			// returnAddressAuto.setShopId(shopAutoVo.getShopId());
			// // 是否删除
			// returnAddressAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			// f = returnAddressAutoMapper.insertSelective(returnAddressAuto);
			// }
			// if (f <= 0) {
			// throw new Exception("退货地址信息更新失败!");
			// }
			// }
			// }
			//
			// // 银行开户信息
			// List<ShopBankCardAuto> openingBankInfomationList =
			// shopAutoVo.getOpeningBankInfomationList();
			// if (openingBankInfomationList != null) {
			// for (int k = 0; k < openingBankInfomationList.size(); k++) {
			// int f = 0;
			// ShopBankCardAuto shopBankCardAuto =
			// openingBankInfomationList.get(k);
			// // 银行开户信息Id
			// Long id = shopBankCardAuto.getId();
			// if (id != null) {
			// // 修改时间
			// shopBankCardAuto.setModifyTime(dateTime);
			// // 修改用户
			// shopBankCardAuto.setModifyUser(loginUser);
			// f =
			// shopBankCardAutoMapper.updateByPrimaryKeySelective(shopBankCardAuto);
			// } else {
			// // 创建时间
			// shopBankCardAuto.setCreateTime(dateTime);
			// // 创建用户
			// shopBankCardAuto.setCreateUser(loginUser);
			// // 是否删除
			// shopBankCardAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			// f = shopBankCardAutoMapper.insertSelective(shopBankCardAuto);
			// }
			// if (f <= 0) {
			// throw new Exception("银行开户信息更新失败!");
			// }
			// }
			// }

			map.putAll(CommonResponseUtils.successResponse("店铺信息更新成功!"));
		} catch (Exception e) {
			logger.info("=====>>>>>>店铺信息更新失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return map;
	}

	/**
	 * 商家统计
	 */
	@Override
	public Map<String, Object> shopCount() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			ProductOrShopCountVo outputMAp = shopAutoMapper.shopCount();
			map.putAll(CommonResponseUtils.successResponse(outputMAp));
			return map;
		} catch (Exception e) {
			logger.info("=====>>>>>>商家统计:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
