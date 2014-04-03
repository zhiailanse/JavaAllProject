package com.zmm.java.annotation;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class test {

	/**
	 * @param args
	 * 当前方法和类上的警告会同时作用
	 * 
	 */
//	@SuppressWarnings({"unchecked","deprecation"})
	@SuppressWarnings(value={"unchecked","deprecation"})
	public static void main(String[] args) {
		
		Map map = new HashMap();
		map.put("first", "one");
		map.put("second", "two");
		
		Date date = new Date();
		System.out.println(date.toLocaleString());
		
		test myTest = new test();
		myTest.doSomeThing();
	}
	
	@MyAnnotation(value1 = EnumTest.Hello,value2={"11","rr"})
	public void valueTest(){
		
	}
	
	@SuppressWarnings("deprecation")
	public void tt(){
		Date date = new Date();
		System.out.println(date.toLocaleString());
	}
	
	@Override
	public String toString(){
		
		return null;
	}
	
	@Deprecated
	public void doSomeThing(){
		
	}

}
