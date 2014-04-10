package com.zmm.java.designpattern.commend;

public class ShoppingCommand extends Command {

	@Override
	void execute() {
		System.out.println("go shopping and buy something ...");
	}

	@Override
	void undo() {

	}

}
