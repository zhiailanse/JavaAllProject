package com.zmm.java.dp.responsibilityChain;

public class SymbolFilter implements Filter {

	@Override
	public String doFilter(String str) {
		String result ;
		result = str.replace("-", "_")
			.replace(".", "。")
			.replace(",", "，")
			;
		return result;
	}

}
