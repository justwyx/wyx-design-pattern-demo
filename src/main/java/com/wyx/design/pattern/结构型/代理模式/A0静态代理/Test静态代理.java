package com.wyx.design.pattern.结构型.代理模式.A0静态代理;

import com.wyx.design.pattern.结构型.代理模式.A0静态代理.proxy.UserServiceImplProxy;
import com.wyx.design.pattern.结构型.代理模式.entity.User;
import com.wyx.design.pattern.结构型.代理模式.service.UserService;
import org.junit.Test;

/**
 * @author : Just wyx
 * @Description : TODO 2020/8/18
 * @Date : 2020/8/18
 */
public class Test静态代理 {


	/**
	 * 代理模式的应用场景
	 * 如果已有的方法在使用的时候需要对原有的方法进行功能增强(如添加日志，开启事务)，此进有两种方法
	 * 1.修改原有的方法来适应.(违反开闭原则)
	 * 2.采用一个代理类调用原有的方法，对原有的方法进行功能加强
	 *
	 * 这里使用的是静态代理的方法，弊端也很明显，需要为每个代码对象生成一个代码类
	 */
	@Test
	public void test() {
		// 使用代码类对象
		UserService userService = new UserServiceImplProxy();
		// 通过代码类对象调用
		User user = new User();
		user.setId(1);
		user.setName("wyx");
		userService.add(user);
		userService.get(1);
	}
}
