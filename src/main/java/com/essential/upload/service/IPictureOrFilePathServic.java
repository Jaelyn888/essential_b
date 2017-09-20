package com.essential.upload.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 上传图片文件
 * 
 * @author czm
 *
 */
@Service
public interface IPictureOrFilePathServic {

	public Map<String, Object> uploadPictureOrFile(@RequestParam("file") MultipartFile[] file, int type);
	
	public Map<String, Object> uploadFile(MultipartFile file, int type);
}
