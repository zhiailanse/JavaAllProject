
package com.zmm.java.designpattern.factory.abstractFactory;

import com.zmm.java.designpattern.factory.Food;
import com.zmm.java.designpattern.factory.MagicStick;
import com.zmm.java.designpattern.factory.Vehicle;
import com.zmm.java.designpattern.factory.Weapen;

public class MagicFactory extends AbstractFactory {

	@Override
	Food createFood() {
		return new MushRoom();
	}

	@Override
	Vehicle createVehicle() {
		return new FlyShip();
	}

	@Override
	Weapen createWeapen() {
		return new MagicStick();
	}

}
