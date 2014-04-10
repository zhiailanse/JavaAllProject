package com.zmm.java.designpattern.factory.propertiesIOC;

import java.io.IOException;
import java.util.Properties;

import com.zmm.java.designpattern.factory.Vehicle;

public class test {

	/**
	 * @param args
	 * IOC: Inversion of Control
	 * her has another name: Dependency Injection(DI)
	 * IOC is not a technology , is a design pattern!
	 * 
	 * 
	 */
	public static void main(String[] args) {
		
		Properties prop = new Properties();
		try {
			//此方法只与Vehicle接口耦合，与其具体使用的实现类无关，从而实现解耦
			/**
			 * 好处：因为把对象生成放在了xml里定义，所以需要换一个实现子类变得很简单
			 * 只要修改xml就可以了，这样甚至可以实现对象的热插拔
			 */
			prop.load(test.class.getClassLoader().getResourceAsStream("properties"));
			String name = (String) prop.get("name");
			Object o = Class.forName(name).newInstance();
			Vehicle vehicle = (Vehicle)o;
			vehicle.move();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
	}

}
