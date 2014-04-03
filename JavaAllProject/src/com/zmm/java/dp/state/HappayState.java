package com.zmm.java.dp.state;

public class HappayState implements MMState {

	@Override
	public void cry() {
		System.out.println("hahaha,cry...");
	}

	@Override
	public void smile() {
		System.out.println("hahaha ,smile...");
	}

	@Override
	public void sleep() {
		System.out.println("miao....miao....!!!");
	}

}
