package com.zmm.java.stream;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

public class RandomFileTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path = System.getProperty("user.dir") + File.separator;
		String destFilePath = path + "employee2.dat";
		
		Employee[] staff = new Employee[3];
		staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
		staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);
		
		try {
			DataOutputStream out = new DataOutputStream(new FileOutputStream(destFilePath));
			for(Employee e : staff){
				e.writeData(out);
			}
			out.close();
			
			//retrieve all records into a new array
			RandomAccessFile in = new RandomAccessFile(destFilePath, "r");
			int n = (int)(in.length()/Employee.RECORD_SIZE);
			Employee[] newStaff = new Employee[n];
			
			//read employees in reverse order
//			for(int i = n-1;i >= 0;i--){
//				newStaff[i] = new Employee();
//				in.seek(i * Employee.RECORD_SIZE);
//				newStaff[i].readData(in);
//			}
			
			//read employees in order
			for(int i = 0;i < n;i++){
				newStaff[i] = new Employee();
				in.seek(i * Employee.RECORD_SIZE);
				newStaff[i].readData(in);
			}
			in.close();
			
			for(Employee e : newStaff){
				System.out.println(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
