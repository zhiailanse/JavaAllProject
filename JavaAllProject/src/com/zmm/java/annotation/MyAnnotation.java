package com.zmm.java.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 
 * @author zhang
 * 如果直接继承java.long.annotation的话，此时它还只是一个接口，而不是一个annotation
 * 
 */
@Retention(RetentionPolicy.CLASS)
public @interface MyAnnotation {
	
	//此时必须写上属性名
	EnumTest value1();

	//当注解的属性名为value时，在对其赋值时可以不指定属性的名称而直接写上属性值即可
	String value() default "hello";
	
	String[] value2();
	
}

enum EnumTest{
	Hello,Workd,Welcome;
}
