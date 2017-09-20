package com.essential.bussiness.product.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.essential.bussiness.order.dao.OrderAutoMapper;
import com.essential.bussiness.order.model.auto.OrderAuto;
import com.essential.bussiness.product.dao.ProductCommentAutoMapper;
import com.essential.bussiness.product.model.auto.ProductCommentAuto;
import com.essential.bussiness.product.model.auto.ProductCommentPicAuto;
import com.essential.bussiness.product.model.vo.BusinessProductCommentVo;
import com.essential.bussiness.product.model.vo.ProductCommentPicVo;
import com.essential.bussiness.product.model.vo.ProductCommentVo;
import com.essential.bussiness.product.model.vo.ProductReplyVo;
import com.essential.bussiness.product.model.vo.SaveProductCommentVo;
import com.essential.bussiness.product.model.vo.SetRecommendCommentVo;
import com.essential.bussiness.product.service.IProductCommentPicService;
import com.essential.bussiness.product.service.IProductCommentService;
import com.essential.bussiness.product.service.IProductReplyCommentService;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.MyException;
import com.essential.common.utils.StringCommonUtils;
import com.essential.common.utils.TmDateUtil;
import com.essential.user.dao.UserBaseInfoAutoMapper;
import com.essential.utils.CommonResponseUtils;
import com.essential.utils.DTOUtils;
import com.essential.utils.LogUtils;

/**
 * 商品评论
 * 
 * @author Jaelyn
 *
 */
@Service
public class ProductCommentServiceImpl implements IProductCommentService {

	/**
	 * 商品评论表
	 */
	@Autowired
	private ProductCommentAutoMapper productCommentAutoMapper;
	/**
	 * 商品回复表
	 */
	@Autowired
	private IProductReplyCommentService productReplyCommentService;

	/**
	 * 商品评价附件图
	 */
	@Autowired
	private IProductCommentPicService commentPicService;

	/**
	 * 用户信息表
	 */
	@Autowired
	private UserBaseInfoAutoMapper userBaseInfoAutoMapper;

	@Autowired
	private OrderAutoMapper orderAutoMapper;

