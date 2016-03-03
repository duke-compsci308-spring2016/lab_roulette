package roulette;

import util.ConsoleReader;

public class OddEven extends Bet {

	public OddEven(String description, int odds) {
		super(description, odds);
		// TODO Auto-generated constructor stub
	}

	public String placeBet() {
		return ConsoleReader.promptOneOf("Please bet", "even", "odd");

	}

	public boolean isMade(String betChoice, Wheel wheel) {
		return (wheel.getNumber() % 2 == 0 && betChoice.equals("even"))
				|| (wheel.getNumber() % 2 == 1 && betChoice.equals("odd"));
	}

}