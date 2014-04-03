package com.zmm.java.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;

public class DocumentedTest {

	@DocumentedAnnotation(hello = "ll")
	public void method(){
		System.out.println("hello ...");
	}
	
}
