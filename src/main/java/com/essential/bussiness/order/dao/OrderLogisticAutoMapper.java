package com.essential.bussiness.order.dao;

import com.essential.bussiness.order.model.auto.OrderLogisticAuto;
import com.essential.bussiness.order.model.auto.OrderLogisticAutoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderLogisticAutoMapper {
    int countByExample(OrderLogisticAutoExample example);

    int deleteByExample(OrderLogisticAutoExample example);

    int deleteByPrimaryKey(Long orderLogisticId);

    int insert(OrderLogisticAuto record);

    int insertSelective(OrderLogisticAuto record);

    List<OrderLogisticAuto> selectByExample(OrderLogisticAutoExample example);

    OrderLogisticAuto selectByPrimaryKey(Long orderLogisticId);

    int updateByExampleSelective(@Param("record") OrderLogisticAuto record, @Param("example") OrderLogisticAutoExample example);

    int updateByExample(@Param("record") OrderLogisticAuto record, @Param("example") OrderLogisticAutoExample example);

    int updateByPrimaryKeySelective(OrderLogisticAuto record);

    int updateByPrimaryKey(OrderLogisticAuto record);
}