package com.zmm.java.designpattern.strategy;

public class Dog implements MyComparable{
	int age;
	
	private MyComparator myComparator = new DogComparator();

	public Dog(int age) {
		super();
		this.age = age;
	}

	@Override
	public int compareTo(Object m) {
//		if(m instanceof Dog){
//			Dog d = (Dog)m;
//			if(this.age > d.age){
//				return 1;
//			}else if(this.age < d.age){
//				return -1;
//			}
//		}
		return myComparator.compare(this, m);
	}

	@Override
	public String toString() {
		return "Dog [age=" + age + "]";
	}
	
}
