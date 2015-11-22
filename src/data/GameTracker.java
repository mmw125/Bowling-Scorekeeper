package data;

import java.util.ArrayList;

public class GameTracker {
	private ArrayList<BowlingGame> games;
	private int current;
	
	/**
	 * Creates a new GameTracker with the given names
	 * @param playerNames the names to load into the tracker
	 */
	public GameTracker(ArrayList<String> playerNames){
		games = new ArrayList<BowlingGame>();
		if(playerNames != null){
			for(String s : playerNames){
				games.add(new BowlingGame(s));
			}
		}
	}
	
	public void addData(char c){
		if(games.get(current) != null){
			boolean progress = games.get(current).addData(c);
			if(progress){
				advance();
			}
		}else{
			System.out.println("Trying to add data to a nonexistant game");
		}
	}
	
	/**
	 * Advances to the next bowler
	 */
	public void advance(){
		
	}
}
