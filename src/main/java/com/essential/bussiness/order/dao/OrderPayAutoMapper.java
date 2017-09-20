package com.essential.bussiness.order.dao;

import com.essential.bussiness.order.model.auto.OrderPayAuto;
import com.essential.bussiness.order.model.auto.OrderPayAutoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderPayAutoMapper {
    int countByExample(OrderPayAutoExample example);

    int deleteByExample(OrderPayAutoExample example);

    int deleteByPrimaryKey(Long orderPayId);

    int insert(OrderPayAuto record);

    int insertSelective(OrderPayAuto record);

    List<OrderPayAuto> selectByExample(OrderPayAutoExample example);

    OrderPayAuto selectByPrimaryKey(Long orderPayId);

    int updateByExampleSelective(@Param("record") OrderPayAuto record, @Param("example") OrderPayAutoExample example);

    int updateByExample(@Param("record") OrderPayAuto record, @Param("example") OrderPayAutoExample example);

    int updateByPrimaryKeySelective(OrderPayAuto record);

    int updateByPrimaryKey(OrderPayAuto record);
}