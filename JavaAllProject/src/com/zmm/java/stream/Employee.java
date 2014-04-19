package com.zmm.java.stream;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class Employee implements Serializable , Cloneable{
	
	
	
	@Override
	protected Object clone() {
		
		try {
			//save the object to a byte array
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(bout);
			out.writeObject(this);
			out.close();
			
			//read a clone of the object from the byte array
			ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
			ObjectInputStream in = new ObjectInputStream(bin);
			Object ret = in.readObject();
			in.close();
			
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int NAME_SIZE = 40;
	public static final int RECORD_SIZE = 2 * NAME_SIZE + 8 + 4 + 4 + 4;
	
	public void writeData(DataOutput out) throws IOException{
		DataIO.writeFixedString(name, NAME_SIZE, out);
		out.writeDouble(salary);
		
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(hireDay);
		out.writeInt(calendar.get(Calendar.YEAR));
		out.writeInt(calendar.get(Calendar.MONTH) +1);
		out.writeInt(calendar.get(Calendar.DAY_OF_MONTH));
	}
	
	public void readData(DataInput in) throws IOException{
		name = DataIO.readFixedString(NAME_SIZE, in);
		salary = in.readDouble();
		int y = in.readInt();
		int m = in.readInt();
		int d = in.readInt();
		GregorianCalendar calendar = new GregorianCalendar(y,m-1,d);
		hireDay = calendar.getTime();
	}
	
	public void writeData(PrintWriter out) throws IOException{
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(hireDay);
		out.println(name + "|"
				+ salary + "|"
				+ calendar.get(Calendar.YEAR) + "|"
				+ (calendar.get(Calendar.MONTH) + 1) + "|"
				+ calendar.get(Calendar.DAY_OF_MONTH));
	}
	
	public void readData(BufferedReader in) throws IOException{
		String s = in.readLine();
		StringTokenizer t = new StringTokenizer(s, "|");
		name = t.nextToken();
		salary = Double.parseDouble(t.nextToken());
		int y = Integer.parseInt(t.nextToken());
		int m = Integer.parseInt(t.nextToken());
		int d = Integer.parseInt(t.nextToken());
		GregorianCalendar calendar = new GregorianCalendar(y, m-1, d);
		hireDay = calendar.getTime();
	}
	
	private String name;
	private  double salary;
	private transient Date hireDay;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getHireDay() {
		return hireDay;
	}
	public void setHireDay(Date hireDay) {
		this.hireDay = hireDay;
	}
	public void raiseSalary(double byPercent){
		double raise = salary * byPercent /100;
		salary += raise;
	}
	public Employee(String name, double salary, int year,int month,int day) {
		super();
		this.name = name;
		this.salary = salary;
		GregorianCalendar calendar = new GregorianCalendar(year, month-1, day);
		this.hireDay = calendar.getTime();
	}
	
	public Employee() {}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", hireDay="
				+ hireDay + "]";
	}
	
}
