package com.zmm.java.stream;

import java.nio.charset.Charset;
import java.util.Set;
import java.util.SortedMap;

public class CharsetTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Charset charset = Charset.forName("iso-8859-1");
		Charset charset = Charset.forName("gbk");
		Set<String> aliases = charset.aliases();
		for(String s : aliases){
//			System.out.println(s);
		}
		
		SortedMap<String, Charset> charsets = Charset.availableCharsets();
		for(String s : charsets.keySet()){
			System.out.println(s);
		}
	}

}
