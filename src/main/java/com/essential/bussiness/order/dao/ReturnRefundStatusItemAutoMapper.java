package com.essential.bussiness.order.dao;

import com.essential.bussiness.order.model.auto.ReturnRefundStatusItemAuto;
import com.essential.bussiness.order.model.auto.ReturnRefundStatusItemAutoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReturnRefundStatusItemAutoMapper {
    int countByExample(ReturnRefundStatusItemAutoExample example);

    int deleteByExample(ReturnRefundStatusItemAutoExample example);

    int deleteByPrimaryKey(Integer returnRefundStatusItemId);

    int insert(ReturnRefundStatusItemAuto record);

    int insertSelective(ReturnRefundStatusItemAuto record);

    List<ReturnRefundStatusItemAuto> selectByExample(ReturnRefundStatusItemAutoExample example);

    ReturnRefundStatusItemAuto selectByPrimaryKey(Integer returnRefundStatusItemId);

    int updateByExampleSelective(@Param("record") ReturnRefundStatusItemAuto record, @Param("example") ReturnRefundStatusItemAutoExample example);

    int updateByExample(@Param("record") ReturnRefundStatusItemAuto record, @Param("example") ReturnRefundStatusItemAutoExample example);

    int updateByPrimaryKeySelective(ReturnRefundStatusItemAuto record);

    int updateByPrimaryKey(ReturnRefundStatusItemAuto record);
}