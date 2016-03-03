package roulette;

import util.ConsoleReader;

public class OddEvenBet extends Bet {

	public OddEvenBet(String description, int odds) {
		super(description, odds);
	}

	public String placeBet() {
		return ConsoleReader.promptOneOf("Please bet", "even", "odd");
	}

	public boolean isMade(String betChoice, Wheel myWheel) {
		return (myWheel.getNumber() % 2 == 0 && betChoice.equals("even"))
				|| (myWheel.getNumber() % 2 == 1 && betChoice.equals("odd"));
	}

}