	/*
	 * 根据商品id 获取推荐的评论表， 如果没有推荐，则获取第一条？
	 * 
	 * @see com.essential.bussiness.product.service.impl.IProductCommentService#
	 * queryRecommendComment
	 * (com.essential.bussiness.product.model.auto.ProductCommentAuto)
	 */
	@Override
	public ProductCommentVo queryRecommendComment(ProductCommentAuto productCommentAuto) {

		productCommentAuto.setIsRecommand(1);
		productCommentAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
		ProductCommentVo productCommentAutoTmp = productCommentAutoMapper.queryRecommendComment(productCommentAuto);

		if (productCommentAutoTmp == null) {
			productCommentAutoTmp = productCommentAutoMapper.queryFirstComment(productCommentAuto);
			if (productCommentAutoTmp == null) {
				return null;
			} else {

				return productCommentAutoTmp;
			}
		} else {

			return productCommentAutoTmp;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.essential.bussiness.product.service.impl.IProductCommentService#
	 * queryCommentCount
	 * (com.essential.bussiness.product.model.auto.ProductCommentAuto)
	 */
	@Override
	public int queryCommentCount(ProductCommentAuto record) {
		if (record == null) {
			return 0;
		}
		Long productId = record.getProductId();
		if (StringCommonUtils.isInvalidateId(productId)) {
			return 0;
		}
		record.setIsDelete(SUConstants.IS_NOT_DELETE);
		int commentCount = productCommentAutoMapper.queryCommentCount(record);
		return commentCount;
	}

	/**
	 * app分页查询评论列表
	 * 
	 * @param requestMap
	 * @return
	 */
	@Override
	public Map<String, Object> queryCommentList(ProductCommentAuto productCommentAuto) {

		try {
			List<ProductCommentVo> commentVoListTmp = new ArrayList<ProductCommentVo>();
			productCommentAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			// requestMap.put("pageIndex", (pageIndex - 1) *
			// SUConstants.PAGE_COUNT);
			productCommentAuto.setPageSize(SUConstants.PAGE_COUNT);
			List<ProductCommentVo> commentVoList = productCommentAutoMapper.queryCommentList(productCommentAuto);
			for (ProductCommentVo productCommentVo : commentVoList) {
				if (productCommentVo != null) {
					commentVoListTmp.add(queryCommentVo(productCommentVo));
				}
			}
			return CommonResponseUtils.successResponse(commentVoListTmp);

		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}

	}

	/**
	 * 分页查询
	 */
	@Override
	public Map<String, Object> queryCommentListByPage(ProductCommentAuto productCommentAuto) {

		try {
			Map<String, Object> resultMap = new HashMap<String, Object>();
			
			//查询当前店铺下的所有订单
			productCommentAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			
			if(productCommentAuto.getPageIndex() == null){
				productCommentAuto.setPageIndex(0);
			}else{
				productCommentAuto.setPageIndex(
						(productCommentAuto.getPageIndex() - 1) * SUConstants.PAGE_COUNT);
			}
			if(productCommentAuto.getPageSize() == null){
				productCommentAuto.setPageSize(SUConstants.PAGE_COUNT);
			}
			
			
			//查询总数量
			int totleCount = productCommentAutoMapper.queryBusinessProductCommentVoForListCount(productCommentAuto);
			if (totleCount > 0) {
				//查询商品及评论信息
				List<BusinessProductCommentVo> businessProductCommentVoList = productCommentAutoMapper.queryBusinessProductCommentVoForList(productCommentAuto);
				
				resultMap.put("totalPageCount", totleCount);
				resultMap.put("businessProductCommentVos", businessProductCommentVoList);
				return CommonResponseUtils.successResponse(resultMap);
			}else{
				resultMap.put("totalPageCount", totleCount);
				resultMap.put("businessProductCommentVos", new ArrayList<BusinessProductCommentVo>());
				return CommonResponseUtils.successResponse();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse();
		}

	}

	/**
	 * 
	 * @param map
	 * @return
	 */
	private ProductCommentVo queryCommentVo(ProductCommentVo productCommentAuto) {
		ProductCommentVo productCommentVo = new ProductCommentVo();
		DTOUtils.map(productCommentAuto, productCommentVo);

		// 评论信息
		// commentTmp.put("commentInfo", productCommentAuto);
		long commentId = productCommentAuto.getCommentId();

		// 附件图
		List<ProductCommentPicVo> picVoList = commentPicService.queryPicVoListByCommentId(commentId);
		productCommentVo.setAttachPicList(picVoList);

		// 商家回复
		List<ProductReplyVo> replyVoList = productReplyCommentService.queryReplyVoListByCommentId(commentId);
		productCommentVo.setReplyList(replyVoList);

		return productCommentVo;

	}

	/**
	 * 保存订单商品评价 用户id
	 * 
	 * @param productCommentVoList
	 * @return
	 */
	@Override
	public Map<String, Object> saveProductComment(List<SaveProductCommentVo> productCommentVoList) {

		try {
			Long orderId = 0l;
			for (SaveProductCommentVo saveProductCommentVo : productCommentVoList) {
				String timeStamp = TmDateUtil.getTimeStamp();
				orderId = saveProductCommentVo.getOrderId();
				ProductCommentAuto productCommentAuto = new ProductCommentAuto();
				DTOUtils.map(saveProductCommentVo, productCommentAuto);
				productCommentAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
				productCommentAuto.setIsRecommand(0);
				productCommentAuto.setStatus(0);
				productCommentAuto.setCreateTime(timeStamp);
				productCommentAuto.setModifyTime(timeStamp);

				Long userId = saveProductCommentVo.getCreateUser();
				if (userId == null) {
					userId = saveProductCommentVo.getUserId();
				}
				productCommentAuto.setModifyUser(userId);
				productCommentAuto.setCreateUser(userId);
				int num = productCommentAutoMapper.insert(productCommentAuto);
				if (num < 1) {
					throw new MyException();
				}
				Long commentId = productCommentAuto.getCommentId();
				Long productId = saveProductCommentVo.getProductId();
				List<ProductCommentPicVo> productCommentPicVoList = saveProductCommentVo.getAttachPicList();
				if (productCommentPicVoList != null) {
					List<ProductCommentPicAuto> productCommentPicAutoList = new ArrayList<ProductCommentPicAuto>();
					for (ProductCommentPicVo productCommentPicVo : productCommentPicVoList) {
						ProductCommentPicAuto productCommentPicAuto = new ProductCommentPicAuto();
						productCommentPicAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
						productCommentPicAuto.setCreateTime(timeStamp);
						productCommentPicAuto.setModifyTime(timeStamp);
						productCommentPicAuto.setModifyUser(userId);
						productCommentPicAuto.setCreateUser(userId);
						productCommentPicAuto.setPath(productCommentPicVo.getPath());
						productCommentPicAuto.setCommitId(commentId);
						productCommentPicAuto.setProductId(productId);
						productCommentPicAutoList.add(productCommentPicAuto);
					}
					num = commentPicService.insertProductCommentPicList(productCommentPicAutoList);
					if (num != productCommentPicAutoList.size()) {
						LogUtils.debug("insert pic exception=" + num);
						throw new MyException();
					}
				}
			}
			OrderAuto orderAuto = new OrderAuto();
			orderAuto.setOrderId(orderId);
			orderAuto.setIsComment(1);
			int num = orderAutoMapper.updateByPrimaryKeySelective(orderAuto);
			if (num > 0) {
				return CommonResponseUtils.successResponse("保存成功");
			} else {
				throw new MyException();
			}
		} catch (Exception e) {
			e.printStackTrace();
			LogUtils.debug("insert pic exception=" + e.getCause());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return CommonResponseUtils.failureResponse("保存失败");
		}
	}

	/**
	 * 设置评论推荐
	 */
	@Override
	public Map<String, Object> setRecommendComment(SetRecommendCommentVo recommendCommentVo) {
		try {

			String timeStamp = TmDateUtil.getTimeStamp();
			ProductCommentAuto productCommentAuto = new ProductCommentAuto();
			productCommentAuto.setModifyUser(recommendCommentVo.getUserId());
			productCommentAuto.setModifyTime(timeStamp);

			int num;
			if (!StringCommonUtils.isInvalidateId(recommendCommentVo.getProductId())) {
				productCommentAuto.setProductId(recommendCommentVo.getProductId());
				productCommentAuto.setIsRecommand(0);
				num = productCommentAutoMapper.updateByProductIdSelective(productCommentAuto);
				if (num < 0) {
					throw new MyException("cancle default recommand comment exception");
				}
			}
			productCommentAuto.setIsRecommand(1);
			productCommentAuto.setCommentId(recommendCommentVo.getCommentId());
			num = productCommentAutoMapper.updateByPrimaryKeySelective(productCommentAuto);
			if (num > 0) {
				return CommonResponseUtils.successResponse("设置成功");
			} else {
				throw new MyException();
			}

		} catch (Exception e) {
			e.printStackTrace();
			LogUtils.debug("setRecommendComment", e.toString());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return CommonResponseUtils.failureResponse("设置失败");
		}
	}

	/**
	 * 取消推荐
	 */
	@Override
	public Map<String, Object> cancleRecommendComment(ProductCommentAuto productCommentAuto) {
		try {
			if (productCommentAuto == null) {
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			Long commentId = productCommentAuto.getCommentId();
			if (StringCommonUtils.isInvalidateId(commentId)) {
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			productCommentAuto.setIsRecommand(0);
			int num = productCommentAutoMapper.updateByPrimaryKeySelective(productCommentAuto);
			if (num > 0) {
				return CommonResponseUtils.successResponse("取消成功");
			} else {
				throw new MyException();
			}
		} catch (Exception e) {
			e.printStackTrace();
			LogUtils.debug("insert pic exception=" + e.getCause());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return CommonResponseUtils.failureResponse("取消失败");
		}
	}
}
