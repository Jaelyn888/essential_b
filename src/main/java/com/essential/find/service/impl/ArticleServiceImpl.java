package com.essential.find.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.essential.bussiness.product.dao.LinkProductAutoMapper;
import com.essential.bussiness.product.dao.ProductAutoMapper;
import com.essential.bussiness.product.model.auto.LinkProductAuto;
import com.essential.bussiness.product.model.auto.ProductAuto;
import com.essential.bussiness.product.model.vo.LinkProductInfo;
import com.essential.bussiness.product.model.vo.ProductBaseInfoVo;
import com.essential.bussiness.product.model.vo.ProductInfoOrLinkProductInfoVo;
import com.essential.bussiness.product.model.vo.ProductSerchInfoVo;
import com.essential.bussiness.product.model.vo.ProductSomeInfoVO;
import com.essential.bussiness.promotion.controller.PromotionAutoController;
import com.essential.bussiness.promotion.model.vo.PromotionProductInfoVo;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.MyException;
import com.essential.common.utils.StringCommonUtils;
import com.essential.common.utils.TmDateUtil;
import com.essential.find.dao.ArticleAutoMapper;
import com.essential.find.dao.ArticleProductAutoMapper;
import com.essential.find.dao.ArticleUserAutoMapper;
import com.essential.find.model.auto.ArticleAuto;
import com.essential.find.model.auto.ArticleProductAuto;
import com.essential.find.model.auto.ArticleUserAuto;
import com.essential.find.model.vo.ArticleDetailVo;
import com.essential.find.model.vo.ArticleSearchVo;
import com.essential.find.model.vo.ArticleVo;
import com.essential.find.model.vo.RequestDetailVo;
import com.essential.find.service.IArticleService;
import com.essential.user.dao.UserBaseInfoAutoMapper;
import com.essential.user.model.auto.UserCollectionAuto;
import com.essential.user.service.IUserCollectionService;
import com.essential.utils.CommonResponseUtils;
import com.essential.utils.DTOUtils;
import com.essential.utils.LogUtils;

@Service
public class ArticleServiceImpl implements IArticleService {

	// 文章 表Mapper
	@Autowired
	private ArticleAutoMapper articalAutoMapper;

	// 相关人 表查询
	@Autowired
	private ArticleUserAutoMapper articalUserAutoMapper;

	// 文章相关商品 表查询
	@Autowired
	private ArticleProductAutoMapper articalProductAutoMapper;

	// 用户基本信息查询
	@Autowired
	private UserBaseInfoAutoMapper userBaseInfoAutoMapper;

	// 相关商品信息
	@Autowired
	private ProductAutoMapper productAutoMapper;

	@Autowired
	@Qualifier("userCollectionServiceImpl")
	private IUserCollectionService userCollectionServiceImpl;

	/**
	 * 外链商品
	 */
	@Autowired
	private LinkProductAutoMapper linkProductAutoMapper;
   //活动
	
	@Autowired
	PromotionAutoController promotionAutoController;

	/**
	 * 按分类组别查询文章
	 */
	@Override
	public Map<String, Object> queryArticleList(ArticleAuto articleAuto) {
		if (articleAuto == null) {
			return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
		}
		Long articleGroupId = articleAuto.getArticleGroupId();
		if (articleGroupId == null) {
			return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
		}
		articleAuto.setPageSize(SUConstants.PAGE_COUNT);
		articleAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
		try {
			List<ArticleVo> list = new ArrayList<ArticleVo>();
			list = articalAutoMapper.queryArticleList(articleAuto);
			return CommonResponseUtils.successResponse(list);
		} catch (Exception e) {
			e.printStackTrace();
			LogUtils.debug("queryArticleList", e);
			return CommonResponseUtils.failureResponse(SUConstants.SERVER_ERROR);
		}
	}

