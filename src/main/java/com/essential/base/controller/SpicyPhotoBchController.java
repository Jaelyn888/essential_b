package com.essential.base.controller;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.essential.common.constants.SUConstants;

@Controller
@RequestMapping("/spicyPhoto")
public class SpicyPhotoBchController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private enum MESSAGE {
		error, success, failure
	};

	String tempImgPath=SUConstants.TEMP_IMG_PATH;

	/**
	 * 
	 * @Description: 上传图片
	 * @author: 李杨
	 * @param: @param file
	 * @param: @param request
	 * @param: @param response
	 * @param: @return
	 * @param: @throws Exception
	 * @return: String
	 * @throws
	 */
	@RequestMapping(value = "/uploadFile")
	@ResponseBody
	public String uploadFile(@RequestParam("file") MultipartFile file,
			HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("text/plain;utf-8");
		double fileSize = file.getSize() / (1024.00 * 1024.00);
		if (fileSize >= 1) {
			return MESSAGE.failure.toString();
		}
		// 初始化，删除已存在的图片
		//保存上传图片的临时路径
		String tempImgPath=SUConstants.TEMP_IMG_PATH;
		File dir = new File(tempImgPath);
		if (!dir.exists()) {
			dir.mkdirs();
		} else {
		}
		String fileName = file.getOriginalFilename();

		Date date = new Date();
		fileName = date.getTime() + "_" + fileName;
		String tempFilePath = tempImgPath + fileName;

		//		String tempFilePath = request.getRealPath(TEMP_IMG_PATH) + "/"
		//		+ rbacUserBsh.getCurrentUserId() + File.separator + fileName;
		FileOutputStream fos = null;
		InputStream is = null;
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
	  	upload.setHeaderEncoding("utf-8");
		try {
			fos = new FileOutputStream(new File(tempFilePath));
			is = file.getInputStream();
			byte[] buffer = new byte[1024];
			int i = -1;
			while ((i = is.read(buffer)) != -1) {
				fos.write(buffer, 0, i);
			}
			fos.flush();
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			fos.close();
			is.close();
			fos = null;
			is = null;
		}
		response.getWriter().write(fileName);
		return null;
	}

	/**
	 * 取消
	 * 
	 * @param request
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/cancle")
	@ResponseBody
	public String destroy(HttpServletRequest request) {
		//		String filePath = request.getRealPath(TEMP_IMG_PATH) + "/"
		//				+ rbacUserBsh.getCurrentUserId();

		String filePath = request.getRealPath(tempImgPath) + "/" + "";
		File tempDir = new File(filePath);
		if (tempDir != null && tempDir.isDirectory()) {
			File[] files = tempDir.listFiles();
			for (File file : files) {
				file.delete();
			}
		}
		//		return CoreServiceViewType.success.toString();
		return "";
	}

	/**
	 * 剪裁并保存图片
	 * 
	 * @param request
	 * @param typeId
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @param imgs_size
	 * @param imgContainerSize
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/cuttingIMG")
	@ResponseBody
	public String cuttingIMG(HttpServletRequest request, String typeId, int x, int y,
			int w, int h, int imgContainerSize, String loginName) throws Exception {
		int[] imgs_size = { 50, 80, 100 };
		//		File dir = new File(request.getRealPath(TEMP_IMG_PATH) + "/"
		//				+ rbacUserBsh.getCurrentUserId());
		File dir = new File(tempImgPath);

		File tempImgFile = null;
		if (dir.isDirectory()) {
			File[] files = dir.listFiles();
			if (files != null && files.length > 0) {
				for (File file : files) {
					if (!file.getName().endsWith("db")) {
						tempImgFile = file;
						break;
					}
				}
			}
		}

		// 定义已剪裁图片的名字为cutted_文件名
		String imgName = tempImgFile.getName();
		String image_path = tempImgPath + "cutted_" + imgName;
		//		String image_path = request.getRealPath(TEMP_IMG_PATH) + "/"
		//		+ rbacUserBsh.getCurrentUserId() + File.separator + "cutted_" + imgName;

		File subFile = new File(image_path);
		subFile.createNewFile();
		// 获取真实需要剪裁的长和宽
		Image image = ImageIO.read(tempImgFile);
		int imageHeight = image.getHeight(null);
		int imageWidth = image.getWidth(null);
		float scale = 0;
		if (imageWidth > imageHeight) {
			scale = imageWidth / (imgContainerSize * 1.00F);
		} else {
			scale = imageHeight / (imgContainerSize * 1.00F);
		}
		w = (int) (w * scale);
		h = (int) (h * scale);
		x = (int) (x * scale);
		y = (int) (y * scale);
		// 剪裁图片
		cut(tempImgFile, x, y, w, h, subFile);
		// 图片caseId设为用户ID
		//		UserInfo userInfo = getLoginUserInfo();

		//		LoginUserInfo userInfo = (LoginUserInfo) request.getSession().getAttribute(
		//				"loginUserInfo");
		//		Long caseId = null;
		//		if (userInfo != null) {
		//			caseId = userInfo.getUserId();
		//		} else {
		//			if (loginName == null || "".equals(loginName.trim())) {
		//				logger.error("the param loginName is null.");
		//				throw new NullPointerException();
		//			}
		//			//			RbacUserEO user = rbacUserBsh.getObjectByLoginName(loginName);
		//			caseId = userInfo.getUserId();
		//		}
		//
		//		if (caseId == null) {
		//			logger.error("SpicyPhotoBchImpl.cuttingIMG:the current user is null!");
		//			throw new Exception();
		//		}
		// 需要截取50x50,80x80和100x100的图片
		for (int imgSize : imgs_size) {
			StringBuffer imgPath = new StringBuffer("");
			imgPath.append(tempImgPath).append(File.separator).append("img_").append(
					String.valueOf(imgSize)).append(imgName);

			//			imgPath.append(
			//					request.getRealPath(TEMP_IMG_PATH) + "/"
			//							+ rbacUserBsh.getCurrentUserId()).append(File.separator)
			//					.append("img_").append(String.valueOf(imgSize)).append(imgName);
			File uploadFile = new File(imgPath.toString());
			uploadFile.createNewFile();
			drawImage(subFile, uploadFile, imgSize, imgSize);
			String businessType = ImageSizeType.IMAGE_100.toString();
			if (imgSize == 50) {
				businessType = ImageSizeType.IMAGE_50.toString();
			} else if (imgSize == 80) {
				businessType = ImageSizeType.IMAGE_80.toString();
			}
			saveImage(typeId, businessType, uploadFile);
		}
		subFile.delete();
		return MESSAGE.success.toString();
	}

	/**
	 * 图片放缩处理
	 * 
	 * @param file
	 *            源图片
	 * @param path
	 *            新图片的存放路径
	 * @param times
	 *            放缩倍数
	 * @throws IOException
	 */
	private void drawImage(File inFile, File outFile, int width, int height)
			throws Exception {
		FileOutputStream imgFos = null;
		try {
			Image image = ImageIO.read(inFile);
			BufferedImage bufImage = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			Graphics2D graphics2D = bufImage.createGraphics();
			graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
					RenderingHints.VALUE_INTERPOLATION_BICUBIC);
			graphics2D.drawImage(image, 0, 0, width, height, null);
			graphics2D.dispose();
			imgFos = new FileOutputStream(outFile);
			// 图片后缀
			String endName = inFile.getName().substring(
					inFile.getName().lastIndexOf(".") + 1);
			ImageIO.write(bufImage, endName, imgFos);
			bufImage.flush();
			imgFos.flush();
		} catch (IOException e) {
			e.printStackTrace();
			outFile.delete();
			throw new Exception(e);
		} finally {
			imgFos.close();
			imgFos = null;
		}
	}

	/**
	 * 保存图片
	 * 
	 * @param caseId
	 * @param typeId
	 * @param contentType
	 * @param file
	 * @throws IOException
	 */
	private void saveImage(String typeId, String businessType, File file)
			throws Exception {
		// 查询ContentEO
		//		ContentEO content = contentBsh.getLatestObjectByCaseId(caseId, typeId,
		//				businessType);

		//		ContentEO content = contentBsh.getLatestObjectByCaseId(caseId, typeId,
		//				businessType);
		//		if (content == null) {
		//			content = new ContentEO();
		//			content.setCaseId(caseId);
		//			content.setTypeId(typeId);
		//			content.setStatus(ContentEO.ContentStatus.E.toString());
		//			content.setBusinessType(businessType);
		//		}

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			//			content.setName(file.getName());
			//			content.setContentType(ContentEO.ContentType.jpg.getValue());
			//			contentBsh.uploadContent(content, fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			fis.close();
			fis = null;
			file.delete();
		}
	}

	/**
	 * 剪裁图片
	 * 
	 * @param file
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @throws IOException
	 */
	private void cut(File file, int x, int y, int w, int h, File subFile)
			throws Exception {
		String fileName = file.getName();
		String endName = fileName.substring(fileName.lastIndexOf(".") + 1);
		Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName(endName);
		ImageReader reader = readers.next();
		InputStream is = null;
		ImageInputStream iis = null;
		try {
			// 剪裁
			is = new FileInputStream(file);
			iis = ImageIO.createImageInputStream(is);
			reader.setInput(iis, true);
			ImageReadParam param = reader.getDefaultReadParam();
			Rectangle rect = new Rectangle(x, y, w, h);
			param.setSourceRegion(rect);
			BufferedImage bi = reader.read(0, param);
			ImageIO.write(bi, endName, subFile);
			iis.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			iis.close();
			is.close();
			iis = null;
			is = null;
			file.delete();
		}

	}

	/**
	 * 展示图片
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/showIMG")
	public void showIMG(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 获取临时存放图片的路径
		File file = new File(request.getRealPath(tempImgPath) + "/" + "");

		//		File file = new File(request.getRealPath(TEMP_IMG_PATH) + "/"
		//				+ rbacUserBsh.getCurrentUserId());
		// 上传的图片
		File tempImgFile = null;
		if (file.isDirectory()) {
			File[] imgFiles = file.listFiles();
			if (imgFiles != null && imgFiles.length == 1) {
				tempImgFile = imgFiles[0];
			}
		}
		if (tempImgFile != null) {
			FileInputStream fis = null;
			OutputStream os = null;
			try {
				fis = new FileInputStream(tempImgFile);
				os = response.getOutputStream();
				byte[] buffer = new byte[1024];
				int i = -1;
				while ((i = fis.read(buffer)) != -1) {
					os.write(buffer, 0, i);
				}
				os.flush();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				throw new Exception(e);
			} finally {
				os.close();
				fis.close();
				os = null;
				fis = null;
			}

		}
	}

	/**
	 * 会员展示图片
	 * 
	 * @param request
	 * @param response
	 * @param typeId
	 * @param businessType
	 * @throws Exception 
	 * @throws IOException
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/showPhoto")
	protected void showPhoto(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(required = true, value = "typeId") String typeId,
			@RequestParam(required = true, value = "businessType") String businessType,
			String loginName) throws Exception {
		OutputStream os = null;
		//		ContentEO content = null;
		InputStream inputStream = null;
		// 判断是否传入正确的businessType，如果错误默认给100x100的图片
		ImageSizeType[] types = ImageSizeType.values();
		boolean flag = false;
		for (ImageSizeType type : types) {
			if (businessType.equals(type.toString())) {
				flag = true;
			}
		}
		if (!flag) {
			businessType = ImageSizeType.IMAGE_100.toString();
		}
		//LoginUserInfo user = (LoginUserInfo) request.getSession().getAttribute("loginUserInfo");
		//Long userId = null;

		if (loginName != null && !"null".equals(loginName)) {
			//			RbacUserEO rbacUser = rbacUserBsh.getObjectByLoginName(loginName);
			//			if (rbacUser != null) {
			//				userId = rbacUser.getUserId();
			//			} else {
			//				logger.error("取不到当前用户！throw new CastaliaException()");
			//				throw new Exception();
			//			}
		} else {
			//			if (user != null) {
			//				userId = user.getUserId();
			//			}
		}
		//		content = contentBsh.getLatestObjectByCaseId(userId, typeId, businessType);
		try {
			//			if (content != null) {
			//				//				inputStream = contentBsh.getContentStream(content.getContentId());
			//			}
			if (inputStream == null) {
				File file = new File(request.getRealPath("/image/blocks.gif"));
				inputStream = new FileInputStream(file);
			}
			os = response.getOutputStream();
			byte[] buffer = new byte[1024];
			int i = -1;
			while ((i = inputStream.read(buffer)) != -1) {
				os.write(buffer, 0, i);
			}
			os.flush();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("IO Download Error", e);
			throw new Exception(e);
		} finally {
			IOUtils.closeQuietly(inputStream);
			IOUtils.closeQuietly(os);
		}
	}

	public enum ImageSizeType {
		IMAGE_50, IMAGE_80, IMAGE_100
	}

}
