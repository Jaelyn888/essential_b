package com.essential.bussiness.product.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.essential.bussiness.product.model.auto.ProductAuto;
import com.essential.bussiness.product.model.vo.ProductReleaseCommodityVO;

/**
 * 商品业务
 * 
 * @author cpx ProductAuto 商品实体 add 增加一个商品 delete 删除一个商品 update 修改一个商品 query
 *         查询一个商品 querymap 查询一个商品 通过一个map queryById 通过id查询商品的详情
 */

@Service
public interface IProductService {
	public Map<String, Object> add(ProductAuto productAuto);

	public Map<String, Object> delete(ProductAuto productAuto);

	public Map<String, Object> update(ProductAuto productAuto);

	public Map<String, Object> query(Long[] brandIds, Long[] productTypeIds, int pageIndex, int type,int own, ProductAuto productAuto);
	//兼容api start
	public Map<String, Object> query(Long[] brandIds, Long[] productTypeIds, int pageIndex, int type,int own,int isDiscount, ProductAuto productAuto);
   //兼容api end
	
	//兼容api start
		public Map<String, Object> queryLast(Long[] brandIds, Long[] productTypeIds, int pageIndex, int type,int own,int isDiscount, ProductAuto productAuto);
	   //兼容api end

	public List<ProductAuto> querymap(Map<String, Object> map);

	public Map<String, Object> queryById(HttpServletRequest request);

	/**
	 * 发布商品 的 商品信息
	 * 
	 * @param request
	 * @return
	 */
	public Map<String, Object> addReleaseCommodity(ProductReleaseCommodityVO productReleaseCommodityVO);

	/**
	 * 根据运费模板组 查询是否有商品在使用
	 * 
	 * @param productAuto
	 * @return
	 */
	public List<ProductAuto> queryProductByFreightGroupId(Long freightGroupId);

	/**
	 * 商品详情
	 * 
	 * @param productId
	 * @param type 0-商品详情，1-售后详情
	 * @return
	 */
	public Map<String, Object> queryProductDetails(Long productId, int type);

}
