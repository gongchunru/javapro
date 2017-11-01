package com.gchr.staticProxy2.dynamicProxy;

import com.gchr.staticProxy2.FontProvider;
import com.gchr.staticProxy2.FontProviderFromDisk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;



public abstract class ProviderFactory {
	public static FontProvider getFontProvider(){
		Class<FontProvider> targetClass = FontProvider.class;
		InvocationHandler h = new CachedProviderHandler(new FontProviderFromDisk());
		FontProvider fontProvider = (FontProvider) Proxy.newProxyInstance(targetClass.getClassLoader(), new Class[]{targetClass}, h);
		return fontProvider;
	}
}
