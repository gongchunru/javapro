package com.gchr.staticProxy2;

//只用对工厂方法的代码进行修改，就可以达到目的，代码的使用处不必进行修改。
public abstract class ProviderFactory {
	public static FontProvider getFontProviderFromDisk(){
		return new FontProviderFromDisk();
	}
	
	public static FontProvider getFontProviderFromNet(){
		return new FontProviderFromNet();
	}
}
