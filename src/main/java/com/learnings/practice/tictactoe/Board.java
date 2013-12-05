package com.learnings.practice.tictactoe;

import java.util.*;

import com.learnings.tictactoe.Position;
import com.learnings.tictactoe.Token;

public class Board {

	private Integer size;
	Map<Position, Token> tokenMap = new HashMap<Position, Token>();

	public Board(Integer size) {
		this.size = size;
	}

	public void place(Position position, Token token) {
		tokenMap.put(position, token);
	}

	public boolean hasTokenAt(Position position) {
		return tokenMap.containsKey(position);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result
				+ ((tokenMap == null) ? 0 : tokenMap.hashCode());
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
		Board other = (Board) obj;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (tokenMap == null) {
			if (other.tokenMap != null)
				return false;
		} else if (!tokenMap.equals(other.tokenMap))
			return false;
		return true;
	}

}
