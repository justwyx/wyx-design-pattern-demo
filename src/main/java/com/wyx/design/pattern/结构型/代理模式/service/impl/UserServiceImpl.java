package com.wyx.design.pattern.结构型.代理模式.service.impl;

import com.wyx.design.pattern.结构型.代理模式.entity.User;
import com.wyx.design.pattern.结构型.代理模式.service.UserService;

/**
 * @author : Just wyx
 * @Description : TODO 2020/8/18
 * @Date : 2020/8/18
 */
public class UserServiceImpl implements UserService {

	public User get(Integer id) {
		System.out.println("get方法执行中。。。");
		User user = new User();
		user.setId(1);
		user.setName("wyx");
		return user;
	}

	public int add(User user) {
		System.out.println("add方法执行中。。。");
		return 1;
	}
}
