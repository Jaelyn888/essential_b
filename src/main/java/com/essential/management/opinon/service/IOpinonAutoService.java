package com.essential.management.opinon.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.management.opinon.model.auto.OpinonAuto;

@Service
public interface IOpinonAutoService {

	public Map<String, Object> queryOpinion(Integer pageIndex, Integer pageSize);

	public Map<String, Object> addOpinion(OpinonAuto opinonAuto);

	public Map<String, Object> updateOpinion(OpinonAuto opinonAuto);

	public Map<String, Object> deleteOpinion(OpinonAuto opinonAuto);
}
