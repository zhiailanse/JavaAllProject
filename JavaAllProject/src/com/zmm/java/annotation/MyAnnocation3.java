package com.zmm.java.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnocation3 {

	String hello() default "help";
	
	String world() default "run";
	
}
