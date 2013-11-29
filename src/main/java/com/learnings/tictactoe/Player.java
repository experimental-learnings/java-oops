package com.learnings.tictactoe;

import java.util.Scanner;

import com.assignment.work.TicTacToe.Seed;

public class Player {
	private String playerName;
	private String gameState;  
	private String currentPlayer;
	Scanner in  = new Scanner(System.in);
	

	public Player(final String name) {
		this.playerName = name;
	}
}

/*

	public void play(Player player1, Position position, Token token,TicTacToeBoard board) {
		do{
			board.place(token, position);
			board.paintBoard();
		    togglePlayer(player1);
		    token.toggleToken(token);
		}
		while(gameState!="Completed");

		
	}

	
	public void begin(Player player1, Position position, Token token, TicTacToeBoard board) {
		currentPlayer = "player1";
		gameState = "Playing";
		board.place(token, position);
		board.paintBoard();
		
	}
	
	public String togglePlayer(Player player1){
		currentPlayer = (currentPlayer.equalsIgnoreCase("player1")) ? "player2" : "player1";
		 return currentPlayer;
		
	}
	
	public void playerMove(Token token,Position position,TicTacToeBoard board) {
		boolean flag = false;
		do {
			if (token.equals("X")) {
				System.out.print("Player 1 sign 'X', enter your move (row[0-"
						+ (position.getRow() - 1) + "] column[0-" + (position.getRow() - 1) + "]): ");
			} else {
				System.out.print("Player 2 sign 'O', enter your move (row[0-"
						+ (position.getRow() - 1) + "] column[0-" + (position.getRow() - 1) + "]): ");
			}
			int row = in.nextInt();
			int col = in.nextInt();
			board.place(token,position);
			flag = true;
		} while (!flag);

	}

	
}
*/
