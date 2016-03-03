package roulette;

import util.ConsoleReader;

public class RedBlackBet extends Bet {

	public RedBlackBet(String description, int odds) {
		super(description, odds);
	}
	
    public String placeBet() {
        return ConsoleReader.promptOneOf("Please bet", Wheel.BLACK, Wheel.RED);
    }
    
    public boolean isMade(String betChoice, Wheel myWheel) {
    	return myWheel.getColor().equals(betChoice);
    }

}
