package app;

import javax.swing.*;

public class MatchingGameFrame extends JFrame{

	public MatchingGameFrame() {
		setSize(500, 400);
		add(new MatchingGamePanel());
		setTitle("Matching Game");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

}
