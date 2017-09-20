package com.essential.find.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.essential.find.model.auto.SpecialAuto;

@Service
public interface ISpecialService {
	public SpecialAuto selectSpecial(SpecialAuto findSpecialAuto);
	public boolean createSpecial(SpecialAuto findSpecialAuto);
	public boolean updateSpecial(SpecialAuto findSpecialAuto);
	public boolean deleteSpecial(SpecialAuto findSpecialAuto);
	
	public List<Object> selectSpecialList(HashMap<String, Object> map);
	
}
