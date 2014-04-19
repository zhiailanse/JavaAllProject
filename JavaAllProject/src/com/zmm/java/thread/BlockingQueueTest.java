package com.zmm.java.thread;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path = System.getProperty("user.dir") + File.separator;
		String keyword = "a";
		
		final int FILE_QUEUE_SIZE = 10;
		final int SEARCH_THREADS = 100;
		
		BlockingQueue<File> queue = new ArrayBlockingQueue<File>(FILE_QUEUE_SIZE);
		
		FileEnumerationTask enumerator = new FileEnumerationTask(new File(path), queue);
		new Thread(enumerator).start();
		for(int i = 1;i <= SEARCH_THREADS;i++){
			new Thread(new SearchTask(queue, keyword)).start();
		}
	}
	
}

class FileEnumerationTask implements Runnable{

	public FileEnumerationTask(File startingDirectory, BlockingQueue<File> queue) {
		super();
		this.startingDirectory = startingDirectory;
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			enumerate(startingDirectory);
			queue.put(DUMMY);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void enumerate(File directory) throws InterruptedException{
		File[] files = directory.listFiles();
		for(File file : files){
			if(file.isDirectory()){
				enumerate(file);
			}else {
				queue.put(file);
			}
		}
		
	}
	
	public static File DUMMY = new File("");
	private File startingDirectory;
	private BlockingQueue<File> queue;
}

class SearchTask implements Runnable{

	public SearchTask(BlockingQueue<File> queue, String keyword) {
		super();
		this.queue = queue;
		this.keyword = keyword;
	}
	@Override
	public void run() {
		try {
			boolean done = false;
			while(!done){
				File file = queue.take();
				if(file == FileEnumerationTask.DUMMY){
					queue.put(file);
					done = true;
				}else{
					search(file);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void search(File file) throws IOException{
		Scanner in = new Scanner(new FileInputStream(file),"utf-16");
		int lineNumber = 0;
		while (in.hasNextLine()){
			lineNumber ++;
			String line = in.nextLine();
			if(line.contains(keyword)){
				System.out.printf("%s:%d:%s%n",file.getPath(),lineNumber,line);
			}
		}
		in.close();
	}
	
	private BlockingQueue<File> queue;
	private String keyword;
}
