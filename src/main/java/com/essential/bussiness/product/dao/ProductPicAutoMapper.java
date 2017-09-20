package com.essential.bussiness.product.dao;

import java.util.List;
import java.util.Map;

import com.essential.bussiness.product.model.auto.ProductPicAuto;
import com.essential.bussiness.shopcart.model.vo.SkuShopCartVo;

public interface ProductPicAutoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductPicAuto record);

    int insertSelective(ProductPicAuto record);

    List<ProductPicAuto> selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductPicAuto record);

    int updateByPrimaryKey(ProductPicAuto record);
    
    List<SkuShopCartVo> selectProductPathAndNameByProductIdAndType(Map<String,Object> map);
    //逻辑删除
    int updateByProductIdPrimary(ProductPicAuto record);
    
    //查询商品图片
    List<ProductPicAuto> queryByPrimaryKey(ProductPicAuto record);
}