package com.essential.bussiness.order.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.essential.bussiness.order.model.auto.OrderAuto;
import com.essential.bussiness.order.model.auto.OrderAutoExample;
import com.essential.bussiness.order.model.vo.OrderProductVo;
import com.essential.bussiness.order.model.vo.QueryOrderCommentVo;

public interface OrderAutoMapper {
    int countByExample(OrderAutoExample example);

    int deleteByExample(OrderAutoExample example);

    int deleteByPrimaryKey(Long orderId);

    int insert(OrderAuto record);

    int insertSelective(OrderAuto record);

    List<OrderAuto> selectByExample(OrderAutoExample example);

    OrderAuto selectByPrimaryKey(Long orderId);

    int updateByExampleSelective(@Param("record") OrderAuto record, @Param("example") OrderAutoExample example);

    int updateByExample(@Param("record") OrderAuto record, @Param("example") OrderAutoExample example);

    int updateByPrimaryKeySelective(OrderAuto record);

    int updateByPrimaryKey(OrderAuto record);
    
    List<OrderProductVo> selectOrderForList(OrderProductVo orderProductVo);
    
    int selectOrderForListCount(OrderProductVo orderProductVo);
    //通过订单号获取totalFee
     OrderAuto  selectTotalFeeByOrderNum(String orderNum);
  
     QueryOrderCommentVo queryOrderShopInfo(@Param("orderId") Long orderId);
     
     //我的订单每个标签页的订单数量
     List<HashMap<String, Integer>> queryMyOrderNumberPerLabelCount(@Param("userId") Long userId);
}