package app;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartGame {
	public static String START_PANEL = "Start game";
	public static String GAME_PANEL = "Game panel";
	public static String SCORE_PANEL = "Score panel";
	public static PriorityQueue<ScoreRecord> scoresRecord = new PriorityQueue<ScoreRecord>();
	public static StartMenuPanel smp = new StartMenuPanel();
	public static MatchingGameControll mgc = new MatchingGameControll();
	public static ScoreOfCurrentGamePanel scgp = new ScoreOfCurrentGamePanel();
	public static CardLayout cardLayout = new CardLayout();
	public static JPanel mainPanel = new JPanel(cardLayout);
	
	public static void readFile(String filePath) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(filePath));
		String line;
		while ((line = in.readLine()) != null) {
			String[] elements = line.split(", ");
			scoresRecord.offer(new ScoreRecord(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]), elements[2]));
		}
		
	}
	
	public static void writeToFile(String filePath) throws Exception {
		FileWriter writer = new FileWriter(filePath, true);
		writer.write(String.valueOf(mgc.matchingGamePanel.moves) + ", " +
				String.valueOf(mgc.matchingGamePanel.time) + ", " +
				smp.name + "\n");
		writer.close();
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(750, 600);
		
		
		
		mainPanel.add(smp, START_PANEL);
		mainPanel.add(mgc, GAME_PANEL);
		mainPanel.add(scgp, SCORE_PANEL);
		
		frame.add(mainPanel);
		frame.setTitle("Memory Game");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		cardLayout.show(mainPanel, START_PANEL);
		
		
		smp.startBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				smp.name = smp.textFieldForName.getText();
				try {
					if (!smp.textFieldForName.getText().equals("")) {
						cardLayout.show(mainPanel, GAME_PANEL);
					} else {
						throw new NoNameAddedException();
					}
				} catch (NoNameAddedException e) {
					System.out.println(e);
				}

			}

		});
		
		mgc.matchingGamePanel.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if(mgc.matchingGamePanel.gameFinished()){
					scgp.yourScoreLabel.setText("Your score: " + String.valueOf(mgc.matchingGamePanel.moves) + " moves " +
				String.valueOf(mgc.matchingGamePanel.time) + " sec");
					cardLayout.show(mainPanel, SCORE_PANEL);
					try {
						writeToFile("src/app/recordOfPreviousScores.txt");
						readFile("src/app/recordOfPreviousScores.txt");
					} catch(Exception e){} 
					
					int rank = 1;
					while(!scoresRecord.isEmpty()) {
						scgp.textAreaOfScores.append(String.valueOf(rank) + ". " + scoresRecord.poll().toString() + "\n");
						rank++;
					}
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
	}

}