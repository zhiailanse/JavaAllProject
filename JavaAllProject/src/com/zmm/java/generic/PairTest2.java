package com.zmm.java.generic;

import java.util.GregorianCalendar;

public class PairTest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GregorianCalendar[] birthdays = {
				new GregorianCalendar(1906, 4, 9),
				new GregorianCalendar(1983, 3, 24),
				new GregorianCalendar(1999, 2, 1),
				new GregorianCalendar(1988, 6, 6)
		};
		Pair<GregorianCalendar> pair = ArrayAlg2.minmax(birthdays);
		System.out.println(pair.getFirst() + "-" + pair.getSecond());
		
	}

}
class ArrayAlg2{
	
	public static <T extends Comparable> Pair<T> minmax(T[] a){
		if(a == null || a.length == 0){
			return null;
		}
		T min = a[0];
		T max = a[0];
		for(int i = 0;i<a.length;i++){
			if(min.compareTo(a[i]) > 0) min = a[i];
			if(max.compareTo(a[i]) < 0) max = a[i];
		}
		return new Pair<T>(min, max);
	}
	
}

class MyComparale implements Comparable<MyComparale>{

	@Override
	public int compareTo(MyComparale o) {
		return 0;
	}
	
}
