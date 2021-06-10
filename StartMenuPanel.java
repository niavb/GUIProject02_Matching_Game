package app;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class StartMenuPanel extends JPanel {
	JButton startBtn = new JButton("Start game");
	JButton showScoresBtn = new JButton("Show current scores");

	public StartMenuPanel() {
		add(showScoresBtn);
		add(startBtn);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

}
