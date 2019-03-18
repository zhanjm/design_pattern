package com.zjm.interceptor.impl;

import java.lang.reflect.Method;

import com.zjm.interceptor.Interceptor;

public class InterceptorImpl implements Interceptor {

	@Override
	public boolean before(Object proxy, Object target, Method method, Object[] args) {
		System.out.println("===反射方法前逻辑===");
		return true;
	}

	@Override
	public void around(Object proxy, Object target, Method method, Object[] args) {
		System.out.println("===反射方法后逻辑===");
	}

	@Override
	public void after(Object proxy, Object target, Method method, Object[] args) {
		System.out.println("===取代了被代理对象的方法===");
	}

}
