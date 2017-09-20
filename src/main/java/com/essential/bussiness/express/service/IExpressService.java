package com.essential.bussiness.express.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.bussiness.express.model.vo.Express;

@Service
public interface IExpressService {
	//查询物流
	public Map<String, Object> queryExpress(Express express);
	//订阅物流（暂时不用）
	public Map<String,Object> subscribeExpress();
	//查询物流企业版
	public Map<String,Object> queryExpressEnterprise(Express express);
	
	

}
