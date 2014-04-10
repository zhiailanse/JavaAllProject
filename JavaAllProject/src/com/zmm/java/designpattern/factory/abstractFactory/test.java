package com.zmm.java.designpattern.factory.abstractFactory;

import com.zmm.java.designpattern.factory.Food;
import com.zmm.java.designpattern.factory.Vehicle;
import com.zmm.java.designpattern.factory.Weapen;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractFactory factory = new MagicFactory();
		Food food = factory.createFood();
		food.pringName();
		Vehicle vehicle = factory.createVehicle();
		vehicle.move();
		Weapen weapen = factory.createWeapen();
		weapen.shoot();
	}

}
