package com.wyx.design.pattern.结构型.代理模式.A2CGLIB动态代理;

import com.wyx.design.pattern.结构型.代理模式.A2CGLIB动态代理.proxy.CGLIBLogProxyFactory;
import com.wyx.design.pattern.结构型.代理模式.A2CGLIB动态代理.proxy.CGLIBRequestProxyFactory;
import com.wyx.design.pattern.结构型.代理模式.entity.User;
import com.wyx.design.pattern.结构型.代理模式.service.UserService;
import com.wyx.design.pattern.结构型.代理模式.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * @Description : CGLIB动态代理测试类
 * @author : Just wyx
 * @Date : 2020/8/18
 */
public class TestCGLIB动态代理 {
	private CGLIBLogProxyFactory cglibLogProxyFactory;
	private CGLIBRequestProxyFactory cglibRequestProxyFactory;

	@Before
	public void init() {
		cglibLogProxyFactory = new CGLIBLogProxyFactory();
		cglibRequestProxyFactory = new CGLIBRequestProxyFactory();
	}

	/**
	 * 测试日志增强
	 */
	@Test
	public void testLog() {
		// 创建目标对象
		UserService userService = new UserServiceImpl();
		// 生成日志增强的代理对象
		userService = (UserService) cglibLogProxyFactory.getProxy(userService);

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
		userService = (UserService) cglibRequestProxyFactory.getProxy(userService);

		// 通过代码类对象调用
		User user = new User();
		user.setId(1);
		user.setName("wyx");
		userService.add(user);
		userService.get(1);
	}
}
