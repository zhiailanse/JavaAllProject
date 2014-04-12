package com.zmm.java.designpattern.bridge.sampleTwo;

public class client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MessageImplementor messageEmail = new MessageEmail();
		CommonMessage commonMessage = new CommonMessage(messageEmail);
		UrgencyMessage urgencyMessage = new UrgencyMessage(messageEmail);
		commonMessage.sendMessage("hello", "zhang");
		
		urgencyMessage.sendMessage("hello", "zhang");
		
		messageEmail.send("hello", "zhang");
	}

}
