package com.zmm.java.designpattern.factory.simpleFactory;

import com.zmm.java.designpattern.factory.Buss;
import com.zmm.java.designpattern.factory.Vehicle;

public class BussFactory implements VehicleFactory {

	@Override
	public Vehicle Create() {
		return new Buss();
	}

}
