package com.essential.common.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import sun.misc.BASE64Decoder;
/*import org.apache.commons.net.ftp.FTPClient;  
import org.apache.commons.net.ftp.FTPReply;  */

public class Upload {

	/**
	 * base方式上传
	 * 
	 * @param imgStr
	 *            图片的base64码
	 * @param ImagePath
	 *            图片要上穿的路径
	 * @return
	 */

	public String uploadImageImageByBase64(String imgStr, String ImagePath) {

		String path = "";// 图片保存的路径

		if (imgStr == null || ImagePath == null) // 图像数据为空
			return "没有上传成功";
		else {
			path = ImagePath;// 图片要保存的路径

		}
		BASE64Decoder decoder = new BASE64Decoder();

		try {
			// Base64解码
			byte[] b = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}

			String imgFilePath = path;
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(b);
			out.flush();
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
			return "没有上传成功出现异常";
		}
		return path;
	}
	/** 
	 * Description: 向FTP服务器上传文件 
	 * @Version1.0 Jul 27, 2008 4:31:09 PM by 崔红保（cuihongbao@d-heaven.com）创建 
	 * @param url FTP服务器hostname 
	 * @param port FTP服务器端口 
	 * @param username FTP登录账号 
	 * @param password FTP登录密码 
	 * @param path FTP服务器保存目录 
	 * @param filename 上传到FTP服务器上的文件名 
	 * @param input 输入流 
	 * @return 成功返回true，否则返回false 
	 */  
	/*public  boolean uploadFile(String url,int port,String username, String password, String path, String filename, InputStream input) {  
	    boolean success = false;  
	   
	    FTPClient ftp = new FTPClient();  
	    try {  
	        int reply;  
	        ftp.connect(url, port);//连接FTP服务器  
	        //如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器  
	        ftp.login(username, password);//登录  
	        reply = ftp.getReplyCode();  
	        if (!FTPReply.isPositiveCompletion(reply)) {  
	            ftp.disconnect();  
	            return success;  
	        }  
	        ftp.changeWorkingDirectory(path);  
	        ftp.storeFile(filename, input);           
	          
	        input.close();  
	        ftp.logout();  
	        success = true;  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    } finally {  
	        if (ftp.isConnected()) {  
	            try {  
	                ftp.disconnect();  
	            } catch (IOException ioe) {  
	            }  
	        }  
	    }  
	    return success;  */

}
