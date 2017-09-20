package com.essential.utils;

import java.util.HashMap;

import com.essential.common.constants.SUConstants;
import com.essential.common.utils.StringCommonUtils;
import com.essential.common.utils.TmDateUtil;
import com.google.gson.Gson;

/**
 * @author Jaelyn 返回手机端数据
 */
public class CommonResponseUtils {

	/**
	 * 成功请求
	 * 
	 * @param object
	 *            返回的数据
	 * @param msg
	 *            提示信息， 默认OK
	 * @return
	 */
	public static HashMap<String, Object> successResponse() {
		return successResponse(null, null);

	}

	public static HashMap<String, Object> successResponse(Object object) {
		return successResponse(null, object);

	}

	public static HashMap<String, Object> successResponse(String msg) {
		return successResponse(msg, null);
	}

	public static HashMap<String, Object> successResponse(String msg, Object object) {
		if (msg == null || msg.length() == 0) {
			msg = SUConstants.MSG_SUCCESS_VALUE;
		}
		return commonResponse(SUConstants.CODE_SUCCESS_VALUE, msg, object);

	}

	/**
	 * 请求异常
	 * 
	 * @param object
	 *            返回的数据
	 * @param msg
	 *            提示信息， 默认error
	 * @return
	 */
	public static HashMap<String, Object> failureResponse() {
		return failureResponse(null, null);
	}

	public static HashMap<String, Object> failureResponse(Object object) {
		return failureResponse(null, object);
	}

	public static HashMap<String, Object> failureResponse(String msg) {
		return failureResponse(msg, null);
	}

	public static HashMap<String, Object> failureResponse(String msg, Object object) {
		if (StringCommonUtils.isEmpty(msg)) {
			msg = SUConstants.SERVER_ERROR;
		}
		return commonResponse(SUConstants.CODE_FAIL_VALUE, msg, object);
	}

	/**
	 * 失败请求反参
	 * 
	 * @param resCode
	 * @param message
	 * @param object
	 * @return
	 */
	public static HashMap<String, Object> commonResponse(String resCode, String msg, Object object) {
		HashMap<String, Object> resMap = new HashMap<String, Object>();
		resMap.put(SUConstants.CODE_KEY, resCode);
		resMap.put(SUConstants.MSG_KEY, msg);
		resMap.put(SUConstants.INFO_KEY, object);
		LogUtils.info("response time+++++++++++++++", TmDateUtil.getTimeStamp());
		return resMap;
	}

	public static void main(String[] args) {
		//test  null 
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("k1", "111");
		map.put("key2", "null");
		map.put("key3", null);
		System.out.println(new Gson().toJson(map));
	}

}
