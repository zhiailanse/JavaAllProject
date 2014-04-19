package com.zmm.java.exception;

import java.util.Date;
import java.util.EmptyStackException;
import java.util.Stack;

public class ExceptionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 0;
		int ntry = 1000000;
		Stack<Integer> s = new Stack<Integer>();
		long s1;
		long s2;
		
		//test a stack for enptiness ntry times
		System.out.println("Testing for empty stack");
		s1 = new Date().getTime();
		for(i =0;i <= ntry;i++){
			if(!s.empty()){
				s.pop();
			}
		}
		s2 = new Date().getTime();
		System.out.println((s2 - s1) + " milliseconds");
		
		//pop an empty stack ntry times and catch the resulting exception
		System.out.println("Catching EmptyStackException");
		s1 = new Date().getTime();
		for(i = 0;i < ntry;i++){
			try {
				s.pop();
			} catch (EmptyStackException e) {
				e.printStackTrace();
			}
		}
		s2 = new Date().getTime();
		System.out.println((s2 - s1) + " milliseconds");
	}

}
