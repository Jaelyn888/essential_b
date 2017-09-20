package com.essential.utils;

import java.util.Random;

import com.essential.common.constants.SUConstants;

public class RandomStr {
	public static String getRandomString(int length){  
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";  
        Random random = new Random();  
        StringBuffer sb = new StringBuffer();  
          
        for(int i = 0 ; i < length; ++i){  
            int number = random.nextInt(62);//[0,62)  
              
            sb.append(str.charAt(number));  
        }  
        return sb.toString();  
    }  
	
	/**
	 * 短信验证码
	 * @return
	 */
	public static String getSmsCode(){
		Random random = new Random();
		String randomCode = "";
		for (int i = 0; i < SUConstants.SEND_REGISTRATION_CODE; i++) {
			randomCode += random.nextInt(10);
		}
		return randomCode;
	}

}
