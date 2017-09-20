package com.essential.bussiness.shop.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.bussiness.shop.model.auto.ShopAuto;
import com.essential.bussiness.shop.model.vo.ShopQualificationCartificateVO;

/**
 * 结算/资质 interface
 * 
 * @author czm
 *
 */
@Service
public interface IShopQualificationCartificateService {

	public Map<String, Object> addShopQualificationCartificate(ShopQualificationCartificateVO shopQualificationCartificateVO);

	public Map<String, Object> updateShopQualificationCartificate(ShopQualificationCartificateVO shopQualificationCartificateVO);

	public Map<String, Object> deleteShopQualificationCartificate(long shopId);

	public Map<String, Object> queryShopQualificationCartificate(long shopId);
}
