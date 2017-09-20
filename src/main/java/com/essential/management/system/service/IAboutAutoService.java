package com.essential.management.system.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.management.system.model.auto.AboutAuto;

@Service
public interface IAboutAutoService {

	public Map<String, Object> addAbout(AboutAuto aboutAuto);

	public Map<String, Object> updateAbout(AboutAuto aboutAuto);

	public Map<String, Object> queryAbout(AboutAuto aboutAuto);

	public Map<String, Object> deleteAbout(Long[] aboutIds);

	public Map<String, Object> saveOrUpdateAbout(AboutAuto aboutAuto);

}
