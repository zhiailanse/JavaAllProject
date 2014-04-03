package com.zmm.java.dp.commend.copy;

public class ShoppingCommand extends Command {

	@Override
	void execute() {
		System.out.println("go shopping and buy something ...");
	}

	@Override
	void undo() {

	}

}
