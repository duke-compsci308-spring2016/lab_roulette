package roulette;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import roulette.OddEven;
import roulette.RedBlack;
import roulette.ThreeConsecutive;

public class Factory {
	String[] bets = {"RedBlack", "OddEven", "RedBlack"};
	
	public Bet createBet(int input) throws NoSuchMethodException, SecurityException {
		Bet bet;
		Class betClass;
		try {
			betClass = Class.forName(bets[input]);
			Constructor betConstructor = betClass.getConstructor(String.class, Integer.class);
			bet = (Bet) betConstructor.newInstance(bets[input], input);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			return null;
		}
		return bet;
	}
}
