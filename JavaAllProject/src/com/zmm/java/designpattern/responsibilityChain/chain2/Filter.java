package com.zmm.java.designpattern.responsibilityChain.chain2;

public interface Filter {
	void dofilter(Producer producer,Consumer consumer,ResponsibilityChain2 chain);
}
