package com.zjm.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.zjm.interceptor.Interceptor;

public class InterceptorJdkProxy implements InvocationHandler {

	private Object target;
	private String InterceptorClass = null;
	
	public InterceptorJdkProxy(Object target, String interceptorClass) {
		this.target = target;
		InterceptorClass = interceptorClass;
	}

	public static Object bind(Object target,String InterceptorClass) {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InterceptorJdkProxy(target, InterceptorClass));
		
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if(InterceptorClass == null) {
			return method.invoke(target, args);
		}
		Object result = null;
		Interceptor interceptor = (Interceptor)Class.forName(InterceptorClass).newInstance();
		if(interceptor.before(proxy, target, method, args)) {
			result = method.invoke(target, args);
		}else {
			interceptor.around(proxy, target, method, args);
		}
		interceptor.after(proxy, target, method, args);
		return result;
	}

	
}
