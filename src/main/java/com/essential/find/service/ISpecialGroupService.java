package com.essential.find.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.essential.find.model.auto.SpecialGroupAuto;
import com.essential.find.model.vo.SpecialGroupVo;

@Service
public interface ISpecialGroupService {
	/**
	 * select all special group
	 * @return
	 */
	public List<SpecialGroupAuto> queryAllSpecialGroup();
	
	/**
	 * save one special group
	 * @param findSpecialGroupAuto
	 * @return
	 */
	public boolean saveSpecialGroup(SpecialGroupAuto findSpecialGroupAuto);
	
	/**
	 * update someone special group
	 * @param findSpecialGroupAuto
	 * @return
	 */
	public boolean updateSpecialGroup(SpecialGroupAuto findSpecialGroupAuto);
	
	/**
	 * query one special group info by groupId
	 * @param groupId
	 * @return
	 */
	public SpecialGroupAuto querySpecialGroupById(SpecialGroupAuto findSpecialGroupAuto);
	
	/**
	 * update someone special group
	 * @param findSpecialGroupAuto
	 * @return
	 */
	public boolean deleteSpecialGroup(SpecialGroupAuto findSpecialGroupAuto);

	public List<SpecialGroupVo> querySpecialGroupVoList();
	
}
