package display;

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
import javax.swing.border.LineBorder;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import data.GameTracker;

/**
 * The class that displays the game and takes input
 *
 * @author Mark Wiggans
 */
public class BowlingDisplay {

	/**
	 * Holds all of the colors for the program 0 = Background Color 1 =
	 * PlayerName Background and Final Score Background 2 = PlayerName Text
	 * Color and Final Score Text Background 3 = Frame Top Background 4 = Frame
	 * Top Text Color 5 = Frame Bottom Background 6 = Frame Bottom Text Color
	 */
	//private Color[] colors;

	/**
	 * The frame that everything is put into
	 */
	private JFrame frame;

	private GameTracker tracker;

	/**
	 * Launches the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				ArrayList<String> names = new ArrayList<>();
				names.add("Mark");
				BowlingDisplay window = new BowlingDisplay(names);
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}

		});
	}

	/**
	 * Creates the application with names from nameInput
	 */
	public BowlingDisplay(ArrayList<String> playerNames) {
		tracker = new GameTracker(playerNames);

		// Creates the window and sets size
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(600, 175));
		frame.setBounds(100, 100, 901, 211);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// Creates the number line across the top
		final NumberRow topReferenceNumbers = new NumberRow();
		frame.add(topReferenceNumbers);

		// Creates the container that stores the score tables
		final JPanel scoreContainer = new JPanel();
		scoreContainer.setBounds(10, 25, frame.getSize().width - 40,
				frame.getSize().height - 70);
		frame.getContentPane().add(scoreContainer);
		scoreContainer.setLayout(new GridLayout(1, 1));

		// Creates the game frame
		GameDisplay newGame = new GameDisplay(playerNames.get(0));
		newGame.panel.setBounds(0, 0, 0, 0);
		scoreContainer.add(newGame.panel);

		// Resizes internal components when entire frame is resized
		frame.addComponentListener(new ComponentListener() {

			@Override
			public void componentShown(ComponentEvent arg0) {
			}

			@Override
			public void componentResized(ComponentEvent arg0) {
				scoreContainer.setBounds(10, 25, frame.getSize().width - 35,
						frame.getSize().height - 70);
//				newGame.setBounds(0, 0, scoreContainer.getSize().width, 100);
				topReferenceNumbers.setBounds(10, 10,
						frame.getSize().width - 35, 15);
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
				System.out.println("Got " + e.getKeyChar());
				if (e.getKeyChar() == '0' || e.getKeyChar() == '1'
						|| e.getKeyChar() == '2' || e.getKeyChar() == '3'
						|| e.getKeyChar() == '4' || e.getKeyChar() == '5'
						|| e.getKeyChar() == '6' || e.getKeyChar() == '7'
						|| e.getKeyChar() == '8' || e.getKeyChar() == '9'
						|| e.getKeyChar() == '*' || e.getKeyChar() == '/'
						|| e.getKeyChar() == '-') {
					// newGame.addData(e.getKeyChar());
					tracker.addData(e.getKeyChar());
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		frame.setVisible(true);


//		JPanel frameOne = new JPanel();
//		frameOne.setBorder(new LineBorder(new Color(0, 0, 0)));
//		add(frameOne);
//		setLayout(new GridLayout(0, 1, 0, 0));
//
//		 JPanel frameOneIndividualContainer = new JPanel();
//		 frameOneIndividualContainer.setBackground(Color.CYAN);
//		 add(frameOneIndividualContainer);
//		 frameOneIndividualContainer
//		 .setLayout(new GridLayout(1, 0, 0, 0));
//
//		 // setLayout(new GridLayout(1, 0, 0, 0));
//
//		 JLabel firstBall = new JLabel("1");
//		 firstBall.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		 firstBall.setHorizontalAlignment(SwingConstants.CENTER);
//		 frameOneIndividualContainer.add(firstBall);
//
//		 JLabel secondBall = new JLabel("2");
//		 secondBall.setHorizontalAlignment(SwingConstants.CENTER);
//		 secondBall.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		 frameOneIndividualContainer.add(secondBall);
//
//		 JLabel thirdBall = new JLabel("3");
//		 thirdBall.setHorizontalAlignment(SwingConstants.CENTER);
//		 thirdBall.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		 frameOneIndividualContainer.add(thirdBall);
//
//		 JPanel subtotal = new JPanel();
//		 subtotal.setBackground(Color.BLUE);
//		 add(subtotal);
//
//		 JLabel label_10 = new JLabel("S");
//		 label_10.setForeground(Color.WHITE);
//		 label_10.setBackground(Color.WHITE);
//		 label_10.setHorizontalAlignment(SwingConstants.CENTER);
//		 label_10.setFont(new Font("Tahoma", Font.BOLD, 20));
//		 subtotal.add(label_10);

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