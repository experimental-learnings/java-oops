package com.assignment.work;

public class StackOverflowEx {
	static int i = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		methodA();
	}

	private static void methodA() {
		if(i++ > 100) throw new RuntimeException();
		methodB();
	}

	private static void methodB() {
		methodA();
	}

}
