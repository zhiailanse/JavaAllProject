package com.zmm.java.designpattern.responsibilityChain.chain2;

import java.util.ArrayList;
import java.util.List;

public class ResponsibilityChain2 implements Filter {
	
	List<Filter> list = new ArrayList<Filter>();
	int index = 0;
	
	public ResponsibilityChain2 add(Filter filter){
		list.add(filter);
		return this;
	}

	@Override
	public void dofilter(Producer producer, Consumer consumer,ResponsibilityChain2 chain2) {
		if(index == list.size()){return;}
		Filter f = list.get(index);
		index++;
		f.dofilter(producer, consumer, chain2);
		
//		for(Filter filter : list){
//			filter.dofilter(producer, consumer,chain2);
//		}
	}

}
