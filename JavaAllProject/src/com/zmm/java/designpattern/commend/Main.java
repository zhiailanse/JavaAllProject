package com.zmm.java.designpattern.commend;

public class Main {

	/**
	 * @param args
	 * 与观察者结构类似，但是语义上偏重于命令
	 */
	public static void main(String[] args) {
		MM mm = new MM();
		Boy me = new Boy();
		mm.order(me);
	}

}
