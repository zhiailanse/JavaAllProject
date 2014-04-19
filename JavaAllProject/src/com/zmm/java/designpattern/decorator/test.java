package com.zmm.java.designpattern.decorator;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Component component = new ConcreteComponent();
		Decorator decorator = new ConcreteDecorator(component);
		decorator.operation();
	}

}
