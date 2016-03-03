package roulette;

import util.ConsoleReader;

public class Consecutive extends Bet {

	public Consecutive(String description, int odds) {
		super(description, odds);
		// TODO Auto-generated constructor stub
	}

	public String placeBet() {
		return "" + ConsoleReader.promptRange("Enter first of three consecutive numbers", 1, Wheel.NUM_SPOTS - 3);

	}

	public boolean isMade(String betChoice, Wheel wheel) {
		int start = Integer.parseInt(betChoice);
		return (start <= wheel.getNumber() && wheel.getNumber() < start + 3);
	}

}