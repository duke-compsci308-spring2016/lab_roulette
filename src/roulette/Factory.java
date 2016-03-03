package roulette;

import util.ConsoleReader;

public class Factory {
	private Bet[] subclasses = { new RedBlack("Red or Black", 1), new OddEven("Odd or Even", 1),
			new ThreeConsecutive("Three in a Row", 11), };

	public Bet getBet() {
		System.out.println("You can make one of the following types of bets:");
		for (int k = 0; k < subclasses.length; k++) {
			System.out.println(String.format("%d) %s", (k + 1), subclasses[k].getDescription()));
		}
		int response = ConsoleReader.promptRange("Please make a choice", 1, subclasses.length);
		if (response < 1 || response > subclasses.length) {
			return subclasses[response - 1];
		} else {
			throw new ArrayIndexOutOfBoundsException("Please select a valid bet");
		}
	}

}