	/**
	 * app端 查询文章详情
	 */
	@Override
	public Map<String, Object> queryArticleDetail(RequestDetailVo requestDetailVo) {
		if (requestDetailVo == null) {
			return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
		}
		Long articleId = requestDetailVo.getArticleId();
		Long userId = requestDetailVo.getUserId();
		if (StringCommonUtils.isInvalidateId(requestDetailVo.getArticleId())) {
			return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
		}

		try {
			// 获取文章详情
			ArticleAuto articalAuto = new ArticleAuto();
			articalAuto.setArticleId(articleId);
			articalAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			articalAuto = articalAutoMapper.queryArticleDetailById(articalAuto);
			if (articalAuto == null) {
				return CommonResponseUtils.failureResponse("文章已被移除");
			}
			ArticleDetailVo articleDetailVo = new ArticleDetailVo();
			DTOUtils.map(articalAuto, articleDetailVo);

			if (userId != null && userId > 0) {
				UserCollectionAuto userCollectionAuto = new UserCollectionAuto();
				userCollectionAuto.setContentId(articleId);
				userCollectionAuto.setUserId(userId);
				userCollectionAuto.setCollectionType(0);
				articleDetailVo.setIsCollected(userCollectionServiceImpl.queryIsCollection(userCollectionAuto));
			}

			return CommonResponseUtils.successResponse(articleDetailVo);
		} catch (Exception e) {
			e.printStackTrace();
			LogUtils.debug("queryArticleDetail", e);
			return CommonResponseUtils.failureResponse(SUConstants.SERVER_ERROR);
		}
	}

	/**
	 * APP查看文章内容接口
	 */
	@Override
	public Map<String, Object> queryArticleContent(ArticleAuto articalAuto) {

		try {
			// 获取文章详情
			articalAuto = articalAutoMapper.queryArticleDetailById(articalAuto);
			if (articalAuto == null) {
				return CommonResponseUtils.failureResponse("文章已被移除");
			}
			// updateReadCount(articleId, articalAuto.getReadcount());
			return CommonResponseUtils.successResponse("", articalAuto);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse(SUConstants.SERVER_ERROR);
		}
	};

	private void updateReadCount(Long articleId, Long readCount) {
		ArticleAuto articalAuto = new ArticleAuto();
		articalAuto.setArticleId(articleId);
		articalAuto.setReadcount(++readCount);
		articalAutoMapper.updateByPrimaryKeySelective(articalAuto);

	}

	/**
	 * 相关商品
	 */
	@Override
	public Map<String, Object> queryRelationProductList(Long articleId) {

		try {
			ArticleProductAuto articleAuto = new ArticleProductAuto();
			articleAuto.setArticleId(articleId);
			articleAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			ArrayList<ProductSomeInfoVO> productList = queryRelationProductListVo(articleAuto);
			return CommonResponseUtils.successResponse(productList);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse(SUConstants.SERVER_ERROR);
		}
	}

