package com.zmm.java.dp.responsibilityChain;

public class MsgOperation implements Filter{
	
	private String result = null;
	
	FilterChain chain;

	public MsgOperation(FilterChain chain) {
		this.chain = chain;
	}
	
	@Override
	public String doFilter(String str) {
		result = chain.doFilter(str);
		return result;
	}
	
	
}
