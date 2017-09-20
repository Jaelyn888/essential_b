package com.essential.user.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.user.model.auto.PushMsgAuto;
import com.essential.user.model.auto.PushMsgUserAuto;
import com.essential.user.model.vo.PlatformPushMsgRequestVo;
import com.essential.user.model.vo.UserPushMsgRequestVo;

/**
 * 退送消息表
 * @author Jaelyn
 *
 */
@Service
public interface IPushMsgService {

	/**
	 * 保存退送信息
	 * @param pushMsgAuto
	 * @return
	 */
	public Map<String,Object> saveUserPushMsg(PlatformPushMsgRequestVo pushMsgAuto);

	public Map<String, Object> queryPlatformPushMsg(PlatformPushMsgRequestVo pushMsgAuto);

	/**
	 * 查询用户消息记录
	 * 
	 * @param pushMsgAuto
	 * @return
	 */
	public Map<String, Object> queryUserPushMsg(UserPushMsgRequestVo pushMsgAuto);

	public Map<String, Object> updateUserPushMsg(PushMsgUserAuto pushMsgAuto);

}
