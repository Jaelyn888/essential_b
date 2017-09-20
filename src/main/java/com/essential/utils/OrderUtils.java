package com.essential.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public class OrderUtils {
	
	public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",
			"g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
			"t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
			"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
			"W", "X", "Y", "Z" };
	
	public static String[] strs = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I",
		"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
		"W", "X", "Y", "Z" };

	public static String generateShortUuid() {
		StringBuffer shortBuffer = new StringBuffer();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		for (int i = 0; i < 8; i++) {
			String str = uuid.substring(i * 4, i * 4 + 4);
			int x = Integer.parseInt(str, 16);
			shortBuffer.append(chars[x % 0x3E]);
		}
		return shortBuffer.toString();

	}
	
	
	public static String shortUniqueRepeatNum() {
		return generateShortUuid();
	}
	
	
	public static String getStringOrderNoForOrder() {
		StringBuffer strBuffer = new StringBuffer();
		Calendar calendar = Calendar.getInstance(Locale.CHINA);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH)+1;
		int i = (year-2016)/26;
		int k = (year-2016)%26;
		int km = (12-month)%12;
		if(i > 0){
			strBuffer.append(strs[k]);
			strBuffer.append(i);
			strBuffer.append(strs[km]);
		}else{
			strBuffer.append(strs[k]);
			strBuffer.append(strs[km]);
		}
		Date date = calendar.getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddHHmmss");
		strBuffer.append(dateFormat.format(date));
		
		return strBuffer.toString();

	}
	
	

	public static String getOrderNumber(String userId) throws Exception {
		StringBuilder sb = new StringBuilder();
		
		sb.append(getStringOrderNoForOrder());
		sb.append(userId);
		
		return sb.toString();
	}
	
	public static String getOrderNumber(String userId, int orderIndex) throws Exception {
		StringBuilder sb = new StringBuilder();
		
		sb.append(getStringOrderNoForOrder());
		sb.append(userId);
		if(orderIndex < 10){
			sb.append("0");
			sb.append(orderIndex);
		}else{
			sb.append(orderIndex);
		}
		return sb.toString();
	}
	
	public static String getExternalOrderNumber(String userId, String serverNo) throws Exception {
		StringBuilder sb = new StringBuilder();
		
		sb.append(serverNo);
		sb.append(getStringOrderNoForOrder());
		sb.append(userId);
		return sb.toString();
	}

	public static void main(String[] args) {
		try {
			Thread t1 = new Thread(new Runnable() {
				int i = 0;
				@Override
				public void run() {
					while(i<10){
						System.out.println("t1------->>>:"+i);
						System.out.println("t1------->>>:"+getStringOrderNoForOrder());
						i++;
					}
					
				}
			});
	//		
	//		Thread t2 = new Thread(new Runnable() {
	//			int j = 0;
	//			@Override
	//			public void run() {
	//				while(j<1000){
	//					System.out.println("t2------->>>:"+j);
	//					System.out.println("t2------->>>:"+getOrderNumber("111"));
	//					j++;
	//				}
	//				
	//			}
	//		});
			t1.start();
	//		t2.start();
		
			System.out.println(getOrderNumber("123", 10));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
