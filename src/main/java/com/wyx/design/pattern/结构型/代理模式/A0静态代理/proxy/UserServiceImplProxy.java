package com.wyx.design.pattern.结构型.代理模式.A0静态代理.proxy;

import com.wyx.design.pattern.结构型.代理模式.service.UserService;
import com.wyx.design.pattern.结构型.代理模式.service.impl.UserServiceImpl;
import com.wyx.design.pattern.结构型.代理模式.entity.User;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description : UserService的静态代理对象
 * @author : Just wyx
 * @Date : 2020/8/18
 */
public class UserServiceImplProxy implements UserService {
	/**
	 * 记录请求次数
	 */
	private static AtomicLong requestRecordNum = new AtomicLong(0);
	/**
	 * 持有一个源对象的引用
	 */
	private UserServiceImpl userService;

	public UserServiceImplProxy() {
		this.userService = new UserServiceImpl();
	}

	public User get(Integer id) {
		// 前置通知 记录请求次数
		requestRecord();
		return userService.get(id);
	}

	public int add(User user) {
		// 前置通知 打印日志
		System.out.println("before proxy-param: " + user.toString());
		int num = userService.add(user);
		// 后置通知 打印日志
		System.out.println("after proxy-result: " + num);
		return num;
	}

	private void requestRecord() {
		System.out.println("请求记录次数：" + requestRecordNum.incrementAndGet());
	}

}
