package com.zmm.java.designpattern.strategy;

public class Cat implements MyComparable{

	int age;
	
	public Cat(int age) {
		super();
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Cat [age=" + age + "]";
	}

	@Override
	public int compareTo(Object m) {
		if(m instanceof Cat){
			Cat c = (Cat) m;
			if(this.age < c.age){
				return 1;
			}else if(this.age > c.age){
				return -1;
			}
		}
		return 0;
	}

}
