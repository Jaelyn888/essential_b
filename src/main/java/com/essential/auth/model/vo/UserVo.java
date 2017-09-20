package com.essential.auth.model.vo;  

import com.essential.auth.model.User;
 
/**
 * @ClassName: UserVo
 * @Description: 分页查询
 * @author: xush
 * @date: 2015年2月10日 上午10:17:39
 *
 */ 
public class UserVo extends User {
	
	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
  
