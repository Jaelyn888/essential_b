package com.essential.coupon.dao;

import com.essential.coupon.model.auto.CouponUseScopeAuto;
import com.essential.coupon.model.auto.CouponUseScopeAutoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouponUseScopeAutoMapper {
    int countByExample(CouponUseScopeAutoExample example);

    int deleteByExample(CouponUseScopeAutoExample example);

    int deleteByPrimaryKey(Long couponUseScopeId);

    int insert(CouponUseScopeAuto record);

    int insertSelective(CouponUseScopeAuto record);

    List<CouponUseScopeAuto> selectByExample(CouponUseScopeAutoExample example);

    CouponUseScopeAuto selectByPrimaryKey(Long couponUseScopeId);

    int updateByExampleSelective(@Param("record") CouponUseScopeAuto record, @Param("example") CouponUseScopeAutoExample example);

    int updateByExample(@Param("record") CouponUseScopeAuto record, @Param("example") CouponUseScopeAutoExample example);

    int updateByPrimaryKeySelective(CouponUseScopeAuto record);

    int updateByPrimaryKey(CouponUseScopeAuto record);
}