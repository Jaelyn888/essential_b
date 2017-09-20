package com.essential.bussiness.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.essential.bussiness.order.model.auto.ReturnRefundStatusAuto;
import com.essential.bussiness.order.model.auto.ReturnRefundStatusAutoExample;
import com.essential.bussiness.order.model.vo.ReturnRefundOrderStatusVo;

public interface ReturnRefundStatusAutoMapper {
    int countByExample(ReturnRefundStatusAutoExample example);

    int deleteByExample(ReturnRefundStatusAutoExample example);

    int deleteByPrimaryKey(Long returnRefundStatusId);

    int insert(ReturnRefundStatusAuto record);

    int insertSelective(ReturnRefundStatusAuto record);

    List<ReturnRefundStatusAuto> selectByExample(ReturnRefundStatusAutoExample example);

    ReturnRefundStatusAuto selectByPrimaryKey(Long returnRefundStatusId);

    int updateByExampleSelective(@Param("record") ReturnRefundStatusAuto record, @Param("example") ReturnRefundStatusAutoExample example);

    int updateByExample(@Param("record") ReturnRefundStatusAuto record, @Param("example") ReturnRefundStatusAutoExample example);

    int updateByPrimaryKeySelective(ReturnRefundStatusAuto record);

    int updateByPrimaryKey(ReturnRefundStatusAuto record);
    
    List<ReturnRefundOrderStatusVo> queryByReturnRefundOrderIdForList(ReturnRefundOrderStatusVo returnRefundOrderStatusVo);
}