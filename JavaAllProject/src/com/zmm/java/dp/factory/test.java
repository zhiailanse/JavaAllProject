package com.zmm.java.dp.factory;

import com.zmm.java.dp.factory.simpleFactory.BussFactory;
import com.zmm.java.dp.factory.simpleFactory.VehicleFactory;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		VehicleFactory factory = new BussFactory();
		Vehicle vehicle = factory.Create();
		vehicle.move();
	}

}
