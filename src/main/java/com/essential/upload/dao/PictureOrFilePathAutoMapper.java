package com.essential.upload.dao;

import java.util.List;

import com.essential.upload.model.auto.PictureOrFilePathAuto;

public interface PictureOrFilePathAutoMapper {
	int deleteByPrimaryKey(Long id);

	int insert(PictureOrFilePathAuto record);

	int insertSelective(PictureOrFilePathAuto record);

	PictureOrFilePathAuto selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(PictureOrFilePathAuto record);

	int updateByPrimaryKey(PictureOrFilePathAuto record);

	//查询
	List<PictureOrFilePathAuto> queryByPrimaryKey(PictureOrFilePathAuto record);
	
	//逻辑删除
	int updateIsDeletePrimary(PictureOrFilePathAuto record);
}