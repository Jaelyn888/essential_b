package com.essential.find.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.essential.find.model.auto.ArticleAuto;
import com.essential.find.model.auto.ArticleProductAuto;
import com.essential.find.model.auto.ArticleUserAuto;

public interface ArticleUserAutoMapper {
    int deleteByPrimaryKey(Long articleuserId);

    int insert(ArticleUserAuto record);

    int insertSelective(ArticleUserAuto record);

    ArticleUserAuto selectByPrimaryKey(Long articleuserId);

    int updateByPrimaryKeySelective(ArticleUserAuto record);

    int updateByPrimaryKey(ArticleUserAuto record);
    
    int updateIsDelete(@Param("articleId")Long articleId,@Param("isDelete")int isDelete);
    
    List<ArticleUserAuto> queryUserIdList(ArticleUserAuto record);

    /**
     * 批量插入相关商品
     * @param productList
     * @param createUserId
     * @param articleId
     * @param timeStamp
     * @return
     */
	int insertList(ArticleAuto articleAuto);
}