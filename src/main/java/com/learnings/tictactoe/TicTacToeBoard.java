package com.learnings.tictactoe;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Iterator;

public class TicTacToeBoard {

	private final Integer size;
	private Map<Position, Token> tokenMap;
	private Map<String, String> playerTokenMap;
	private String currentPlayer="player1";
	private String previousPlayer;
	
	public TicTacToeBoard(final Integer rows, final Integer columns) {
		this.size = rows;
		tokenMap = new HashMap<Position, Token>(rows * columns, 1.0F);
		playerTokenMap = new HashMap<String, String>(2, 1.0F);
		playerTokenMap.put("player1", "X");
		playerTokenMap.put("player2", "O");
	}

	public Integer getRows() {
		return size;
	}

	public void place(final Token token, final Position position,String playerName) {
		currentPlayer = playerName;
		if(!(currentPlayer.equals(previousPlayer))){
			if(position.getRow()<size && position.getColumn()<size){
				if (tokenMap.containsKey(position)) {
					throw new TokenAlreadyPresentException();
				}
				tokenMap.put(position, token);
			}else{
				throw new OutOfBoardSizeException();
			}
		}else{
			throw new WrongPlayerException();	
		}
		previousPlayer = currentPlayer;
		currentPlayer = togglePlayer(currentPlayer);
	}
	
	public String togglePlayer(String player1){
		currentPlayer = (currentPlayer).equalsIgnoreCase("player1") ? "player2" : "player1";
		 return currentPlayer;
		
	}

	public void play(String playerName){
		
	}
	public void begin(){
		
	}
	// for rows
	public void checkHorizontalsWon(Position position,Token token){
		int row = position.getRow();
		int column = position.getColumn();

		if((tokenMap.get(new Position(row,column+1)).equals(tokenMap.get(new Position(row,column+2))))
				||
			(tokenMap.get(new Position(row,column-1)).equals(tokenMap.get(new Position(row,column-2))))
			    ||
			(tokenMap.get(new Position(row,column+1)).equals(tokenMap.get(new Position(row,column-1))))){
			
		}
		
	}
	
	 public void hasWon(){
		 
	 }
	 
	 public void hasDraw(){
		 
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
	
	public Token getToken(Position position) {
		return tokenMap.get(position);
	}

}