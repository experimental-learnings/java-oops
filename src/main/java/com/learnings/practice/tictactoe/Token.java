package com.learnings.practice.tictactoe;

public class Token {

	private String currentToken;

	public Token(String string) {
		this.currentToken = string;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((currentToken == null) ? 0 : currentToken.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Token other = (Token) obj;
		if (currentToken == null) {
			if (other.currentToken != null)
				return false;
		} else if (!currentToken.equals(other.currentToken))
			return false;
		return true;
	}

	public String getCurrentToken() {
		return currentToken;
	}

}
