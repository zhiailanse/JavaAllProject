package com.zmm.java.dp.bridge;

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
