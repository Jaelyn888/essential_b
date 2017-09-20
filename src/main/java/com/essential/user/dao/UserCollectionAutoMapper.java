package com.essential.user.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.essential.bussiness.product.model.vo.ProductInfoWithPromotionVo;
import com.essential.find.model.vo.ArticleVo;
import com.essential.find.model.vo.SpecialVo;
import com.essential.user.model.auto.UserCollectionAuto;
import com.essential.user.model.vo.CollectionBrandInfoVo;

public interface UserCollectionAutoMapper {
    int deleteByPrimaryKey(Long collectionId);

    int insert(UserCollectionAuto record);

    int insertSelective(UserCollectionAuto record);

    UserCollectionAuto selectByPrimaryKey(Long collectionId);

    int updateByPrimaryKeySelective(UserCollectionAuto record);

    int updateByPrimaryKey(UserCollectionAuto record);
    
    int insertMap(Map<String, Object> requestMap);
    
    List<UserCollectionAuto> selectByParamSelective(UserCollectionAuto userCollectionAuto);

	ArrayList<ArticleVo> queryArticleList(UserCollectionAuto userCollectionAuto);

	ArrayList<SpecialVo> querySpecialList(UserCollectionAuto userCollectionAuto);

	ArrayList<ArticleVo> queryShopList(UserCollectionAuto userCollectionAuto);

	ArrayList<ProductInfoWithPromotionVo> queryProductList(UserCollectionAuto userCollectionAuto);

	ArrayList queryBlogList(UserCollectionAuto userCollectionAuto);

	ArrayList<CollectionBrandInfoVo> queryBrandList(UserCollectionAuto userCollectionAuto);
	
	Integer queryCount(UserCollectionAuto userCollectionAuto);
}