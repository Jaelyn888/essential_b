package com.essential.utils;

import java.util.LinkedList;
import java.util.List;

public class UniqueRepeat {
	
	public static Long[] array_unique(Long[] param) {
		List<Long> list = new LinkedList<Long>();
		for (int i = 0; i < param.length; i++) {
			if (!list.contains(param[i])) {
				list.add(param[i]);
			}
		}
		return (Long[]) list.toArray(new Long[list.size()]);
	}

}
