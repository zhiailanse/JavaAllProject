package com.zmm.java.dp.commend;

public class MM {
	String name = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void order(Boy b){
		Command c1 = new ShoppingCommand();
		Command c2 = new HugCommand();
		Command c3 = new HappyCommand();
		b.addCommand(c1).addCommand(c2).addCommand(c3);
		b.executeCommand();
	}
	
}
