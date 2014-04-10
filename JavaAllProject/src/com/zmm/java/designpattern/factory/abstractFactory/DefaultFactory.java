package com.zmm.java.designpattern.factory.abstractFactory;

import com.zmm.java.designpattern.factory.AK47;
import com.zmm.java.designpattern.factory.Apple;
import com.zmm.java.designpattern.factory.Buss;
import com.zmm.java.designpattern.factory.Car;
import com.zmm.java.designpattern.factory.Food;
import com.zmm.java.designpattern.factory.Vehicle;
import com.zmm.java.designpattern.factory.Weapen;

public class DefaultFactory extends AbstractFactory{

	@Override
	Food createFood() {
		return new Apple();
	}

	@Override
	Vehicle createVehicle() {
		return new Car();
	}

	@Override
	Weapen createWeapen() {
		return new AK47();
	}
	
}
