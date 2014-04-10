package com.zmm.java.designpattern.bridge.copy;

public class Main {

	/**
	 * @param args
	 * }��ά�ȣ�������ϣ�bridge
	 */
	public static void main(String[] args) {
		Gift f = new CheepGift(new Pen());
		f.sendGift();
	}

}
