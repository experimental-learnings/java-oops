package com.assignment.work.TicTacToe;

import java.util.Scanner;

public class GameMain {
	private Board board;
	private GameState currentState;
	private Seed currentPlayer;
	private static Scanner in = new Scanner(System.in);
	private static int size;

	public GameMain() {
		board = new Board(size);
		initGame();
		do {
			playerMove(currentPlayer);
			board.paintBoard();
			updateGameStatus(currentPlayer);
			gameResult(currentState);
			currentPlayer = (currentPlayer == Seed.CROSS) ? Seed.NOUGHT
					: Seed.CROSS;
		} while (currentState == GameState.PLAYING);
	}

	public void initGame() {
		board.clear();
		currentPlayer = Seed.CROSS;
		currentState = GameState.PLAYING;
	}

	public void gameResult(GameState State) {
		if (State == GameState.CROSS_WON) {
			System.out.println("'X' won! Bye!");
		} else if (State == GameState.NOUGHT_WON) {
			System.out.println("'O' won! Bye!");
		} else if (State == GameState.DRAW) {
			System.out.println("It's Draw! Bye!");
		}
	}

	public void playerMove(Seed theSeed) {
		boolean flag = false;
		do {
			if (theSeed == Seed.CROSS) {
				System.out.print("Player 1 sign 'X', enter your move (row[0-"
						+ (size - 1) + "] column[0-" + (size - 1) + "]): ");
			} else {
				System.out.print("Player 2 sign 'O', enter your move (row[0-"
						+ (size - 1) + "] column[0-" + (size - 1) + "]): ");
			}
			int row = in.nextInt();
			int col = in.nextInt();
			flag = board.moveValidate(row, col, theSeed);
		} while (!flag);

	}

	public void updateGameStatus(Seed theSeed) {
		if (board.hasWon(theSeed)) {
			currentState = (theSeed == Seed.CROSS) ? GameState.CROSS_WON
					: GameState.NOUGHT_WON;
		} else if (board.isDraw()) {
			currentState = GameState.DRAW;
		}
	}

	public static void main(String[] args) {
		System.out.println("Enter the board size you want to play");
		size = in.nextInt();
		new GameMain();
	}
}
