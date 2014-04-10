package com.zmm.java.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zmm.java.designpattern.factory.Weapen;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		Object o = factory.getBean("v");
		Weapen weapen = (Weapen)o;
		weapen.shoot();
	}

}
