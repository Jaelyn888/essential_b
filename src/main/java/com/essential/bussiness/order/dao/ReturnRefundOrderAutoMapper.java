package com.essential.bussiness.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.essential.bussiness.order.model.auto.ReturnRefundOrderAuto;
import com.essential.bussiness.order.model.auto.ReturnRefundOrderAutoExample;
import com.essential.bussiness.order.model.vo.GenerateRefundOrderVo;
import com.essential.bussiness.order.model.vo.ReturnRefundOrderVo;

public interface ReturnRefundOrderAutoMapper {
    int countByExample(ReturnRefundOrderAutoExample example);

    int deleteByExample(ReturnRefundOrderAutoExample example);

    int deleteByPrimaryKey(Long returnRefundOrderId);

    int insert(ReturnRefundOrderAuto record);

    int insertSelective(ReturnRefundOrderAuto record);

    List<ReturnRefundOrderAuto> selectByExample(ReturnRefundOrderAutoExample example);

    ReturnRefundOrderAuto selectByPrimaryKey(Long returnRefundOrderId);

    int updateByExampleSelective(@Param("record") ReturnRefundOrderAuto record, @Param("example") ReturnRefundOrderAutoExample example);

    int updateByExample(@Param("record") ReturnRefundOrderAuto record, @Param("example") ReturnRefundOrderAutoExample example);

    int updateByPrimaryKeySelective(ReturnRefundOrderAuto record);

    int updateByPrimaryKey(ReturnRefundOrderAuto record);
    
    List<ReturnRefundOrderVo> quertReturnRefundForList(ReturnRefundOrderVo returnRefundOrderVo);
    
    int quertReturnRefundForListCount(ReturnRefundOrderVo returnRefundOrderVo);
    
    List<GenerateRefundOrderVo> queryGenerateRefundOrderForList(GenerateRefundOrderVo generateRefundOrderVo);
    
    int queryGenerateRefundOrderForListCount(GenerateRefundOrderVo generateRefundOrderVo);
}