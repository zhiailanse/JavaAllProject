package com.zmm.java.designpattern.bridge;

public class Pen implements Gift {

	@Override
	public void sendGift() {
		System.out.println(" I am a pen!!!");
	}

}
