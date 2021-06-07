package app;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

public class MatchingGamePanel extends JPanel {
	MatchingGame mg;
	int border = 2;
	int lastMove = 0;
	static int FIRST_CARD_PICKED = 1;
	static int SECOND_CARD_PICKED = 2;
	static int CHECKED_PLAYED_CARDS = 0;
	Map<Integer, Card> pickedCards = new HashMap<>();

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
		if (lastMove == CHECKED_PLAYED_CARDS) {
			mg.gameField[y][x] = mg.gameField[y][x] * 10;
			pickedCards.put(1, new Card(x, y, mg.gameField[y][x]));
			lastMove++;
		}else if(lastMove == FIRST_CARD_PICKED){
			mg.gameField[y][x] = mg.gameField[y][x] * 10;
			pickedCards.put(2, new Card(x, y, mg.gameField[y][x]));
			lastMove++;
		}else if(lastMove == SECOND_CARD_PICKED){
			lastMove = CHECKED_PLAYED_CARDS;
			if(checkIfPair()) {
				mg.gameField[pickedCards.get(1).y][pickedCards.get(1).x]=0;
				mg.gameField[pickedCards.get(2).y][pickedCards.get(2).x]=0;
				pickedCards.remove(1);
				pickedCards.remove(2);
			}else {
				mg.gameField[pickedCards.get(1).y][pickedCards.get(1).x]/=10;
				mg.gameField[pickedCards.get(2).y][pickedCards.get(2).x]/=10;
				pickedCards.remove(1);
				pickedCards.remove(2);
			}
		}
		repaint();
	}
	
	public boolean checkIfPair(){
		int card1 = pickedCards.get(1).value;
		int card2 = pickedCards.get(2).value;
		if(card1==card2) {
			return true;
		}else return false;
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
