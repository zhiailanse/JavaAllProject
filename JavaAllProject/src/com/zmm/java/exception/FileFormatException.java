package com.zmm.java.exception;

public class FileFormatException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FileFormatException() {
		
	}
	
	FileFormatException(String gripe){
		super(gripe);
	}
}
