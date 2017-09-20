package com.essential.user.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.common.constants.SUConstants;
import com.essential.common.utils.StringCommonUtils;
import com.essential.user.model.auto.PushMsgUserAuto;
import com.essential.user.model.vo.PlatformPushMsgRequestVo;
import com.essential.user.model.vo.UserPushMsgRequestVo;
import com.essential.user.service.IPushMsgService;
import com.essential.utils.CommonResponseUtils;

/**
 * 退送消息
 * @author Jaelyn
 *
 */
@Controller
@RequestMapping(value="pushMsg")
public class PushMsgController {
	
	@Autowired
	@Qualifier("pushMsgServiceImpl")
	private IPushMsgService pushMsgServiceImpl;
	/**
	 * 保存退送信息
	 * 
	 * @param pushMsgAuto
	 * @return
	 */
	@RequestMapping(value="savePushMsg")
	@ResponseBody
	public Map<String, Object> savePushMsg(PlatformPushMsgRequestVo pushMsgAuto) {
		
		try {
			Integer strategy=pushMsgAuto.getPushStrategy();
			String msgContent=pushMsgAuto.getMsgContent();
			if(strategy==null||strategy<0){
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			if(StringCommonUtils.isEmpty(msgContent)){
				return CommonResponseUtils.failureResponse("推送标题不能为空");
			}
			String createUserName=pushMsgAuto.getAttr1();
			if(StringCommonUtils.isEmpty(createUserName)){
				pushMsgAuto.setAttr1("系统通知");
			}
			return pushMsgServiceImpl.saveUserPushMsg(pushMsgAuto);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("保存失败");
		}
	}
	
	/**
	 * 查询平台发送记录
	 * @param pushMsgAuto
	 * @return
	 */
	@RequestMapping(value="queryPlatformPushMsg")
	@ResponseBody
	public Map<String, Object> queryPlatformPushMsg(PlatformPushMsgRequestVo pushMsgAuto) {
		
		try {
			Integer pageIndex=pushMsgAuto.getPageIndex();
			if(pageIndex==null){
				return CommonResponseUtils.failureResponse("页码不能为空");
			}
			Integer pushStrategy=pushMsgAuto.getPushStrategy();
			if(pushStrategy!=null&&pushStrategy.equals(SUConstants.PushStrategy_Personal)){
				return CommonResponseUtils.failureResponse("不支持查询推送个人记录");
			}
			return pushMsgServiceImpl.queryPlatformPushMsg(pushMsgAuto);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("查询失败");
		}
	}
	
	/**
	 * 查询用户退送消息记录
	 * @param pushMsgAuto
	 * @return
	 */
	@RequestMapping(value="queryUserPushMsg")
	@ResponseBody
	public Map<String, Object> queryUserPushMsg(UserPushMsgRequestVo pushMsgAuto) {
		try {
			return pushMsgServiceImpl.queryUserPushMsg(pushMsgAuto);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("保存失败");
		}
	}
	
	/**
	 * 用户设置已读  (合并删除接口  前台设置)
	 * @param pushMsgAuto
	 * @return
	 */
	@RequestMapping(value="updateUserPushMsg")
	@ResponseBody
	public Map<String, Object> updateUserPushMsg(PushMsgUserAuto pushMsgAuto) {
		
		try {
			return pushMsgServiceImpl.updateUserPushMsg(pushMsgAuto);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("保存失败");
		}
	}
	
	/**
	 * 用户删除系统消息
	 * @param pushMsgAuto
	 * @return
	 */
	@RequestMapping(value="deleteUserPushMsg")
	@ResponseBody
	public Map<String, Object> deleteUserPushMsg(PushMsgUserAuto pushMsgAuto) {
		
		try {
			pushMsgAuto.setIsDelete(SUConstants.IS_DELETE);
			return pushMsgServiceImpl.updateUserPushMsg(pushMsgAuto);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("删除失败");
		}
	}
	
	
}
