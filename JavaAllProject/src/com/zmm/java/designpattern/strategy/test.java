package com.zmm.java.designpattern.strategy;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dog[] dogs = {new Dog(5),new Dog(2),new Dog(12),};
		Cat[] cats = {new Cat(5),new Cat(2),new Cat(12),};
		
		DataSorter.sort(dogs);
	}

}
