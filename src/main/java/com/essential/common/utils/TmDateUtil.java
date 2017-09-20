package com.essential.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.essential.common.constants.SUConstants;

/**
 * 格式化日期
 * TmDateUtil <BR>
 * 创建人:lijie <BR>
 * 时间:2015年2月4日 下午2:24:49 <BR>
 * @version 1.0.0
 */
public class TmDateUtil {

	private static Logger logger = LoggerFactory.getLogger(TmDateUtil.class);
	
	/**
	 * 日期转换
	 * 方法名：dateToString<BR>
	 * 创建人:lijie <BR>
     * 时间:2015年2月4日 下午2:24:49 <BR>
	 * @param time
	 * @return Date<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public static Date stringToDate(String time){
		Date startTime = null;
		try {
			 startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
		} catch (ParseException e) {
			logger.info("=========>>>>>>日期"+time+"转换异常");
			e.printStackTrace();
		}
		return startTime;
	}
	
	
	/**
	 * 
	 * 方法名：getTimeFormat<BR>
	 * 创建人:lijie <BR>
     * 时间:2015年2月4日 下午2:24:49 <BR>
	 * @param startTime
	 * @return String<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public static String getTimeFormat(String startTime){
		return getTimeFormat(stringToDate(startTime));
	}
	
	/**
	 * 获取日期几分钟前，几年前
	 * 方法名：getTimeFormat<BR>
	 * 创建人:lijie <BR>
     * 时间:2015年2月4日 下午2:24:49 <BR>
	 * @param startTime
	 * @return String<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public static String getTimeFormat(Date startTime){
		try{
			long startTimeMills = startTime.getTime();
			long endTimeMills = System.currentTimeMillis();
			long diff = (endTimeMills - startTimeMills)/1000;//秒
			long day_diff  = (long) Math.floor(diff/86400);//天
			StringBuffer buffer = new StringBuffer();
			if(day_diff<0){
				return "[error],时间越界...";
			}else{
				if(day_diff==0 && diff<60){
					if(diff==0)diff=1;
					buffer.append(diff+"秒前");
				}else if(day_diff==0 && diff<120){
					buffer.append("1 分钟前");
				}else if(day_diff==0 && diff<3600){
					buffer.append(Math.round(Math.floor(diff/60))+"分钟以前");
				}else if(day_diff==0 && diff<7200){
					buffer.append("1小时前");
				}else if(day_diff==0 && diff<86400){
					buffer.append(Math.round(Math.floor(diff/3600))+"小时前");
				}else if(day_diff==1){
					buffer.append("1天前");
				}else if(day_diff<7){
					buffer.append(day_diff+"天前");
				}else if(day_diff <30){
					buffer.append(Math.round(Math.ceil( day_diff / 7 )) + " 星期前");
				}else if(day_diff >=30 && day_diff<=179 ){
					buffer.append(Math.round(Math.ceil( day_diff / 30 )) + "月前");
				}else if(day_diff >=180 && day_diff<365){
					buffer.append("半年前");
				}else if(day_diff>=365){
					buffer.append(Math.round(Math.ceil( day_diff /30/12))+"年前");
				}
			}
			return buffer.toString();
		}catch(Exception ex){
			return "";
		}
	}
	
	
	
	/** 
	   * 将java.util.Date 格式转换为字符串格式'yyyy-MM-dd HH:mm:ss'(24小时制)<br> 
	   * 如Sat May 11 17:24:21 CST 2002 to '2002-05-11 17:24:21'<br> 
	   * @param time Date 日期<br> 
	   * @return String   字符串<br> 
	   */ 
	public static String dateToString(Date time){
		SimpleDateFormat formatter;
		String ctime = null;
		try {
			formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss"); 
		    ctime = formatter.format(time); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    

		return ctime;
	} 
	
	
	/** 
	   *取系统当前时间:返回只值为如下形式 
	   *2002-10-30 20:24:39 
	   * @return String 
	   */ 
	public static String Now(){ 
	    return dateToString(new Date()); 
	} 


	/** 
	   *取系统当前时间:返回值为如下形式 
	   *2002-10-30 
	   *@return String 
	   */ 
	public static String getYYYY_MM_DD(){ 
	    return dateToString(new Date()).substring(0,10); 

	} 


	/** 
	   *取系统给定时间:返回值为如下形式 
	   *2002-10-30 
	   *@return String 
	   */ 
	   public static String getYYYY_MM_DD(String date){ 
	    return date.substring(0,10); 

	} 

	/**
	 * 获取当前时间的小时
	 * @return
	 */
	public static String getHour(){ 
	    SimpleDateFormat formatter;
	    String ctime = null;
	    try {
	    	formatter = new SimpleDateFormat ("H"); 
	    	ctime = formatter.format(new Date()); 
		} catch (Exception e) {
			logger.info("=========>>>>>>日期格式化异常");
			e.printStackTrace();
		}
	    return ctime; 
    } 

	/**
	 * 获取当前时间的日期
	 * @return
	 */
	public static String getDay(){ 
	      SimpleDateFormat formatter;
	      String ctime = null;
	      try {
	    	  formatter = new SimpleDateFormat ("d"); 
	    	  ctime = formatter.format(new Date()); 
		} catch (Exception e) {
			logger.info("=========>>>>>>日期格式化异常");
			e.printStackTrace();
		}
	      return ctime; 
    } 

	/**
	 * 获取当前时间的月份
	 * @return
	 */
	public static String getMonth(){ 
	    SimpleDateFormat formatter;
	    String ctime = null;
	    try {
	    	formatter = new SimpleDateFormat ("M"); 
		    ctime = formatter.format(new Date()); 
		} catch (Exception e) {
			logger.info("=========>>>>>>日期格式化异常");
			e.printStackTrace();
		}
	    
	    return ctime; 
    } 

	/**
	 * 获取当前时间的年份
	 * @return
	 */
	public static String getYear(){ 
	    SimpleDateFormat formatter; 
	    String ctime = null;
	    try {
	    	formatter = new SimpleDateFormat ("yyyy"); 
		    ctime = formatter.format(new Date()); 
		} catch (Exception e) {
			logger.info("=========>>>>>>日期格式化异常");
			e.printStackTrace();
		}
	    
	    return ctime; 
    } 
	  
	/**
	 * 获取当前时间的周
	 * @return
	 */
	public static String getWeek(){ 
	    SimpleDateFormat formatter;
	    String ctime = null;
	    try {
	    	formatter = new SimpleDateFormat ("E"); 
		    ctime = formatter.format(new Date()); 
		} catch (Exception e) {
			logger.info("=========>>>>>>日期格式化异常");
			e.printStackTrace();
		}
	    
	    return ctime; 
    } 
	
	
	/**
	 * 转换日期格式
	 * @param formatStr格式化格式
	 * @return
	 */
	public static String dateToString(String formatStr,Date date){
		String datestr = null;
		
		try {
			SimpleDateFormat sdf=new SimpleDateFormat(formatStr); 
			datestr=sdf.format(date); 
		} catch (Exception e) {
			logger.info("=========>>>>>>日期格式化异常");
			e.printStackTrace();
		}
		
		return datestr;
	}
	
	/**
	 * 转换日期格式
	 * @param formatStr格式化格式
	 * @return
	 */
	public static Date stringToDate(String formatStr,String time){
		Date date = null;
		try {
			date = new SimpleDateFormat(formatStr).parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	* 返回当前日期的前一个时间日期，amount为正数 当前时间后的时间 为负数 当前时间前的时间
	* 默认日期格式yyyy-MM-dd
	* @param field 日历字段
	* y 年 M 月 d 日 H 时 m 分 s 秒
	* @param amount 数量
	* @return 一个日期
	*/
	public static Date getPreDate(String field,int amount){
		Calendar calendar = Calendar.getInstance(Locale.CHINA);
		calendar.setTime(new Date());
		if(field!=null&&!field.equals("")){
			if(field.equals("y")){
				calendar.add(Calendar.YEAR, amount);
			}else if(field.equals("M")){
				calendar.add(Calendar.MONTH, amount);
			}else if(field.equals("d")){
				calendar.add(Calendar.DAY_OF_MONTH, amount);
			}else if(field.equals("H")){
				calendar.add(Calendar.HOUR, amount);
			}
		}else{
			return null;
		}
		return calendar.getTime();
	}
	
	/**
	* 某一个日期的前一个日期
	* @param d,某一个日期
	* @param field 日历字段
	* y 年 M 月 d 日 H 时 m 分 s 秒
	* @param amount 数量
	* @return 一个日期
	*/
	public static Date getPreDate(Date d,String field,int amount){
		Calendar calendar = Calendar.getInstance(Locale.CHINA);
		calendar.setTime(d);
		if(field!=null&&!field.equals("")){
			if(field.equals("y")){
				calendar.add(Calendar.YEAR, amount);
			}else if(field.equals("M")){
				calendar.add(Calendar.MONTH, amount);
			}else if(field.equals("d")){
				calendar.add(Calendar.DAY_OF_MONTH, amount);
			}else if(field.equals("H")){
				calendar.add(Calendar.HOUR, amount);
			}
		}else{
			return null;
		}
		return calendar.getTime();
	}
	
	/**
	 * 通过格林威治获取当前时间
	 * @param formatStr 日期格式化格式("yyyy-MM-dd HH:mm:ss.SSS")HH:24小时制 hh:12小时制
	 * @return
	 */
	public static String getCalendarDate(String formatStr){
		 String dateString = null;
		 try {
			 Calendar calendar = Calendar.getInstance(Locale.CHINA);
		     Date date = calendar.getTime();
		     SimpleDateFormat dateFormat = new SimpleDateFormat(formatStr);
		     dateString = dateFormat.format(date);
		 } catch (Exception e) {
			 logger.info("=========>>>>>>日期格式化异常");
			 e.printStackTrace();
		 }
		
	     return dateString;
	}
	
	/**
	 * 
	 * 获取当前时间戳(改为YYYY-MM-dd HH:MI:SS.SSS时间格式)
	 * @return
	 */
	public static String getTimeStamp(){
		return getCalendarDate(SUConstants.TIMESTAMP_FOMART);
	}
	public static void main(String[] args) {
		Date date = stringToDate("yyyy-MM-dd HH:mm:ss.SSS","2016-07-08 13:13:13.778");
		Date date1 = stringToDate("yyyy-MM-dd HH:mm:ss.SSS","2016-07-08 13:13:13.777");
		System.out.println(date);
		System.out.println(date1);
		System.out.println(getPreDate("H",-72));
	}
	
}
