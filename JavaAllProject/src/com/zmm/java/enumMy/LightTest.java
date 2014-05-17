package com.zmm.java.enumMy;

import java.util.EnumMap;
import java.util.EnumSet;

public class LightTest {
	
	public static void main(String[] args) {
		
//		testEnumMap();
		testEnumSet();
	}
	
	public static void testEnumSet() {
		EnumSet<Light> currEnumSet = EnumSet.allOf(Light.class);
		for(Light aLightSetElement : currEnumSet) {
			System.out.println("当前EnumSet中数据位: " + aLightSetElement);
		}
	}
	
	public static void testEnumMap() {
		EnumMap<Light, String> currEnumMap = new EnumMap<LightTest.Light, String>(Light.class);
		currEnumMap.put(Light.RED, "红灯");
		currEnumMap.put(Light.GREEN, "绿灯");
		currEnumMap.put(Light.YELLOW, "黄灯");
		
		for(Light aLight : Light.values()){
			System.out.println("[key=" + aLight.name() + ",value=" + currEnumMap.get(aLight) + "]");
		}
	}
	
	public static void testTraversalEnum() {
		//1.枚举类型的遍历
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
