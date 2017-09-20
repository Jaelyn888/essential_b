package com.essential.find.service;

import java.util.Map;

import org.springframework.stereotype.Service;
@Service
public interface IDiscoverTopGroupService {

	/**
	 * all group
	 * 
	 * @return
	 */
	public abstract Map<String, Object> queryFindTopGroup();

}