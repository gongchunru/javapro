package com.gchr.staticProxy2;

public class FontProviderFromNet implements FontProvider {

	@Override
	public Font getFont(String name) {
		return new Font(name,2);
	}

}
