package com.zmm.java.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
	private final double[] accounts;
	private Lock bankLock = new ReentrantLock();
	private Condition sufficientFunds;
	
	public Bank(int n,double initialBalance) {
		sufficientFunds = bankLock.newCondition();
		accounts = new double[n];
		for(int i = 0;i < n;i++){
			accounts[i] = initialBalance;
		}
	}
	
//	public synchronized void transfer(int from ,int to,double amount){
//	try {
//		System.out.print("--");
//		while(accounts[from] < amount) {
//			System.out.println("!!!!!!!!!!!" + Thread.currentThread() );
//			wait();
//		}
//		System.out.print(Thread.currentThread());
//		accounts[from] -= amount;
//		System.out.printf("%10.2f from %d to %d ",amount,from,to );
//		accounts[to] += amount;
//		System.out.printf("Total Balance: %10.2f%n",getTotalBalance());
//		notifyAll();
//	} catch (Exception e) {
//		e.printStackTrace();
//	}finally{
//		
//	}
//}
	
	public void transfer(int from ,int to,double amount){
		if(bankLock.tryLock()){
			bankLock.lock();
			try {
				if(accounts[from] < amount) {
					System.out.println(Thread.currentThread() + "await");
					sufficientFunds.await();
//					System.out.println("!!!!!!!!!!!");
				}
				System.out.print(Thread.currentThread());
				accounts[from] -= amount;
				System.out.printf("%10.2f from %d to %d",amount,from,to );
				accounts[to] += amount;
				System.out.printf("Total Balance: %10.2f%n",getTotalBalance());
				sufficientFunds.signalAll();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				bankLock.unlock();
			}
		}else{
			return;
		}
	}

	public Object getTotalBalance() {
		double sum = 0;
		for(double d : accounts){
			sum += d;
		}
		return sum;
	}
	
	public int size(){
		return accounts.length;
	}
	              
}
