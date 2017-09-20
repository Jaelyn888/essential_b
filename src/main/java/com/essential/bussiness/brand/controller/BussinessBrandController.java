package com.essential.bussiness.brand.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.essential.bussiness.brand.model.auto.BrandAuto;
import com.essential.bussiness.brand.model.auto.ShopandbrandAuto;
import com.essential.bussiness.brand.model.vo.BrandVo;
import com.essential.bussiness.brand.service.IBrandService;
import com.essential.bussiness.product.model.auto.ProductTypeAuto;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.MyException;
import com.essential.common.utils.TmDateUtil;
import com.essential.utils.CommonResponseUtils;


/**
 * 商品品牌
 * @author essential-gfs
 *
 */
@Controller
@RequestMapping(value="bussinessBrand")
public class BussinessBrandController {
	
	private Logger logger = LoggerFactory.getLogger(BussinessBrandController.class);

	//装配商品品牌service
	@Autowired
	@Qualifier("brandServiceImpl")
	IBrandService brandService;
	
	
	
	/**
	 * 查询全部商品品全部牌列表(分页)
	 * @param bussinessBrandModel 品牌实体
	 * @return
	 */
	@RequestMapping(value="queryTotalBrand")
	@ResponseBody
	public Map<String, Object> queryTotalBrand(BrandVo brandVo){
		
		try {
			return brandService.queryTotalBrandForPage(brandVo);
		} catch (MyException me) {
			me.printStackTrace();
			return CommonResponseUtils.failureResponse("查询全部商品品牌列表失败");
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("查询全部商品品牌列表失败");
		}
	}
	
	
	/**
	 * 查询全部商品品全部牌列表(不分页)
	 * @param bussinessBrandModel 品牌实体
	 * @return
	 */
	@RequestMapping(value="queryTotalBrandNoPage")
	@ResponseBody
	public Map<String, Object> queryTotalBrandNoPage(BrandVo brandVo){
		
		try {
			return brandService.queryTotalBrand(brandVo);
		} catch (MyException me) {
			me.printStackTrace();
			return CommonResponseUtils.failureResponse("查询全部商品品牌列表失败");
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("查询全部商品品牌列表失败");
		}
	}
	
	
	/**
	 * 查询全部商品品牌列表或查询全部商品品牌及热门品牌列表
	 * @param bussinessBrandModel 品牌实体
	 * @param requestType 请求类型 1:查询全部品牌,2:查询全部品牌及热门品牌
	 * @return
	 */
	@RequestMapping(value="queryTotalBrandOrHotBrand")
	@ResponseBody
	public Map<String,Object> queryTotalBrandOrHotBrandForList(BrandAuto bussinessBrandModel,String requestType){
		
		try {
			bussinessBrandModel.setStatus(1);
			return brandService.queryTotalBrandOrHotBrandForList(bussinessBrandModel,requestType);
		} catch (MyException me) {
			me.printStackTrace();
			return CommonResponseUtils.failureResponse(me.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("查询品牌信息失败");
		}
	}
	
	/**
	 * 新增商品品牌
	 * @param bussinessBrandModel 商品品牌实体类
	 * @param categoryIds 商品品类数组
	 * @return
	 */
	@RequestMapping(value="add")
	@ResponseBody
	public Map<String,Object> saveBussinessBrand(BrandAuto bussinessBrandModel, Long[] categoryIds){
		try {
			String nowDate = TmDateUtil.getTimeStamp();
			if(categoryIds == null || categoryIds.length<=0){
				Map<String,Object> bussinessBrandMap = new HashMap<String, Object>();
				bussinessBrandMap.put(SUConstants.CODE_KEY, SUConstants.CODE_FAIL_VALUE);
				bussinessBrandMap.put(SUConstants.MSG_KEY, "新增商品品牌失败,数组categoryIds为空");
				return bussinessBrandMap;
			}
			bussinessBrandModel.setCreateTime(nowDate);
			bussinessBrandModel.setModifyTime(nowDate);
			return brandService.saveBussinessBrand(bussinessBrandModel,categoryIds);
		} catch (MyException me) {
			me.printStackTrace();
			return CommonResponseUtils.failureResponse(me.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("新增商品品牌失败");
		}
	}
	
	/**
	 * 修改商品品牌信息
	 * @param bussinessBrandModel 商品品牌实体类
	 * @param categoryIds 商品品类数组
	 * @return
	 */
	@RequestMapping(value="update")
	@ResponseBody
	public Map<String,Object> updateBussinessBrand(BrandAuto bussinessBrandModel,Long[] categoryIds){
		try {
			if(categoryIds == null || categoryIds.length<=0){
				Map<String,Object> bussinessBrandMap = new HashMap<String, Object>();
				bussinessBrandMap.put(SUConstants.CODE_KEY, SUConstants.CODE_FAIL_VALUE);
				bussinessBrandMap.put(SUConstants.MSG_KEY, "修改商品品牌失败,数组categoryIds为空");
				return bussinessBrandMap;
			}
			bussinessBrandModel.setModifyTime(TmDateUtil.getTimeStamp());
			return brandService.updateBussinessBrand(bussinessBrandModel,categoryIds);
		} catch (MyException me) {
			me.printStackTrace();
			return CommonResponseUtils.failureResponse(me.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("修改商品品牌失败");
		}
	}
	
	
	/**
	 * 查询商品品牌和商品分类列表
	 * @param model
	 * @return
	 */
	@RequestMapping(value="queryBrandAndProductType")
	@ResponseBody
	public Map<String,Object> queryBrandAndProductTypeForList(BrandAuto bussinessBrandModel){
		try {
			ProductTypeAuto productTypeModel = new ProductTypeAuto();
			productTypeModel.setCategoryId(bussinessBrandModel.getCategoryId());
			productTypeModel.setIsDeleted(SUConstants.IS_NOT_DELETE);
			bussinessBrandModel.setStatus(1);
			
			return brandService.queryBrandAndProductTypeForList(bussinessBrandModel,productTypeModel);
		} catch (MyException me) {
			me.printStackTrace();
			return CommonResponseUtils.failureResponse(me.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("修改商品品牌失败");
		}
	}
	
	/**
	 * 查询品牌和商品集合
	 * @param BrandAuto 品牌实体
	 * @param pageIndex 页数
	 * @return
	 */
	@RequestMapping(value="queryBrandAndProductList")
	@ResponseBody
	public Map<String,Object> queryBrandAndProductList(BrandAuto brandAuto, Integer pageIndex, Integer pageSize, Long userId){
		if(brandAuto.getBrandId() == null){
			return CommonResponseUtils.failureResponse("品牌id不能为空");
		}
		if(pageIndex == null){
			return CommonResponseUtils.failureResponse("页码不能为空");
		}
		try {
			return brandService.queryBrandandProductList(brandAuto, pageIndex, pageSize, userId);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("查询品牌商品信息失败");
		}
	}
	
	/**
	 * 通过shopId查询品牌列表
	 * @param shopandbrandAuto 店铺品牌关联实体
	 * @return
	 */
	@RequestMapping(value="shop")
	@ResponseBody
	public Map<String,Object> queryBrandByShopId(Long shopId,Long pageIndex,Long checked,String brandName) {
		try {
			
			return brandService.queryBrandandList(shopId,pageIndex,checked,brandName);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("通过shopId查询品牌列表失败");
			return CommonResponseUtils.failureResponse("通过shopId查询品牌列表失败");
			
		}
		
	}
	
	
	/**
	 * 修改热门品牌品牌
	 * @param bussinessBrandModel 商品品牌实体类
	 * @return
	 */
	@RequestMapping(value="updateHotBrand")
	@ResponseBody
	public Map<String,Object> updateHotBrand(BrandAuto bussinessBrandModel){
		try {
			bussinessBrandModel.setModifyTime(TmDateUtil.getTimeStamp());
			return brandService.updateHotBrand(bussinessBrandModel);
		} catch (MyException me) {
			me.printStackTrace();
			return CommonResponseUtils.failureResponse(me.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResponseUtils.failureResponse("修改商品品牌失败");
		}
	}
	
	/**
	 * 通过shopId和categoryId查询品牌列表
	 * @param 
	 * @return
	 */
	@RequestMapping(value="queryShopIdCategoryId")
	@ResponseBody
	public Map<String,Object> queryBrandbyCategoryidShopId(Long shopId,Long categoryId) {
		
		try {			
			return brandService.queryBrandbyCategoryidShopId(shopId, categoryId);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("根据店铺id和大分类id查询品牌列表失败");
			return CommonResponseUtils.failureResponse("根据店铺id和大分类id查询品牌列表失败");
			
		}
		
	}
	
	
	/**
	 * 
	 * @param 
	 * @param 品牌申请（web前端思雨）
	 * @return
	 */
	@RequestMapping(value="brandApply")
	@ResponseBody
	public Map<String,Object> brandApply(ShopandbrandAuto shopandbrandAuto) {
		
		try {
			
			return brandService.brandApply(shopandbrandAuto);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			logger.info("品牌申请失败");
			return CommonResponseUtils.failureResponse("品牌申请失败");
			
		}
		
	}
	
	/**
	 * 
	 * @param 
	 * @param 品牌审核（web前端思雨）
	 * @return
	 */
	@RequestMapping(value="brandAudit")
	@ResponseBody
	public Map<String,Object> brandAudit(ShopandbrandAuto shopandbrandAuto) {
		
		try {
			
			return brandService.brandAudit(shopandbrandAuto);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("品牌审核失败");
			return CommonResponseUtils.failureResponse("品牌审核失败");
			
		}
		
	}
	
	
	
	
	
	
}
