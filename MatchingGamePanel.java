package app;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MatchingGamePanel extends JPanel{
	MatchingGame mg;
	int border = 2;
	int nextMove = 0;
	static int firstCardPicked = 1;
	static int secondCardPicked = 2;
	static int wrongPair = 3;
	static int rightPair = 4;
	
	
	public MatchingGamePanel() {
		mg = new MatchingGame();
		for (int i = 0; i < mg.gameField.length; i++) {
			for (int j = 0; j < mg.gameField[i].length; j++) {
				System.out.print(mg.gameField[i][j]);
			}
			System.out.println();
		}
	}
	
	public void playTurn(int x, int y) {
		
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		int width = getWidth()/4 - border;
		int height = getHeight()/3 - border;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 3; j++) {
				g.fillRect(border + i * (width + border), border + j * (height + border), width, height);
			}
		}
	}

}
