package com.zmm.java.designpattern.bridge.copy;

public class ExpensiveGift extends GiftImpl {

	public ExpensiveGift(Gift gift) {
		super(gift);
	}

	@Override
	public void sendGift() {
		System.out.print("I am an expensive gift : ");
		gift.sendGift();
	}


}
