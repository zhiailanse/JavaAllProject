package com.zmm.java.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationReflectionTest{

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		MyTest myTest = new MyTest();
		Class<MyTest> c = MyTest.class;
		Method method = c.getMethod("output", new Class[]{});
		
		if(method.isAnnotationPresent(MyAnnocation3.class)){
			method.invoke(myTest, new Object[]{});
			
			MyAnnocation3 myAnnocation3 = method.getAnnotation(MyAnnocation3.class);
			
			String hello = myAnnocation3.hello();
			String world = myAnnocation3.world();
			
			System.out.println(hello + "," + world);
		}
		
		Annotation[] annotations = method.getAnnotations();
		for(Annotation annotation : annotations){
			System.out.println(annotation.annotationType().getName());
		}
	}

}
