package com.zjm.dynamicproxy;

import com.zjm.service.HelloWorld;
import com.zjm.service.impl.HelloWorldImpl;

public class JdkProxyExampleTest {

	
	public static void main(String[] args) {
		
		JdkProxyExample jdk = new JdkProxyExample();
		HelloWorld proxy = (HelloWorld)jdk.bind(new HelloWorldImpl());
		proxy.sayHelloWorld();
	}
	
}
