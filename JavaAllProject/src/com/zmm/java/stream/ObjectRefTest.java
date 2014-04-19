package com.zmm.java.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectRefTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path = System.getProperty("user.dir") + File.separator;
		String destFilePath = path + "employeeObjectRef.dat";
		
		Employee harry = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
		boss.setBonus(5000);
		boss.setSecretary(harry);
		
		Employee[] staff = new Employee[3];
		staff[0] = boss;
		staff[1] = harry;
		staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);
		
		try {
			//save all employee records to the file employeeRef.dat
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(destFilePath));
			out.writeObject(staff);
			out.close();
			
			//retrive all records into a new array
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(destFilePath));
			Employee[] newStaff = (Employee[]) in.readObject();
			in.close();
			
			newStaff[1].raiseSalary(10);
			
			for(Employee e : newStaff){
				System.out.println(e);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
