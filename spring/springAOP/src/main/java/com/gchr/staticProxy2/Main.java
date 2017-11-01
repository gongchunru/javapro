package com.gchr.staticProxy2;

public class Main {
	public static void main(String[] args) {
		FontProvider fontProvider = ProviderFactory.getFontProviderFromDisk();
		Font font2 = fontProvider.getFont("华文");
		System.out.println(font2.toString());
	}
}
