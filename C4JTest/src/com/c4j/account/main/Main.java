package com.c4j.account.main;

import com.c4j.account.Account;

public class Main {

	
	/**
	 * 
	 * @param args
	 */
	public static void main (String[] args){
		
		Account myAccount = new Account();
		
		myAccount.initAccount(1);
		
		myAccount.addToAccount(100);
		myAccount.displayBalance();
		
		myAccount.withdrawFromAccount(50);
		myAccount.displayBalance();
	}
}
