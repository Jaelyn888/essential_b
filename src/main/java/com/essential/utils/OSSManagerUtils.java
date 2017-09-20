package com.essential.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;

import com.aliyun.openservices.oss.OSSClient;
import com.aliyun.openservices.oss.model.ObjectMetadata;
import com.essential.common.utils.TmDateUtil;

public class OSSManagerUtils {
	/**
	 * 上传OSS服务器文件
	 * 
	 * @Title: uploadFile
	 * @Description:
	 * @param file
	 *            文件类型
	 * @param remotePath
	 *            业务目录
	 * @return String 返回类型
	 * @throws
	 */
	public static String uploadFile(File file, String remoteBizPath) throws Exception {
		InputStream fileContent = null;
		fileContent = new FileInputStream(file);
		String oldFileName = file.getName();

		return uploadFileByInputStream(fileContent, remoteBizPath, oldFileName);
	}

	/**
	 * 获取文件流上传文件到OSS服务器
	 * 
	 * @param fileContent
	 *            文件输入流
	 * @param remoteBizPath
	 *            oss服务器文件目录
	 * @return 文件在oss服务器的路径
	 * @param oldFileName
	 *            原文件名
	 * @throws Exception
	 */
	public static String uploadFileByInputStream(InputStream fileContent, String remoteBizPath, String oldFileName) throws Exception {
		// 获取OSS配置信息
		OSSConfigure ossConfigure = new OSSConfigure();

		// 文件目录组装：根目录为当前日期，业务目录传入
		String remotePath = TmDateUtil.getCalendarDate("yyyyMMdd");
		remotePath += "/" + remoteBizPath;
		// 重新组装文件名
		StringBuffer fileNameBuffer = new StringBuffer();
		fileNameBuffer.append(System.currentTimeMillis());
		fileNameBuffer.append(UUID.randomUUID().toString().replaceAll("-", "").toLowerCase().substring(0, 9));
		fileNameBuffer.append(oldFileName.substring(oldFileName.lastIndexOf(".")));
		String fileName = fileNameBuffer.toString();

		OSSClient ossClient = new OSSClient(ossConfigure.getEndpoint(), ossConfigure.getAccessKeyId(), ossConfigure.getAccessKeySecret());
		String remoteFilePath = remotePath == null ? "" : remotePath.substring(0, remotePath.length()).replaceAll("\\\\", "/") + "/";
		// 创建上传Object的Metadata
		ObjectMetadata objectMetadata = new ObjectMetadata();
		objectMetadata.setContentLength(fileContent.available());
		objectMetadata.setCacheControl("no-cache");
		objectMetadata.setHeader("Pragma", "no-cache");
		// objectMetadata.setContentType(contentType(file.getName().substring(
		// file.getName().lastIndexOf("."))));
		objectMetadata.setContentDisposition("inline;filename=" + fileName);
		// 上传文件
		ossClient.putObject(ossConfigure.getBucketName(), remoteFilePath + fileName, fileContent, objectMetadata);
		// System.out.println(ossConfigure.getAccessUrl() + "/" + remoteFilePath
		// + fileName);
		fileContent.close();
		return ossConfigure.getAccessUrl() + "/" + remoteFilePath + fileName;
	}

	/**
	 * 根据key删除OSS服务器上的文件
	 * 
	 * @Title: deleteFile
	 * @Description:
	 * @param @param ossConfigure
	 * @param @param filePath 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public static void deleteFile(OSSConfigure ossConfigure, String filePath) {
		OSSClient ossClient = new OSSClient(ossConfigure.getEndpoint(), ossConfigure.getAccessKeyId(), ossConfigure.getAccessKeySecret());
		ossClient.deleteObject(ossConfigure.getBucketName(), filePath);

	}

	/**
	 * Description: 判断OSS服务文件上传时文件的contentType
	 * 
	 * @Version1.0
	 * @param FilenameExtension
	 *            文件后缀
	 * @return String
	 */
	public static String contentType(String FilenameExtension) {
		if (FilenameExtension.equals("BMP") || FilenameExtension.equals("bmp")) {
			return "image/bmp";
		}
		if (FilenameExtension.equals("GIF") || FilenameExtension.equals("gif")) {
			return "image/gif";
		}
		if (FilenameExtension.equals("JPEG") || FilenameExtension.equals("jpeg") || FilenameExtension.equals("JPG") || FilenameExtension.equals("jpg") || FilenameExtension.equals("PNG")
				|| FilenameExtension.equals("png")) {
			return "image/jpeg";
		}
		if (FilenameExtension.equals("HTML") || FilenameExtension.equals("html")) {
			return "text/html";
		}
		if (FilenameExtension.equals("TXT") || FilenameExtension.equals("txt")) {
			return "text/plain";
		}
		if (FilenameExtension.equals("VSD") || FilenameExtension.equals("vsd")) {
			return "application/vnd.visio";
		}
		if (FilenameExtension.equals("PPTX") || FilenameExtension.equals("pptx") || FilenameExtension.equals("PPT") || FilenameExtension.equals("ppt")) {
			return "application/vnd.ms-powerpoint";
		}
		if (FilenameExtension.equals("DOCX") || FilenameExtension.equals("docx") || FilenameExtension.equals("DOC") || FilenameExtension.equals("doc")) {
			return "application/msword";
		}
		if (FilenameExtension.equals("XML") || FilenameExtension.equals("xml")) {
			return "text/xml";
		}
		return "text/html";
	}
}
