package roulette;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ResourceBundle;

import roulette.bets.*;
import util.ConsoleReader;

public class Factory {
	private static final String PREFIX = "roulette.bets.";
	private String[] myPossibleBets = {
			"RedBlack",
			"OddEven",
			"ThreeConsecutive",
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
		String description = ResourceBundle.getBundle("bets").getString(myPossibleBets[response-1]).split(",")[0];
		int odds = Integer.parseInt(ResourceBundle.getBundle("bets").getString(myPossibleBets[response-1]).split(",")[1]);
		return (Bet) betCon.newInstance(new Object[]{new String(description), new Integer(odds)});
	}
}
