package com.zmm.java;

import java.lang.ref.SoftReference;
import java.util.HashMap;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		System.out.println(Math.sqrt(8));
		
		HashMap<String, SoftReference<String>> cache = new HashMap<String, SoftReference<String>>();
		
		int x = 5;
		changeX(x);
		
		System.out.println(x);
	}
	
	public static int changeX(int x){
		x = 3;
		return x;
	}

}
