package com.zmm.java.thread;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolTest {

	public static void main(String[] args) {
		String path = System.getProperty("user.dir") + File.separator + "src";
		String keyWord = "a";
		
		ExecutorService pool = Executors.newCachedThreadPool();
		
		MatchCounter counter = new MatchCounter(new File(path), keyWord, pool);
		Future<Integer> result = pool.submit(counter);
		
		try {
			System.out.println(result.get() + " matching files.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			pool.shutdown();
		}
		
		int largestPoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
		System.out.println("largest pool size =" + largestPoolSize);
	}
}

/**
 * This task counts the files in a directory and its sub directories that contain a given keyword
 * @author zhang
 * 
 */
class MatchCounter implements Callable<Integer>{

	public MatchCounter(File directory, String keyword, ExecutorService pool) {
		super();
		this.directory = directory;
		this.keyword = keyword;
		this.pool = pool;
	}

	@Override
	public Integer call() throws Exception {
		count = 0;
		try {
			File[] files = directory.listFiles();
			ArrayList<Future<Integer>> results = new ArrayList<Future<Integer>>();
			for(File file : files){
				if(file.isDirectory()){
					MatchCounter counter = new MatchCounter(file, keyword, pool);
					Future<Integer> result = pool.submit(counter);
					results.add(result);//Future 是一个包含线程的结果
				}else{
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
	
	private File directory ;
	private String keyword;
	private ExecutorService pool;
	private int count;
}