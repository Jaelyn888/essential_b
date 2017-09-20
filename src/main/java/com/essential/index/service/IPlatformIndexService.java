package com.essential.index.service;

import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * 平台首页service
 * @author essential-gfs
 *
 */
@Service
public interface IPlatformIndexService {
	
	public Map<String, Object> queryIndexInfo();
}
