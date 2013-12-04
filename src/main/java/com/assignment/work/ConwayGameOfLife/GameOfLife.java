package com.assignment.work.ConwayGameOfLife;

public class GameOfLife {
	public static void main(String[] args) {
		String[] dish = { "_#_", "_#_", "_#_", };
		int gens = 3;
		for (int i = 0; i < gens; i++) {
			System.out.println("Generation " + i + ":");
			print(dish);
			dish = life(dish);
		}
	}

	public static String[] life(String[] dish) {
		String[] newGen = new String[dish.length];
		for (int row = 0; row < dish.length; row++) {
			newGen[row] = "";
			for (int i = 0; i < dish[row].length(); i++) {

				String above = "";
				String same = "";
				String below = "";
				if (i == 0) {
					
					above = (row == 0) ? null : dish[row - 1].substring(i,
							i + 2);
					same = dish[row].substring(i + 1, i + 2);
					
					below = (row == dish.length - 1) ? null : dish[row + 1]
							.substring(i, i + 2);
				} else if (i == dish[row].length() - 1) {
					
					above = (row == 0) ? null : dish[row - 1].substring(i - 1,
							i + 1);
					same = dish[row].substring(i - 1, i);
					
					
					below = (row == dish.length - 1) ? null : dish[row + 1]
							.substring(i - 1, i + 1);
				} else {
					above = (row == 0) ? null : dish[row - 1].substring(i - 1,
							i + 2);
					same = dish[row].substring(i - 1, i)
							+ dish[row].substring(i + 1, i + 2);
					
					below = (row == dish.length - 1) ? null : dish[row + 1]
							.substring(i - 1, i + 2);
				}
				int neighbors = getNeighbors(above, same, below);
				if (neighbors < 2 || neighbors > 3) {
					newGen[row] += "_";
				} else if (neighbors == 3) {
					newGen[row] += "#";
				} else {
					newGen[row] += dish[row].charAt(i);
				}
			}
		}
		return newGen;
	}

	public static int getNeighbors(String above, String same, String below) {
		int ans = 0;
		if (above != null) {
			for (char x : above.toCharArray()) {
				if (x == '#')
					ans++;
			}
		}
		for (char x : same.toCharArray()) {
			if (x == '#')
				ans++;
		}
		if (below != null) {
			for (char x : below.toCharArray()) {
				if (x == '#')
					ans++;
			}
		}
		return ans;
	}

	public static void print(String[] dish) {
		for (String s : dish) {
			System.out.println(s);
		}
	}
}
