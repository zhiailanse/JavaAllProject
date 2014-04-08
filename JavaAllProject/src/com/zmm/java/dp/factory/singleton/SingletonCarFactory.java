package com.zmm.java.dp.factory.singleton;

import com.zmm.java.dp.factory.Car;

public class SingletonCarFactory {
	private static Car car = new Car();
	
	private SingletonCarFactory(){
	}
	
	public static synchronized Car getInstance(){
		return car;
	}
}
