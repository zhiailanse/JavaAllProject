package com.zmm.java.dp.factory.simpleFactory;

import com.zmm.java.dp.factory.Buss;
import com.zmm.java.dp.factory.Vehicle;

public class BussFactory implements VehicleFactory {

	@Override
	public Vehicle Create() {
		return new Buss();
	}

}
