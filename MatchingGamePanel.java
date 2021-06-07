package app;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MatchingGamePanel extends JPanel {
	MatchingGame mg;
	int border = 2;
	int nextMove = 0;
	static int FIRST_CARD_PICKED = 1;
	static int SECOND_CARD_PICKED = 2;
	static int WRONG_PAIR = 3;
	static int RIGHT_PAIR = 4;

	public MatchingGamePanel() {
		mg = new MatchingGame();
		for (int i = 0; i < mg.gameField.length; i++) {
			for (int j = 0; j < mg.gameField[i].length; j++) {
				System.out.print(mg.gameField[i][j]);
			}
			System.out.println();
		}
	}

	public void turnCard(int x, int y) {
		if (nextMove == 0) {
			mg.gameField[y][x] = mg.gameField[y][x] * 10;
			nextMove++;
		}else if(nextMove == FIRST_CARD_PICKED){
			mg.gameField[y][x] = mg.gameField[y][x] * 10;
			nextMove++;
		}else if(nextMove == SECOND_CARD_PICKED){
			checkIfPair();
		}
		repaint();
	}
	
	public boolean checkIfPair(){
		return true;
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		int width = getWidth() / 4 - border;
		int height = getHeight() / 3 - border;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				if (mg.gameField[j][i] == 0) {
					g.setColor(Color.WHITE);
					g.fillRect(border + i * (width + border), border + j * (height + border), width, height);
				}else if (mg.gameField[j][i] == 10) {
					g.setColor(Color.BLUE);
					g.fillRect(border + i * (width + border), border + j * (height + border), width, height);
				}else if (mg.gameField[j][i] == 20) {
					g.setColor(Color.CYAN);
					g.fillRect(border + i * (width + border), border + j * (height + border), width, height);
				}else if (mg.gameField[j][i] == 30) {
					g.setColor(Color.GREEN);
					g.fillRect(border + i * (width + border), border + j * (height + border), width, height);
				}else if (mg.gameField[j][i] == 40) {
					g.setColor(Color.ORANGE);
					g.fillRect(border + i * (width + border), border + j * (height + border), width, height);
				}else if (mg.gameField[j][i] == 50) {
					g.setColor(Color.MAGENTA);
					g.fillRect(border + i * (width + border), border + j * (height + border), width, height);
				}else if (mg.gameField[j][i] == 60) {
					g.setColor(Color.YELLOW);
					g.fillRect(border + i * (width + border), border + j * (height + border), width, height);
				}else {
					g.setColor(Color.BLACK);
					g.fillRect(border + i * (width + border), border + j * (height + border), width, height);
				}
			}
		}

		
	}

}
