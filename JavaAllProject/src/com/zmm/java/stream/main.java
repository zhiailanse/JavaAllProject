package com.zmm.java.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;


public class main {

	/**
	 * @param args
	 * the four abstract classes :
	 * InputStream,OutputStream;Reader,Writer;
	 * 
	 * interface-Appendable:writer() 
	 * 
	 * interface->DataInput->DataInputStream;RandomAccessFile;
	 * ..
	 * 
	 * @throws FileNotFoundException 
	 * 
	 */
	public static void main(String[] args) throws Exception {
		
//		InputStream is = new FileInputStream(new File(""));
		
		
		String dir = System.getProperty("user.dir");
		System.out.println(dir);
		
		InputStreamReader isr = new InputStreamReader(System.in);
		
		StringReader sr = new StringReader("sst");
		
	}
	
}
