package com.essential.upload.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.essential.upload.service.IPictureOrFilePathServic;
import com.essential.utils.CommonResponseUtils;

/**
 * 上传图片文件
 * 
 * @author czm
 *
 */
@Controller
@RequestMapping(value = "pictureOrFilePathController")
public class PictureOrFilePathController {

	private Logger logger = LoggerFactory.getLogger(PictureOrFilePathController.class);
	
	@Autowired
	IPictureOrFilePathServic pictureOrFilePathServic;

	/**
	 * 上传图片
	 * 
	 * @param pictureOrFilePathListVo
	 * @return
	 */
	@RequestMapping(value = "uploadPictureOrFile")
	@ResponseBody
	public Map<String, Object> uploadPictureOrFile(@RequestParam("file") MultipartFile[] file, int imgType) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			return pictureOrFilePathServic.uploadPictureOrFile(file, imgType);
		} catch (Exception e) {
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("图片上传失败!"));
		}
		return map;
	}
	
	
	
	@RequestMapping(value = "uploadFile")
	@ResponseBody
	public Map<String, Object> uploadPictureOrFile(MultipartHttpServletRequest request, int imgType) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Map<String, MultipartFile> fileMap = request.getFileMap();
			
			for (Entry<String, MultipartFile> entry : fileMap.entrySet()) {
				MultipartFile file = entry.getValue();
				
				if(!file.isEmpty())
				{
					logger.info("上传图片文件信息："+entry.getValue());
					return pictureOrFilePathServic.uploadFile(file, imgType);
				}
				else{
					logger.error("上传图片为空！！");
					return  CommonResponseUtils.failureResponse("上传的图片为空");
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			map.putAll(CommonResponseUtils.failureResponse("图片上传失败!"));
		}
		return map;
	}
}
