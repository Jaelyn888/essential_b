package com.essential.logisticscompany.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.logisticscompany.model.auto.ExpressInformationAuto;
import com.essential.logisticscompany.model.vo.ExpressInformationVo;

@Service
public interface IExpressInformationService {
	
	public Map<String, Object> queryExpressInfo(ExpressInformationVo expressInformationVo);
	
	public Map<String, Object> addExpressInfo(ExpressInformationAuto expressInformationAuto);
	
	public Map<String, Object> updateExpressInfo(ExpressInformationAuto expressInformationAuto);
	
	public Map<String, Object> deleteExpressInfo(Long[] expressId);

}
