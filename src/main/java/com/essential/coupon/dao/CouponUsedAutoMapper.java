package com.essential.coupon.dao;

import com.essential.coupon.model.auto.CouponUsedAuto;
import com.essential.coupon.model.auto.CouponUsedAutoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouponUsedAutoMapper {
    int countByExample(CouponUsedAutoExample example);

    int deleteByExample(CouponUsedAutoExample example);

    int deleteByPrimaryKey(Long couponUsedId);

    int insert(CouponUsedAuto record);

    int insertSelective(CouponUsedAuto record);

    List<CouponUsedAuto> selectByExample(CouponUsedAutoExample example);

    CouponUsedAuto selectByPrimaryKey(Long couponUsedId);

    int updateByExampleSelective(@Param("record") CouponUsedAuto record, @Param("example") CouponUsedAutoExample example);

    int updateByExample(@Param("record") CouponUsedAuto record, @Param("example") CouponUsedAutoExample example);

    int updateByPrimaryKeySelective(CouponUsedAuto record);

    int updateByPrimaryKey(CouponUsedAuto record);
}