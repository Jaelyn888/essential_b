package com.essential.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sun.misc.BASE64Encoder;

/**
 * 字符串处理 StringUtils <BR>
 * TODO <BR>
 * 创建人:lijie <BR>
 * 时间:2015年2月4日 下午2:27:42 <BR>
 * 
 * @version 1.0.0
 */
public class StringCommonUtils {

	/**
	 * 将一个日期转换成String 方法名：getDateString<BR>
	 * 创建人:lijie <BR>
	 * 时间:2015年2月4日 下午2:27:42 <BR>
	 * 
	 * @param date
	 * @param pattern
	 * @return String<BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	public static String formatDateToString(Date date, String pattern) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(date);
	}

	/**
	 * 将日期字符串转换成Date 方法名：getDateString<BR>
	 * 创建人:lijie <BR>
	 * 时间:2015年2月4日 下午2:27:42 <BR>
	 * 
	 * @param dateString
	 * @param pattern
	 * @return
	 * @throws ParseException
	 *             Date<BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	public static Date parseStringToDate(String dateString, String pattern) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.parse(dateString);
	}

	/**
	 * 
	 * 将小数格式化成字符串，会进行四舍五入 如：3656.4554===结果:3656.46<BR>
	 * 方法名：formatDoubleToString<BR>
	 * 创建人:lijie <BR>
	 * 时间:2015年2月4日 下午2:27:42 <BR>
	 * 
	 * @param dou
	 * @return String<BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	/*
	 * public static String formatDoubleToString(double dou,String format) {
	 * if(isEmpty(format))format = "#.##"; DecimalFormat decimalFormat = new
	 * DecimalFormat(format); String string = decimalFormat.format(dou);//
	 * 四舍五入，逢五进一 return string; }
	 */

	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 * @return
	 */
	/*
	 * public static boolean isEmpty(String str) { return null == str ||
	 * str.length() == 0 || "".equals(str) || str.matches("\\s*"); }
	 */

	/**
	 * 非空判断 (这里用一句话描述这个方法的作用)<BR>
	 * 方法名：isNotEmpty<BR>
	 * 创建人:lijie <BR>
	 * 时间:2015年2月4日 下午2:27:42 <BR>
	 * 
	 * @param str
	 * @return boolean<BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	/*
	 * public static boolean isNotEmpty(String str) { return !isEmpty(str); }
	 */

	/**
	 * 百分比转换 方法名：getPercent<BR>
	 * 创建人：xuchengfei <BR>
	 * 时间：2014年8月12日-下午9:50:46 <BR>
	 * 
	 * @param num
	 * @param totalCount
	 * @param format
	 * @return String<BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	/*
	 * public static String getPercent(int num,double
	 * totalCount,String...objects){ String format = "#.##"; if(objects!=null &&
	 * objects.length>0){ format = objects[0]; } return
	 * StringUtils.formatDoubleToString((num/totalCount)*100,format)+"%"; }
	 */

	/**
	 * 百分比转换 方法名：getPercent<BR>
	 * 创建人:lijie <BR>
	 * 时间:2015年2月4日 下午2:27:42 <BR>
	 * 
	 * @param num
	 *            当前的数字
	 * @param totalCount
	 *            总数
	 * @param format
	 * @return String<BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	/*
	 * public static String getPercent(int num,float
	 * totalCount,String...objects){//动态参数 String format = "#.##";
	 * if(objects!=null && objects.length>0){ format = objects[0]; } return
	 * StringUtils.formatDoubleToString((num/totalCount)*100,format)+"%"; }
	 */

	/**
	 * 冒泡排序方法,如果为true那就是降序，false那么久是升序 方法名：sorts<BR>
	 * 创建人:lijie <BR>
	 * 时间:2015年2月4日 下午2:27:42 <BR>
	 * 
	 * @param datas
	 * @param flag
	 * @return int[]<BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	public static int[] sorts(int[] datas, boolean flag) {
		for (int i = 0; i < datas.length; i++) {// 轮询次数
			for (int j = 0; j < datas.length - 1; j++) {// 交换次数
				if (flag) {
					if (datas[j] < datas[j + 1]) {
						int temp = datas[j];
						datas[j] = datas[j + 1];
						datas[j + 1] = temp;
					}
				} else {
					if (datas[j] < datas[j + 1]) {
						int temp = datas[j];
						datas[j] = datas[j + 1];
						datas[j + 1] = temp;
					}
				}
			}
		}
		return datas;
	}

	/**
	 * 凯德加密 方法名：encryption<BR>
	 * 创建人:lijie <BR>
	 * 时间:2015年2月4日 下午2:27:42 <BR>
	 * 
	 * @param str
	 * @param k
	 * @return String<BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	public static String encryption(String str, int k) {
		String string = "";
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= 'a' && c <= 'z') {
				c += k % 26;
				if (c < 'a') {
					c += 26;
				}
				if (c > 'z') {
					c -= 26;
				}
			} else if (c >= 'A' && c <= 'Z') {
				c += k % 26;
				if (c < 'A') {
					c += 26;
				}
				if (c > 'Z') {
					c -= 26;
				}
			}
			string += c;
		}
		return string;
	}

	/**
	 * 凯德解密 方法名：dencryption<BR>
	 * 创建人:lijie <BR>
	 * 时间:2015年2月4日 下午2:27:42 <BR>
	 * 
	 * @param str
	 * @param n
	 * @return String<BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	public static String dencryption(String str, int n) {
		String string = "";
		int k = Integer.parseInt("-" + n);
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= 'a' && c <= 'z') {
				c += k % 26;
				if (c < 'a') {
					c += 26;
				}
				if (c > 'z') {
					c -= 26;
				}
			} else if (c >= 'A' && c <= 'Z') {
				c += k % 26;
				if (c < 'A') {
					c += 26;
				}
				if (c > 'Z') {
					c -= 26;
				}
			}
			string += c;
		}
		return string;
	}

	/**
	 * 文件后缀处理
	 * 
	 * @param oldExt
	 * @return
	 */
	public static String ext(String oldExt) {
		String result = oldExt;
		if (!oldExt.equals("") && oldExt != null) {
			if (oldExt.toLowerCase().equals("xlsx") || oldExt.toLowerCase().equals("xlsx"))
				result = "xls";
			if (oldExt.toLowerCase().equals("docx") || oldExt.toLowerCase().equals("doc"))
				result = "word";
		}
		return result;
	}

