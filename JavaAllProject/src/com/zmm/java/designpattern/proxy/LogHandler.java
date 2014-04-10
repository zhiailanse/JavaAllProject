package com.zmm.java.designpattern.proxy;

import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {

	private Object t;

	public LogHandler(Object t) {
		super();
		this.t = t;
	}

	@Override
	public void invoke(Object o,Method m) {
		System.out.println("begin loging ...");
		try {
			m.invoke(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Loging finish.");
	}

}
