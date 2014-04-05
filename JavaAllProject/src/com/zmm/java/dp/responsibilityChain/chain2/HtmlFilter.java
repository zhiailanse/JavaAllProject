package com.zmm.java.dp.responsibilityChain.chain2;

public class HtmlFilter implements Filter{

	@Override
	public void dofilter(Producer producer, Consumer consumer,ResponsibilityChain2 chain2) {
		producer.msg = producer.msg.replace("-", "_");
		chain2.dofilter(producer, consumer, chain2);
		consumer.msg = consumer.msg.replace("[", "{");
	}

}
