package roulette;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import roulette.bets.*;
import util.ConsoleReader;

public class Factory {
	private static final String PREFIX = "roulette.bets.";
	private String[] myPossibleBets = {
			"RedBlack",
			"OddEven",
			"ThreeConsecutive",
	};
	private String[] descriptions = {
			"Red or Black",
			"Odd or Even",
			"Three in a Row",

	};
	private int[] odds = {
			1,
			1,
			11,

	};
	public Bet promptForBet() throws NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		System.out.println("You can make one of the following types of bets:");
		for (int k = 0; k < myPossibleBets.length; k++) {
			System.out.println(String.format("%d) %s", (k + 1), myPossibleBets[k]));
		}
		int response = ConsoleReader.promptRange("Please make a choice", 1, myPossibleBets.length);
		String className = PREFIX + myPossibleBets[response-1];
		Class[] params = new Class[]{String.class, Integer.class};
		Constructor betCon = Class.forName(className).getConstructor(params);
		return (Bet) betCon.newInstance(new Object[]{new String(descriptions[response-1]), new Integer(odds[response-1])});
	}
}
