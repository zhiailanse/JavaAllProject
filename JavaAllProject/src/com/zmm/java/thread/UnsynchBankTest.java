package com.zmm.java.thread;

public class UnsynchBankTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Bank b = new Bank(100, 1000);
		int i = 0;
		for(i = 0;i < 10;i++){
			TransferRunnable r = new TransferRunnable(b, i, 1000);
			Thread t = new Thread(r);
			t.start();
		}
	}

}

class TransferRunnable implements Runnable{

	public TransferRunnable(Bank bank, int fromAccount, double maxAmount) {
		super();
		this.bank = bank;
		this.fromAccount = fromAccount;
		this.maxAmount = maxAmount;
	}
	@Override
	public void run() {
		try {
			while(true){
				int toAccount = (int) (bank.size() * Math.random());
				double amount = maxAmount * Math.random();
				bank.transfer(fromAccount, toAccount, amount);
				Thread.sleep((int)(DELAY * Math.random()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Bank bank;
	private int fromAccount;
	private double maxAmount;
	private int DELAY = 10;
	
}
