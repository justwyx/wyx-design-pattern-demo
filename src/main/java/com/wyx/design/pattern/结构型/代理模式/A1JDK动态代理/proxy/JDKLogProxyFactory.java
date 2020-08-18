package com.wyx.design.pattern.结构型.代理模式.A1JDK动态代理.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @Description : JDK代理模式，日志增强
 * @author : Just wyx
 * @Date : 2020/8/18
 */
public class JDKLogProxyFactory implements InvocationHandler {
	// 源目标对象
	private Object target;

	/**
	 * 获取代理对象
	 * @param target 目标对象
	 * @return 返回一个代理对象
	 */
	public Object getProxy(Object target) {
		// 目标对象注入到代理对象中
		this.target = target;

		/**
		 * 1.目标类的类加载器
		 * 2.目标类的接口集合
		 * 3.代理对象调用时的调用处理器
		 */
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(),
				this);
	}


	/**
	 *
	 * @param proxy 代理对象
	 * @param method 目标对象的方法
	 * @param args 方法参数
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 前置通知 打印日志
		System.out.println(method.getName() + "-param: " + Arrays.toString(args));

		/**
		 * 下面代码执行，实际是利用反射，调用的目标对象的方法
		 */
		Object returnValue = method.invoke(target, args);
		// 后置通知 打印日志
		System.out.println(method.getName() + "-result: " + returnValue.toString());
		System.out.println();
		return returnValue;
	}
}
