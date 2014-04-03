package com.zmm.java.dp.state.copy;

public class Main {

	/**
	 * @param args
	 * ��Ҫ����������ǿ��״̬����ͬ��״̬
	 */
	public static void main(String[] args) {
		MM mm = new MM();
		mm.setState(new BadState());
		mm.cry();
		mm.smile();
		mm.sleep();
	}

}
