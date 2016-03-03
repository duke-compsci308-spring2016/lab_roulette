package roulette;

import util.ConsoleReader;

public class ThreeInARowBet extends Bet {

	public ThreeInARowBet(String description, int odds) {
		super(description, odds);
	}

	public String placeBet() {
		return "" + ConsoleReader.promptRange("Enter first of three consecutive numbers", 1, Wheel.NUM_SPOTS - 3);
	}

	public boolean isMade(String betChoice, Wheel myWheel) {
		int start = Integer.parseInt(betChoice);
		return (start <= myWheel.getNumber() && myWheel.getNumber() < start + 3);
	}
}
