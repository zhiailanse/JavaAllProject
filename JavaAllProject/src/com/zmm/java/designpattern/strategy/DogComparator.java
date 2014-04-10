package com.zmm.java.designpattern.strategy;

public class DogComparator implements MyComparator {

	@Override
	public int compare(Object o1,Object o2) {
		if(o1 instanceof Dog && o2 instanceof Dog){
			Dog d1 = (Dog) o1;
			Dog d2 = (Dog) o2;
			if(d1.age > d2.age){
				return -1;
			}else if(d1.age < d2.age){
				return 1;
			}
		}
		return 0;
	}

}
