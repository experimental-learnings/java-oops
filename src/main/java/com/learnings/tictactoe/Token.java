package com.learnings.tictactoe;

public class Token {
	private Token XToken;
	private Token OToken;
	private Token currentToken;
	public Token(final String token) {
		//this.currentToken=token;
	}
	public Token(final Token token) {
		this.currentToken=token;
	}
	public Token toggleToken(Token currentToken){
		currentToken = (currentToken == XToken ? OToken : XToken);
		return currentToken;
		
		
	}

}
