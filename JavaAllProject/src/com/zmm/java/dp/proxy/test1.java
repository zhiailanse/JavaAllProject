package com.zmm.java.dp.proxy;

public class test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String fileName = System.getProperty("user.dir");
		System.out.println(fileName);
		
	}
	String rt = "\r\n";
	String src = 
	"package com.zmm.java.dp.proxy;" + rt +
	"  public class PlussLogMoveable implements Moveable {" + rt +
		"  Moveable moveable;" + rt +
		"  public PlussLogMoveable(Moveable moveable) {" + rt +
			"  this.moveable = moveable;" + rt +
		"  }" + rt +
		"@Override" + rt +
		"  public void move() {" + rt +
			"  System.out.println(\"begin loging ...\");" + rt +
			"  moveable.move();" + rt +
			"  System.out.println(\"Loging finish.\");" + rt +
		" }" + rt +
	"}" ;

			
}
