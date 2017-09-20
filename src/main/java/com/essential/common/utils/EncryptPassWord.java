package com.essential.common.utils;

import java.security.MessageDigest;

public class EncryptPassWord {
	
	
	
	
	public static String EncryptStr(String password)
	{
		//得到序列化bytes
		byte[] bytes = toUnicodeMC(password);
		//进行加密
		String returnPassword =toMD5Code(bytes);
		//转为大写
		returnPassword= returnPassword.toUpperCase();
		//每隔2个字符加个美丽的横杠（-）
		
		 StringBuffer sb=new StringBuffer(returnPassword);
	        int index;
	        for(index=2;index<sb.length();index+=3){
	       sb.insert(index, '-');
	        }
			System.out.print(sb);
			
		return sb.toString();
		
	}

	//得到差异化的bytes
	//1. .NET中，每个字符的byte序列与unicode相反，而java是标准unicode编码

	//2. JAVA中，byte序列多了2个byte
	
	public static byte[] toUnicodeMC(String s) {
	     byte[] bytes = new byte[s.length() * 2];
	     for (int i = 0; i < s.length(); i++) {
	         int code = s.charAt(i) & 0xffff;
	         bytes[i * 2] = (byte) (code & 0x00ff);
	         bytes[i * 2 + 1] = (byte) (code >> 8);
	     }
	     return bytes;
	 }
	
	
	
	
	
	//非标准的javaMd5(含.net规则，除了密码加密，请谨慎调用此方法)
	public static String toMD5Code(byte[] bytes) {
	     StringBuffer sb = new StringBuffer();
	     try {
	         MessageDigest md5 = MessageDigest.getInstance("MD5");
	         md5.reset();
	         md5.update(bytes);
	         byte[] after = md5.digest();

	         for (int i = 0; i < after.length; i++) {
	             String hex = Integer.toHexString(0xff & after[i]);
	             if (hex.length() == 1)
	                 hex = "0" + hex;
	                 sb.append(hex);
	             }
	      } catch (Exception ex) {
	         ex.printStackTrace();
	      }
	      return sb.toString();
	 }
	
	
	
	
}
