package com.zmm.java.thread;

public class main {
	
	public static void main(String[] args) {
		
	}
	
}


class Timer{
	private static int num = 0;
	
	public void add(String name){
		num++;
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			System.out.println();
			e.printStackTrace();
		}
	}
	
}