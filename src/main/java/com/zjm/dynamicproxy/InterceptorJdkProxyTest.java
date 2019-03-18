package com.zjm.dynamicproxy;

import com.zjm.service.HelloWorld;
import com.zjm.service.impl.HelloWorldImpl;

public class InterceptorJdkProxyTest {

	public static void main(String[] args) {
		HelloWorld proxy = (HelloWorld)InterceptorJdkProxy.bind(new HelloWorldImpl(), "com.zjm.interceptor.impl.InterceptorImpl");
		proxy.sayHelloWorld();
	}
}
