package com.zmm.java.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class DataFileTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String path = System.getProperty("user.dir") + File.separator;
		String destFilePath = path + "employee.dat";
		
		Employee[] staff = new Employee[3];
		staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
		staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);
		
		try {
			//save all emplyees records to the file employee.dat
			PrintWriter out = new PrintWriter(new File(destFilePath));
			writeData(staff, out);
			out.close();
			
			BufferedReader in = new BufferedReader(new FileReader(destFilePath));
			Employee[] newStaff = readData(in);
			in.close();
			
			for(Employee e : newStaff){
				System.out.println(e);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * writes all employees in an array to a print writer
	 * @param employees
	 * @param out
	 * @throws IOException
	 */
	static void writeData(Employee[] employees,PrintWriter out)throws IOException{
		//write number of emplyees
		out.println(employees.length);
		
		for(Employee e : employees){
			e.writeData(out);
		}
	}
	
	/**
	 * Reads an array of employees form a buffered reader
	 * @param in the bufferd reader
	 * @return the array of employees
	 * @throws IOException
	 */
	static Employee[] readData(BufferedReader in)throws IOException{
		//retrieve the array size
		int n = Integer.parseInt(in.readLine());
		Employee[] employees = new Employee[n];
		for(int i = 0;i < employees.length;i++){
			employees[i] = new Employee();
			employees[i].readData(in);
		}
		return employees;
	}

}
