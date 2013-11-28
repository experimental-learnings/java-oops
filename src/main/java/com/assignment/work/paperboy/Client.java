package com.assignment.work.paperboy;

public class Client {
	private Wallet wallet = new Wallet();

	private final String name;

	public Client(String name) {
		this.name = name;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public float pay(float collectionMoney) {
		if (wallet.hasSufficientFund(collectionMoney)) {
			return wallet.dispenseCash(collectionMoney);
		}
		return (float) 0.0;

	}

}
