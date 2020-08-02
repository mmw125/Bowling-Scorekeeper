package model;

import java.util.Optional;

/**
 * Represents a frame of bowling
 * @author Mark Wiggans
 */
public class Frame {
	protected Optional<Frame> previousFrame;
	protected Optional<Frame> nextFrame;
	protected Optional<Integer> firstRoll;
	protected Optional<Integer> secondRoll;
	
	/**
	 * Creates a new frame
	 */
	public Frame(){
		this(null);
	}

	public Frame(Frame previous) {
		previousFrame = Optional.ofNullable(previous);
		nextFrame = Optional.empty();
		firstRoll = Optional.empty();
		secondRoll = Optional.empty();
	}
	
	public void setNextFrame(Frame frame){
		nextFrame = Optional.of(frame);
	}
	
	public void setFirstRoll(int first){
		firstRoll = Optional.of(first);
	}
	
	public void setSecondRoll(int second){
		secondRoll = Optional.of(second);
	}

	public String getFirstRollDisplay() {
		return firstRoll.map(roll -> {
			if (roll == 0) {
				return "-";
			}
			if (roll == 10) {
				return "X";
			}
			return roll.toString();
		}).orElse("");

	}

	public String getSecondRollDisplay() {
		return secondRoll.map(roll -> {
			if (roll == 0) {
				return "-";
			}
			if (roll + firstRoll.orElse(0) >= 10) {
				return "/";
			} else {
				return secondRoll.toString();
			}
		}).orElse("");
	}

	public int getNextRoll() {
		return nextFrame.map(frame -> frame.firstRoll.orElse(0)).orElse(0);
	}

	public int getNextTwoRolls() {
		return nextFrame.map(next -> {
			if (next.firstRoll.orElse(0) == 10) {
				return 10 + next.getNextRoll();
			} else if (next.firstRoll.isPresent() && next.secondRoll.isPresent()) {
				return next.firstRoll.get() + next.secondRoll.get();
			}
			return 0;
		}).orElse(0);
	}
	
	/**
	 * Gets the score that appears on the bottom
	 * null if it shouldn't show anything
	 * @return the score on the bottom
	 */
	private Optional<Integer> calculateScore() {
		return Optional.empty();
	}
	
	/**
	 * Returns the score that should be displayed for this frame
	 * if some of the data is incomplete then it will not display
	 * @return the score in a string if there is enough data
	 */
	public String getScoreDisplay() {
		return calculateScore().map(score -> score + "").orElse("");
	}

	public boolean isComplete() {
		if (firstRoll.orElse(0) == 10) {
			return true;
		}
		if (firstRoll.isPresent() && secondRoll.isPresent()) {
			return true;
		}
		return false;
	}

	/**
	 * @param c key that was pressed
	 * @return true if it can progress to the next frame
	 */
	public boolean addData(char c) {
		int value;
		if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7'
				|| c == '8' || c == '9') {
			value = c - '0';
		} else if (c == '*' || c == 'x' || c == 'X') {
			value = 10;
		} else if (c == '/') {
			value = 10 - firstRoll.orElse(0);
		} else if (c == '-') {
			value = 0;
		} else {
			return false;
		}
		if (firstRoll.isEmpty()) {
			setFirstRoll(value);
			if (value == 10) {
				return true;
			}
			return false;
		}

		int first = firstRoll.get();
		if (value + first > 10) {
			return false;
		}
		setSecondRoll(value);
		return true;
	}
}
