package com.essential.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.essential.user.model.auto.UserReceiptAddressAuto;

public interface UserReceiptAddressAutoMapper {
    int deleteByPrimaryKey(Long addressId);

    int insert(UserReceiptAddressAuto record);

    int insertSelective(UserReceiptAddressAuto record);

    UserReceiptAddressAuto selectByPrimaryKey(Long addressId);

    int updateByPrimaryKeySelective(UserReceiptAddressAuto record);

    int updateByPrimaryKey(UserReceiptAddressAuto record);
    
    /**
     * 所有收货地址
     * @param userReceiptAddressAuto
     * @return
     */
    List<UserReceiptAddressAuto> queryAddressListByUserId(UserReceiptAddressAuto userReceiptAddressAuto);
    /**
     * 默认收货地址
     * @param userId  用户id
     * @return
     */
    UserReceiptAddressAuto queryDefaultAddress(UserReceiptAddressAuto userReceiptAddressAuto);
    
    /**
     * 查找第一条
     * @param userId  用户id
     * @return
     */
    UserReceiptAddressAuto queryFirstAddress(@Param("userId") Long userId); 
    
    /**
     * 查找最新的一条
     * @param userId  用户id
     * @return
     */
    UserReceiptAddressAuto queryNewestAddress(@Param("userId") Long userId); 
    
    
    /**
     * 查找推荐的地址
     * @param userId  用户id
     * @return
     */
    UserReceiptAddressAuto queryRecommendAddress(@Param("userId") Long userId);

    /**
     * 取消默认收货地址
     * @param defaultAddress
     * @return
     */
	int cancelDefaultAddress(UserReceiptAddressAuto defaultAddress); 
}