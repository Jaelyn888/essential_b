package com.essential.bussiness.order.dao;

import com.essential.bussiness.order.model.auto.OrderProductAuto;
import com.essential.bussiness.order.model.auto.OrderProductAutoExample;
import com.essential.bussiness.order.model.vo.SearchOrderVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface OrderProductAutoMapper {
    int countByExample(OrderProductAutoExample example);

    int deleteByExample(OrderProductAutoExample example);

    int deleteByPrimaryKey(Long orderProductId);

    int insert(OrderProductAuto record);

    int insertSelective(OrderProductAuto record);

    List<OrderProductAuto> selectByExample(OrderProductAutoExample example);

    OrderProductAuto selectByPrimaryKey(Long orderProductId);

    int updateByExampleSelective(@Param("record") OrderProductAuto record, @Param("example") OrderProductAutoExample example);

    int updateByExample(@Param("record") OrderProductAuto record, @Param("example") OrderProductAutoExample example);

    int updateByPrimaryKeySelective(OrderProductAuto record);

    int updateByPrimaryKey(OrderProductAuto record);
    
    OrderProductAuto selectProductInfoByProductSkuId(@Param("productSkuId") Long productSkuId);
    
    List<OrderProductAuto> selectForList(OrderProductAuto record);
    
    List<SearchOrderVo> searchOrderByProductName(OrderProductAuto record);
}