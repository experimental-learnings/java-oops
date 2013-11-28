package com.assignment.work.TicTacToe;

import java.io.PrintStream;

public enum Seed {
	EMPTY {
		public void print(PrintStream out) {
			out.print("   ");
		}
	},
	CROSS {
		public void print(PrintStream out) {
			out.print(" X ");
		}
	},
	NOUGHT {
		public void print(PrintStream out) {
			out.print(" O ");
		}
	};

	public abstract void print(PrintStream out);

}