package com.zmm.java.dp.state;

public class BadState implements MMState {

	@Override
	public void cry() {
		System.out.println("cry ....a----");
	}

	@Override
	public void smile() {
		System.out.println("bad ..smile....");
	}

	@Override
	public void sleep() {
		System.out.println("get out!!!!!!!!!!!!");
	}

}
