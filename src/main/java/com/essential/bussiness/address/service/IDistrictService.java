package com.essential.bussiness.address.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.bussiness.address.model.auto.DistrictAuto;
@Service
public interface IDistrictService {

	/**
	 * 查询所有区、县
	 * @param map
	 * @return
	 */
	public Map<String,Object> queryDistrictVoListByParentId(DistrictAuto districtAuto);
	public List<DistrictAuto> queryDistrictListByParentId(DistrictAuto districtAuto);
	/**
	 * 新增区、县
	 * @param District
	 * @return
	 */
	public abstract Map<String, Object> saveDistrict(DistrictAuto district);

	/**
	 * update District
	 * 
	 * @param District
	 *            更新后的评论信息
	 * @return
	 */
	public abstract Map<String, Object> updateDistrict(DistrictAuto district);

	/**
	 * delete District
	 * 
	 * @param District
	 *            更新后的评论信息
	 * @return
	 */
	public abstract Map<String, Object> deleteDistrict(DistrictAuto district);

	/**
	 * select by DistrictId
	 * 
	 * @param DistrictId
	 * @return
	 */
	public abstract Map<String, Object> queryDistrictById(long districtId);

}