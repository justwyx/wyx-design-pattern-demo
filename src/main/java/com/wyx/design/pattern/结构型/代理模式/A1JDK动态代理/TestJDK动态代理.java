package com.wyx.design.pattern.结构型.代理模式.A1JDK动态代理;

import com.wyx.design.pattern.结构型.代理模式.A1JDK动态代理.proxy.JDKLogProxyFactory;
import com.wyx.design.pattern.结构型.代理模式.A1JDK动态代理.proxy.JDKRequestProxyFactory;
import com.wyx.design.pattern.结构型.代理模式.entity.User;
import com.wyx.design.pattern.结构型.代理模式.service.UserService;
import com.wyx.design.pattern.结构型.代理模式.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * @author : Just wyx
 * @Description : TODO 2020/8/18
 * @Date : 2020/8/18
 */
public class TestJDK动态代理 {
	private JDKLogProxyFactory jdkLogProxyFactory;
	private JDKRequestProxyFactory jdkRequestProxyFactory;

	@Before
	public void init() {
		jdkLogProxyFactory = new JDKLogProxyFactory();
		jdkRequestProxyFactory = new JDKRequestProxyFactory();
	}

	/**
	 * 测试日志增强
	 */
	@Test
	public void testLog() {
		// 创建目标对象
		UserService userService = new UserServiceImpl();
		// 生成日志增强的代理对象
		userService = (UserService) jdkLogProxyFactory.getProxy(userService);

		// 通过代码类对象调用
		User user = new User();
		user.setId(1);
		user.setName("wyx");
		userService.add(user);
		userService.get(1);
	}

	/**
	 * 测试统计调用增强
	 */
	@Test
	public void testRequest() {
		// 创建目标对象
		UserService userService = new UserServiceImpl();
		// 生成日志增强的代理对象
		userService = (UserService) jdkRequestProxyFactory.getProxy(userService);

		// 通过代码类对象调用
		User user = new User();
		user.setId(1);
		user.setName("wyx");
		userService.add(user);
		userService.get(1);
	}
}
