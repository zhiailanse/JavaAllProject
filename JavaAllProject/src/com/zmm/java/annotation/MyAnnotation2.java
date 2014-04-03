package com.zmm.java.annotation;

import java.lang.annotation.Annotation;

/**
 * Annotation本身是一个接口，而不是一个注解
 * @author zhang
 *
 */
public class MyAnnotation2 implements Annotation{


	@Override
	public Class<? extends Annotation> annotationType() {
		// TODO Auto-generated method stub
		return null;
	}

}
