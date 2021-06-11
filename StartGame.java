package app;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartGame {
	public static String START_PANEL = "Start game";
	public static String GAME_PANEL = "Game panel";
	public static String SCORE_PANEL = "Score panel";
//	PriorityQueue<ScoreRecord> scoresRecord = new PriorityQueue<ScoreRecord>();
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setSize(500, 400);
		CardLayout cardLayout = new CardLayout();
		
		JPanel mainPanel = new JPanel(cardLayout);
		StartMenuPanel smp = new StartMenuPanel();
		MatchingGameControll mgc = new MatchingGameControll();
		ScoreOfCurrentGamePanel scgp = new ScoreOfCurrentGamePanel();
		mainPanel.add(smp, START_PANEL);
		mainPanel.add(mgc, GAME_PANEL);
		mainPanel.add(scgp, SCORE_PANEL);
		
		frame.add(mainPanel);
		frame.setTitle("Matching Game");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		try {
			Scanner in = new Scanner(new File("src/app/recordOfPreviousScores.txt"));
			PriorityQueue<ScoreRecord> scoresRecord = new PriorityQueue<ScoreRecord>();
			while(in.hasNext()){
				String line = in.nextLine();
				String[] elements = line.split(", ");
//				scoresRecord.add(new ScoreRecord(elements[0], elements[1], elements[2]));
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cardLayout.show(mainPanel, START_PANEL);
		
		smp.startBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				cardLayout.show(mainPanel, GAME_PANEL);
			}
			
		});
		
		mgc.matchingGamePanel.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if(mgc.matchingGamePanel.gameFinished()){
					cardLayout.show(mainPanel, SCORE_PANEL);
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
