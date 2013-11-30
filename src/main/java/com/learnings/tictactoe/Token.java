package com.learnings.tictactoe;

public class Token {
	private String currentToken;

	public Token(final String token) {
		this.currentToken = token;
	}

	public String getCurrentToken(){
		return  currentToken;
	}
	
}
