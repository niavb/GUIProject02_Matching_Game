package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartGameMenu {
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setSize(400, 400);
		
		JPanel mainPanel = new JPanel();
		JButton startBtn = new JButton("Start game");
		JButton showScoresBtn = new JButton("Show current scores");
		mainPanel.add(showScoresBtn);
		mainPanel.add(startBtn);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		frame.add(mainPanel);
		frame.setTitle("Matching Game Menu");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		startBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.dispose();
				MatchingGameFrame mga = new MatchingGameFrame();
			}
			
		});
	}

}
