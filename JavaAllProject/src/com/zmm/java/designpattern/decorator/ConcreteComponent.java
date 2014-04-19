package com.zmm.java.designpattern.decorator;

public class ConcreteComponent implements Component{
	public ConcreteComponent(){
		
	}
	
	@Override
	public void operation() {
		System.out.println("开车");
	}

}
