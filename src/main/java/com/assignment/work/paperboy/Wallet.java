package com.assignment.work.paperboy;

public class Wallet {
	private float money = 100;

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public float dispenseCash(float cash) {
		if(hasSufficientFund(cash)){
			money -= cash;
			return cash;
		} else{
			throw new InsufficientFundException();
		}
	}

	public boolean hasSufficientFund(float cash) {
		return money > cash;
	}
	
}
