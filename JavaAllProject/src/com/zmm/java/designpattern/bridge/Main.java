package com.zmm.java.designpattern.bridge;

public class Main {

	/**
	 * @param args
	 * 多个维度，排列组合,减少继承，减少耦合
	 */
	public static void main(String[] args) {
		Gift f = new CheepGift(new Pen());
		f.sendGift();
	}

}
