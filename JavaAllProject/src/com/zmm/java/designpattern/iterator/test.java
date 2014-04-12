package com.zmm.java.designpattern.iterator;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayListMy aListMy = new ArrayListMy();
		for(int i = 0;i < 15;i++){
			aListMy.add(i);
		}
		
		IteratorMy iteratorMy = aListMy.iterator();
		while(iteratorMy.hasNext()){
			System.out.println(iteratorMy.next());
		}
		
		
//		LinkedListMy linkedListMy = new LinkedListMy();
//		for(int i = 0;i<15;i++){
//			linkedListMy.add(new Object());
//		}
//		System.out.println(linkedListMy.size());
	}

}
