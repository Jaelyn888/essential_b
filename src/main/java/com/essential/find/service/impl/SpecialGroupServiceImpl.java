package com.essential.find.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.common.constants.SUConstants;
import com.essential.find.dao.SpecialGroupAutoMapper;
import com.essential.find.model.auto.SpecialGroupAuto;
import com.essential.find.model.vo.SpecialGroupVo;
import com.essential.find.service.ISpecialGroupService;
import com.essential.utils.DTOUtils;

@Service
public class SpecialGroupServiceImpl implements ISpecialGroupService {
	@Autowired
	private SpecialGroupAutoMapper findSpecialGroupAutoMapper;
	
	/* 
	 * @see com.essential.find.service.SpecialGroupService#saveSpecialGroup(com.essential.find.model.auto.FindSpecialGroupAuto)
	 */
	@Override
	public boolean saveSpecialGroup(SpecialGroupAuto findSpecialGroupAuto) {
		boolean flag = false;
		try {
			int i = findSpecialGroupAutoMapper.insert(findSpecialGroupAuto);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	/* 
	 * @see com.essential.find.service.SpecialGroupService#updateSpecialGroup(com.essential.find.model.auto.FindSpecialGroupAuto)
	 */
	@Override
	public boolean updateSpecialGroup(SpecialGroupAuto findSpecialGroupAuto) {
		boolean flag = false;
		try {
			findSpecialGroupAutoMapper.updateByPrimaryKeySelective(findSpecialGroupAuto);
			flag = true;
			} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	/* 
	 * @see com.essential.find.service.SpecialGroupService#selectSpecialGroupById(long)
	 */
	@Override
	public SpecialGroupAuto querySpecialGroupById(SpecialGroupAuto findSpecialGroupAuto) {
		return findSpecialGroupAutoMapper.selectByPrimaryKey(findSpecialGroupAuto.getSpecialGroupId());
	}
	/* 
	 * @see com.essential.find.service.SpecialGroupService#getAllSpecialGroup()
	 */
	@Override
	public List<SpecialGroupAuto> queryAllSpecialGroup() {
		return findSpecialGroupAutoMapper.selectAllSpecialGroup();
	}
	
	/* 
	 * @see com.essential.find.service.SpecialGroupService#deleteSpecialGroup(com.essential.find.model.auto.FindSpecialGroupAuto)
	 */
	@Override
	public boolean deleteSpecialGroup(SpecialGroupAuto findSpecialGroupAuto) {
		findSpecialGroupAutoMapper.updateByPrimaryKeySelective(findSpecialGroupAuto);
		return true;
	}
	@Override
	public List<SpecialGroupVo> querySpecialGroupVoList() {
		try {
			List<SpecialGroupAuto> specialGroupAutoList=queryAllSpecialGroup();
			List<SpecialGroupVo> specialGroupVoList=DTOUtils.map(specialGroupAutoList, SpecialGroupVo.class);
			return specialGroupVoList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<SpecialGroupVo>();
		}
	}
}
