package com.zmm.java.designpattern.bridge.sampleTwo;

public class CommonMessage extends AbstractMessage {

	public CommonMessage(MessageImplementor impl) {
		super(impl);
	}
	
	@Override
	public void sendMessage(String message, String toUser) {
		super.sendMessage(message, toUser);
	}

}
