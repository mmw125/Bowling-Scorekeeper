package display;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.LineBorder;

class FrameDisplay extends JPanel {
	/**
	 * These can represent the first nine frames of a game
	 */
	private static final long serialVersionUID = 1L;
	private JLabel firstBall;
	private JLabel secondBall;
	private JLabel subtotalLabel;

	/**
	 * Default constructor
	 */
	FrameDisplay() {
		init();
	}

	private void init() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new GridLayout(0, 1, 0, 0));

		JPanel frameOneIndividualContainer = new JPanel();
		frameOneIndividualContainer.setBackground(Color.CYAN);
		add(frameOneIndividualContainer);
		frameOneIndividualContainer.setLayout(new GridLayout(1, 0, 0, 0));

		firstBall = new JLabel("");
		firstBall.setFont(new Font("Tahoma", Font.PLAIN, 20));
		firstBall.setHorizontalAlignment(SwingConstants.CENTER);
		frameOneIndividualContainer.add(firstBall);

		secondBall = new JLabel("");
		secondBall.setHorizontalAlignment(SwingConstants.CENTER);
		secondBall.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frameOneIndividualContainer.add(secondBall);

		JPanel subtotal = new JPanel();
		subtotal.setBackground(Color.BLUE);
		add(subtotal);

		subtotalLabel = new JLabel("");
		subtotalLabel.setForeground(Color.WHITE);
		subtotalLabel.setBackground(Color.WHITE);
		subtotalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		subtotalLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		subtotal.add(subtotalLabel);
	}

	public void setSubtotal(int i) {
		subtotalLabel.setText(i + "");
	}
}
