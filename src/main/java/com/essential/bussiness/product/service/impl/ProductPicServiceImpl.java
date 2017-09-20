package com.essential.bussiness.product.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.bussiness.product.dao.ProductPicAutoMapper;
import com.essential.bussiness.product.model.auto.ProductPicAuto;
import com.essential.bussiness.product.service.IProductPicService;
import com.essential.common.constants.SUConstants;

@Service
public class ProductPicServiceImpl implements IProductPicService {
	private static Logger logger = LoggerFactory
			.getLogger(ProductServiceImpl.class);

	@Autowired
	ProductPicAutoMapper productPicAutoMapper;
/**
 * query 通过商品id查询商品的图片
 */
	@Override
	public Map<String, Object> query(String productId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<ProductPicAuto> list=new ArrayList<ProductPicAuto>();
		
		try {

			list = productPicAutoMapper.selectByPrimaryKey(Long.parseLong(productId));
			map.put(SUConstants.CODE_KEY, SUConstants.CODE_SUCCESS_VALUE);
			map.put(SUConstants.MSG_KEY, SUConstants.MSG_SUCCESS_VALUE);
			map.put("info", list);
			return map;

		} catch (Exception e) {
			logger.info("查询商品图片失败");
			e.printStackTrace();
		}
		map.put(SUConstants.CODE_KEY, SUConstants.CODE_FAIL_VALUE);
		map.put(SUConstants.MSG_KEY, "查询产品图片失败");
		return map;
	}

}
