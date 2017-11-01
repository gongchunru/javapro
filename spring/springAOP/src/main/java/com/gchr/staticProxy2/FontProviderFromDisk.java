package com.gchr.staticProxy2;

public class FontProviderFromDisk implements FontProvider {
	@Override
	public Font getFont(String name) {
		return new Font(name, 1);
	}
}
