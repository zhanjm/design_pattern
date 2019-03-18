package com.zjm.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyExample implements InvocationHandler {

	private Object target = null;
	
	public Object bind(Object target) {
		this.target = target;
		System.out.println("===执行bind方法===");
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	
	public Object invoke(Object arg0, Method method, Object[] arg2) throws Throwable {
		System.out.println("===进入代理逻辑方法===");
		System.out.println("===在调度真实对象之前的服务===");
		Object obj = method.invoke(target, arg2);
		System.out.println("===在调度真实对象之后的服务===");
		
		return obj;
	}
	
		

}
