package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;

import javax.swing.SwingConstants;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import controller.GameTracker;

/**
 * The class that displays the game and takes input
 *
 * @author Mark Wiggans
 */
public class BowlingDisplay {
	/**
	 * The frame that everything is put into
	 */
	private JFrame frame;

	private final GameTracker tracker;

	/**
	 * Creates the application with names from nameInput
	 */
	public BowlingDisplay(GameTracker tracker, ArrayList<String> playerNames) {
		this.tracker = tracker;
		// Creates the window and sets size
		frame = new JFrame();
        frame.setTitle("Bowling Scorekeeper");
		frame.setMinimumSize(new Dimension(600, 175));
		frame.setBounds(100, 100, 901, 211);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		// Creates the number line across the top
		final NumberRow topReferenceNumbers = new NumberRow();
		frame.add(topReferenceNumbers);

		// Creates the container that stores the score tables
		final JPanel scoreContainer = new JPanel();
		scoreContainer.setBounds(10, 25, frame.getSize().width - 40,
				frame.getSize().height - 70);
		frame.getContentPane().add(scoreContainer);
        scoreContainer.setLayout(new GridLayout(playerNames.size(), 1));

		// Creates the game frame
        for (String name : playerNames) {
            GameDisplay newGame = new GameDisplay(name);
            newGame.panel.setBounds(0, 0, 0, 0);
            scoreContainer.add(newGame.panel);
        }

		// Resizes internal components when entire frame is resized
		frame.addComponentListener(new ComponentListener() {
			@Override
			public void componentResized(ComponentEvent arg0) {
				scoreContainer.setBounds(10, 25, frame.getSize().width - 35,
						frame.getSize().height - 70);
				topReferenceNumbers.setBounds(10, 10,
						frame.getSize().width - 35, 15);
			}

			@Override
			public void componentShown(ComponentEvent arg0) {
			}

			@Override
			public void componentMoved(ComponentEvent arg0) {
			}

			@Override
			public void componentHidden(ComponentEvent arg0) {
			}
		});

		frame.addKeyListener(new KeyListener() {

			public void keyTyped(KeyEvent e) {
				tracker.addData(e.getKeyChar());
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		frame.setVisible(true);
	}


	/**
	 * Creates the numbers that mark the rows
	 *
	 * @author Mark Wiggans
	 */
	public class NumberRow extends JPanel {
		private static final long serialVersionUID = 1L;

		NumberRow() {

			setLayout(new BorderLayout(0, 0));

			JPanel leftPadding = new JPanel();
			leftPadding.setPreferredSize(new Dimension(100, 10));
			FlowLayout flowLayout = (FlowLayout) leftPadding.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			add(leftPadding, BorderLayout.WEST);

			JPanel rightPadding = new JPanel();
			rightPadding.setPreferredSize(new Dimension(100, 10));
			add(rightPadding, BorderLayout.EAST);

			JPanel header = new JPanel();
			add(header, BorderLayout.CENTER);
			header.setLayout(new GridLayout(1, 0, 0, 0));

			for (int count = 1; count < 11; count++) {
				JPanel panel_39 = new JPanel();
				header.add(panel_39);
				panel_39.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));

				JLabel label = new JLabel(count + "");
				label.setAlignmentY(Component.TOP_ALIGNMENT);
				label.setVerticalAlignment(SwingConstants.TOP);
				label.setFont(new Font("Tahoma", Font.BOLD, 12));
				panel_39.add(label);
			}
		}
	}
}