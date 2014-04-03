package com.zmm.java.dp.state;

public class MM implements MMState{
	String name = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	MMState state = null;

	public MMState getState() {
		return state;
	}

	public void setState(MMState state) {
		this.state = state;
	}

	@Override
	public void cry() {
		if(state != null){
			state.cry();
		}
	}

	@Override
	public void smile() {
		if(state != null){
			state.smile();
		}
	}

	@Override
	public void sleep() {
		if(state != null){
			state.sleep();
		}
	}
	
	
}
