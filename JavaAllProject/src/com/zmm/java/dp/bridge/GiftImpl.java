package com.zmm.java.dp.bridge;

public abstract class GiftImpl implements Gift{
	
	protected Gift gift = null;
	
	public GiftImpl(Gift gift) {
		this.gift = gift;
	}

	public Gift getGift() {
		return gift;
	}

	public void setGift(Gift gift) {
		this.gift = gift;
	}
	
	
}
