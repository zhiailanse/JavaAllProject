package com.zmm.java.thread;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String keyword = "a";
		String path = System.getProperty("user.dir") + File.separator + "src";
		
		MatchCounterFuture counter = new MatchCounterFuture(new File(path), keyword);
		FutureTask<Integer> task = new FutureTask<Integer>(counter);
		Thread t = new Thread(task);
		t.start();
		
		try {
			System.out.println(task.get() + " matching files.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

//class MyFileFilter implements FileFilter{
//	@Override
//	public boolean accept(File pathname) {
//		System.out.println(pathname.getName());
//		if(pathname.getName().endsWith(".java")){
//			return true;
//		}
//		return false;
//	}
//}

class MatchCounterFuture implements Callable<Integer>{

	public MatchCounterFuture(File directory, String keyword) {
		super();
		this.directory = directory;
		this.keyword = keyword;
	}
	@Override
	public Integer call() throws Exception {
		count = 0;
		try {
			File[] files = directory.listFiles();
			ArrayList<Future<Integer>> results = new ArrayList<Future<Integer>>();
			
			for(File file : files){
				if(file.isDirectory()){
					MatchCounterFuture counter = new MatchCounterFuture(file, keyword);
					FutureTask<Integer> task = new FutureTask<Integer>(counter);//callable converts to runnable
					results.add(task);
					Thread t = new Thread(task);
					t.start();
				}else{
//					if(file.getName().endsWith(".java")){
//						if(search(file)) count++;
//					}
					if(search(file)) count++;
				}
			}
			for(Future<Integer> result : results){
				try {
					count += result.get();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public boolean search(File file){
		try {
			Scanner in = new Scanner(file);
			boolean found = false;
			while(in.hasNextLine() && !found){
				String line = in.nextLine();
				if(line.contains(keyword)){
					System.out.println(file.getName());
					found = true;
				}
			}
			in.close();
			return found;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	private File directory;
	private String keyword;
	private int count;
}
