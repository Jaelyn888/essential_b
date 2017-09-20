package com.essential.bussiness.product.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.bussiness.product.model.vo.ProductPlatformVo;
import com.essential.bussiness.product.model.vo.RejectProductReasonVo;

@Service
public interface IProductPlatformService {

	// 查询商品
	public Map<String, Object> queryProductPlatform(ProductPlatformVo productPlatformVo);

	// 强制下架/撤销强制下架
	public Map<String, Object> forceOrRevokeProductPlatform(RejectProductReasonVo rejectProductReasonVo);

	// 设置自营/取消自营
	public Map<String, Object> selfProductPlatform(Long productId, Integer type);
	
	// 查看商品详情
	public Map<String, Object> queryProductDetaileInfo(Long productId);
}
