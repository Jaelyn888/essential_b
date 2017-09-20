package com.essential.bussiness.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import com.essential.bussiness.product.dao.ProductAutoMapper;
import com.essential.bussiness.product.model.auto.ProductAuto;
import com.essential.bussiness.product.model.vo.ProductAutoAddField;
import com.essential.find.dao.ArticleAutoMapper;
import com.essential.find.model.auto.ArticleAuto;
import com.essential.utils.CommonResponseUtils;

@Controller
@RequestMapping(value = "transferData")
public class TransferData {
	
	@Autowired
	ProductAutoMapper productAutoMapper;
	
	@Autowired
	ArticleAutoMapper articleAutoMapper;

	/**
	 * 商品数据富文本框转换
	 * @return
	 */
	@RequestMapping(value="transferInfo")
	@ResponseBody
	public Map<String, Object> transferInfo() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ProductAuto productAuto = new ProductAuto();
//			productAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			List<ProductAutoAddField> list = productAutoMapper.queryInfo(productAuto);
			for(int i = 0; i < list.size(); i++){
				ProductAuto productAutoInfo = list.get(i);
				Long productId = productAutoInfo.getProductId();
				//商品详情
				String conter = productAutoInfo.getProductDescribe();
				//售后详情
				String ret = productAutoInfo.getReturnProductExplain();
				
				//转换后的商品详情
				String tmp = htmlUnescape(conter);
				//转换后的售后详情
				String sale = htmlUnescape(ret);
				
				productAuto.setProductId(productId);
				productAuto.setProductDescribe(tmp);
				productAuto.setReturnProductExplain(sale);
				int j = productAutoMapper.updateByPrimaryKeySelective(productAuto);
				if(j <= 0){
					throw new Exception();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("转移失败"));
		}
		
		return map;
	}
	
	/**
	 * 文章数据富文本框转换
	 * @return
	 */
	@RequestMapping(value="transferInfoArtical")
	@ResponseBody
	public Map<String, Object> transferInfoArtical() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<ArticleAuto> list = articleAutoMapper.queryArticalEditor();
			for(int i = 0; i < list.size(); i++){
				ArticleAuto articleAuto = list.get(i);
				String articale = articleAuto.getArticleContent();
				String articaleHtml = htmlUnescape(articale);
				articleAuto.setArticleContent(articaleHtml);
				int j = articleAutoMapper.updateByPrimaryKeySelective(articleAuto);
				if(j<=0){
					throw new Exception();
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("转移失败"));
		}
		
		return map;
	}

	
	public String htmlUnescape(String ret) {
		try {
			//文本格式转换
			String html = HtmlUtils.htmlUnescape(ret);
			return html;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}
	
	/**
	 * 查询遍历SKU从查询商品的最大价格
	 * @return
	 */
	@RequestMapping(value="productMaxPrice")
	@ResponseBody
	public Map<String, Object> productMaxPrice(){
		
		
		
		
		
		return null;
	}
}
