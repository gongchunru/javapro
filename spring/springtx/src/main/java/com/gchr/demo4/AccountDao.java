package com.gchr.demo4;

public interface AccountDao {
	
	/**
	 * 
	 * @param out 转出账户
	 * @param money
	 */
	public void outMoney(String out, double money);
	
	/**
	 * 
	 * @param in 转入账户
	 * @param money 金钱
	 */
	public void inMoney(String in, double money);
	
}
