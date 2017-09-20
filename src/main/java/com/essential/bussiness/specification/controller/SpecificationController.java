package com.essential.bussiness.specification.controller;

import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.bussiness.specification.model.auto.SpecificationValueAuto;
import com.essential.bussiness.specification.model.auto.SpecificationkeyAuto;
import com.essential.bussiness.specification.service.ISpecificationsService;
import com.essential.utils.CommonResponseUtils;



@Controller
@RequestMapping(value = "specification")
public class SpecificationController {
	private org.slf4j.Logger logger=LoggerFactory.getLogger(SpecificationController.class);
	@Autowired
	ISpecificationsService specificationsService;
//通过商品的id去查询商品的各种一级规格
	@RequestMapping(value = "byProductId")
	@ResponseBody
	public Map<String, Object> specification(
			@RequestParam(value = "productId") Long productId) {
		try {
			return specificationsService.querySpecificationByProductId(productId);
		} catch (Exception e) {
			
			e.printStackTrace();
			logger.info("通过商品的id去查询商品的各种一级规格失败");
			return CommonResponseUtils.failureResponse("通过商品的id去查询商品的各种一级规格失败");
			
		}
		
				
	}
	//通过一级规格id去和商品的id去查询这个商品所具有的规格值
	@RequestMapping(value = "byKeyId")
	@ResponseBody
	public Map<String, Object> querySpecificationByKeyId(@RequestParam(value = "productId") Long productId,@RequestParam(value="KeyId") Long keyId) {
	try {
		return specificationsService.querySpecificationValueByPidKId(productId,keyId);
		
	} catch (Exception e) {
		e.printStackTrace();
		logger.info("通过一级规格id去和商品的id去查询这个商品所具有的规格值失败");
		return CommonResponseUtils.failureResponse("通过一级规格id去和商品的id去查询这个商品所具有的规格值失败");
	}
		
		
		
		
	}
	//通过skuId查询规格
		@RequestMapping(value = "bySkuId")
		@ResponseBody
		public Map<String, Object> querySpecificationByKeyId(@RequestParam(value = "skuId") Long skuId) {
			try {
				return specificationsService.querySpecificationBySkuId(skuId);
			} catch (Exception e) {
				e.printStackTrace();
				logger.info("通过skuId查询规格失败");
				return CommonResponseUtils.failureResponse("通过skuId查询规格失败");
			}
			
			
			
			
		}
		
		   //增加规格键和规格值通过大分类的id
				@RequestMapping(value = "addKey")
				@ResponseBody
				public Map<String, Object> addKey(String categoryId,String keyName,String value) {
					
					try {
						
						return specificationsService.addSpecificationKey(categoryId,keyName,value);
					} catch (Exception e) {
						e.printStackTrace();
						logger.info("增加规格键和规格值通过大分类的id失败");
						return CommonResponseUtils.failureResponse("增加规格键和规格值通过大分类的id失败");
					}
					
					
					
				}
				//删除规格键
				@RequestMapping(value = "deleteKey")
				@ResponseBody
				public Map<String, Object> deleteKey(SpecificationkeyAuto specificationkeyAuto) {
					try {
						return specificationsService.deleteSpecificationKey(specificationkeyAuto);
						
					} catch (Exception e) {
						
					e.printStackTrace();
					logger.info("删除规格键失败");
					return CommonResponseUtils.failureResponse("删除规格键失败");
					}
					
					
					
					
				}
				//修改规格键
				@RequestMapping(value = "updateKey")
				@ResponseBody
				public Map<String, Object> updateKey(SpecificationkeyAuto specificationkeyAuto) {
					try {
						return specificationsService.updateSpecificationKey(specificationkeyAuto);
						
					} catch (Exception e) {

						e.printStackTrace();
						logger.info("修改规格键失败");
						return CommonResponseUtils.failureResponse("修改规格键失败");
					}
					
					
					
					
				}
				
