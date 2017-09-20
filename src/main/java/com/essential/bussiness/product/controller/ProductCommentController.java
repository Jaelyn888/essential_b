package com.essential.bussiness.product.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.bussiness.product.model.auto.ProductCommentAuto;
import com.essential.bussiness.product.model.vo.SaveProductCommentVo;
import com.essential.bussiness.product.model.vo.SetRecommendCommentVo;
import com.essential.bussiness.product.service.IProductCommentService;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.StringCommonUtils;
import com.essential.utils.CommonResponseUtils;


/**
 * 商品评论表
 * @author Jaelyn
 *
 */
@Controller
@RequestMapping(value="productComment")
public class ProductCommentController {

	@Autowired
	@Qualifier("productCommentServiceImpl")
	private IProductCommentService productCommentServiceImpl;
	
	/**
	 * app 分页查询评论列表
	 * 
	 * @param requestMap
	 * @return
	 */
	@RequestMapping(value="queryCommentList")
	@ResponseBody
	public Map<String, Object> queryCommentList(ProductCommentAuto productCommentAuto) {

		try {
			if (productCommentAuto == null) {
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			Long productId=productCommentAuto.getProductId();
			if(StringCommonUtils.isInvalidateId(productId)){
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			return productCommentServiceImpl.queryCommentList(productCommentAuto);

		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}
	}
	
	
	/**
	 * web 分页查询评论列表
	 * 
	 * @param requestMap
	 * @return
	 */
	@RequestMapping(value="queryCommentListByPage")
	@ResponseBody
	public Map<String, Object> queryCommentListByPage(ProductCommentAuto productCommentAuto) {

		try {
			if (productCommentAuto == null
					|| productCommentAuto.getShopId() == null) {
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			if(StringCommonUtils.isInvalidateId(productCommentAuto.getShopId())){
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			
			return productCommentServiceImpl.queryCommentListByPage(productCommentAuto);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}
	}
	/**
	 * 保存文章评论
	 * @param productCommentVoList
	 * @return
	 */
	@RequestMapping(value="saveProductComment")
	@ResponseBody
	public Map<String, Object> saveProductComment(@RequestBody List<SaveProductCommentVo> productCommentVoList) {

		try {
			return productCommentServiceImpl.saveProductComment(productCommentVoList);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}
	}
	
	/**
	 * 设置推荐评论
	 * @param productCommentVoList
	 * @return
	 */
	@RequestMapping(value="setRecommendComment")
	@ResponseBody
	public Map<String, Object> setRecommendComment(SetRecommendCommentVo recommendCommentVo) {

		try {
			if (recommendCommentVo == null) {
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			if (StringCommonUtils.isInvalidateId(recommendCommentVo.getCommentId()) || StringCommonUtils.isInvalidateId(recommendCommentVo.getUserId())) {
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}

			return productCommentServiceImpl.setRecommendComment(recommendCommentVo);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}
	}
}
