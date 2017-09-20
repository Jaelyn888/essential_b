package com.essential.bussiness.shop.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.bussiness.shop.dao.ShopAutoMapper;
import com.essential.bussiness.shop.dao.ShopBankCardAutoMapper;
import com.essential.bussiness.shop.model.auto.ShopAuto;
import com.essential.bussiness.shop.model.auto.ShopBankCardAuto;
import com.essential.bussiness.shop.model.vo.ShopQualificationCartificateVO;
import com.essential.bussiness.shop.service.IShopQualificationCartificateService;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.TmDateUtil;
import com.essential.utils.CommonResponseUtils;

/**
 * 结算/资质 Service
 * 
 * @author czm
 *
 */
@Service
public class ShopQualificationCartificateServiceImpl implements IShopQualificationCartificateService {
	private static Logger logger = LoggerFactory.getLogger(ShopQualificationCartificateServiceImpl.class);

	@Autowired
	ShopAutoMapper shopAutoMapper;

	@Autowired
	ShopBankCardAutoMapper shopBankCardAutoMapper;

	/**
	 * 增加结算/资质信息
	 */
	@Override
	public Map<String, Object> addShopQualificationCartificate(ShopQualificationCartificateVO shopQualificationCartificateVO) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			int k = 0;
			// 获取时间戳
			String dateTime = TmDateUtil.getTimeStamp();
			// 店铺Id
			long shopId = shopQualificationCartificateVO.getShopId();
			// 登录用户
			long loginUser = shopQualificationCartificateVO.getLoginUser();

			ShopAuto shopAuto = new ShopAuto();
			// 公司名称
			shopAuto.setCompanyName(shopQualificationCartificateVO.getCompanyName());
			// 税务登记号码
			shopAuto.setTaxRegistrationNumber(shopQualificationCartificateVO.getTaxRegistrationNumber());
			// 省Id
			shopAuto.setProvinceId(shopQualificationCartificateVO.getProvinceId());
			// 市Id
			shopAuto.setCityId(shopQualificationCartificateVO.getCityId());
			// 区（县）Id
			shopAuto.setDistrictId(shopQualificationCartificateVO.getDistrictId());
			// 详细地址
			shopAuto.setDetailAddress(shopQualificationCartificateVO.getDetailAddress());
			// 电话
			shopAuto.setFixedTelephone(shopQualificationCartificateVO.getFixedTelephone());
			// 公司法人身份证正面
			shopAuto.setLegalidScan(shopQualificationCartificateVO.getLegalidScan());
			// 公司法人身份证反面
			shopAuto.setLegalidBackScan(shopQualificationCartificateVO.getLegalidBackScan());
			// 营业执照
			shopAuto.setBussinessLicenceScan(shopQualificationCartificateVO.getBussinessLicenceScan());
			// 税务登记证扫描件
			shopAuto.setTaxRegistrationCertificateScan(shopQualificationCartificateVO.getTaxRegistrationCertificateScan());
			// 组织机构代码证
			shopAuto.setOrganizationCodeScan(shopQualificationCartificateVO.getOrganizationCodeScan());
			// 开户许可证
			shopAuto.setAccountOpeningLicenseScan(shopQualificationCartificateVO.getAccountOpeningLicenseScan());

