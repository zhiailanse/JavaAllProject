package com.zmm.java.dp.proxy;
public class PlussLogMoveable implements Moveable {
	Moveable moveable;
	public PlussLogMoveable(Moveable moveable) {
		this.moveable = moveable;
	}
	@Override
	public void move() {
		System.out.println("begin loging ...");
		moveable.move();
		System.out.println("Loging finish.");
	}
}