	private ArrayList<ProductSomeInfoVO> queryRelationProductListVo(ArticleProductAuto articleAuto) {
		// 获取文章商品
		List<ArticleProductAuto> productSomeInfoVOList = articalProductAutoMapper.queryRelationProductList(articleAuto);
		ArrayList<ProductSomeInfoVO> productList = new ArrayList<ProductSomeInfoVO>();
		for (ArticleProductAuto articleProductAuto : productSomeInfoVOList) {
			Long productId=articleProductAuto.getProductId();
			
			if(StringCommonUtils.isInvalidateId(productId)){
				continue;
			}
			Integer isLinkProduct = articleProductAuto.getIsLinkProduct();
			if (isLinkProduct == null) {
				isLinkProduct = 0;
			}
			ProductSomeInfoVO productSomeInfoVo = new ProductSomeInfoVO();
			productSomeInfoVo.setMainId(articleProductAuto.getArticleproductId());
			productSomeInfoVo.setIsLinkProduct(isLinkProduct);
			if (isLinkProduct == 0) {
				//这是奕赏
				
				ProductAuto productAuto = new ProductAuto();
				productAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
				productAuto.setProductId(productId);
				ProductBaseInfoVo prBaseInfoVo = productAutoMapper.queryProductBaseInfoById(productAuto);
				if (prBaseInfoVo != null) {
					DTOUtils.map(prBaseInfoVo, productSomeInfoVo);
				}
				productSomeInfoVo.setLinkFrom("奕赏");
				productSomeInfoVo.setMarketPrice(new BigDecimal(prBaseInfoVo.getCostPrice()));
				//gtyadd
				
				// 查询活动
				Map<String, Object> mappromotion = promotionAutoController.productPromotion(productId);
				PromotionProductInfoVo promotionProductInfoVo = (PromotionProductInfoVo) mappromotion.get("info");

				// code=3就是没有活动
				if (mappromotion.get("code").equals("3")) {

					// 没有活动.
					productSomeInfoVo.setIsDiscount("0");

				}
				// code=1就是有活动
				if (mappromotion.get("code").equals("1")) {
					productSomeInfoVo.setIsDiscount("1");
					for (String o : mappromotion.keySet())

					{
						
						float costPrice = (float) prBaseInfoVo.getCostPrice();// 原价
						
						float percent = promotionProductInfoVo.getDiscountPercent();// 打折的百分比
						
						float discountCostprice = (costPrice * percent) / 10;
						
						
						discountCostprice = (float)(Math.round(discountCostprice * 100))/100;
						productSomeInfoVo.setDiscountPrice(discountCostprice);
					}

				}
				
				//gtyadd
			} else {
				//这是外联
				LinkProductAuto linkProductAuto = new LinkProductAuto();
				linkProductAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
				linkProductAuto.setLinkId(productId);
				LinkProductInfo linkProductInfo = linkProductAutoMapper.queryProductInfo(linkProductAuto);
				if (linkProductInfo != null) {
					DTOUtils.map(linkProductInfo, productSomeInfoVo);
					productSomeInfoVo.setCostPrice(productSomeInfoVo.getMarketPrice().floatValue());
					//IsDiscount为0没有活动因为是外联商品，活动是别的平台的
					productSomeInfoVo.setIsDiscount("0");
					
				}
			}
			productSomeInfoVo.setProductId(productId);
			
			productList.add(productSomeInfoVo);
		}

		return productList;
	}

