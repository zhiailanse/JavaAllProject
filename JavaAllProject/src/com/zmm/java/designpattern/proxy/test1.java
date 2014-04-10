package com.zmm.java.designpattern.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


public class test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		Tank t = new Tank();
		InvocationHandler h = new LogHandler(t);
		Moveable m = (Moveable) Proxy.newProxyInstance(Moveable.class, h);
		m.move();
	}
	
}
