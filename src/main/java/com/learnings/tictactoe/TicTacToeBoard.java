package com.learnings.tictactoe;

import java.util.HashMap;
import java.util.Map;

public class TicTacToeBoard {

	private final Integer rows;
	private Map<Position, Token> tokenMap;

	public TicTacToeBoard(final Integer rows, final Integer columns) {
		this.rows = rows;
		tokenMap = new HashMap<Position, Token>(rows * columns, 1.0F);
	}

	public Integer getRows() {
		return rows;
	}

	public void place(final Token token, final Position position) {
		if (tokenMap.containsKey(position)) {
			throw new TokenAlreadyPresentException();
		}
		tokenMap.put(position, token);
	}

	public Token getToken(Position position) {
		return tokenMap.get(position);
	}

}
	