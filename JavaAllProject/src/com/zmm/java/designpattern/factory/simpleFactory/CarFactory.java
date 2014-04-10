package com.zmm.java.designpattern.factory.simpleFactory;

import com.zmm.java.designpattern.factory.Car;
import com.zmm.java.designpattern.factory.Vehicle;

public class CarFactory implements VehicleFactory {

	@Override
	public Vehicle Create() {
		return new Car();
	}

}
