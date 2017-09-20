package com.essential.coupon.dao;

import com.essential.coupon.model.auto.CouponAuto;
import com.essential.coupon.model.auto.CouponAutoExample;
import com.essential.coupon.model.vo.CouponAutoVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CouponAutoMapper {
	int countByExample(CouponAutoExample example);

	int deleteByExample(CouponAutoExample example);

	int deleteByPrimaryKey(Long couponId);

	int insert(CouponAuto record);

	int insertSelective(CouponAuto record);

	List<CouponAuto> selectByExample(CouponAutoExample example);

	CouponAuto selectByPrimaryKey(Long couponId);

	int updateByExampleSelective(@Param("record") CouponAuto record, @Param("example") CouponAutoExample example);

	int updateByExample(@Param("record") CouponAuto record, @Param("example") CouponAutoExample example);

	int updateByPrimaryKeySelective(CouponAuto record);

	int updateByPrimaryKey(CouponAuto record);

	// 查询未使用的优惠券(全用户)
	List<CouponAuto> queryCouponNotUsedAllUser(CouponAutoVo record);

	// 查询未使用的优惠券(新用户)
	List<CouponAuto> queryCouponNotUsedNewUser(CouponAutoVo record);

	// 查询未使用的优惠券(兑换)
	List<CouponAuto> queryCouponNotUsedReceive(CouponAutoVo record);

	// 查询已失效的优惠券(全用户)
	List<CouponAuto> queryCouponHasFailedAllUser(CouponAutoVo record);

	// 查询已失效的优惠券(新用户)
	List<CouponAuto> queryCouponHasFailedNewUser(CouponAutoVo record);

	// 查询已失效的优惠券(兑换)
	List<CouponAuto> queryCouponHasFailedReceive(CouponAutoVo record);

	// 删除优惠券
	int updateIsdelete(CouponAuto record);

	// 优惠券列表（平台）
	List<CouponAuto> querycouponList(CouponAutoVo record);
	//兑换优惠券(手机端)
	CouponAuto  querycouponisexist(String code);
	//查询优惠券id
	CouponAuto selectCouponId(String code);
	
}