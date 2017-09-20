package com.essential.user.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.essential.bussiness.brand.dao.BrandAutoMapper;
import com.essential.bussiness.brand.model.auto.BrandAuto;
import com.essential.bussiness.order.model.vo.OrderProductVo;
import com.essential.bussiness.order.model.vo.ReturnRefundOrderVo;
import com.essential.bussiness.order.service.IQueryOrderService;
import com.essential.bussiness.order.service.IReturnRefundOrderService;
import com.essential.bussiness.product.dao.ProductAutoMapper;
import com.essential.bussiness.product.model.vo.ProductSerchInfoVo;
import com.essential.bussiness.recommend.dao.RecommendAutoMapper;
import com.essential.bussiness.recommend.model.auto.RecommendAuto;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.StringCommonUtils;
import com.essential.common.utils.TmDateUtil;
import com.essential.find.dao.ArticleAutoMapper;
import com.essential.find.model.auto.ArticleAuto;
import com.essential.user.dao.PushMsgAutoMapper;
import com.essential.user.dao.PushMsgUserAutoMapper;
import com.essential.user.model.auto.PushMsgAuto;
import com.essential.user.model.auto.PushMsgUserAuto;
import com.essential.user.model.vo.PlatformPushMsgRequestVo;
import com.essential.user.model.vo.PushMsgVo;
import com.essential.user.model.vo.UserPushMsgRequestVo;
import com.essential.user.service.IPushMsgService;
import com.essential.utils.CommonResponseUtils;
import com.essential.utils.DTOUtils;
import com.essential.utils.JPushUtils;

/**
 * 退送消息表
 * 
 * @author Jaelyn
 *
 */
@Service
public class PushMsgServiceImpl implements IPushMsgService {

	/**
	 * 消息管理
	 */
	@Autowired
	private PushMsgAutoMapper pushMsgAutoMapper;
	/**
	 * 消息对应的用户
	 */
	@Autowired
	private PushMsgUserAutoMapper pushMsgUserAutoMapper;
	// 注入订单service
	@Autowired
	@Qualifier("queryOrderServiceImpl")
	IQueryOrderService queryOrderService;
	// 注入退货退款订单service
	@Autowired
	@Qualifier("returnRefundOrderServiceImpl")
	IReturnRefundOrderService returnRefundService;

	@Autowired
	private ArticleAutoMapper articleAutoMapper;
	@Autowired
	private ProductAutoMapper productAutoMapper;
	@Autowired
	private BrandAutoMapper brandAutoMapper;
	//注入推荐dao
	@Autowired
	private RecommendAutoMapper recommendDao;

