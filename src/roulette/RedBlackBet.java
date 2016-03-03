package roulette;

import util.ConsoleReader;

public class RedBlackBet extends Bet {

	public RedBlackBet(String description, int odds) {
		super(description, odds);
		// TODO Auto-generated constructor stub
	}
    public String placeBet(){
        return ConsoleReader.promptOneOf("Please bet", Wheel.BLACK, Wheel.RED);
    	
    }
    public boolean isMade(String betChoice, Wheel wheel){
            return wheel.getColor().equals(betChoice);
    }

}