package com.zmm.java.dp.responsibilityChain.chain2;

public class test {

	/**
	 * @param args
	 * 如果要求处理的顺序的话，先处理producer的信息，回来再处理consumer的信息
	 */
	public static void main(String[] args) {
		ResponsibilityChain2 chain = new ResponsibilityChain2();
		HtmlFilter htmlFilter = new HtmlFilter();
		SencitiveFilter sencitiveFilter = new SencitiveFilter();
		
		chain.add(htmlFilter).add(sencitiveFilter);
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		
		System.out.println(producer.msg + "?" + consumer.msg);
		
		chain.dofilter(producer, consumer,chain);
		System.out.println(producer.msg + "?" + consumer.msg);
	}

}
