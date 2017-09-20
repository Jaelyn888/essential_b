package com.essential.management.system.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.essential.management.system.model.auto.HelpAuto;

@Service
public interface IHelpAutoService {

	public Map<String, Object> addHelp(HelpAuto helpAuto);
	
	public Map<String, Object> updateHelp(HelpAuto helpAuto);
	
	public Map<String, Object> queryHelp(HelpAuto helpAuto);
	
	public Map<String, Object> deleteHelp(Long helpId);
}
