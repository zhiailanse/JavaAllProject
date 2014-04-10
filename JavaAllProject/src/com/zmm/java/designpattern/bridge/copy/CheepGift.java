
package com.zmm.java.designpattern.bridge.copy;

public class CheepGift extends GiftImpl {

	public CheepGift(Gift gift) {
		super(gift);
	}

	@Override
	public void sendGift() {
		System.out.print("I am a cheep gift : ");
		gift.sendGift();
	}

}