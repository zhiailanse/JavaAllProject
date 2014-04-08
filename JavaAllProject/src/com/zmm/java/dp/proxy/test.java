package com.zmm.java.dp.proxy;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tank tank = new Tank();
		MeasureTimeMoveable measureTimeMoveable = new MeasureTimeMoveable(tank);
		PlussLogMoveable plussLogMoveable = new PlussLogMoveable(measureTimeMoveable);
		plussLogMoveable.move();
	}

}
