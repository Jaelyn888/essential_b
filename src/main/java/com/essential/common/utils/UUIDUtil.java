package com.essential.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
/**
 * UUIDUtil <BR>
 * TODO <BR>
 * 创建人:lijie <BR>
 * 时间:2015年2月4日 下午2:18:30 <BR>
 * @version 1.0.0
 */
public class UUIDUtil {
	/**
	 * 根据日期和UUID生成主键
	 * TODO <BR>
	 * getUUID
	 * @return date+uuid
	 * 创建人:lijie <BR>
	 * 时间:2015年2月4日 下午2:32:31 <BR>
	 */
	public static String getUUID() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String date =  dateFormat.format(new Date());
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase().substring(0, 9);
        return date + uuid; 
	}
	
	/**
	 * 测试方法
	 * TODO <BR>
	 * main
	 * @param args
	 * 创建人:lijie <BR>
	 * 时间:2015年2月4日 下午2:34:14 <BR>
	 */
	public static void main(String args[]) {
		String str = getUUID();
		System.out.println(str);
	}
}
