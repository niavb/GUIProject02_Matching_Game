package app;

import java.util.*;

public class MatchingGame {
	public int[][] gameField = new int[3][4];
	
	public MatchingGame() {
		Stack<Integer> numbersToAdd = new Stack<Integer>();
		for (int i = 1; i < 7; i++) {
			numbersToAdd.add(i);
			numbersToAdd.add(i);
		}
		Collections.shuffle(numbersToAdd);
		for (int i = 0; i < gameField.length; i++) {
			for (int j = 0; j < gameField[i].length; j++) {
				gameField[i][j] = numbersToAdd.pop();
			}
		}
	}

}
