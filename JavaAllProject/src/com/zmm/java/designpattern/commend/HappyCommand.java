package com.zmm.java.designpattern.commend;

public class HappyCommand extends Command {

	@Override
	void execute() {
		System.out.println("miao ............miao .....");
	}

	@Override
	void undo() {

	}

}
