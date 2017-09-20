package com.essential.management.version.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.management.version.model.auto.VersionAuto;

@Service
public interface IVersionAutoService {

	public Map<String, Object> queryVersion(VersionAuto versionAuto,Integer pageIndex,Integer pageSize);
	
	public Map<String, Object> addVersion(VersionAuto versionAuto);
	
	public Map<String, Object> updateVersion(VersionAuto versionAuto);
	
	public Map<String, Object> deleteVersion(Long versionId);
	
	public Map<String, Object> queryNewVersion();
}