			int i = shopAutoMapper.updateByPrimaryKeySelective(shopAuto);
			if (i > 0) {
				List<ShopBankCardAuto> openingBankInfomationList = shopQualificationCartificateVO.getOpeningBankInfomation();
				for (int j = 0; j < openingBankInfomationList.size(); j++) {
					ShopBankCardAuto shopBankCardAuto = openingBankInfomationList.get(j);
					shopBankCardAuto.setShopId(shopId);
					shopBankCardAuto.setCreateTime(dateTime);
					shopBankCardAuto.setCreateUser(loginUser);
					shopBankCardAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
					k = shopBankCardAutoMapper.insertSelective(shopBankCardAuto);
					if (k <= 0)
						throw new Exception("增加银行账户信息失败");
				}
			} else {
				throw new Exception("增加结算/资质信息失败");
			}
			map.putAll(CommonResponseUtils.successResponse("增加结算/资质信息成功!"));
			return map;
		} catch (Exception e) {
			logger.info("=========>>>>>>增加结算/资质信息失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		
	}

	/**
	 * 更新结算/资质信息
	 */
	@Override
	public Map<String, Object> updateShopQualificationCartificate(ShopQualificationCartificateVO shopQualificationCartificateVO) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			int k = 0;
			// 获取时间戳
			String dateTime = TmDateUtil.getTimeStamp();
			// 店铺Id
			long shopId = shopQualificationCartificateVO.getShopId();
			// 登录用户
			long loginUser = shopQualificationCartificateVO.getLoginUser();
			//是否相同
			long isSame = shopQualificationCartificateVO.getIsSame();
			

			ShopAuto shopAuto = new ShopAuto();
			//店铺Id
			shopAuto.setShopId(shopId);
			//修改用户
			shopAuto.setModifyUser(loginUser);
			//修改时间
			shopAuto.setModifyTime(dateTime);
			shopAuto.setUserId(loginUser);
			//开票账户和结算账户是否相同
			shopAuto.setIsSame(isSame);
			// 公司名称
			shopAuto.setCompanyName(shopQualificationCartificateVO.getCompanyName());
			// 税务登记号码
			shopAuto.setTaxRegistrationNumber(shopQualificationCartificateVO.getTaxRegistrationNumber());
			// 省Id
			shopAuto.setProvinceId(shopQualificationCartificateVO.getProvinceId());
			// 市Id
			shopAuto.setCityId(shopQualificationCartificateVO.getCityId());
			// 区（县）Id
			shopAuto.setDistrictId(shopQualificationCartificateVO.getDistrictId());
			// 详细地址
			shopAuto.setDetailAddress(shopQualificationCartificateVO.getDetailAddress());
			// 电话
			shopAuto.setFixedTelephone(shopQualificationCartificateVO.getFixedTelephone());
			// 公司法人身份证正面
			shopAuto.setLegalidScan(shopQualificationCartificateVO.getLegalidScan());
			// 公司法人身份证反面
			shopAuto.setLegalidBackScan(shopQualificationCartificateVO.getLegalidBackScan());
			// 营业执照
			shopAuto.setBussinessLicenceScan(shopQualificationCartificateVO.getBussinessLicenceScan());
			// 税务登记证扫描件
			shopAuto.setTaxRegistrationCertificateScan(shopQualificationCartificateVO.getTaxRegistrationCertificateScan());
			// 组织机构代码证
			shopAuto.setOrganizationCodeScan(shopQualificationCartificateVO.getOrganizationCodeScan());
			// 开户许可证
			shopAuto.setAccountOpeningLicenseScan(shopQualificationCartificateVO.getAccountOpeningLicenseScan());

			int i = shopAutoMapper.updateByPrimaryKeySelective(shopAuto);
			if (i > 0) {
				ShopBankCardAuto shopBankCard = new ShopBankCardAuto();
				// 店铺Id
				shopBankCard.setShopId(shopId);
				// 是否删除
				shopBankCard.setIsDelete(SUConstants.IS_NOT_DELETE);
				List<ShopBankCardAuto> openingBankList = shopBankCardAutoMapper.queryByPrimaryKey(shopBankCard);
				// 查询出两条数据且开票信息与结算信息账户相同时
				if(openingBankList.size() >1 && isSame == 1){
					shopBankCard.setType(Long.valueOf(1));
					shopBankCard.setIsDelete(SUConstants.IS_DELETE);
					int y = shopBankCardAutoMapper.updateIsDeleteKey(shopBankCard);
					if(y <= 0){
						throw new Exception("开票信息与结算信息由不同改变成相同时，删除结算账户失败!");
					}
				}

				List<ShopBankCardAuto> openingBankInfomationList = shopQualificationCartificateVO.getOpeningBankInfomation();
				for (int j = 0; j < openingBankInfomationList.size(); j++) {
					ShopBankCardAuto shopBankCardAuto = openingBankInfomationList.get(j);
					Long id = shopBankCardAuto.getId();
					shopBankCardAuto.setShopId(shopId);
					shopBankCardAuto.setCreateTime(dateTime);
					shopBankCardAuto.setCreateUser(loginUser);
					shopBankCardAuto.setIsDelete(SUConstants.IS_NOT_DELETE);

					if(id != null){
						k = shopBankCardAutoMapper.updateByPrimaryKey(shopBankCardAuto);
					}else{
						k = shopBankCardAutoMapper.insertSelective(shopBankCardAuto);
					}
					if (k <= 0)
						throw new Exception("更新银行账户信息失败");
				}
			} else {
				throw new Exception("更新结算/资质信息失败");
			}
			map.putAll(CommonResponseUtils.successResponse());
			return map;
		} catch (Exception e) {
			logger.info("=========>>>>>>更新结算/资质信息失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		
	}

	/**
	 * 删除结算/资质信息
	 */
	@Override
	public Map<String, Object> deleteShopQualificationCartificate(long shopId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ShopBankCardAuto shopBankCardAuto = new ShopBankCardAuto();
			shopBankCardAuto.setShopId(shopId);
			shopBankCardAuto.setIsDelete(SUConstants.IS_DELETE);
			int i = shopBankCardAutoMapper.updateIsDeleteKey(shopBankCardAuto);
			if (i <= 0) {
				map.putAll(CommonResponseUtils.failureResponse("删除成功"));
			}else{
				map.putAll(CommonResponseUtils.successResponse("删除成功"));
			}
			return map;
		} catch (Exception e) {
			logger.info("=========>>>>>>删除结算/资质信息失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	
	}

	/**
	 * 查询结算/资质信息
	 */
	@Override
	public Map<String, Object> queryShopQualificationCartificate(long shopId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ShopAuto shopAuto = new ShopAuto();
			shopAuto = shopAutoMapper.selectByPrimaryKey(shopId);

			ShopQualificationCartificateVO shopQualificationCartificateVO = new ShopQualificationCartificateVO();

			// 店铺Id
			shopQualificationCartificateVO.setShopId(shopAuto.getShopId());
			// 公司名称
			shopQualificationCartificateVO.setCompanyName(shopAuto.getCompanyName());
			// 税务登记号码
			shopQualificationCartificateVO.setTaxRegistrationNumber(shopAuto.getTaxRegistrationNumber());
			// 省Id
			shopQualificationCartificateVO.setProvinceId(shopAuto.getProvinceId());
			// 市Id
			shopQualificationCartificateVO.setCityId(shopAuto.getCityId());
			// 区（县）Id
			shopQualificationCartificateVO.setDistrictId(shopAuto.getDistrictId());
			// 详细地址
			shopQualificationCartificateVO.setDetailAddress(shopAuto.getDetailAddress());
			// 电话
			shopQualificationCartificateVO.setFixedTelephone(shopAuto.getFixedTelephone());
			// 公司法人身份证正面
			shopQualificationCartificateVO.setLegalidScan(shopAuto.getLegalidScan());
			// 公司法人身份证反面
			shopQualificationCartificateVO.setLegalidBackScan(shopAuto.getLegalidBackScan());
			// 营业执照
			shopQualificationCartificateVO.setBussinessLicenceScan(shopAuto.getBussinessLicenceScan());
			// 税务登记证扫描件
			shopQualificationCartificateVO.setTaxRegistrationCertificateScan(shopAuto.getTaxRegistrationCertificateScan());
			// 组织机构代码证
			shopQualificationCartificateVO.setOrganizationCodeScan(shopAuto.getOrganizationCodeScan());
			// 开户许可证
			shopQualificationCartificateVO.setAccountOpeningLicenseScan(shopAuto.getAccountOpeningLicenseScan());
			//开票账户和结算账户是否相同 ,0-不相同，1-相同
			shopQualificationCartificateVO.setIsSame(shopAuto.getIsSame());

			ShopBankCardAuto shopBankCardAuto = new ShopBankCardAuto();
			shopBankCardAuto.setShopId(shopId);
			shopBankCardAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			List<ShopBankCardAuto> openingBankInfomationList = shopBankCardAutoMapper.queryByPrimaryKey(shopBankCardAuto);
			// 开户银行
			shopQualificationCartificateVO.setOpeningBankInfomation(openingBankInfomationList);
			map.putAll(CommonResponseUtils.successResponse(shopQualificationCartificateVO));
			return map;
		} catch (Exception e) {
			logger.info("=========>>>>>>查询结算/资质信息失败:" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

}
