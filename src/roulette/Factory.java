package roulette;

import java.lang.reflect.InvocationTargetException;

import util.ConsoleReader;

public class Factory {
	public static Bet getBet(String betType, String description, int odds) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> betClass = Class.forName(betType);
		Bet bet = (Bet) betClass.getConstructor().newInstance(description,odds);
		return bet;
	}
}
