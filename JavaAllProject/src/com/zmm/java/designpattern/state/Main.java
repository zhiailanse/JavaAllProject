package com.zmm.java.designpattern.state;

public class Main {

	/**
	 * @param args
	 * 与策略模式结构类似
	 */
	public static void main(String[] args) {
		MM mm = new MM();
		mm.setState(new BadState());
		mm.cry();
		mm.smile();
		mm.sleep();
	}

}
