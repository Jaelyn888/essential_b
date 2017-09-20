package com.essential.utils;

import java.math.BigDecimal;

import org.springframework.util.StringUtils;

public class StringToNumberUtils extends StringUtils {

	// 将字母转换成数字_1
	public static String stringToNumber(String input) {
		String reg = "[a-zA-Z]";
		StringBuffer strBuf = new StringBuffer();
//		input = input.toLowerCase();
		if (null != input && !"".equals(input)) {
			for (char c : input.toCharArray()) {
				if (String.valueOf(c).matches(reg)) {
					strBuf.append((int)c);
				} else {
					strBuf.append(c);
				}
			}
			return strBuf.toString();
		} else {
			return input;
		}
	}

	// 将字母转换成数字
	public static void letterToNum(String input) {
		for (byte b : input.getBytes()) {
			System.out.print(b - 96);
		}
	}

	// 将数字转换成字母
	public static void numToLetter(String input) {
		for (byte b : input.getBytes()) {
			System.out.print((char) (b + 48));
		}
	}

	/**
	 * 去除无效的0
	 * @param number
	 * @return
	 */
	public static String trimNumber(double number) {  
	    return BigDecimal.valueOf(number).stripTrailingZeros().toPlainString();  
	}  
	  
	public static void main(String[] args) {  
	    String intNumber = "00012340";  
	    System.out.println(trimNumber(Double.parseDouble(intNumber)));  
	    String doubleNumber = "12.340";  
	    System.out.println(trimNumber(Double.parseDouble(doubleNumber)));  
	      
	    String eNumber = "1.2e3";  
	    System.out.println(trimNumber(Double.parseDouble(eNumber)));  

		String i1 = "A13a";
		System.out.println(stringToNumber(i1));
	}
	

}