				//增加规格值规格
				@RequestMapping(value = "addValue")
				@ResponseBody
				public Map<String, Object> addValue(SpecificationValueAuto specificationValueAuto) {
					
					try {
						
						return specificationsService.addSpecificationValue(specificationValueAuto);
					} catch (Exception e) {
						e.printStackTrace();
						logger.info("增加规格值规格失败");
						return CommonResponseUtils.failureResponse("增加规格值规格失败");
					}
					
					
					
				}
				//删除规格值
				@RequestMapping(value = "deleteValue")
				@ResponseBody
				public Map<String, Object> deleteValue(SpecificationValueAuto specificationValueAuto) {
					
					try {
						
						return specificationsService.deleteSpecificationValue(specificationValueAuto);
					} catch (Exception e) {
						e.printStackTrace();
						logger.info("删除规格值");
						return CommonResponseUtils.failureResponse("删除规格值");
					}
						
				
				}
				//修改规格值
				@RequestMapping(value = "updaetValue")
				@ResponseBody
				public Map<String, Object> addSpecificationValue(SpecificationValueAuto specificationValueAuto) {					
					
					try {
						return specificationsService.updateSpecificationValue(specificationValueAuto);
						
					} catch (Exception e) {
						e.printStackTrace();
						logger.info("修改规格值失败");
						
						
						return CommonResponseUtils.failureResponse("修改规格值失败");
					
				}
				}
				
				//通过规格去匹配规格的库存
				@RequestMapping(value = "selectSkuCount")
				@ResponseBody
				public Map<String, Object> selectSkuCountByProductId(@RequestParam(value = "productId")Long productId,Long[] valueIds) {
						
					
					try {
						return specificationsService.selectSkuCount(productId, valueIds);
					} catch (Exception e) {
						e.printStackTrace();
						logger.info("通过规格去匹配规格的库存失败");
						return CommonResponseUtils.failureResponse("通过规格去匹配规格的库存失败");
					}
					
					
				}
				
				//通过规格id去查库存
				@RequestMapping(value = "selectStockBySkuId")
				@ResponseBody
				public Map<String, Object> selectStock(Long skuId,Long productCount) {
						
					
					try {
						return specificationsService.selectStock(skuId, productCount);
						
					} catch (Exception e) {
						e.printStackTrace();
						logger.info("通过规格id去查库存失败");
						return CommonResponseUtils.failureResponse("通过规格id去查库存失败");
						
					}
					
					
				}
				//查询所有的key
				@RequestMapping(value = "selectAllKeys")
				@ResponseBody
				public Map<String, Object> selectAllKeys() {
						
					
					try {
						return specificationsService.selectAllSpecificationKey();	
					} catch (Exception e) {
						logger.info("查询所有key失败");
						e.printStackTrace();
						return CommonResponseUtils.failureResponse("查询所有得key是失败");
						
					}
				}
				
				//查询某种规格所有的规格值
				@RequestMapping(value = "selectAllValuesByKeyId")
				@ResponseBody
				public Map<String, Object> selectAllValuesByKeyId(Long keyId) {
						
					
					try {
						return specificationsService.selectAllValues(keyId);
						
					} catch (Exception e) {
						
						logger.info("查询某种规格所有的规格值失败");
						e.printStackTrace();
						return CommonResponseUtils.failureResponse("查询某种规格所有的规格值失败");
					}
				}
				
				
				//查询规格列表
				@RequestMapping(value = "selectSpecificationList")
				@ResponseBody
				public Map<String, Object> selectSpecificationList() {
						try {
							
							return specificationsService.selectSpecificationLst();
						} catch (Exception e) {
							logger.info("查询规格列表失败");
							return CommonResponseUtils.failureResponse("查询规格列表失败");
							
						}
					
				}
				/**
				 * 修改规格键（陈蒙蒙）
				 * @return
				 */
				@RequestMapping(value = "modifySpecificationKey")
				@ResponseBody
				public Map<String, Object> modifySpecificationKey(SpecificationkeyAuto specificationkeyAuto) {
						
					try {
						return specificationsService.modifySpecificationKey(specificationkeyAuto);
						
					} catch (Exception e) {
						logger.info("修改规格键失败");
						e.printStackTrace();
						return CommonResponseUtils.failureResponse("修改规格键失败");
						
					
					}
					
				}
			
				
		
				

}
