package com.zmm.java.stream;

import java.io.File;

public class FileDirectoriesTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		parse(new String[]{"D://"});
		
	}
	
	static void parse(String[] dir){
		try {
			File pathName = new File(dir[0]);
//			String[] fileNames = pathName.list(new ExtensionFiler("txt"));
			String[] fileNames = pathName.list();
			
			for(int i = 0;i < fileNames.length;i++){
				File f = new File(pathName.getPath(), fileNames[i]);
				
				//if the file is again a directory ,call the main method recursively
				if(f.isDirectory()){
					System.out.println(f.getCanonicalPath());
					parse(new String[]{f.getPath()});
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
