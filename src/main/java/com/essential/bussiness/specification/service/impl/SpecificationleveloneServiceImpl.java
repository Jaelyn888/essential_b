package com.essential.bussiness.specification.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essential.bussiness.product.dao.ProductSkuAutoMapper;
import com.essential.bussiness.product.model.auto.ProductSkuAuto;
import com.essential.bussiness.specification.dao.SpecificationLevelTwoAutoMapper;
import com.essential.bussiness.specification.dao.SpecificationleveloneAutoMapper;
import com.essential.bussiness.specification.model.auto.SpecificationLevelTwoAuto;
import com.essential.bussiness.specification.model.auto.SpecificationleveloneAuto;
import com.essential.bussiness.specification.service.SpecificationLeveloneService;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.TmDateUtil;

/**
 * 一级规格业务
 * 
 * @author cpx
 *
 */
@Service
public class SpecificationleveloneServiceImpl implements
		SpecificationLeveloneService {
	private static Logger logger = LoggerFactory
			.getLogger(SpecificationleveloneServiceImpl.class);
	@Autowired
	SpecificationleveloneAutoMapper specificationleveloneAutoMapper;
	@Autowired
	ProductSkuAutoMapper productSkuAutoMapper;
	@Autowired
	SpecificationLevelTwoAutoMapper specificationLevelTwoAutoMapper;
	

	/**
	 * 新增一级规格
	 */
	@Override
	public Map<String, Object> insertSpecificationLevelone(
			SpecificationleveloneAuto specificationleveloneauto) {
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			specificationleveloneauto.setCreateTime(TmDateUtil.getTimeStamp());
			specificationleveloneauto.setModifyTime(TmDateUtil.getTimeStamp());
			System.out.println(System.currentTimeMillis());

			int i = specificationleveloneAutoMapper
					.insert(specificationleveloneauto);
			if (i > 0) {
				map.put(SUConstants.CODE_KEY, SUConstants.CODE_SUCCESS_VALUE);
				map.put(SUConstants.MSG_KEY, SUConstants.MSG_SUCCESS_VALUE);
				return map;
			}
		} catch (Exception e) {
			logger.info("新增一级规格失败:", e);
			e.printStackTrace();
		}

		map.put(SUConstants.CODE_KEY, SUConstants.CODE_FAIL_VALUE);
		map.put(SUConstants.MSG_KEY, "新增一级级规格失败");

		return map;
	}

	/**
	 * 修改一级规格
	 */
	@Override
	public Map<String, Object> updateById(
			SpecificationleveloneAuto specificationleveloneauto) {

		Map<String, Object> map = new HashMap<String, Object>();
		if (specificationleveloneauto.getSpecificationId() == null) {
			map.put(SUConstants.MSG_KEY, "一级规格ID为空,修改一级规格信息失败");
			map.put(SUConstants.CODE_KEY, SUConstants.CODE_FAIL_VALUE);

			return map;
		}

		try {
			specificationleveloneauto.setModifyTime(TmDateUtil.getTimeStamp());
			int i = specificationleveloneAutoMapper
					.updateByPrimaryKeySelective(specificationleveloneauto);
			if (i > 0) {
				map.put(SUConstants.MSG_KEY, SUConstants.MSG_SUCCESS_VALUE);
				map.put(SUConstants.CODE_KEY, SUConstants.CODE_SUCCESS_VALUE);

				return map;
			}

		} catch (Exception e) {
			logger.info("修改一级规格信息失败:", e);
			e.printStackTrace();
		}

		map.put(SUConstants.MSG_KEY, "修改一级规格信息失败");
		map.put(SUConstants.CODE_KEY, SUConstants.CODE_FAIL_VALUE);

		return map;

	}

	/**
	 * 删除一级规格
	 */
	@Override
	public Map<String, Object> deleteById(
			SpecificationleveloneAuto specificationlevelone) {

		Map<String, Object> map = new HashMap<String, Object>();
		specificationlevelone.setIsDeleted(SUConstants.IS_DELETE);
		if (specificationlevelone.getSpecificationId() == null) {
			map.put(SUConstants.MSG_KEY, "一级规格ID为空,删除一级规格信息失败");
			map.put(SUConstants.CODE_KEY, SUConstants.CODE_FAIL_VALUE);

			return map;
		}

		try {
			int i = specificationleveloneAutoMapper
					.updateByPrimaryKeySelective(specificationlevelone);
			if (i > 0) {
				map.put(SUConstants.MSG_KEY, SUConstants.MSG_SUCCESS_VALUE);
				map.put(SUConstants.CODE_KEY, SUConstants.CODE_SUCCESS_VALUE);

				return map;
			}

		} catch (Exception e) {
			logger.info("删除一级规格信息失败:", e);
			e.printStackTrace();
		}

		map.put(SUConstants.MSG_KEY, "删除一级规格信息失败");
		map.put(SUConstants.CODE_KEY, SUConstants.CODE_FAIL_VALUE);
		return map;
	}

	/**
	 * 查询一级规格
	 */
	@Override
	public Map<String, Object> query(
			SpecificationleveloneAuto specificationLeveloneAuto) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<SpecificationleveloneAuto> list = new ArrayList<SpecificationleveloneAuto>();
		try {
			list = specificationleveloneAutoMapper.selectall(specificationLeveloneAuto);
			map.put(SUConstants.MSG_KEY, SUConstants.MSG_SUCCESS_VALUE);
			map.put(SUConstants.CODE_KEY, SUConstants.CODE_SUCCESS_VALUE);
			map.put("info", list);
			return map;

		} catch (Exception e) {
			logger.info("查询一级规格失败:", e);
			e.printStackTrace();
		}
		map.put(SUConstants.MSG_KEY, "查询一级规格失败");
		map.put(SUConstants.CODE_KEY, SUConstants.CODE_FAIL_VALUE);
		return map;
	}

	/**
	 * 根据商品spuId去查询规
	 */
	@Override
	public Map<String, Object> querySpecification(Long productId) {
		Map<String, Object> map = new HashMap<String, Object>();
		

		// 得到商品spuId
		List<ProductSkuAuto> productSkuAuto = productSkuAutoMapper
				.selectByProductId(productId);

		// SpecificationType为2的规格
		Long[] specificationtwo = new Long[productSkuAuto.size() ];
		Long[] specificationtwo1 = new Long[productSkuAuto.size()];
		Long[] specificationtwo2 = new Long[productSkuAuto.size()];
		Long[] specificationtwo3 = new Long[productSkuAuto.size()];

		for (int i = 0; i <= productSkuAuto.size()-1; i++) {
			if (productSkuAuto.get(i).getSpecificationType() == 2) {
				
				specificationtwo1[i] = productSkuAuto.get(i).getSpecificationid1();
				specificationtwo2[i] = productSkuAuto.get(i).getSpecificationid2();
				specificationtwo3[i] = productSkuAuto.get(i).getSpecificationid3();

			}

			System.out.println("............");
		}
		List list = new ArrayList(Arrays.asList(specificationtwo1));
	      list.addAll(Arrays.asList(specificationtwo2));
	      list.addAll(Arrays.asList(specificationtwo3));
	      Object[] c = list.toArray();
	      map.put("specificationIds", c);
	      List<SpecificationLevelTwoAuto> specificationLevelTwoAuto  =  specificationLevelTwoAutoMapper.selectOneId(map);
	      //一级键的id数组
	     Long[] specificationOneId = new Long[specificationLevelTwoAuto.size()];
	     for (int i = 0; i <= productSkuAuto.size()-1; i++) {
				if (productSkuAuto.get(i).getSpecificationType() == 2) {
					specificationOneId[i]=specificationLevelTwoAuto.get(i).getLevelTwoIs().longValue();

				}

				System.out.println("888888888888888");
			}
	     Map<String, Object> specificationOneKeyMap = new HashMap<String, Object>();
	     specificationOneKeyMap.put("specificationOneKeyIds", specificationOneId);
	     List<SpecificationleveloneAuto> SpecificatiOnleveloneList=specificationleveloneAutoMapper.selectOneName(specificationOneKeyMap);
	     
	     String[] specificationOneKey = new String[SpecificatiOnleveloneList.size()];
	     for (int i = 0; i <= SpecificatiOnleveloneList.size()-1; i++) {
				
					specificationOneKey[i]=SpecificatiOnleveloneList.get(i).getLevelOneName();

				

				System.out.println("------------------------------------------------------");
				System.out.println(specificationOneKey);
			}
	     
		return map;
	}

}
