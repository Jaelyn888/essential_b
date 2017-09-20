package com.essential.bussiness.order.dao;

import com.essential.bussiness.order.model.auto.ReturnRefundOrderPicAuto;
import com.essential.bussiness.order.model.auto.ReturnRefundOrderPicAutoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReturnRefundOrderPicAutoMapper {
    int countByExample(ReturnRefundOrderPicAutoExample example);

    int deleteByExample(ReturnRefundOrderPicAutoExample example);

    int deleteByPrimaryKey(Long returnRefundOrderPicId);

    int insert(ReturnRefundOrderPicAuto record);

    int insertSelective(ReturnRefundOrderPicAuto record);

    List<ReturnRefundOrderPicAuto> selectByExample(ReturnRefundOrderPicAutoExample example);

    ReturnRefundOrderPicAuto selectByPrimaryKey(Long returnRefundOrderPicId);

    int updateByExampleSelective(@Param("record") ReturnRefundOrderPicAuto record, @Param("example") ReturnRefundOrderPicAutoExample example);

    int updateByExample(@Param("record") ReturnRefundOrderPicAuto record, @Param("example") ReturnRefundOrderPicAutoExample example);

    int updateByPrimaryKeySelective(ReturnRefundOrderPicAuto record);

    int updateByPrimaryKey(ReturnRefundOrderPicAuto record);
}