package com.essential.bussiness.order.dao;

import com.essential.bussiness.order.model.auto.OrderProductPromotionAuto;
import com.essential.bussiness.order.model.auto.OrderProductPromotionAutoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderProductPromotionAutoMapper {
    int countByExample(OrderProductPromotionAutoExample example);

    int deleteByExample(OrderProductPromotionAutoExample example);

    int deleteByPrimaryKey(Long orderPromotionId);

    int insert(OrderProductPromotionAuto record);

    int insertSelective(OrderProductPromotionAuto record);

    List<OrderProductPromotionAuto> selectByExample(OrderProductPromotionAutoExample example);

    OrderProductPromotionAuto selectByPrimaryKey(Long orderPromotionId);

    int updateByExampleSelective(@Param("record") OrderProductPromotionAuto record, @Param("example") OrderProductPromotionAutoExample example);

    int updateByExample(@Param("record") OrderProductPromotionAuto record, @Param("example") OrderProductPromotionAutoExample example);

    int updateByPrimaryKeySelective(OrderProductPromotionAuto record);

    int updateByPrimaryKey(OrderProductPromotionAuto record);
}