	/**
	 * 发送退送信息
	 * 
	 * @param pushMsgAuto
	 * @return
	 */
	@Override
	public Map<String, Object> saveUserPushMsg(PlatformPushMsgRequestVo pushMsgAuto) {
		try {
			// 发送消息
			String timeStamp = TmDateUtil.getTimeStamp();
			pushMsgAuto.setCreateTime(timeStamp);
			pushMsgAuto.setModifyTime(timeStamp);
			pushMsgAuto.setPushTime(timeStamp);
			pushMsgAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			int num = pushMsgAutoMapper.insert(pushMsgAuto);
			if (num <= 0) {
				return CommonResponseUtils.failureResponse("发送失败");
			} else {
				// 根据消息类别发送通知
				int pushStrategy = pushMsgAuto.getPushStrategy();
				JPushUtils jPushUtils = new JPushUtils(pushMsgAuto.getMsgContent());
				Map<String, String> extrasMap = new HashMap<String, String>();
				String mainId = pushMsgAuto.getMainId();
				String secondId = pushMsgAuto.getSecondId();
				String threeId = pushMsgAuto.getThreeId();
				String attr1 = pushMsgAuto.getAttr1();
				String attr2 = pushMsgAuto.getAttr2();
				String attr3 = pushMsgAuto.getAttr3();
				String attr4 = pushMsgAuto.getAttr4();
				String attr5 = pushMsgAuto.getAttr5();
				String attr6 = pushMsgAuto.getAttr6();
				extrasMap.put("pushTypeId", "" + pushMsgAuto.getPushTypeId());
				extrasMap.put("mainId", mainId);
				extrasMap.put("secondId", secondId);
				extrasMap.put("threeId", threeId);
				extrasMap.put("attr1", attr1);
				extrasMap.put("attr2", attr2);
				extrasMap.put("attr3", attr3);
				extrasMap.put("attr4", attr4);
				extrasMap.put("attr5", attr5);
				extrasMap.put("attr6", attr6);

				// （0:所有，1:个人，2：普通用户,3:vip,）
				switch (pushStrategy) {
				case 0:
					jPushUtils.sendPushAll(extrasMap);
					if (num > 0) {
						return CommonResponseUtils.successResponse("发送成功");
					} else {
						return CommonResponseUtils.failureResponse("发送失败");
					}

				case 1:
					Long userId = pushMsgAuto.getUserId();
					jPushUtils.sendPushAlias(userId.toString(), extrasMap);

					PushMsgUserAuto pushMsgUserAuto = new PushMsgUserAuto();
					pushMsgUserAuto.setCreateTime(timeStamp);
					pushMsgUserAuto.setModifyTime(timeStamp);
					pushMsgUserAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
					pushMsgUserAuto.setIsRead(SUConstants.ReadStatus_NOT_READ);
					pushMsgUserAuto.setUserId(userId);
					pushMsgUserAuto.setMsgId(pushMsgAuto.getMsgId());
					num = pushMsgUserAutoMapper.insert(pushMsgUserAuto);
					if (num > 0) {
						return CommonResponseUtils.successResponse("发送成功");
					} else {
						return CommonResponseUtils.failureResponse("发送失败");
					}

				case 2:
					jPushUtils.sendPushTag("common", extrasMap);
					if (num > 0) {
						return CommonResponseUtils.successResponse("发送成功");
					} else {
						return CommonResponseUtils.failureResponse("发送失败");
					}
				case 3:
					jPushUtils.sendPushTag("vip", extrasMap);
					if (num > 0) {
						return CommonResponseUtils.successResponse("发送成功");
					} else {
						return CommonResponseUtils.failureResponse("发送失败");
					}
				default:
					if (num > 0) {
						return CommonResponseUtils.successResponse("发送成功");
					} else {
						return CommonResponseUtils.failureResponse("发送失败");
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("发送失败");
		}
	}

	/**
	 * 查询平台退送记录
	 * 
	 * @param pushMsgAuto
	 * @return
	 */
	@Override
	public Map<String, Object> queryPlatformPushMsg(PlatformPushMsgRequestVo pushMsgAuto) {
		try {
			// 发送消息
			pushMsgAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			Integer pageIndex=pushMsgAuto.getPageIndex();
			if(pageIndex==null){
				return CommonResponseUtils.failureResponse(SUConstants.PARAM_ERRROR);
			}
			Integer pageSize=pushMsgAuto.getPageSize();
			if(pageSize==null||pageIndex.intValue()<SUConstants.PAGE_COUNT){
				pageSize=SUConstants.PAGE_COUNT;
				pushMsgAuto.setPageSize(SUConstants.PAGE_COUNT);
			}
			pushMsgAuto.setPageIndex((pageIndex-1) * pageSize);
			List<PushMsgAuto> pushMsgAutoList = pushMsgAutoMapper.queryPlatformPushMsg(pushMsgAuto);
			long totleCount=pushMsgAutoMapper.queryTotlePushNumber(pushMsgAuto);
			List<Map<String, Object>> dataList = queryPushMsgVo(pushMsgAutoList);
			HashMap<String,Object> resultMap=new HashMap<String, Object>();
			resultMap.put("totalPageCount", totleCount);
			resultMap.put("contentList", dataList);
			return CommonResponseUtils.successResponse(resultMap);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("查询失败");
		}
	}

	/**
	 * 转换具体的消息内容
	 * 
	 * @param pushMsgAutoList
	 * @return
	 */
	private List<Map<String, Object>> queryPushMsgVo(List<PushMsgAuto> pushMsgAutoList) {
		ArrayList<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		for (PushMsgAuto pushMsgAuto : pushMsgAutoList) {
			int pushTypeId = pushMsgAuto.getPushTypeId().intValue();
			String mainId = pushMsgAuto.getMainId();
			if (StringCommonUtils.isEmpty(mainId)) {
				continue;
			}
			Map<String, Object> map = new HashMap<String, Object>();
			Long id = Long.valueOf(mainId);
			if (pushTypeId == 0) {
				try {
					ArticleAuto articleAuto=new ArticleAuto();
					articleAuto.setArticleId(id);
					articleAuto=articleAutoMapper.queryArticleDetailById(articleAuto);				
					if(articleAuto!=null){
						articleAuto.setArticleContent(null);
						articleAuto.setCreateTime(pushMsgAuto.getCreateTime());
						map=DTOUtils.beanToMap(articleAuto);
					}		
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (pushTypeId == 1) {
				RecommendAuto recommendAuto = recommendDao.selectByPrimaryKey(id);
					try {
						recommendAuto.setCreateTime(pushMsgAuto.getCreateTime());
						map=DTOUtils.beanToMap(recommendAuto);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			} else if (pushTypeId == 3) {
				HashMap<String, Object> productMap = new HashMap<String, Object>();
				productMap.put("productId", id);
				productMap.put("pageSize", 1);
				productMap.put("pageIndex", 0);
				List<ProductSerchInfoVo> productSerchInfoVos = productAutoMapper.queryProductByShopId(productMap);
				if (productSerchInfoVos.size() > 0) {
					ProductSerchInfoVo prBaseInfoVo = productSerchInfoVos.get(0);
					try {
						prBaseInfoVo.setCreateTime(pushMsgAuto.getCreateTime());
						map=DTOUtils.beanToMap(prBaseInfoVo);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}else if(pushTypeId==5){
				BrandAuto brandAuto=brandAutoMapper.selectByPrimaryKey(id);
				if(brandAuto!=null){
					try {
						brandAuto.setCreateTime(pushMsgAuto.getCreateTime());
						map=DTOUtils.beanToMap(brandAuto);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			map.put("pushTypeId", pushTypeId);
			map.put("msgTitle", pushMsgAuto.getMsgTitle());
			map.put("attr1", pushMsgAuto.getAttr1());
			dataList.add(map);
		}
		return dataList;
	}

	/**
	 * 查询用户消息记录
	 * 
	 * @param pushMsgAuto
	 * @return
	 */
	@Override
	public Map<String, Object> queryUserPushMsg(UserPushMsgRequestVo pushMsgAuto) {
		try {
			// 发送消息
			pushMsgAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			pushMsgAuto.setPageSize(SUConstants.PAGE_COUNT);
			// pushMsgAuto.setPageIndex(pushMsgAuto.getPageIndex()*SUConstants.PAGE_COUNT);
			List<PushMsgVo> pushMsgVoList = pushMsgAutoMapper.queryUserPushMsg(pushMsgAuto);

			for (PushMsgVo tempPushMsgAuto : pushMsgVoList) {
				if (tempPushMsgAuto.getPushTypeId() == 8) {// 订单
					OrderProductVo orderProductVo = new OrderProductVo();
					orderProductVo.setOrderId(Long.parseLong(tempPushMsgAuto.getMainId()));
					Map<String, Object> orderInfoMap = queryOrderService.queryOrderForList(orderProductVo, null, 1, pushMsgAuto.getUserId());
					if (SUConstants.CODE_SUCCESS_VALUE.equals(orderInfoMap.get(SUConstants.CODE_KEY).toString())) {
						tempPushMsgAuto.setData(orderInfoMap.get(SUConstants.INFO_KEY));
					} else {
						tempPushMsgAuto.setData("");
					}
				} else if (tempPushMsgAuto.getPushTypeId() == 9) {// 退货退款订单
					ReturnRefundOrderVo returnRefundOrderVo = new ReturnRefundOrderVo();
					returnRefundOrderVo.setReturnRefundOrderId(Long.parseLong(tempPushMsgAuto.getMainId()));
					Map<String, Object> orderInfoMap = returnRefundService.queryRefundOrderForList(returnRefundOrderVo, 1, pushMsgAuto.getUserId(), "退货退款");
					if (SUConstants.CODE_SUCCESS_VALUE.equals(orderInfoMap.get(SUConstants.CODE_KEY).toString())) {
						tempPushMsgAuto.setData(orderInfoMap.get(SUConstants.INFO_KEY));
					} else {
						tempPushMsgAuto.setData("");
					}
				}
			}
			return CommonResponseUtils.successResponse(pushMsgVoList);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("查询失败");
		}
	}

	/**
	 * 设置消息已读
	 * 
	 * @param pushMsgAuto
	 * @return
	 */
	@Override
	public Map<String, Object> updateUserPushMsg(PushMsgUserAuto pushMsgAuto) {
		try {
			// 发送消息
			// pushMsgAuto.setIsRead(ReadStatus.READ.ordinal());

			int num = pushMsgUserAutoMapper.updateByParams(pushMsgAuto);
			if (num > 0) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put(SUConstants.MSG_KEY, "删除成功");
				map.put("msgId", pushMsgAuto.getMsgId());
				return CommonResponseUtils.successResponse(map);
			} else {
				return CommonResponseUtils.failureResponse("删除失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("删除失败");
		}
	}

}
