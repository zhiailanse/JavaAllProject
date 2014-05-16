package com.zmm.java.thread;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Thread life cycle : new,runnable,blocked,dead 
 * blocked: 
 * 1.sleeping
 * 2.IO blocked
 * 3.waiting a lock
 * 4.waiting a condition
 * 5.be suspend
 * 
 * volatile:保证域的安全
 * @author zhang
 *
 */
public class main {
	
	public static void main(String[] args) {
		ConcurrentHashMap<String, Integer> con = new ConcurrentHashMap<String, Integer>();
		
		ThreadGroup threadGroup = new ThreadGroup("my");
		String nameParent = threadGroup.getParent().getName();
		System.out.println(nameParent);
		System.out.println(threadGroup.getName());
		System.out.println("activeCount()="+threadGroup.getParent().activeCount());
		
		Thread threadMy = new Thread(new SleepRunnable());
		threadMy.setUncaughtExceptionHandler(new myExceptionHandler());
		threadMy.start();
//		threadMy.interrupt();
		Thread.setDefaultUncaughtExceptionHandler(new myExceptionHandler());
		
	}
	
}

class SleepRunnable implements Runnable{

	@Override
	public void run() {
		try {
			Thread.currentThread().sleep(1000);
			System.out.println("over");
			System.out.println(4/0);
		} catch (InterruptedException e) {
			System.out.println("interruped!!!");
			e.printStackTrace();
		}
	}
	
}

class myExceptionHandler implements Thread.UncaughtExceptionHandler{

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("333:" + e.getMessage());
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