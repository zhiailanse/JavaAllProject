package com.zmm.java.enumMy;

public class LightTest {
	
	public static void main(String[] args) {
		//1.
		Light[] allLight = Light.values();
		for(Light aLight : allLight){
			System.out.println("当前灯 name : " + aLight.name());
			System.out.println("当前灯 ordinal : " + aLight.ordinal());
			System.out.println("当前灯：" + aLight);
		}
		
	}

	public enum Light{
		
		RED(1),GREEN(3),YELLOW(2);
		
		private int nCode;
		private Light(int _nCode){
			this.nCode = _nCode;
		}
		
		@Override
		public String toString() {
			return String.valueOf(this.nCode);
		}
		
	}
	
}
