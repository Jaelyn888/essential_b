package com.essential.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * 
 * @ClassName: AllTests
 * @Description: 总的测试类
 * @author: wanglt
 * @date: 2015年3月18日 下午5:56:42
 * 
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
		com.essential.test.auth.user.service.impl.UserServiceImplTest.class,
		})
public class AllTests {
	public static void main(String[] args) {
		JUnitCore.main("com.essential.test.AllTests");
	}
}
