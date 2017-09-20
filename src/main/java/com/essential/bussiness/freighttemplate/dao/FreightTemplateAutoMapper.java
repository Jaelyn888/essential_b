package com.essential.bussiness.freighttemplate.dao;

import java.util.List;

import com.essential.bussiness.freighttemplate.model.auto.FreightGroupNameAuto;
import com.essential.bussiness.freighttemplate.model.auto.FreightTemplateAuto;

public interface FreightTemplateAutoMapper {
    int deleteByPrimaryKey(Long freightId);

    int insert(FreightTemplateAuto record);

    int insertSelective(FreightTemplateAuto record);

    FreightTemplateAuto selectByPrimaryKey(Long freightId);

    int updateByPrimaryKeySelective(FreightTemplateAuto record);

    int updateByPrimaryKey(FreightTemplateAuto record);
    
    List<FreightTemplateAuto> queryFreightTemplateList(FreightTemplateAuto record);

    /**
     * 批量保存
     * @param freightGroupId
     * @param freightTemplateAutoList
     * @return
     */
	int insertSelectiveList(FreightGroupNameAuto freightGroupNameAuto);
}