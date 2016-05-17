package com.cfj.account.main;
import com.cfj.account.Account;


public class Main {

	public static void main(String[] args) {
		
		Account myAccount = new Account(1);
		
		//myAccount.initAccount(1);
		
		myAccount.addToAccount(100);
		myAccount.displayBalance();
		
		myAccount.withdrawFromAccount(50);
		myAccount.displayBalance();
	}

}
