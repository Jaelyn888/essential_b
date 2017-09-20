package com.essential.bussiness.order.dao;

import com.essential.bussiness.order.model.auto.OrderStatusItemAuto;
import com.essential.bussiness.order.model.auto.OrderStatusItemAutoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderStatusItemAutoMapper {
    int countByExample(OrderStatusItemAutoExample example);

    int deleteByExample(OrderStatusItemAutoExample example);

    int deleteByPrimaryKey(Integer orderStatusItemId);

    int insert(OrderStatusItemAuto record);

    int insertSelective(OrderStatusItemAuto record);

    List<OrderStatusItemAuto> selectByExample(OrderStatusItemAutoExample example);

    OrderStatusItemAuto selectByPrimaryKey(Integer orderStatusItemId);

    int updateByExampleSelective(@Param("record") OrderStatusItemAuto record, @Param("example") OrderStatusItemAutoExample example);

    int updateByExample(@Param("record") OrderStatusItemAuto record, @Param("example") OrderStatusItemAutoExample example);

    int updateByPrimaryKeySelective(OrderStatusItemAuto record);

    int updateByPrimaryKey(OrderStatusItemAuto record);
}