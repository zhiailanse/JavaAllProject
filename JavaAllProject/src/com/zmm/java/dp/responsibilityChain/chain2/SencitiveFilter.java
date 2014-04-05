package com.zmm.java.dp.responsibilityChain.chain2;

public class SencitiveFilter implements Filter {

	@Override
	public void dofilter(Producer producer, Consumer consumer,ResponsibilityChain2 chain2) {
		producer.msg = producer.msg.replace("敏感", "不敏感");
		chain2.dofilter(producer, consumer, chain2);
		consumer.msg = consumer.msg.replace("被就业", "就业");
	}

}
