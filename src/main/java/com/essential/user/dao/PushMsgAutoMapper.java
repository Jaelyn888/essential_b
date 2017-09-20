package com.essential.user.dao;

import java.util.List;

import com.essential.user.model.auto.PushMsgAuto;
import com.essential.user.model.vo.PlatformPushMsgRequestVo;
import com.essential.user.model.vo.PushMsgVo;


public interface PushMsgAutoMapper {
    int deleteByPrimaryKey(Long msgId);

    int insert(PushMsgAuto record);

    int insertSelective(PushMsgAuto record);

    PushMsgAuto selectByPrimaryKey(Long msgId);

    int updateByPrimaryKeySelective(PushMsgAuto record);

    int updateByPrimaryKey(PushMsgAuto record);

    /**
     * 查询平台退送记录
     * @param pushMsgAuto
     * @return
     */
	List<PushMsgAuto> queryPlatformPushMsg(PushMsgAuto pushMsgAuto);
	  /**
     * 查询平台退送记录
     * @param pushMsgAuto
     * @return
     */
	List<PushMsgVo> queryUserPushMsg(PushMsgAuto pushMsgAuto);

	/**
	 *  查询数量
	 * @param pushMsgAuto
	 * @return
	 */
	long queryTotlePushNumber(PlatformPushMsgRequestVo pushMsgAuto);
}