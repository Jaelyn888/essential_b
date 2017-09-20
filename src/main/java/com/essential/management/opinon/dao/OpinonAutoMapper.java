package com.essential.management.opinon.dao;

import java.util.List;
import java.util.Map;

import com.essential.management.opinon.model.auto.OpinonAuto;
import com.essential.management.opinon.model.vo.CountVo;
import com.essential.management.opinon.model.vo.OpinonAutoVo;

public interface OpinonAutoMapper {
	int deleteByPrimaryKey(Long opinionId);

	int insert(OpinonAuto record);

	int insertSelective(OpinonAuto record);

	OpinonAuto selectByPrimaryKey(Long opinionId);

	int updateByPrimaryKeySelective(OpinonAuto record);

	int updateByPrimaryKey(OpinonAuto record);

	// 查询意见信息
	List<OpinonAutoVo> queryByPrimaryKey(Map<String, Object> record);
	
	// 意见总数
	CountVo opinonCount();
}