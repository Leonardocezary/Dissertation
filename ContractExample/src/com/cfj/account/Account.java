package com.cfj.account;
import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;

/**
 * 
 * @author leoky
 *
 */
public class Account {

	private int balance;
	
	public Account() {
	}
	
	@Requires({ "ammount > 0" })
	@Ensures({ "balance == ammount"})
	public Account(int ammount) {
		balance = ammount;
		System.out.println("The balance is now " + balance + "\n");
	}
	
	@Requires({ "ammount > 0" })
	@Ensures({ "balance > ammount", "balance == old (balance) + ammount"})
	public void addToAccount(int ammount){
		balance += ammount;
		System.out.println(ammount + " will be added");
	}
	
	@Requires({ "ammount > 0", "ammount < balance" })
	@Ensures({ "balance >= 0", "balance == old (balance) - ammount"})
	public void withdrawFromAccount(int ammount){
		balance -= ammount;
		System.out.println(ammount + " will be withdrawed");
	}
	
	@Requires({ "ammount > 0" })
	@Ensures({ "balance == ammount"})
	public void initAccount(int ammount){
		balance = ammount;
		System.out.println("The balance is now " + balance + "\n");
	}
	
	/**
	 * 
	 */
	public void displayBalance(){
		System.out.println("The balance is now " + balance + "\n");
	}
}
