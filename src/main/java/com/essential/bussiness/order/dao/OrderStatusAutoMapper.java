package com.essential.bussiness.order.dao;

import com.essential.bussiness.order.model.auto.OrderStatusAuto;
import com.essential.bussiness.order.model.auto.OrderStatusAutoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderStatusAutoMapper {
    int countByExample(OrderStatusAutoExample example);

    int deleteByExample(OrderStatusAutoExample example);

    int deleteByPrimaryKey(Long orderStatusId);

    int insert(OrderStatusAuto record);

    int insertSelective(OrderStatusAuto record);

    List<OrderStatusAuto> selectByExample(OrderStatusAutoExample example);

    OrderStatusAuto selectByPrimaryKey(Long orderStatusId);

    int updateByExampleSelective(@Param("record") OrderStatusAuto record, @Param("example") OrderStatusAutoExample example);

    int updateByExample(@Param("record") OrderStatusAuto record, @Param("example") OrderStatusAutoExample example);

    int updateByPrimaryKeySelective(OrderStatusAuto record);

    int updateByPrimaryKey(OrderStatusAuto record);
}