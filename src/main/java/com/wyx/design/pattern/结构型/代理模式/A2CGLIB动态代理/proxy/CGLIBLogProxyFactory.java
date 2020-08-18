package com.wyx.design.pattern.结构型.代理模式.A2CGLIB动态代理.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Description : CGLIB代理，日志增强
 * @author : Just wyx
 * @Date : 2020/8/18
 */
public class CGLIBLogProxyFactory implements MethodInterceptor {

	public Object getProxy(Object target) {
		// 创建增加器
		Enhancer enhancer = new Enhancer();
		// 设置需要增强的类的类对象
		enhancer.setSuperclass(target.getClass());
		// 设置回调函数
		enhancer.setCallback(this);
		return enhancer.create();
	}


	/**
	 *
	 * @param proxy 代理对象，也就是目标对象的子类
	 * @param method 目标对象的方法
	 * @param args 参数
	 * @param methodProxy 代理对象的方法
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		// 前置通知 打印日志
		System.out.println(method.getName() + "-param: " + Arrays.toString(args));

		// 通过调用代理类的invokeSuper方法,而invokeSuper方法会去调用目标类的invoke方法完成目标对象的调用
		Object returnValue = methodProxy.invokeSuper(proxy, args);
		// 不能直接调用子类的方法，不然会自己调用自己，死循环
//		Object returnValue = method.invoke(proxy, args);
		// 后置通知 打印日志
		System.out.println(method.getName() + "-result: " + returnValue.toString());
		System.out.println();
		return returnValue;
	}
}
