package com.c4j.account;

import static de.vksi.c4j.Condition.ignored;
import static de.vksi.c4j.Condition.postCondition;
import static de.vksi.c4j.Condition.preCondition;
import static de.vksi.c4j.Condition.old;

import de.vksi.c4j.ClassInvariant;
import de.vksi.c4j.Target;

public class AccountContract extends Account {

	@Target
	private Account target;

	@ClassInvariant
	public void classInvariant() {
		assert target.getBalance() >= MIN_BALANCE : "balance >= MIN_BALANCE";
		assert target.getBalance() <= MAX_BALANCE : "balance <= MAX_BALANCE";
	}

	public AccountContract() {
		super();
	}

	public AccountContract(int balance) {
		super(balance);

		if (preCondition()) {
			assert balance >= MIN_BALANCE : "balance >= MIN_BALANCE";
			assert balance <= MAX_BALANCE : "balance <= MAX_BALANCE";
		}

		if (postCondition()) {
			assert target.getBalance() == balance : " balance set";
		}
	}

	@Override
	public void addToAccount(int ammount) {
		if (preCondition()) {
			assert ammount > MIN_BALANCE : "ammount > MIN_BALANCE";
			assert ammount <= MAX_BALANCE : "ammount <= MAX_BALANCE";
		}

		if (postCondition()) {
			assert target.getBalance() == old(target.getBalance())/*target.getPreviousBalance()*/ + ammount : "ammount added";
		}
	}

	public void withdrawFromAccount(int ammount) {
		if (preCondition()) {
			assert ammount > MIN_BALANCE : "ammount > MIN_BALANCE";
			assert ammount <= MAX_BALANCE : "ammount <= MAX_BALANCE";
			assert ammount <= target.getBalance() : " ammount <= currentbalance";
		}

		if (postCondition()) {
			assert target.getBalance() == old(target.getBalance())/*target.getPreviousBalance()*/ - ammount : "ammount withdrawed";
		}
	}

	public void initAccount(int ammount) {
		if (preCondition()) {
			assert ammount > MIN_BALANCE : "ammount > MIN_BALANCE";
			assert ammount <= MAX_BALANCE : "ammount <= MAX_BALANCE";
		}

		if (postCondition()) {
			assert target.getBalance() == ammount : "ammount added";
		}
	}

	@Override
	public int getBalance() {
		return ignored();
	}

	@Override
	public int getPreviousBalance() {
		return ignored();
	}
}
