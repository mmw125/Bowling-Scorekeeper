package display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GameDisplay {
	private JPanel frameContainer;
	private JPanel panel;
	private String playerName;

	GameDisplay(String playerName) {
		this.playerName = playerName;
		init();
	}

	private void init() {
		panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel letterName = new JPanel();
		letterName.setBackground(Color.BLUE);
		letterName.setPreferredSize(new Dimension(100, 10));
		panel.add(letterName, BorderLayout.WEST);

		JLabel playerLabel = new JLabel(playerName.charAt(0) + "");
		playerLabel.setForeground(Color.WHITE);
		playerLabel.setBackground(SystemColor.activeCaptionBorder);
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
	}
	
	/**
	 * Adds a panel to the panel in the 
	 * @param panel the panel to add
	 */
	public void addPanel(JPanel panel){
		frameContainer.add(panel);
	}
}