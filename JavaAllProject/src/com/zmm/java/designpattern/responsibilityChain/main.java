package com.zmm.java.designpattern.responsibilityChain;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "草泥马,操,.-----------";
		
		FilterChain chain = new FilterChain();
		SymbolFilter symbolFilter = new SymbolFilter();
		SensitiveFilter sensitiveFilter = new SensitiveFilter();
		chain.add(sensitiveFilter);
		chain.add(symbolFilter);
		
		MsgOperation msgOperation = new MsgOperation(chain);
		s = msgOperation.doFilter(s);
		
		System.out.println(s);
	}

}
