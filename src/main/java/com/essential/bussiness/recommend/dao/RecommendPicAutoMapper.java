package com.essential.bussiness.recommend.dao;

import com.essential.bussiness.recommend.model.auto.RecommendPicAuto;
import com.essential.bussiness.recommend.model.auto.RecommendPicAutoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecommendPicAutoMapper {
    int countByExample(RecommendPicAutoExample example);

    int deleteByExample(RecommendPicAutoExample example);

    int deleteByPrimaryKey(Long recommendPicId);

    int insert(RecommendPicAuto record);

    int insertSelective(RecommendPicAuto record);

    List<RecommendPicAuto> selectByExample(RecommendPicAutoExample example);

    RecommendPicAuto selectByPrimaryKey(Long recommendPicId);

    int updateByExampleSelective(@Param("record") RecommendPicAuto record, @Param("example") RecommendPicAutoExample example);

    int updateByExample(@Param("record") RecommendPicAuto record, @Param("example") RecommendPicAutoExample example);

    int updateByPrimaryKeySelective(RecommendPicAuto record);

    int updateByPrimaryKey(RecommendPicAuto record);
}