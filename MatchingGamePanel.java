package app;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MatchingGamePanel extends JPanel {
	MatchingGame mg;
	int border = 2;
	
	int moves = 0;
	long time = 0;
	long startTime;
	long endTime;
	
	int lastMove = 0;
	static int FIRST_CARD_PICKED = 1;
	static int SECOND_CARD_PICKED = 2;
	static int CHECKED_PLAYED_CARDS = 0;
	Map<Integer, Card> pickedCards = new HashMap<>();
	
	BufferedImage pic1, pic2, pic3, pic4, pic5, pic6, backOfCardsPic;

	public MatchingGamePanel() {
		setBackground(Color.WHITE);
		mg = new MatchingGame();
		for (int i = 0; i < mg.gameField.length; i++) {
			for (int j = 0; j < mg.gameField[i].length; j++) {
				System.out.print(mg.gameField[i][j]);
			}
			System.out.println();
		}
	}
	
	public boolean gameFinished() {
		for (int i = 0; i < mg.gameField.length; i++) {
			for (int j = 0; j < mg.gameField[i].length; j++) {
				if(mg.gameField[i][j]!=0) {
					return false;
				}
			}
		}
		return true;
	}

	public void turnCard(int x, int y) {
		if (lastMove == CHECKED_PLAYED_CARDS) {
			mg.gameField[y][x] = mg.gameField[y][x] * 10;
			pickedCards.put(1, new Card(x, y, mg.gameField[y][x]));
			lastMove = FIRST_CARD_PICKED;
		}else if(lastMove == FIRST_CARD_PICKED){
			mg.gameField[y][x] = mg.gameField[y][x] * 10;
			pickedCards.put(2, new Card(x, y, mg.gameField[y][x]));
			if(moves==0) {
				startTime = System.currentTimeMillis();
			}
			moves++;
			lastMove = SECOND_CARD_PICKED;
		}else if(lastMove == SECOND_CARD_PICKED){
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
			if(gameFinished()) {
				endTime = System.currentTimeMillis();
				time = (endTime - startTime) / 1000;
			}
			lastMove = CHECKED_PLAYED_CARDS;
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
		try {
			pic1 = ImageIO.read(new File("src/app/pic1.jpg"));
			pic2 = ImageIO.read(new File("src/app/pic2.jpg"));
			pic3 = ImageIO.read(new File("src/app/pic3.jpg"));
			pic4 = ImageIO.read(new File("src/app/pic4.jpg"));
			pic5 = ImageIO.read(new File("src/app/pic5.jpg"));
			pic6 = ImageIO.read(new File("src/app/pic6.jpg"));
			backOfCardsPic = ImageIO.read(new File("src/app/forBackOfCards.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int width = getWidth() / 4 - border;
		int height = getHeight() / 3 - border;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				if (mg.gameField[j][i] == 0) {
					g.setColor(Color.WHITE);
					g.fillRect(border + i * (width + border), border + j * (height + border), width, height);
				}else if (mg.gameField[j][i] == 10) {
					g.drawImage(pic1, border + i * (width + border), border + j * (height + border), width, height, this);
				}else if (mg.gameField[j][i] == 20) {
					g.drawImage(pic2, border + i * (width + border), border + j * (height + border), width, height, this);
				}else if (mg.gameField[j][i] == 30) {
					g.drawImage(pic3, border + i * (width + border), border + j * (height + border), width, height, this);
				}else if (mg.gameField[j][i] == 40) {
					g.drawImage(pic4, border + i * (width + border), border + j * (height + border), width, height, this);
				}else if (mg.gameField[j][i] == 50) {
					g.drawImage(pic5, border + i * (width + border), border + j * (height + border), width, height, this);
				}else if (mg.gameField[j][i] == 60) {
					g.drawImage(pic6, border + i * (width + border), border + j * (height + border), width, height, this);
				}else {
					g.drawImage(backOfCardsPic, border + i * (width + border), border + j * (height + border), width, height, this);
				}
			}
		}

		
	}

}