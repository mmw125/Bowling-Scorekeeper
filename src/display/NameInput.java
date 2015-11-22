package display;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class NameInput {

        private JFrame frame;

        private Color[] colors;

        public static void main(String[] args) {
                EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                try {
                                        NameInput window = new NameInput();
                                        window.frame.setVisible(true);
                                } catch (Exception e) {
                                        e.printStackTrace();
                                }
                        }
                });
        }

        /**
         * Creates the application.
         */
        public NameInput() {
                initialize();
                colors = new Color[7];
                colors[0] = Color.blue;
//              {
//                              Color.blue, Color.blue, Color.white, Color.cyan, Color.black, Color.blue, Color.white
//              };
        }
        
        public int numOfNames = 1;
        
        /**
         * Holds all of the player objects
         */
        private ArrayList<JTextField> players = new ArrayList<JTextField>();
        
        private String[] playerNames;
                        
        private void initialize() {
                frame = new JFrame();
                frame.setBounds(100, 100, 298, 250);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.getContentPane().setLayout(new BorderLayout(0, 0));
                frame.setMinimumSize(new Dimension(400, 250));
                frame.setResizable(true);
                
                
                //Button container
                JPanel panel = new JPanel();
                frame.getContentPane().add(panel, BorderLayout.SOUTH);
                panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
                JButton btnStartGame = new JButton("Start Game");
                panel.add(btnStartGame);
                
                btnStartGame.addMouseListener(new MouseListener() {
                        
                        @Override
                        public void mouseReleased(MouseEvent arg0) {
                                
                        }
                        
                        @Override
                        public void mousePressed(MouseEvent arg0) {
                                
                        }
                        
                        @Override
                        public void mouseExited(MouseEvent arg0) {
                                
                        }
                        
                        @Override
                        public void mouseEntered(MouseEvent arg0) {
                                
                        }
                        
                        @Override
                        public void mouseClicked(MouseEvent arg0) {
                                @SuppressWarnings("unused")
								BowlingDisplay game = new BowlingDisplay(getPlayerNames());
                                frame.setVisible(false);
                        }
                });
                
                JPanel panel_1 = new JPanel();
                frame.getContentPane().add(panel_1, BorderLayout.CENTER);
                panel_1.setLayout(new GridLayout(0, 1));
                
                JPanel colorChoosers = new JPanel();
                colorChoosers.setLayout(new GridLayout(0, 1));
                panel_1.add(colorChoosers);
                
                for(int i = 0; i < 5; i++){
                        System.out.println(i);
                        JColorChooser colorChooser = new JColorChooser();
                        colorChoosers.add(colorChooser);
                        colorChooser.setColor(Color.black);
                }
                
                //textField_1 = new JTextField();
                //panel_3.add(textField_1);
                //textField_1.setColumns(25);
                
                
                
                for(int count = 0; count < numOfNames; count++){
                        JTextField nameInput = new JTextField();
                        panel_1.add(nameInput);
                        players.add(nameInput);
                }
        }
        
        public ArrayList<String> getPlayerNames(){
                int number = 0;
                playerNames = new String[numOfNames];
                for(int count = 0; count < numOfNames; count++){
                        if(!players.get(count).getText().isEmpty()){
                                playerNames[number] = players.get(count).getName();
                                number++;
                        }
                }
                return new ArrayList<String>();
        }
}
