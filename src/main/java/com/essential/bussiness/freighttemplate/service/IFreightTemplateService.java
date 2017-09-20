package com.essential.bussiness.freighttemplate.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.essential.bussiness.freighttemplate.model.auto.FreightGroupNameAuto;
import com.essential.bussiness.freighttemplate.model.vo.FreightGroupNameVo;
import com.essential.user.model.vo.UserReceiptAddressVo;

public interface IFreightTemplateService {

	/**
	 * 根据页码分页查询运费模板
	 */
	public HashMap<String, Object> queryFreightTemplateList(Map<String, Object> requestMap);

	/**
	 * 根据商品数量，运费模板、收货地址  计算运费总额
	 */
	public Map<String, Object> queryFreightByAddressId(UserReceiptAddressVo userReceiptAddressVo);
	
	/**
	 * 根据店铺id  查询运费模板
	 * @param freightGroupNameAuto
	 * @return
	 */
	public List<FreightGroupNameVo> queryFreightGroupList(Map<String,Object> requstMap);
	
	public Map<String, Object> saveOrUpdateFreightTemplateAndGroup(FreightGroupNameAuto freightGroupNameAuto);

	/**
	 * 根据店铺id 查询运费模板
	 * 
	 * @param freightGroupNameAuto
	 * @return
	 */
	HashMap<String, Object> deleteFreightGroupList(FreightGroupNameAuto freightGroupNameAuto);

}