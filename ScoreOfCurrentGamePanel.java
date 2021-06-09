package app;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ScoreOfCurrentGamePanel extends JPanel{
	
	public ScoreOfCurrentGamePanel() {
		JButton oneBtn = new JButton("Start game 222");
		JButton twoBtn = new JButton("Show current scores");
		add(oneBtn);
		add(twoBtn);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

}
