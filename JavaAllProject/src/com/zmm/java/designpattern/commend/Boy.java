package com.zmm.java.designpattern.commend;

import java.util.ArrayList;
import java.util.List;

public class Boy {
	
	List<Command> commands = new ArrayList<Command>();
	
	public Boy addCommand(Command command){
		commands.add(command);
		return this;
	}
	
	public void executeCommand(){
		for(Command c : commands){
			c.execute();
		}
	}

	String name = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
