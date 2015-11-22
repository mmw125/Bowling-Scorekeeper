package data;

import java.util.ArrayList;

public class BowlingGame {
	private String name;
	private ArrayList<Frame> frames;
	//private int currentFrame;
	
	public BowlingGame(String bowlerName){
		name = bowlerName;
		init();
	}
	
	public String getName(){
		return name;
	}

	private void init(){
		frames = new ArrayList<Frame>(10);
		Frame frame = new Frame();
		frames.add(frame);
		for(int i = 1; i < 9; i++){
			frame = new Frame(frames.get(i - 1));
			frames.add(frame);
			frames.get(i - 1).setNextFrame(frame);
		}
	}
	
	public boolean addData(char data){
		return true;
	}
}
