package com.c4j.account;

import de.vksi.c4j.ContractReference;
import de.vksi.c4j.Pure;

/**
 * 
 * @author leoky
 *
 */
@ContractReference(AccountContract.class)
public class Account {

	public static final int MIN_BALANCE = 0;
	public static final int MAX_BALANCE = 100000;//Integer.MAX_VALUE;
	
	private int balance;
	private int previousBalance;
	
	/**
	 * 
	 * @param balance
	 */
	public Account(){
	}
	
	/**
	 * 
	 * @param balance
	 */
	public Account(int balance){
		this.balance = balance;
	}
	
	public void addToAccount(int ammount){
		previousBalance = balance;
		balance += ammount;
		System.out.println(ammount + " will be added");
	}
	
	public void withdrawFromAccount(int ammount){
		previousBalance = balance;
		balance -= ammount;
		System.out.println(ammount + " will be withdrawed");
	}
	
	public void initAccount(int ammount){
		balance = ammount;
	}
	
	/**
	 * 
	 */
	public void displayBalance(){
		System.out.println("The balance is now " + getBalance() + "\n");
	}

	
	@Pure
	public int getBalance() {
		return balance;
	}

	/**
	 * 
	 * @param balance
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	@Pure
	public int getPreviousBalance() {
		return previousBalance;
	}

	
	
	
}
