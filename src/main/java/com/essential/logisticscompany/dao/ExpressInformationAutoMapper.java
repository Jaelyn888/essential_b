package com.essential.logisticscompany.dao;

import java.util.List;

import com.essential.logisticscompany.model.auto.ExpressInformationAuto;
import com.essential.logisticscompany.model.vo.ExpressInformationVo;

public interface ExpressInformationAutoMapper {
	int deleteByPrimaryKey(Long expressId);

	int insert(ExpressInformationAuto record);

	int insertSelective(ExpressInformationAuto record);

	ExpressInformationAuto selectByPrimaryKey(Long expressId);

	int updateByPrimaryKeySelective(ExpressInformationAuto record);

	int updateByPrimaryKey(ExpressInformationAuto record);

	List<ExpressInformationAuto> queryExpressInfo(ExpressInformationVo record);
}