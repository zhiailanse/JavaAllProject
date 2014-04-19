package com.zmm.java.stream;

public class SerialCloneTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Employee harry = new Employee("Harry Hacker", 335000, 1989, 10, 1);
		//clone harry
		Employee harry2 = (Employee) harry.clone();
		
		//mutate harry
		harry.raiseSalary(20);
		
		System.out.println(harry);
		System.out.println(harry2);
	}

}
