package com.essential.index.service;

import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * 商家首页service
 * @author essential-gfs
 *
 */
@Service
public interface IBusinessIndexService {

	public Map<String, Object> queryIndexInfo(Long shopId);
}
