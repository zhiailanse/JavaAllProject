package com.zmm.java.designpattern.responsibilityChain;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {
	
	List<Filter> list = new ArrayList<Filter>();
	
	public void add(Filter filter){
		list.add(filter);
	}
	
	public void remove(Filter filter){
		list.remove(filter);
	}

	@Override
	public String doFilter(String str) {
		String temp = str;
		for(Filter filter : list){
			temp = filter.doFilter(temp);
		}
		return temp;
	}

}
