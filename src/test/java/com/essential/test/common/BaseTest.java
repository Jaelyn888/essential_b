package com.essential.test.common;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * BaseTest <BR>
 * 所有测试类继承此类，否则无法使用spring自动注入 <BR>
 * 创建人:lijie <BR>
 * 时间:2015年3月11日 下午5:50:41 <BR>
 * 
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml",
		"classpath:conf/spring-mybatis.xml", "classpath:conf/spring-shiro.xml" })
public class BaseTest extends Assert {
	
	@Test
	public void testBase(){
		
	}

}
