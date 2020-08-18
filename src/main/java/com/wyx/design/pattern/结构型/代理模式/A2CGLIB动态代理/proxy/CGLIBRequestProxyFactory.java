package com.wyx.design.pattern.结构型.代理模式.A2CGLIB动态代理.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description : CGLIB代理模式，请求记录
 * @author : Just wyx
 * @Date : 2020/8/18
 */
public class CGLIBRequestProxyFactory implements MethodInterceptor {
	/**
	 * 记录请求次数
	 */
	private static AtomicLong requestRecordNum = new AtomicLong(0);


	public Object getProxy(Object target) {
		// 创建增加器
		Enhancer enhancer = new Enhancer();
		// 设置需要增强的类的类对象
		enhancer.setSuperclass(target.getClass());
		// 设置回调函数
		enhancer.setCallback(this);
		return enhancer.create();
	}


	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		// 前置通知 记录调用次数
		requestRecord();

		Object resultValue = methodProxy.invokeSuper(proxy, args);
		System.out.println();
		return resultValue;
	}


	private void requestRecord() {
		System.out.println("请求记录次数：" + requestRecordNum.incrementAndGet());
	}


}
