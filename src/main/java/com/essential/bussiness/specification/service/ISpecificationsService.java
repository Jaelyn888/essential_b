package com.essential.bussiness.specification.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.bussiness.product.model.auto.ProductSkuRelationAuto;
import com.essential.bussiness.specification.model.auto.SpecificationValueAuto;
import com.essential.bussiness.specification.model.auto.SpecificationkeyAuto;

@Service
public interface ISpecificationsService {

	//根据产品id查出产品的sku
	
	Map<String,Object> querySpecificationByProductId(Long ProductId);
	
	//根据产品id 和keyid（一级规格的值如（尺码，颜色））flag(表示这个顶级规格是否有三级,1为有三级，0为没三级)
	Map<String,Object> querySpecificationValueByPidKId(Long productId,Long KeyId);
	
	//根据spuid查到规格
	Map<String,Object> querySpecificationBySkuId(Long SkuId);
	//增加规格键
	Map<String,Object> addSpecificationKey(String categoryId,String keyName,String value);
	//删除规格键
	Map<String,Object> deleteSpecificationKey(SpecificationkeyAuto specificationkeyAuto);
	//修改规格键
	Map<String,Object> updateSpecificationKey(SpecificationkeyAuto specificationkeyAuto);
	
	//增加规格值
	Map<String,Object> addSpecificationValue(SpecificationValueAuto specificationValueAuto);
	//删除规格值
	Map<String,Object> deleteSpecificationValue(SpecificationValueAuto specificationValueAuto);
	//修改规格值
	Map<String,Object> updateSpecificationValue(SpecificationValueAuto specificationValueAuto);
	
	//通过规格去查库存
	
	Map<String,Object> selectSkuCount (Long productId,Long[] ValueIds);
	//通过skuId和productCounts去查库存是否够	
    Map<String,Object> selectStock (Long skuId,Long productCount);
    
    //查询全部的规格键
    Map<String,Object> selectAllSpecificationKey ();
    
  //查询全部的values
    Map<String,Object> selectAllValues(Long keyId);
    //查询规格列表
    Map<String,Object> selectSpecificationLst();
    
    //修改规格键
    Map<String,Object>modifySpecificationKey(SpecificationkeyAuto specificationkeyAuto);
    
	
	
	
	
	
}
