package com.essential.bussiness.product.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.essential.bussiness.product.dao.LinkProductAutoMapper;
import com.essential.bussiness.product.model.auto.LinkProductAuto;
import com.essential.bussiness.product.service.IProductLinkService;
import com.essential.common.constants.SUConstants;
import com.essential.common.utils.MyException;
import com.essential.utils.CommonResponseUtils;
/**
 * 外链商品操作
 * @author Jaelyn
 *
 */
@Service
public class ProductLinkServiceImpl implements IProductLinkService {
	
	@Autowired
	private LinkProductAutoMapper linkProductAutoMapper;
	/**
	 * 保存外链商品
	 * @param linkProductAuto
	 * @return
	 */
	@Override
	public Map<String, Object> saveLinkProduct(LinkProductAuto linkProductAuto){
		try {
			linkProductAuto.setIsDelete(SUConstants.IS_NOT_DELETE);
			int num=linkProductAutoMapper.insert(linkProductAuto);
			if(num>0){
				Map<String,Object> resultMap=new HashMap<String, Object>();
				resultMap.put(SUConstants.MSG_KEY, "保存成功");
				resultMap.put("productId", linkProductAuto.getLinkId());
				return CommonResponseUtils.successResponse("保存成功",resultMap);
			}else{
				throw new MyException();
			}
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return CommonResponseUtils.failureResponse(SUConstants.SERVER_ERROR);	
		}
	}

}
