package com.zmm.java.designpattern.iterator;


public class ArrayListMy implements Iterable{
	
	Object[] objects = new Object[10];
	
	int index = 0;
	
	public void add(Object o){
		if(index == objects.length){
			Object[] objects2 = new Object[objects.length * 2];
			System.arraycopy(objects, 0, objects2, 0, index);
			objects = objects2;
		}
		objects[index] = o;
		index++;
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
			Object result = objects[curIndex];
			curIndex++;
			return result;
		}
		
	}

	@Override
	public IteratorMy iterator() {
		return new MyIterator();
	}
	
}
