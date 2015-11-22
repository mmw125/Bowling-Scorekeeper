package data;

/**
 * Represents a frame of bowling
 * @author Mark Wiggans
 */
public class Frame {
	protected Frame previousFrame;
	protected Frame nextFrame;
	protected Integer firstRoll;
	protected Integer secondRoll;
	
	/**
	 * Creates a new frame
	 */
	public Frame(){
		this(null);
	}
	
	public Frame(Frame previous){
		previousFrame = previous;
		nextFrame = null;
		firstRoll = null;
		secondRoll = null;
	}
	
	public void setNextFrame(Frame frame){
		nextFrame = frame;
	}
	
	public void setFirstRoll(int first){
		firstRoll = first;
	}
	
	public void setSecondRoll(int second){
		secondRoll = second;
	}
	
	public String getFirstRoll(){
		if(firstRoll == null){
			return "";
		}
		if(firstRoll == 0){
			return "-";
		}
		if(firstRoll == 10){
			return "X";
		}else{
			return firstRoll.toString();
		}
	}
	
	public String getSecondRoll(){
		if(secondRoll == null){
			return "";
		}
		if(secondRoll == 0){
			return "-";
		}
		if(firstRoll == 10){
			return "";
		}else if(firstRoll + secondRoll >= 10){
			return "/";
		}else{
			return secondRoll.toString();
		}
	}
	
	public Integer getNextRoll(){
		if(nextFrame != null){
			return nextFrame.firstRoll;
		}
		return null;
	}
	
	public Integer getNextTwoRolls(){
		if(nextFrame != null){
			if(nextFrame.firstRoll == 10){
				return 10 + nextFrame.getNextRoll();
			}else if(nextFrame.firstRoll != null && nextFrame.secondRoll != null){
				return nextFrame.firstRoll + nextFrame.secondRoll;
			}
		}
		return null;
	}
	
	/**
	 * Gets the score that appears on the bottom
	 * null if it shouldn't show anything
	 * @return the score on the bottom
	 */
	private int calculateScore(){
		int output;
		//adds the previous frame to the output
		if (previousFrame != null){
			output = previousFrame.calculateScore();
		}else{
			output = 0;
		}
		
		if(firstRoll != null){
			if(firstRoll == 10){
				
			}else if(secondRoll != null){
				
			}
		}
		return output;
	}
	
	/**
	 * Returns the score that should be displayed for this frame
	 * if some of the data is incomplete then it will not display
	 * @return the score in a string if there is enough data
	 */
	public String getScore(){
		return calculateScore() + "";
	}
}
