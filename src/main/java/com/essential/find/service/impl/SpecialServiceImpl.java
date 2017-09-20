package com.essential.find.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.find.dao.SpecialAutoMapper;
import com.essential.find.model.auto.SpecialAuto;
import com.essential.find.service.ISpecialService;

@Service
public class SpecialServiceImpl implements ISpecialService {
	@Autowired
	SpecialAutoMapper mapper;
	
	/* 
	 * 查询一个 精选详情
	 * @parameter
	 */
	@Override
	public SpecialAuto selectSpecial(SpecialAuto findSpecialAuto) {
		return mapper.selectByPrimaryKey(findSpecialAuto.getSpecialId());
	}
	
	/* 
	 * 创建一个精选类目
	 * @parameter
	 */
	@Override
	public boolean createSpecial(SpecialAuto findSpecialAuto) {
		boolean flag = false;
		try {
			mapper.insertSelective(findSpecialAuto);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	/* 删除一个精选类目
	 * @parameter
	 */
	@Override
	public boolean deleteSpecial(SpecialAuto findSpecialAuto) {
		boolean flag = false;
		try {
			mapper.updateByPrimaryKeySelective(findSpecialAuto);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	/* 
	 * 更新一个精选类目
	 * @parameter
	 */
	@Override
	public boolean updateSpecial(SpecialAuto findSpecialAuto) {
		boolean flag = false;
		try {
			mapper.updateByPrimaryKeySelective(findSpecialAuto);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	/* 
	 * 查询 精选 列表
	 * @parameter
	 */
	@Override
	public List<Object> selectSpecialList(HashMap<String, Object> map) {
		return mapper.selectSpecialList(map);
	}
}
