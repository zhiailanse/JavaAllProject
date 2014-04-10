package com.zmm.java.designpattern.responsibilityChain;

public class SensitiveFilter implements Filter{

	@Override
	public String doFilter(String str) {
		String result;
		result = str.replace("草", "爱")
			.replace("操", "爱")
			.replace("草泥马", "我爱你")
			.replace("被就业", "就业")
			;
		return result;
	}

}
