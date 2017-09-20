package com.essential.bussiness.address.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.bussiness.address.model.auto.ProvinceAuto;
@Service
public interface IProvinceService {

	/**
	 * 查询所有省
	 * @param map
	 * @return
	 */
	public Map<String, Object> queryProvinceList(Map<String, Object> map);

	/**
	 * 新增省
	 * @param Province
	 * @return
	 */
	public  Map<String, Object> saveProvince(ProvinceAuto province);

	/**
	 * update Province
	 * 
	 * @param Province
	 *          
	 * @return
	 */
	public  Map<String, Object> updateProvince(ProvinceAuto province);

	/**
	 * delete Province
	 * 
	 * @param Province
	 *            
	 * @return
	 */
	public Map<String, Object> deleteProvince(ProvinceAuto province);

	/**
	 * select by provinceId
	 * 
	 * @param provinceId
	 * @return
	 */
	public Map<String, Object> queryProvinceById(long provinceId);

	public Map<String, Object> queryAreaList(Map<String,Object> map);

}