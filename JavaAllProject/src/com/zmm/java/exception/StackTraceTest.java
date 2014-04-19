package com.zmm.java.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class StackTraceTest {

	/**
	 * @param args
	 * A Program that displays a trace of a recursive(递归 ) method call
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter n: ");
		int input = s.nextInt();
		int n = input;
		int result = factorial(n);
		System.out.println(result);
	}
	
	/**
	 * computes the factorial of a number
	 * @param n a nonnegative integer
	 * @return n! = 1*2*3*...*n
	 */
	public static int factorial(int n){
		System.out.println("factorial(" + n + ");");
		Throwable t = new Throwable();
		StackTraceElement[] frames = t.getStackTrace();
		for(StackTraceElement f : frames){
			System.out.println(f);
		}
		int r;
		if(n <= 1)
		{
			r = 1;
		}else{
			r = n * factorial(n - 1);
		}
		return r;
	}

}
