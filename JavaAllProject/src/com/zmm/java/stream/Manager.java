package com.zmm.java.stream;

public class Manager extends Employee{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private double bonus;
	private Employee secretary;

	public Employee getSecretary() {
		return secretary;
	}

	public void setSecretary(Employee secretary) {
		this.secretary = secretary;
	}

	public Manager(String name, double salary, int year, int month, int day) {
		super(name, salary, year, month, day);
		bonus = 0;
	}

	@Override
	public double getSalary() {
		double baseSalary = super.getSalary();
		return baseSalary + bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return super.toString()+"[bonus="+bonus+"]"+"[secretary" + secretary + "]";
	}
	
}
