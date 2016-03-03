package roulette;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Factory {

	private String[] classnames = {"OddEven","RedBlack", "ThreeConsecutive"};
	private static ResourceBundle myResources = ResourceBundle.getBundle("Resources/Bets");
	
	public static Bet createBet(String classname){
		String[] betArguments = myResources.getString(classname).split(", ");
		double odds = Double.parseDouble(betArguments[0]);
		String descriptor = betArguments[1];
		Bet bet = null;
		switch (classname){
			case "OddEven":
				bet = new OddEven(odds, descriptor);
				break;
			case "RedBlack":
				bet = new RedBlack(odds, descriptor);
				break;
			case "ThreeConsecutive":
				bet = new ThreeConsecutive(odds, descriptor);
				break;
			default:
				return null;
		}
		return bet;
	}
	
	public static Bet createBetwithReflection(String classname) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<?> clazz = Class.forName((classname));
		Bet bet = (Bet) clazz.getConstructor().newInstance();
		return bet;
	}	
}
