package com.zmm.java.designpattern.commend;

public class HugCommand extends Command {

	@Override
	void execute() {
		System.out.println("hug me please !!!");
	}

	@Override
	void undo() {

	}

}
