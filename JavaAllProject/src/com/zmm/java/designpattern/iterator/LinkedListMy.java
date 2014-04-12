package com.zmm.java.designpattern.iterator;

public class LinkedListMy implements Iterable{
	int index = 0;
	Node head = null;
	Node tail = null;
	
	public void add(Object o){
		Node n = new Node(null, o);
		if(head == null){
			head = n;
			tail = n;
		}
		tail.next = n;
		index ++;
	}
	
	public int size(){
		return index;
	}
	
	private class MyIterator implements IteratorMy{

		int curIndex = 0;
		@Override
		public boolean hasNext() {
			if(curIndex >= index){
				return false;
			}
			return true;
		}

		@Override
		public Object next() {
			
			return null;
		}
		
	}

	@Override
	public IteratorMy iterator() {
		return new MyIterator();
	}
	
}