	/**
	 * 文章增加
	 */
	@Override
	public Map<String, Object> addArticle(ArticleAuto articleAuto) {

		try {
			// 商品数量
			List<ArticleProductAuto> productList = articleAuto.getArticleProductAutoList();
			int productSize = 0;
			if (productList == null) {
			} else {
				productSize = productList.size();
			}
			articleAuto.setRelationProductCount(productSize);
			// 用户数量
			List<ArticleUserAuto> articleUserAutoList = articleAuto.getArticleUserAutoList();
			int userSize = 0;
			if (articleUserAutoList == null) {
			} else {
				userSize = articleUserAutoList.size();
			}
			articleAuto.setRelationUserCount(userSize);
			int i = articalAutoMapper.insert(articleAuto);
			// 返回文章Id
			Long articleId = articleAuto.getArticleId();
			if (StringCommonUtils.isInvalidateId(articleId)) {
				throw new MyException();
			}

			// 保存商品
			if (productSize > 0) {
				int num = articalProductAutoMapper.insertList(articleAuto);
				if (productSize != num) {
					throw new MyException();
				}
			}

			// 保存用户
			if (userSize > 0) {
				int num = articalUserAutoMapper.insertList(articleAuto);
				if (userSize != num) {
					throw new MyException();
				}
			}

			return CommonResponseUtils.successResponse("保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return CommonResponseUtils.failureResponse(SUConstants.SERVER_ERROR);
		}
	}

	/**
	 * 文章修改
	 */
	@Override
	public Map<String, Object> updateArticle(ArticleAuto articleAuto) {

		try {
			// 修改文章 的数据封装
			List<ArticleProductAuto> productList = articleAuto.getArticleProductAutoList();
			int productSize = 0;
			if (productList == null) {
			} else {
				productSize = productList.size();
			}
			articleAuto.setRelationProductCount(productSize);
			// 用户数量
			List<ArticleUserAuto> articleUserAutoList = articleAuto.getArticleUserAutoList();
			int userSize = 0;
			if (articleUserAutoList == null) {
			} else {
				userSize = articleUserAutoList.size();
			}
			articleAuto.setRelationUserCount(userSize);
	
			int num = articalAutoMapper.updateByPrimaryKeySelective(articleAuto);
			updateArticleRelationInfo(articleAuto);
			if (num > 0) {
				return CommonResponseUtils.successResponse("更新成功");
			} else {
				throw new MyException();
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("更新失败");
		}
	}

	/**
	 * 文章删除
	 */
	@Override
	public Map<String, Object> deleteArticle(ArticleAuto articalaAuto) {
		try {
			// 文章删除
			String timStamp = TmDateUtil.getTimeStamp();
			articalaAuto.setModifyTime(timStamp);
			articalaAuto.setIsDelete(SUConstants.IS_DELETE);
			int num = articalAutoMapper.updateByPrimaryKeySelective(articalaAuto);
			if (num > 0) {
				return CommonResponseUtils.successResponse("删除成功");
			} else {
				throw new MyException("删除失败");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("删除失败");
		}
	}

	/**
	 * 文章查询
	 */
	@Override
	public Map<String, Object> queryArticleById(Long articaleId) {
		try {
			ArticleAuto findArticalAuto = articalAutoMapper.selectByPrimaryKey(articaleId);
			return CommonResponseUtils.successResponse(findArticalAuto);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse(SUConstants.SERVER_ERROR);
		}
	}

	/**
	 * app查询文章
	 */
	@Override
	public Map<String, Object> queryArticleSearchList(ArticleAuto articleAuto) {
		try {
			// 查询文章表

			List<ArticleSearchVo> list = articalAutoMapper.queryArticleSearchList(articleAuto);
			return CommonResponseUtils.successResponse(list);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse(SUConstants.SERVER_ERROR);
		}

	}

	/**
	 * web 查询文章
	 */
	@Override
	public Map<String, Object> queryArticleListByPage(ArticleAuto articleAuto) {
		try {
			Integer pageIndex = articleAuto.getPageIndex();
			articleAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			Map<String, Object> resultMap = new HashMap<String, Object>();
			int totleCount = articalAutoMapper.queryTotleCount(articleAuto);
			resultMap.put("totalPageCount", totleCount);
			if (totleCount > 0) {
				// 查询文章表
				Integer pageSize = articleAuto.getPageSize();
				if (pageSize == null || pageSize < 10) {
					articleAuto.setPageSize(SUConstants.PAGE_COUNT);
				}
				
				articleAuto.setPageIndex((pageIndex - 1) * SUConstants.PAGE_COUNT);

				List<ArticleVo> list = articalAutoMapper.queryArticleList(articleAuto);
				resultMap.put("contentList", list);
			}
			return CommonResponseUtils.successResponse(resultMap);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse(SUConstants.SERVER_ERROR);
		}

	}

	/**
	 * 平台编辑查询文章详情
	 * 
	 * @return
	 */
	@Override
	public Map<String, Object> queryArticleDetailAndRelationInfoById(ArticleAuto articleAuto) {
		try {
			Long articleId=articleAuto.getArticleId();
			ArticleAuto findArticalAuto = articalAutoMapper.selectByPrimaryKey(articleId);
			ArticleProductAuto articleProductAuto = new ArticleProductAuto();
			articleProductAuto.setArticleId(articleId);
			articleProductAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			List<ArticleProductAuto> productSomeInfoVOList = articalProductAutoMapper.queryRelationProductList(articleProductAuto);
			ArrayList<ProductInfoOrLinkProductInfoVo> productList = new ArrayList<ProductInfoOrLinkProductInfoVo>();
			for (ArticleProductAuto articleProductAutoTmp : productSomeInfoVOList) {
				Long productId=articleProductAutoTmp.getProductId();
				if(StringCommonUtils.isInvalidateId(productId)){
					continue;
				}
				Integer isLinkProduct = articleProductAutoTmp.getIsLinkProduct();
				if (isLinkProduct == null) {
					isLinkProduct = 0;
				}
				ProductInfoOrLinkProductInfoVo productInfoOrLinkProductInfoVo = new ProductInfoOrLinkProductInfoVo();
				productInfoOrLinkProductInfoVo.setMainId(articleProductAutoTmp.getArticleproductId());
				productInfoOrLinkProductInfoVo.setIsLinkProduct(isLinkProduct);
				if (isLinkProduct == 0) {
					productInfoOrLinkProductInfoVo.setLinkFrom("弈赏");
					HashMap<String, Object> productMap = new HashMap<String, Object>();
					productMap.put(SUConstants.KEY_IS_DELETE,SUConstants.IS_NOT_DELETE);
					productMap.put("productId",productId);
					productMap.put("pageSize", 1);
					productMap.put("pageIndex", 0);
					List<ProductSerchInfoVo> productSerchInfoVos=productAutoMapper.queryProductByShopId(productMap);
					if(productSerchInfoVos.size()>0){
					ProductSerchInfoVo prBaseInfoVo = productSerchInfoVos.get(0);
					if (prBaseInfoVo != null) {
						DTOUtils.map(prBaseInfoVo, productInfoOrLinkProductInfoVo);
					}
					}
				} else {
					LinkProductAuto linkProductAuto = new LinkProductAuto();
					linkProductAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
					linkProductAuto.setLinkId(productId);
					LinkProductInfo linkProductInfo = linkProductAutoMapper.queryProductInfo(linkProductAuto);
					if (linkProductInfo != null) {
						DTOUtils.map(linkProductInfo, productInfoOrLinkProductInfoVo);
					}
				}
				productInfoOrLinkProductInfoVo.setProductId(productId);
				productList.add(productInfoOrLinkProductInfoVo);
			}

			findArticalAuto.setProductInfoOrLinkProductInfoVos(productList);
			return CommonResponseUtils.successResponse(findArticalAuto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new MyException("查询失败");
		}
	}

	/**
	 * 文章修改商品和相关人
	 */
	@Override
	public Map<String, Object> updateArticleProductOrUser(ArticleAuto articleAuto) {
		try {
			// 商品数量
			updateArticleRelationInfo(articleAuto);
			return CommonResponseUtils.successResponse("保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return CommonResponseUtils.failureResponse(SUConstants.SERVER_ERROR);
		}
	}

	/**
	 * 更新相关信息
	 * @param articleAuto
	 */
	private void updateArticleRelationInfo(ArticleAuto articleAuto) {
		List<ArticleProductAuto> productList = articleAuto.getArticleProductAutoList();
		int productSize = 0;
		if (productList == null) {
		} else {
			productSize = productList.size();
		}
		//articleAuto.setRelationProductCount(productSize);
		// 用户数量
		List<ArticleUserAuto> articleUserAutoList = articleAuto.getArticleUserAutoList();
		int userSize = 0;
		if (articleUserAutoList == null) {
		} else {
			userSize = articleUserAutoList.size();
		}
		//articleAuto.setRelationUserCount(userSize);
		int num ;
		//= articalAutoMapper.updateByPrimaryKeySelective(articleAuto);

//		if (num < 1) {
//			throw new MyException();
//		}
		// 删除旧的
		String timeStamp = TmDateUtil.getTimeStamp();
		ArticleProductAuto articleProductAuto = new ArticleProductAuto();
		ArticleUserAuto articleUserAuto = new ArticleUserAuto();
		articleProductAuto.setArticleId(articleAuto.getArticleId());
		articleProductAuto.setIsDelete(SUConstants.IS_DELETE);
		articleProductAuto.setModifyTime(timeStamp);
		articleProductAuto.setModifyUserId(articleAuto.getModifyUserId());

		articleUserAuto.setArticleId(articleAuto.getArticleId());
		articleUserAuto.setIsDelete(SUConstants.IS_DELETE);
		articleUserAuto.setModifyTime(timeStamp);
		articleUserAuto.setModifyUserId(articleAuto.getModifyUserId());
		articalProductAutoMapper.updateByPrimaryKeySelective(articleProductAuto);
		articalUserAutoMapper.updateByPrimaryKeySelective(articleUserAuto);
		// 保存商品
		articleAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
		if (productSize > 0) {
			num = articalProductAutoMapper.insertList(articleAuto);
			if (productSize != num) {
				throw new MyException();
			}
		}

		// 保存用户
		if (userSize > 0) {
			num = articalUserAutoMapper.insertList(articleAuto);
			if (userSize != num) {
				throw new MyException();
			}
		}

		
	}

}
