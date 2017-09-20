package com.essential.coupon.dao;

import com.essential.coupon.model.auto.CouponUserReceiveAuto;
import com.essential.coupon.model.auto.CouponUserReceiveAutoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouponUserReceiveAutoMapper {
    int countByExample(CouponUserReceiveAutoExample example);

    int deleteByExample(CouponUserReceiveAutoExample example);

    int deleteByPrimaryKey(Long couponUserReceiveId);

    int insert(CouponUserReceiveAuto record);

    int insertSelective(CouponUserReceiveAuto record);

    List<CouponUserReceiveAuto> selectByExample(CouponUserReceiveAutoExample example);

    CouponUserReceiveAuto selectByPrimaryKey(Long couponUserReceiveId);

    int updateByExampleSelective(@Param("record") CouponUserReceiveAuto record, @Param("example") CouponUserReceiveAutoExample example);

    int updateByExample(@Param("record") CouponUserReceiveAuto record, @Param("example") CouponUserReceiveAutoExample example);

    int updateByPrimaryKeySelective(CouponUserReceiveAuto record);

    int updateByPrimaryKey(CouponUserReceiveAuto record);
    //查询优惠券是否领过
   CouponUserReceiveAuto   verifyrepetition(CouponUserReceiveAuto couponUserReceiveAuto);
}