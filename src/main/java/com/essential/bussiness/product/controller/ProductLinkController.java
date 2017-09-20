package com.essential.bussiness.product.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.bussiness.product.model.auto.LinkProductAuto;
import com.essential.bussiness.product.service.IProductLinkService;
import com.essential.common.constants.SUConstants;
import com.essential.utils.CommonResponseUtils;
@Controller
@RequestMapping(value="linkProduct")
public class ProductLinkController {

	@Autowired
	@Qualifier("productLinkServiceImpl")
	private IProductLinkService productLinkServiceImpl;
	@RequestMapping(value = "saveLinkProduct")
	@ResponseBody
	public Map<String, Object> saveLinkProduct(LinkProductAuto linkProductAuto){
		try {
			if(linkProductAuto==null){
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			
			return productLinkServiceImpl.saveLinkProduct(linkProductAuto);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse(SUConstants.SERVER_ERROR);
		}
	}
}
