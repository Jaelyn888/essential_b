package com.essential.common.enums;

public enum PageCacheEnums {

//	HOME("/essential/home", "主页",0),

//	USER_MANAGER("/essential/user/userManager", "用户管理主页"),
	
//	DEMO_HOME("/essential/demoAbout/index", "Demo主页"),
	
	;

	/**
	 * 需要缓存的请求路径
	 */
	public String url;

	/**
	 * 缓存描述
	 */
	public String msg;
	
	/**
	 * 缓存时间，以分钟计算，没有失效时间设为0
	 */
	public long cacheMinutes;

	private PageCacheEnums(String url, String msg,long cacheMinutes) {
		this.url = url;
		this.msg = msg;
		this.cacheMinutes = cacheMinutes;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public long getCacheMinutes() {
		return cacheMinutes;
	}

	public void setCacheMinutes(long cacheMinutes) {
		this.cacheMinutes = cacheMinutes;
	}

}