	public static boolean isImage(String ext) {
		return ext.toLowerCase().matches("jpg|gif|bmp|png|jpeg");
	}

	public static boolean isDoc(String ext) {
		return ext.toLowerCase().matches("doc|docx|xls|xlsx|pdf|txt|ppt|pptx|rar|zip|html|jsp|sql|htm|shtml|xml");
	}

	public static boolean isVideo(String ext) {
		return ext.toLowerCase().matches("mp4|flv|mp3|rmbv|avi");
	}

	public static String base64Encode(byte[] b) {
		if (b == null) {
			return null;
		}
		return new BASE64Encoder().encode(b);
	}

	/**
	 * md5加密 方法名：md5Base64<BR>
	 * 创建人:lijie <BR>
	 * 时间:2015年2月4日 下午2:27:42 <BR>
	 * 
	 * @param str
	 * @return String<BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	public static String md5Base64(String str) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			return base64Encode(md5.digest(str.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * public static String saltPassword(String slatString,String password){
	 * return md5Base64(slatString+password); }
	 */

	/**
	 * @Description: 返回当前时间
	 * @author: xush
	 * @param: @return
	 * @return: String
	 * @throws
	 */
	public static String nowDateStr() {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateNowStr = sdf.format(now);
		return dateNowStr;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		for (int i = 1; i <= 1000; i++) {
			System.out.println("=====" + i);
		}
		long end = System.currentTimeMillis();
		System.out.println("一共耗费:" + (end - start) + "毫秒");
	}

	public static String getRandomString() { // length表示生成字符串的长度
		String base = "abcdefghijklmnopqrstuvwxyz";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 6; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	/**
	 * 转换字节数组为16进制字串
	 * 
	 * @param b
	 *            字节数组
	 * @return 16进制字串
	 */
	public static String byteArrayToHexString(byte[] b) {
		StringBuilder resultSb = new StringBuilder();
		for (byte aB : b) {
			resultSb.append(byteToHexString(aB));
		}
		return resultSb.toString();
	}

	/**
	 * 转换byte到16进制
	 * 
	 * @param b
	 *            要转换的byte
	 * @return 16进制格式
	 */
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0) {
			n = 256 + n;
		}
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	/**
	 * MD5编码
	 * 
	 * @param origin
	 *            原始字符串
	 * @return 经过MD5加密之后的结果
	 */
	public static String MD5Encode(String origin) {
		String resultString = null;
		try {
			resultString = origin;
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(resultString.getBytes("UTF-8"));
			resultString = byteArrayToHexString(md.digest());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultString;
	}

	/**
	 * 对昵称 手机号中间隐藏
	 * 
	 * @param phone
	 * @return
	 */
	public static String encodeNickName(String phone) {

		return phone;
	}

	/**
	 * 判空或者空格
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return isEmpty(str,true);
	}
	public static boolean isEmpty(String str,boolean trim) {
		String temp = str;
		if(trim){
			return str == null || "".equals(temp.trim());
		}else{
			return str == null || "".equals(temp);
		}
		
		
	}
	/**
	 * 判断是否为无效的id 参数需是对象类型数据 对象空，或者值小于1无效
	 * 
	 * @param articleGroupId
	 * @return
	 */
	public static boolean isInvalidateId(Long id) {
		if (id == null || id < 1) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 验证手机号
	 * @param phone
	 * @return
	 */
	public static boolean isPhone(String phone){
		String temp = phone;
		if(phone!=null&&temp.trim().length()==11){
			return true;
		}else{
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-2,5-9])|(17[0-9]))\\d{8}$");

		return p.matcher(phone).matches();
		}
	}
	//判断email格式是否正确
	public static boolean isEmail(String email) {
		if (isEmpty(email)) {
			return false;
		}
		String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		Pattern p = Pattern.compile(str);
		return p.matcher(email).matches();
	}
	//判断是否全是数字
	public static boolean isNumer(String number) {
		if (isEmpty(number)) {
			return false;
		}
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(number);
		return isNum.matches();
	}
	/**判断字符类型是否是号码或字母
	 * @param str
	 * @return
	 */
	public static boolean isNumberOrAlpha(String str) {
		if (isEmpty(str,false)) {
			return false;
		}
		Pattern p = Pattern.compile("^[A-Za-z0-9]+$");
		Matcher m = p.matcher(str);
		return m.matches();
	}
}
