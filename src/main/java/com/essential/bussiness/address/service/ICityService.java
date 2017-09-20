package com.essential.bussiness.address.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.bussiness.address.model.auto.CityAuto;

@Service
public interface ICityService {

	/**
	 * 查询所有省
	 * @param map
	 * @return
	 */
	public Map<String, Object> queryCityVoListByParentId(CityAuto cityAuto);

	public List<CityAuto> queryCityListByParentId(CityAuto cityAuto);
	/**
	 * 新增省
	 * @param City
	 * @return
	 */
	public Map<String, Object> saveCity(CityAuto city);

	/**
	 * update City
	 * 
	 * @param City
	 *            更新后的评论信息
	 * @return
	 */
	public Map<String, Object> updateCity(CityAuto city);

	/**
	 * delete City
	 * 
	 * @param City
	 *            更新后的评论信息
	 * @return
	 */
	public abstract Map<String, Object> deleteCity(CityAuto city);

	/**
	 * select by CityId
	 * 
	 * @param CityId
	 * @return
	 */
	public abstract Map<String, Object> selectCityById(long cityId);

}