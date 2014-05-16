package com.zmm.java.stream;

import java.nio.charset.Charset;

public class javacode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String defaultCharsetName = Charset.defaultCharset().displayName();
		System.out.println(System.getProperty("file.encoding"));
		
	}

}
