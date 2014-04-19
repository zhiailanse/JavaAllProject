package com.zmm.java.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class main {

	/**
	 * @param args
	 * class Throwable ->
	 * Error and Exception
	 * 
	 * Exception ->
	 * IOException and RuntimeException
	 * 
	 * RuntimeException:
	 * classCastException;ArrayIndexOutOfBoundsException;NullPointerException
	 * 
	 * IOException
	 * while read data from the end of a file;open a wrong url;reflect a wrong name of a class;
	 * 
	 * all implementations of RuntimeException and Error are called unchecked excepiton
	 * the others is called checked exception(IOException)
	 * 
	 * 
	 * “早抛出，晚捕获”
	 */
	public static void main(String[] args) {
//		File file = new File("");
//		try {
//			FileOutputStream fos = new FileOutputStream(file);
//		} catch (myIOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	class myIOException extends FileNotFoundException{
		
	}
	
	public static String getStackTrace(Throwable t){
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw,true);
		t.printStackTrace(pw);
		pw.flush();
		sw.flush();
		return sw.toString();
	}

}
