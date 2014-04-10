package com.zmm.java.designpattern.strategy;

public class DataSorter {
	
	public static void sort(Object[] a){
		for(int i = 0;i < a.length;i++){
			for(int j = i;j < a.length;j++){
				MyComparable a1 = (MyComparable) a[i];
				MyComparable a2 = (MyComparable) a[j];
				if(a1.compareTo(a2) > 0){
					
					swap(a,i,j);
				}
			}
			System.out.println(a[i]);
		}
	}
	
	public static void swap(Object[] o,int i,int j){
		Object temp;
		temp = o[i];
		o[i] = o[j];
		o[j] = temp;
	}
	
	public static void printArray(Object[] a){
		for(int i = 0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}
	
}
