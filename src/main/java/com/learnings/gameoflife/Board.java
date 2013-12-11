package com.learnings.gameoflife;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Board {
	private int size;
	private Map<Position, String> liveCellMapPattern;
	private Position currentPosition;

	public Board(int size) {
		this.size = size;
		this.liveCellMapPattern = new HashMap<Position, String>();
	}

	public void place(Position position,String liveCell) {
		validate(position, liveCell);
		currentPosition = position;
		liveCellMapPattern.put(position, liveCell);
		computeNextGen();
	}

	public String subString(int row,int initialCol,int lastCol){
		return liveCellMapPattern.get(new Position(row, initialCol))+""+liveCellMapPattern.get(new Position(row, lastCol));
	}

	public void computeNextGen() {
		for(int row=0; row<size ;row++){
			for(int col=0;col<size;col++){
				String above = "";
				String same = "";
				String below = "";
				if(col == 0) {
					above = (row == 0) ? null : subString(row -1 , col, col+1);
					same = liveCellMapPattern.get(new Position(row, col+1));
					below = (row == size - 1) ? null : subString(row+1, col, col+1);
				}else if(col == size-1){
					above = (row == 0) ? null : subString(row-1, col-1, col);
					same = liveCellMapPattern.get(new Position(row, col-1));
					below = (row == size - 1) ? null : subString(row+1, col-1, col);
				}else{
					above = (row == 0) ? null : subString(row-1, col-1, col)+""+liveCellMapPattern.get(new Position(row-1, col+1));
					same = subString(row, col-1, col+1);
					below = (row == size - 1) ? null : subString(row+1, col-1, col)+""+liveCellMapPattern.get(new Position(row+1, col+1));
				
				}
				System.out.println("Above :"+above);
				System.out.println("Same :"+same);
				System.out.println("Below :"+below);
				
			}
		}
		
	}
	public static int getNeighbors(String above, String same, String below) {
		int count = 0;
		if (above != null) {
			for (char x : above.toCharArray()) {
				if (x == 'L')
					count++;
			}
		}
		for (char x : same.toCharArray()) {
			if (x == 'L')
				count++;
		}
		if (below != null) {
			for (char x : below.toCharArray()) {
				if (x == 'L')
					count++;
			}
		}
		return count;
	}
	
	public void updateGen(){
		
	}
	
	private void validate(Position position,String token) {
		if (isPlacementOutsideBoundaries(position)) throw new OutOfBoardSizeException();
	}
	private boolean isPlacementOutsideBoundaries(final Position position) {
		return position.getRow() >= size || position.getColumn() >= size;
	}
	public BoardState getBoardState(){
		return new BoardState();
	}
	
	

	public class BoardState {

		String getLiveCell(Position position) {
			return liveCellMapPattern.get(position);
		}

		Map<Position, String> getLiveCellMap() {
			return Collections.unmodifiableMap(liveCellMapPattern);
		}

		Integer getSize() {
			return size;
		}

		public boolean hasLiveCellAt(Position position) {
			return liveCellMapPattern.containsKey(position);
		}
	}
}
