package controller;

import model.BowlingGame;
import view.BowlingDisplay;

import java.awt.*;
import java.util.ArrayList;

public class GameTracker {
    private final BowlingDisplay display;
    private final ArrayList<BowlingGame> games;
    private int currentBowler;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ArrayList<String> names = new ArrayList<>();
                names.add("Mark");
                names.add("Other");
                new GameTracker(names);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
	
	/**
	 * Creates a new GameTracker with the given names
	 * @param playerNames the names to load into the tracker
	 */
	public GameTracker(ArrayList<String> playerNames){
        this.display = new BowlingDisplay(this, playerNames);
		games = new ArrayList<>();
        for (String s : playerNames) {
            games.add(new BowlingGame(s));
		}
	}
	
	public void addData(char c){
        BowlingGame game = games.get(currentBowler);
        boolean progress = game.addData(c);

        if (progress) {
            advance();
        }

	}
	
	/**
	 * Advances to the next bowler
	 */
    private void advance() {
        System.out.println("Advancing player");
        currentBowler++;
        if (currentBowler >= games.size()) {
            currentBowler = 0;
        }
	}
}
