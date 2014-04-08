package com.zmm.java.dp.factory.simpleFactory;

import com.zmm.java.dp.factory.Car;
import com.zmm.java.dp.factory.Vehicle;

public class CarFactory implements VehicleFactory {

	@Override
	public Vehicle Create() {
		return new Car();
	}

}
