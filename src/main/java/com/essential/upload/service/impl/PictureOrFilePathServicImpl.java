package com.essential.upload.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.essential.common.constants.SUConstants;
import com.essential.upload.service.IPictureOrFilePathServic;
import com.essential.utils.CommonResponseUtils;
import com.essential.utils.OSSManagerUtils;

/**
 * 图片文件的路径保存
 * 
 * @author czm
 *
 */
@Service
public class PictureOrFilePathServicImpl implements IPictureOrFilePathServic {

	private static Logger logger = LoggerFactory.getLogger(PictureOrFilePathServicImpl.class);

	@Override
	public Map<String, Object> uploadPictureOrFile(@RequestParam("file") MultipartFile[] file, int type) {
		try {
			// 远程服务器文件路径
			List<String> uploadPathList = new ArrayList<String>();
			String remotePath = "";
			if( file.length <= 0){
				return CommonResponseUtils.failureResponse("请选择上传的文件!");
			}
			for(int i =0; i < file.length; i++){
				if(!file[i].isEmpty()){
					logger.info("=========>>>>>>文件上传开始：----文件名："
							+file[i].getOriginalFilename()+"-------------大小："+file[i].getSize());
					InputStream inputStream = file[i].getInputStream();
					String filename = file[i].getOriginalFilename();
					if (type == SUConstants.FILE_SHOP_TYPE) {
						remotePath = SUConstants.FILE_SHOP;
					} else if (type == SUConstants.FILE_PRODUCT_TYPE) {
						remotePath = SUConstants.FILE_PRODUCT;
					}  else if (type == SUConstants.FILE_RECOMMEND_TYPE) {
						remotePath = SUConstants.FILE_RECOMMEND;
					} else {
						remotePath = SUConstants.FILE_OTHER;
					}
					uploadPathList.add(OSSManagerUtils.uploadFileByInputStream(inputStream, remotePath, filename));
					logger.info("=========>>>>>>文件上传结束：----文件名："+file[i].getOriginalFilename()
							+"-------------大小："+file[i].getSize());
				}else{
					throw new Exception("图片上传失败!");
				}
			}
			
			return CommonResponseUtils.successResponse(uploadPathList);
		} catch (Exception e) {
			logger.info("=============>>>>>>" + e);
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	
	
	@Override
	public Map<String, Object> uploadFile(MultipartFile file, int type) {
		try {
			// 远程服务器文件路径
			List<String> uploadPathList = new ArrayList<String>();
			String remotePath = "";
			if(!file.isEmpty()){
				InputStream inputStream = file.getInputStream();
				String filename = file.getOriginalFilename();
				if (type == SUConstants.FILE_SHOP_TYPE) {
					remotePath = SUConstants.FILE_SHOP;
				} else if (type == SUConstants.FILE_PRODUCT_TYPE) {
					remotePath = SUConstants.FILE_PRODUCT;
				} else {
					remotePath = SUConstants.FILE_OTHER;
				}
				uploadPathList.add(OSSManagerUtils.uploadFileByInputStream(inputStream, remotePath, filename));
			}else{
				throw new Exception("图片上传失败!");
			}
			
			return CommonResponseUtils.successResponse(uploadPathList);
		} catch (Exception e) {
			logger.info("=============>>>>>>" + e);
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
