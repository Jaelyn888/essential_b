package com.essential.bussiness.product.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.bussiness.product.model.auto.LinkProductAuto;

/**
 * 外链商品表
 * @author Jaelyn
 *
 */
@Service
public interface IProductLinkService {

	Map<String, Object> saveLinkProduct(LinkProductAuto linkProductAuto);

}
