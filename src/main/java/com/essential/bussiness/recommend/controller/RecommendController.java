package com.essential.bussiness.recommend.controller;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essential.bussiness.recommend.model.auto.RecommendAuto;
import com.essential.bussiness.recommend.model.vo.RecommendInputParamVo;
import com.essential.bussiness.recommend.service.IRecommendService;
import com.essential.common.utils.MyException;
import com.essential.utils.CommonResponseUtils;


/**
 * 推荐controller
 * @author essential-gfs
 *
 */
@Controller
@RequestMapping(value="recommend")
public class RecommendController {
	
	//注入推荐模块service
	@Autowired
	@Qualifier("recommendServiceImpl")
	IRecommendService recommendService;
	
	
	/**
	 * 新建推荐
	 * 
	 * @param recommendAuto 推荐实体
	 * @param relatedProducts 相关商品productId数组
	 * @return
	 */
	@RequestMapping(value="add")
	@ResponseBody
	public Map<String, Object> saveRecommend(RecommendAuto recommendAuto,Long[] relatedProducts) {
		if(recommendAuto.getCreateUser() == null){
			return CommonResponseUtils.failureResponse("新建推荐失败,用户id为空");
		}
		try {
			return recommendService.saveRecommend(recommendAuto, relatedProducts);
		} catch (MyException me) {
			me.printStackTrace();
			return CommonResponseUtils.failureResponse(me.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("新建推荐失败");
		}
	}
	
	
	/**
	 * 查询推荐列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value="queryForList")
	@ResponseBody
	public Map<String, Object> queryForList(String recommendTitle, Integer status, Long loginUserId, 
			Integer pageNo, Integer pageCount) {
		if(loginUserId == null){
			return CommonResponseUtils.failureResponse("查询推荐列表失败,用户id为空");
		}
		try {
			if(recommendTitle != null && StringUtils.isEmpty(recommendTitle)){
				recommendTitle = null;
			}
			
			return recommendService.queryRecommend(recommendTitle, status, loginUserId, pageNo, pageCount);
		} catch (MyException me) {
			me.printStackTrace();
			return CommonResponseUtils.failureResponse(me.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("查询推荐列表失败");
		}
	}
	
	
	
	/**
	 * 编辑推荐
	 * 
	 * @param recommendAuto 推荐实体
	 * @param relatedProducts 相关商品productId数组
	 * @return
	 */
	@RequestMapping(value="update")
	@ResponseBody
	public Map<String, Object> updateRecommend(RecommendAuto recommendAuto,Long[] relatedProducts) {
		if(recommendAuto.getModifyUser() == null){
			return CommonResponseUtils.failureResponse("编辑推荐失败,用户id为空");
		}
		
		try {
			return recommendService.updateRecommend(recommendAuto, relatedProducts);
		} catch (MyException me) {
			me.printStackTrace();
			return CommonResponseUtils.failureResponse(me.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("编辑推荐失败");
		}
	}
	
	
	
	/**
	 * 查询推荐的相关商品
	 * 
	 * @param recommendId 推荐id
	 * @return
	 */
	@RequestMapping(value="queryRecommendRelatedProduct")
	@ResponseBody
	public Map<String, Object> queryRecommendRelatedProduct(Long recommendId, Integer pageNo, Integer pageCount) {
		if(recommendId == null){
			return CommonResponseUtils.failureResponse("查询当前推荐的相关商品失败,推荐id为空");
		}
		
		try {
			return recommendService.queryRecommendRelatedProduct(recommendId, pageNo, pageCount);
		} catch (MyException me) {
			me.printStackTrace();
			return CommonResponseUtils.failureResponse(me.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("查询当前推荐的相关商品失败");
		}
	}
	
	
	
	/**
	 * 广告位管理
	 * 
	 * @param recommendId 推荐id
	 * @param type 设置类型  1：置顶设置，2：广告位设置
	 * @param flag 设置值 1：是，0：否
	 * @return
	 */
	@RequestMapping(value="advertisingPositionManager")
	@ResponseBody
	public Map<String, Object> advertisingPositionManager(Long recommendId, Integer flag, Integer type) {
		if(recommendId == null){
			return CommonResponseUtils.failureResponse("广告位管理失败,推荐id为空");
		}
		
		try {
			return recommendService.updateRecommendAdvertisingPosition(recommendId, flag, type);
		} catch (MyException me) {
			me.printStackTrace();
			return CommonResponseUtils.failureResponse(me.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("广告位管理失败");
		}
	}
	
	
	
	/**
	 * 上下线设置
	 * 
	 * @param recommendId 推荐id
	 * @param flag 1：是，0：否
	 * @return
	 */
	@RequestMapping(value="updateStatus")
	@ResponseBody
	public Map<String, Object> updateStatus(Long recommendId, Integer flag) {
		if(recommendId == null){
			return CommonResponseUtils.failureResponse("上下线设置失败,推荐id为空");
		}
		
		try {
			Integer type = 3;
			return recommendService.updateRecommendAdvertisingPosition(recommendId, flag, type);
		} catch (MyException me) {
			me.printStackTrace();
			return CommonResponseUtils.failureResponse(me.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("广告位管理失败");
		}
	}
	
	
	
	/**
	 * 查询推荐轮播
	 * 
	 * 
	 * @return
	 */
	@RequestMapping(value="queryRecommendCarouselPic")
	@ResponseBody
	public Map<String, Object> queryRecommendCarouselPic() {
	
		try {
			return recommendService.queryRecommendCarouselPic();
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("查询推荐轮播失败");
		}
	}
	/**
	 * 查询推荐列表forApp
	 * 
	 * 
	 * @return
	 */
	@RequestMapping(value="queryRecommendListForApp")
	@ResponseBody
	public Map<String, Object> queryRecommendList(RecommendInputParamVo recommendInputParamVo) {
	
		try {
			return recommendService.queryRecommendListForApp(recommendInputParamVo);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("查询推荐列表失败");
		}
	}
	
	
	/**
	 * 查询推荐详情
	 * 
	 * 
	 * @return
	 */
	@RequestMapping(value="queryProductDetails")
	@ResponseBody
	public Map<String, Object> queryProductDetails(long recommendId,int pageIndex) {
	
		try {
			return recommendService.queryRecommendDetail(recommendId, pageIndex);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("查询推荐详情失败");
		}
	}
	
	
	
	/**
	 * 查询广告管理列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value="queryAdvertisingForList")
	@ResponseBody
	public Map<String, Object> queryAdvertisingForList(String recommendTitle, Integer status, Long loginUserId, 
			Integer pageNo, Integer pageCount) {
		if(loginUserId == null){
			return CommonResponseUtils.failureResponse("查询广告管理列表失败,用户id为空");
		}
		try {
			if(recommendTitle != null && StringUtils.isEmpty(recommendTitle)){
				recommendTitle = null;
			}
			
			return recommendService.queryAdvertisingForList(recommendTitle, status, loginUserId, pageNo, pageCount);
		} catch (MyException me) {
			me.printStackTrace();
			return CommonResponseUtils.failureResponse(me.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("查询广告管理列表失败");
		}
	}
}
