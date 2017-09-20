package com.essential.bussiness.product.dao;

import com.essential.bussiness.product.model.auto.LinkProductAuto;
import com.essential.bussiness.product.model.vo.LinkProductInfo;

public interface LinkProductAutoMapper {
    int deleteByPrimaryKey(Long linkId);

    int insert(LinkProductAuto record);

    int insertSelective(LinkProductAuto record);

    LinkProductAuto selectByPrimaryKey(Long linkId);

    int updateByPrimaryKeySelective(LinkProductAuto record);

    int updateByPrimaryKey(LinkProductAuto record);

    /**
     * 根据id  查询基本信息
     * @param linkProductAuto
     * @return
     */
	LinkProductInfo queryProductInfo(LinkProductAuto linkProductAuto);
	
	
}