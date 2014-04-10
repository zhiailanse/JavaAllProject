package com.zmm.java.designpattern.factory.abstractFactory;

import com.zmm.java.designpattern.factory.Food;
import com.zmm.java.designpattern.factory.Vehicle;
import com.zmm.java.designpattern.factory.Weapen;

public abstract class AbstractFactory {
	abstract Food createFood();
	
	abstract Vehicle createVehicle();
	
	abstract Weapen createWeapen();
}
