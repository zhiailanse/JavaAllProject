package com.zmm.java.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface MyTarget {
	

	String value();
	
}
