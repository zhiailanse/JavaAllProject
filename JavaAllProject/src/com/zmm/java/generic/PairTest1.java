package com.zmm.java.generic;

public class PairTest1 {

	/**
	 * 类型变量放在修饰符后面，返回类型前面
	 * @param args
	 */
	public static void main(String[] args) {
		String[] words = new String[]{"Mary","had","a","little","lamb"}; 
		Integer[] ints = new Integer[]{1,3,4,2,9};
		Pair<String> pair = ArrayAlg.minmax(words);
		System.out.println("min=" + pair.getFirst());
		System.out.println("max=" + pair.getSecond());
		
		System.out.println(ArrayAlg.getMiddle(words));
	}

}

class ArrayAlg{
	
	public static Pair<String> minmax(String[] a){
		if(a == null || a.length == 0){
			return null;
		}
		String min = a[0];
		String max = a[0];
		for(int i = 1;i < a.length;i++){
			if(min.compareTo(a[i]) > 0) min = a[i];
			if(max.compareTo(a[i]) < 0) max = a[i];
		}
		
		return new Pair<String> (min,max);
	}
	
	public static <T> T getMiddle(T[] a){
		
		return a[a.length/2];
	}
	
}
