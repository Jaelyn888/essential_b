package com.essential.common.utils;


import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

public class JSONUtils {
	/**
	 * 将对象转换为json字符串
	 * 
	 * @param obj
	 * @return
	 */
	public static String objectToString(Object obj) {
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		JSONObject json = JSONObject.fromObject(obj, jsonConfig);
		return json.toString();
	}

	/**
	 * 将数组转换为json字符串
	 * 
	 * @param obj
	 * @return
	 */
	public static String arrayToString(Object obj) {
		JSONArray jsonArray = JSONArray.fromObject(obj);
		return jsonArray.toString();
	}
	
	/**
	 * @Description: json生成list
	 * @author: xush
	 * @param: @param String 列如{"id":1,"name":"企业号","parentid":0},{"id":2,"name":"上海技术三中心","parentid":1}
	 * @param: @return
	 * @return: List<String> 
	 * @throws
	 */ 
	public static List<String> jsonToList(String String){
		List<String> strList = new ArrayList<String>();
		String departmentArray[] = String.split("},");
		for(String stemp:departmentArray){			
			if (!stemp.endsWith("}")) {
			stemp = stemp + "}";
			}
			strList.add(stemp);
		}
		return strList;
	}
	
	/**
	 * @Description: 判断json中是否包含字段
	 * @author: xush
	 * @param: @param jsonObject
	 * @param: @param Field
	 * @param: @return
	 * @return: boolean
	 * @throws
	 */ 
	public static boolean jsonIsContainField(JSONObject jsonObject,String Field){
		return jsonObject.toString().contains(Field);
	}
}
