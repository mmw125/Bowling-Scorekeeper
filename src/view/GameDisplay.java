package view;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class GameDisplay {
	JPanel panel;
	private String playerName;
	private ArrayList<FrameDisplay> frames = new ArrayList<>();

	GameDisplay(String playerName) {
		System.out.println("Creating display for " + playerName);
		this.playerName = playerName;
		init();
	}

	private void init() {
		panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel letterName = new JPanel();
		letterName.setBorder(new LineBorder(Color.BLACK));
		letterName.setBackground(Color.BLUE);
		letterName.setPreferredSize(new Dimension(100, 10));
		panel.add(letterName, BorderLayout.WEST);

		JLabel playerLabel = new JLabel(playerName.charAt(0) + "");
		playerLabel.setForeground(Color.WHITE);
		playerLabel.setSize(new Dimension(100, 0));
		playerLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));
		letterName.add(playerLabel);

		JPanel finalScoreContainer = new JPanel();
		finalScoreContainer.setBackground(Color.BLUE);
		finalScoreContainer.setPreferredSize(new Dimension(100, 10));
		panel.add(finalScoreContainer, BorderLayout.EAST);

		JLabel finalScore = new JLabel("Final");
		finalScore.setAlignmentY(Component.TOP_ALIGNMENT);
		finalScore.setVerticalTextPosition(SwingConstants.BOTTOM);
		finalScore.setVerticalAlignment(SwingConstants.BOTTOM);
		finalScore.setFont(new Font("Tahoma", Font.PLAIN, 45));
		finalScore.setForeground(Color.WHITE);
		finalScoreContainer.add(finalScore);

		JPanel frameContainer = new JPanel();
		panel.add(frameContainer, BorderLayout.CENTER);
		frameContainer.setLayout(new GridLayout(1, 1, 0, 0));

		for (int i = 0; i < 10; i++) {
			FrameDisplay frameDisplay = new FrameDisplay();
			frameContainer.add(frameDisplay);
			frames.add(frameDisplay);
		}
	}

	public FrameDisplay getFrame(int frame) {
		return frames.get(frame);
	}

	public String getName() {
		return playerName;
	}
}