package com.zmm.java.designpattern.proxy;

public class MeasureTimeMoveable implements Moveable {
	Moveable moveable;
	
	public MeasureTimeMoveable(Moveable moveable) {
		this.moveable = moveable;
	}

	@Override
	public void move() {
		long begin = System.currentTimeMillis();
		moveable.move();
		long end = System.currentTimeMillis();
		System.out.println("spend time is :" + (end - begin));
	}

}
