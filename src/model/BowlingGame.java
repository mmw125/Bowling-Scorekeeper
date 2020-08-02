package model;

import java.util.ArrayList;

public class BowlingGame {
	private final String name;
	private final ArrayList<Frame> frames;
	private int currentFrame;

	public BowlingGame(String bowlerName) {
		this.currentFrame = 0;
		name = bowlerName;

		frames = new ArrayList<>(10);
		Frame frame = new Frame();
		frames.add(frame);
		for (int i = 1; i < 9; i++) {
			frame = new Frame(frames.get(i - 1));
			frames.add(frame);
			frames.get(i - 1).setNextFrame(frame);
		}
	}

	public boolean addData(char c) {
		System.out.println("Adding data for " + name);
		if (frames.get(currentFrame).isComplete()) {
			throw new IllegalStateException("Attempting to add data to a completed frame");
		}
		boolean progress = frames.get(currentFrame).addData(c);
		if (progress) {
			currentFrame++;
		}
		return progress;
	}
}
