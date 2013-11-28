package com.assignment.work.paperboy;

public class Paperboy {

	private final String name;
	private float collectedMoney;

	public Paperboy(String name) {
		this.name = name;
	}

	public void collectMoney(Client[] clients, int collectionMoney) {
		// for (Client client : clients) {
		// float existing = client.getWallet().getMoney();
		// if(existing > collectionMoney){
		// collectedMoney += collectionMoney;
		// client.getWallet().setMoney(existing - collectionMoney);
		// } else{
		// throw new InsufficientFundException();
		// }
		//
		// }

		for (Client client : clients) {
			collectionMoney += client.pay(collectionMoney);
		}
	}

	public static void main(String[] args) {
		Client[] clients = new Client[1];
		clients[0] = new Client("Maggie");
		new Paperboy("Jack").collectMoney(clients, 10);
	}
}
