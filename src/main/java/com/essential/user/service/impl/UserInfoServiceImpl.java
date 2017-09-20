package com.essential.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.omg.CORBA.UShortSeqHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.essential.bussiness.sms.model.auto.SmsAuto;
import com.essential.bussiness.sms.service.ISmsService;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.EncryptPassWord;
import com.essential.common.utils.MyException;
import com.essential.common.utils.StringCommonUtils;
import com.essential.common.utils.TmDateUtil;
import com.essential.user.dao.PushMsgUserAutoMapper;
import com.essential.user.dao.UserBaseInfoAutoMapper;
import com.essential.user.model.auto.PushMsgUserAuto;
import com.essential.user.model.auto.UserBaseInfoAuto;
import com.essential.user.model.vo.RegisterVo;
import com.essential.user.model.vo.UserBaseInfoVo;
import com.essential.user.model.vo.UserInfoRequestVo;
import com.essential.user.model.vo.UserInfoVo;
import com.essential.user.service.IUserInfoService;
import com.essential.utils.CommonResponseUtils;
import com.essential.utils.DTOUtils;
import com.essential.utils.LogUtils;
import com.essential.utils.OrderUtils;

/**
 * @author Jaelyn
 *
 *         用户基本信息
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService {

	private String TAG = IUserInfoService.class.getSimpleName();
	/**
	 * 用户基本信息表dao
	 */
	@Autowired
	private UserBaseInfoAutoMapper userBaseInfoMapper;

	@Autowired
	private ISmsService smsServiceImpl;

	@Autowired
	private PushMsgUserAutoMapper pushMsgUserAutoMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.essential.user.service.impl.IUserInfoService#queryById(java.lang.
	 * Long)
	 */
	@Override
	public Map<String, Object> queryById(Long userId) {
		try {
			UserBaseInfoVo userBaseInfo = userBaseInfoMapper.selectBaseInfoVoByPrimaryKey(userId);
			if (userBaseInfo != null) {
				return CommonResponseUtils.successResponse(userBaseInfo);
			} else {
				return CommonResponseUtils.failureResponse("用户不存在");
			}

		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("用户不存在");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.essential.user.service.impl.IUserInfoService#checkLogin(java.util
	 * .Map)
	 */
	@Override
	public Map<String, Object> checkLogin(UserInfoRequestVo userBaseInfo) {

		try {
			// 查询
			userBaseInfo.setIsDelete(SUConstants.IS_NOT_DELETE);
			userBaseInfo.setUserTypeId(SUConstants.USERTYPE_APP);
			List<UserInfoVo> userBaseInfoList = queryUserInfoByParams(userBaseInfo);
			if (userBaseInfoList.size() > 0) {
				UserInfoVo userBaseInfoTmp = userBaseInfoList.get(0);
				PushMsgUserAuto record = new PushMsgUserAuto();
				record.setUserId(userBaseInfoTmp.getUserId());
				record.setIsDelete(SUConstants.IS_NOT_DELETE);
				record.setIsRead(SUConstants.ReadStatus_NOT_READ);
				int unReadCount = pushMsgUserAutoMapper.queryUnReadCountByUserId(record);
				userBaseInfoTmp.setUnReadCount(unReadCount);
				// 更新登录记录
				return CommonResponseUtils.successResponse("登录成功", userBaseInfoTmp);
			} else {
				return CommonResponseUtils.failureResponse("用户名或密码不正确");
			}

		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("用户名或密码不正确");
		}
	}

	/**
	 * 登陆会用到，修改请谨慎
	 */
	public List<UserInfoVo> queryUserInfoByParams(UserInfoRequestVo userBaseInfo) {
		List<UserInfoVo> userBaseInfoList = userBaseInfoMapper.queryUserInfoByParams(userBaseInfo);
		return userBaseInfoList;
	}

	/**
	 * 根据用户id 查询用户基本信息
	 * 
	 * @param userId
	 * @return
	 */
	public UserBaseInfoVo queryUserInfoVoByUserId(Long userId) {
		try {
			UserBaseInfoVo userBaseInfo = userBaseInfoMapper.selectBaseInfoVoByPrimaryKey(userId);
			return userBaseInfo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 修改昵称，性别等
	 */
	@Override
	public Map<String, Object> updateUserBaseInfo(UserInfoRequestVo userBaseInfoAuto) {
		// 判断昵称是否已使用
		Integer requestType = userBaseInfoAuto.getRequestType();
		if (requestType == null) {
			return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
		}
		try {
			userBaseInfoAuto.setModifyTime(TmDateUtil.getTimeStamp());
			int num = 0;
			String msg = "";
			UserInfoRequestVo userBaseInfoAutoTmp = new UserInfoRequestVo();
			userBaseInfoAutoTmp.setIsDelete(SUConstants.IS_NOT_DELETE);
			// 请求类型 0：删除，1：修改昵称，2：修改性别，3：修改出生日期，4：所在地，5：简介,6:头像
			switch (requestType) {
			case 0:
				userBaseInfoAuto.setIsDelete(SUConstants.IS_DELETE);
				num = userBaseInfoMapper.updateByPrimaryKeySelective(userBaseInfoAuto);
				if (num > 0) {
					msg = "删除成功";
				} else {
					msg = "删除失败";
				}
				break;
			case 1:
				String userNickname = userBaseInfoAuto.getUserNickname();
				if (StringCommonUtils.isEmpty(userNickname)) {
					return CommonResponseUtils.failureResponse("昵称不能为空");
				}
				num = userBaseInfoMapper.updateByPrimaryKeySelective(userBaseInfoAuto);
				if (num > 0) {
					msg = "修改成功";
				} else {
					msg = "修改失败";
				}
				break;
			case 2:// 2：修改性别
				Integer userSex = userBaseInfoAuto.getUserSex();
				if (userSex == null || userSex < 0 || userSex > 2) {
					msg = "真个性，性别超出三界了";
					break;
				}
			case 3:// ，3：修改出生日期，
			case 4:// 4：所在地，
			case 5:// 5：简介
			case 6:
				// String userIcon = userBaseInfoAuto.getUserIcon();
				// if (StringCommonUtils.isEmptyOrSpace(userIcon)) {
				// return CommonResponseUtils.failureResponse("头像不能为空");
				// }
				num = userBaseInfoMapper.updateByPrimaryKeySelective(userBaseInfoAuto);
				if (num > 0) {
					msg = "修改成功";
				} else {
					msg = "修改失败";
				}
				break;
			case 7:
			case 8:
				num = userBaseInfoMapper.updateByPrimaryKeySelective(userBaseInfoAuto);
				if (num > 0) {
					msg = "操作成功";
				} else {
					msg = "操作失败";
				}
				break;
			default:
				msg = SUConstants.PARAM_ERRROR;
				break;
			}
			if (num > 0) {
				return CommonResponseUtils.successResponse(msg);
			} else {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return CommonResponseUtils.failureResponse(msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String msg = "修改失败";
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return CommonResponseUtils.failureResponse(msg);
		}

	}

	/**
	 * 第三方登录
	 */
	@Override
	public Map<String, Object> thirdPartyLogin(UserInfoRequestVo userBaseInfo) {
		try {
			// 组装数据 查询历史记录
			String openId = userBaseInfo.getTag();
			Integer platform = userBaseInfo.getPlatform();
			UserInfoRequestVo userTmp = new UserInfoRequestVo();
			userTmp.setTag(openId);
			userTmp.setPlatform(platform);
			userTmp.setUserTypeId(SUConstants.USERTYPE_APP);
			userTmp.setIsDelete(SUConstants.IS_NOT_DELETE);

			List<UserInfoVo> userBaseInfoList = userBaseInfoMapper.queryUserInfoByParams(userTmp);
			UserInfoVo userBaseInfoTmp = new UserInfoVo();
			if (userBaseInfoList.size() > 0) {
				userBaseInfoTmp = userBaseInfoList.get(0);
				PushMsgUserAuto record = new PushMsgUserAuto();
				record.setUserId(userBaseInfoTmp.getUserId());
				record.setIsDelete(SUConstants.IS_NOT_DELETE);
				record.setIsRead(SUConstants.ReadStatus_NOT_READ);
				int unReadCount = pushMsgUserAutoMapper.queryUnReadCountByUserId(record);
				userBaseInfoTmp.setUnReadCount(unReadCount);
				// 更新登录记录
			} else {
				userBaseInfo.setUserTypeId(SUConstants.USERTYPE_APP);
				userBaseInfo.setUserPwd(EncryptPassWord.EncryptStr("123456"));
				userBaseInfo.setIsDelete(SUConstants.IS_NOT_DELETE);
				String uuid = OrderUtils.shortUniqueRepeatNum();
				String userName = "";
				if (platform == SUConstants.PLATFORM_QQ) {
					userName = "qq" + uuid;
				} else if (platform == SUConstants.PLATFORM_WECHAT) {
					userName = "wx" + uuid;
				} else if (platform == SUConstants.PLATFORM_WEIBO) {
					userName = "wb" + uuid;
				}
				userBaseInfo.setUserName(userName);
				UserBaseInfoAuto userBaseInfoAutoTmp = registerAppUser(userBaseInfo);
				Long userId = userBaseInfoAutoTmp.getUserId();
				if (StringCommonUtils.isInvalidateId(userId)) {
					throw new MyException("登录失败");
				} else {
					DTOUtils.map(userBaseInfoAutoTmp, userBaseInfoTmp);
				}

			}
			return CommonResponseUtils.successResponse("登录成功", userBaseInfoTmp);
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return CommonResponseUtils.failureResponse("登录失败");
		}
	}

	/**
	 * zhuce 生成环信等
	 * 
	 * @param userBaseInfo
	 * @return
	 */
	private UserBaseInfoAuto registerAppUser(UserBaseInfoAuto userBaseInfo) {
		try {
			userBaseInfo.setIsDelete(SUConstants.IS_NOT_DELETE);
			userBaseInfo.setStatus(SUConstants.USERTYPE_STATUS_NORMAL);
			userBaseInfo.setUserSex(0);
			userBaseInfo.setCreateTime(TmDateUtil.getTimeStamp());
			int num = userBaseInfoMapper.insert(userBaseInfo);
			// 注册环信
			registerIM(userBaseInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userBaseInfo;
	}

	/**
	 * 注册即时通讯信息
	 * @param userBaseInfoAuto 
	 */
	private void registerIM(UserBaseInfoAuto userBaseInfoAuto) {

	}

	/**
	 * 通过用户名修改密码 支付密码基本信息
	 */
	@Override
	public Map<String, Object> updateInfoByUserName(UserInfoRequestVo userBaseInfo) {
		Integer requestType = userBaseInfo.getRequestType();
		if (requestType == null) {
			return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
		}
		try {
			int num = 0;
			userBaseInfo.setModifyTime(TmDateUtil.getTimeStamp());
			UserInfoRequestVo userBaseInfoAutoTmp = new UserInfoRequestVo();
			// 请求类型 0：修改登录，1：忘记登录密码，2：修改支付密码，3：忘记支付密码、
			String userPwd;
			String newPwd;
			List<UserBaseInfoVo> userBaseInfoVoListTmp;
			switch (requestType) {
			case 0: // 0：修改登录密码
				userPwd = userBaseInfo.getUserPwd();
				newPwd = userBaseInfo.getNewPwd();
				if (StringCommonUtils.isEmpty(userPwd) || StringCommonUtils.isEmpty(newPwd)) {
					return CommonResponseUtils.failureResponse("密码不能为空");
				}
				userPwd = EncryptPassWord.EncryptStr(userPwd);
				newPwd = EncryptPassWord.EncryptStr(newPwd);
				userBaseInfoAutoTmp.setUserName(userBaseInfo.getUserName());
				userBaseInfoAutoTmp.setUserPwd(userPwd);
				userBaseInfoAutoTmp.setUserTypeId(SUConstants.USERTYPE_APP);
				userBaseInfoAutoTmp.setIsDelete(SUConstants.IS_NOT_DELETE);
				userBaseInfoVoListTmp = userBaseInfoMapper.queryBaseInfoVoByParams(userBaseInfoAutoTmp);
				num = userBaseInfoVoListTmp.size();
				if (num > 0) {
					Long userId = userBaseInfoVoListTmp.get(0).getUserId();
					userBaseInfoAutoTmp.setUserId(userId);
					userBaseInfoAutoTmp.setUserPwd(newPwd);
					userBaseInfoAutoTmp.setModifyTime(TmDateUtil.getTimeStamp());
					num = userBaseInfoMapper.updateByPrimaryKeySelective(userBaseInfoAutoTmp);
					if (num > 0) {
						return CommonResponseUtils.successResponse("修改成功");
					} else {
						throw new MyException("修改失败");
					}
				} else {
					return CommonResponseUtils.failureResponse("用户名或密码不正确");
				}

			case 1:
				newPwd = userBaseInfo.getNewPwd();
				if (StringCommonUtils.isEmpty(newPwd)) {
					return CommonResponseUtils.failureResponse("密码不能为空");
				}
				newPwd = EncryptPassWord.EncryptStr(newPwd);
				userBaseInfoAutoTmp.setUserName(userBaseInfo.getUserName());
				userBaseInfoAutoTmp.setUserTypeId(SUConstants.USERTYPE_APP);
				userBaseInfoAutoTmp.setIsDelete(SUConstants.IS_NOT_DELETE);
				userBaseInfoVoListTmp = userBaseInfoMapper.queryBaseInfoVoByParams(userBaseInfoAutoTmp);
				num = userBaseInfoVoListTmp.size();
				if (num > 0) {
					Long userId = userBaseInfoVoListTmp.get(0).getUserId();
					userBaseInfoAutoTmp.setUserId(userId);
					userBaseInfoAutoTmp.setUserPwd(newPwd);
					userBaseInfoAutoTmp.setUserName(null);
					userBaseInfoAutoTmp.setModifyTime(TmDateUtil.getTimeStamp());
					num = userBaseInfoMapper.updateByPrimaryKeySelective(userBaseInfoAutoTmp);
					if (num > 0) {
						return CommonResponseUtils.successResponse("修改成功");
					} else {
						throw new MyException("修改失败");
					}
				} else {
					return CommonResponseUtils.failureResponse("用户名不存在");
				}
			default:
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);

			}
		} catch (Exception e) {
			LogUtils.info(e.toString());
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return CommonResponseUtils.failureResponse(e.getMessage());
		}
	}

	/**
	 * 注册用户
	 */
	@Override
	public Map<String, Object> appRegister(RegisterVo userBaseInfoAuto) {

		try {
			userBaseInfoAuto.setPlatform(SUConstants.PLATFORM_PHONE);
			String userName = userBaseInfoAuto.getUserName();
			userBaseInfoAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			userBaseInfoAuto.setUserTypeId(SUConstants.USERTYPE_APP);
			userBaseInfoAuto.setStatus(SUConstants.USERTYPE_STATUS_NORMAL);
			UserBaseInfoAuto userBaseInfoAutoTmp = new UserBaseInfoAuto();
			userBaseInfoAutoTmp.setUserName(userName);
			userBaseInfoAutoTmp.setIsDelete(SUConstants.IS_NOT_DELETE);
			userBaseInfoAutoTmp.setUserTypeId(SUConstants.USERTYPE_APP);
			SmsAuto smsAuto = new SmsAuto();
			smsAuto.setUserPhone(userName);
			smsAuto.setUserTypeId(SUConstants.USERTYPE_APP);
			smsAuto.setServiceType(0);
			smsAuto.setSmsCode(userBaseInfoAuto.getSmsCode());
			int num = smsServiceImpl.qurySms(smsAuto);
			if (num <= 0) {
				return CommonResponseUtils.failureResponse("验证码验证失败");
			}
			// 查询用户名是否已存在
			num = 0;// userBaseInfoMapper.queryBaseInfoVoByParams(userBaseInfoAutoTmp).size();
			if (num > 0) {
				return CommonResponseUtils.failureResponse("用户名已注册");
			} else {
				// baocun
				userBaseInfoAuto = (RegisterVo) registerAppUser(userBaseInfoAuto);
				if (userBaseInfoAuto != null) {
					UserInfoVo userInfoVo = new UserInfoVo();
					DTOUtils.map(userBaseInfoAuto, userInfoVo);
					registerIM(userBaseInfoAuto);
					return CommonResponseUtils.successResponse("注册成功", userInfoVo);
				} else {
					throw new MyException();
				}
			}
		} catch (Exception e) {
			LogUtils.debug(TAG, "==========>>>>>>>>>>>注册失败 :" + e);
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return CommonResponseUtils.failureResponse("注册失败");

		}

	}

	/**
	 * 环信与用户绑定
	 */
	@Override
	public Map<String, Object> ringSignalAndUser(UserBaseInfoAuto userBaseInfoAuto) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			int i = userBaseInfoMapper.updateByPrimaryKeySelective(userBaseInfoAuto);
			if (i <= 0) {
				throw new Exception("环信与用户绑定失败 ");
			}
			map.putAll(CommonResponseUtils.successResponse("环信与用户绑定成功"));
			return map;
		} catch (Exception e) {
			LogUtils.debug(TAG, "==========>>>>>>>>>>>环信与用户绑定失败 :" + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 平台用户管理
	 */
	@Override
	public Map<String, Object> queryUserList(UserInfoRequestVo userManageRequest) {
		try {
			Integer pageIndex = userManageRequest.getPageIndex();
			Integer pageCount = userManageRequest.getPageSize();
			if (pageIndex == null || pageIndex < 1) {
				pageIndex = 1;
			}
			if (pageCount == null) {
				pageCount = SUConstants.PAGE_COUNT;
				userManageRequest.setPageSize(pageCount);
			}
			pageIndex = (pageIndex - 1) * pageCount;
			userManageRequest.setPageIndex(pageIndex);
			userManageRequest.setUserTypeId(SUConstants.USERTYPE_APP);
			List<UserInfoVo> userInfoList = userBaseInfoMapper.queryUserInfoByLikeParams(userManageRequest);
			int countNum = userBaseInfoMapper.queryCountByParams(userManageRequest);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userList", userInfoList);
			map.put("count", countNum);

			return CommonResponseUtils.successResponse(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new MyException();
		}
	}

}
