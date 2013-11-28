package com.learnings.tictactoe;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Iterator;

public class TicTacToeBoard {

	private final Integer size;
	private Map<Position, Token> tokenMap;
	public TicTacToeBoard(final Integer rows, final Integer columns) {
		this.size = rows;
		tokenMap = new HashMap<Position, Token>(rows * columns, 1.0F);	
	}

	public Integer getRows() {
		return size;
	}

	public void place(final Token token, final Position position) {
		if(position.getRow()<size && position.getColumn()<size){
			if (tokenMap.containsKey(position)) {
				throw new TokenAlreadyPresentException();
			}
			tokenMap.put(position, token);
		}else{
			throw new OutOfBoardSizeException();
		}
	}

	public Token getToken(Position position) {
		return tokenMap.get(position);
	}
	
	public void paintBoard() {
		
		for (int row = 0; row < size; ++row) {
			for (int col = 0; col < size; ++col) {
				Iterator it = tokenMap.entrySet().iterator();
				while(it.hasNext()){
					Map.Entry<Position, Token> cellData= (Entry<Position, Token>) it.next();
					System.out.println(cellData.getValue());
				}
				if (col < size - 1)
					System.out.print("|");
			}
			System.out.println();
			if (row < size - 1) {
				System.out.println("----------------------------");
			}
		}
	
		
	}

	public void setTokenMap(Map<Position, Token> tokenMap) {
		this.tokenMap = tokenMap;
	}

}