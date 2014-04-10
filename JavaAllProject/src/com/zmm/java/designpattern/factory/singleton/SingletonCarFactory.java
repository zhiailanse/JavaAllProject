package com.zmm.java.designpattern.factory.singleton;

import com.zmm.java.designpattern.factory.Car;

public class SingletonCarFactory {
	private static Car car = new Car();
	
	private SingletonCarFactory(){
	}
	
	public static synchronized Car getInstance(){
		return car;
	}
}
