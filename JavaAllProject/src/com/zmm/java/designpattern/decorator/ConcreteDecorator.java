package com.zmm.java.designpattern.decorator;

public class ConcreteDecorator extends Decorator{

	public ConcreteDecorator(Component component) {
		super(component);
	}
	
	@Override
	public void operation() {
		this.addedOperation();
		super.operation();
	}

	public void addedOperation(){
		System.out.println("晚上");
	}
}
