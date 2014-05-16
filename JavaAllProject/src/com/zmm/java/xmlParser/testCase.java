package com.zmm.java.xmlParser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;

public class testCase extends TestCase{
	
	public void testXMLparser(){
		InputStream input = this.getClass().getClassLoader().getResourceAsStream("books.xml");
		System.out.println(input);
		List<Book> lists = new ArrayList<Book>();
		try {
			lists = BooksXMLParser.parse(input);
			for(Book book : lists){
				System.out.println(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
