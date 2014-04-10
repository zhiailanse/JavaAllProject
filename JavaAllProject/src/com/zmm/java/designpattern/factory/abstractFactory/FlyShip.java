package com.zmm.java.designpattern.factory.abstractFactory;

import com.zmm.java.designpattern.factory.Vehicle;

public class FlyShip implements Vehicle {

	@Override
	public void move() {
		System.out.println("FlyShip is flying...");
	}

}
