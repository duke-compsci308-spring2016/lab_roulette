package roulette;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ResourceBundle;

import roulette.bets.OddEven;
import roulette.bets.RedBlack;
import roulette.bets.ThreeConsecutive;
import util.ConsoleReader;

public class BetFactory {
	private String[] myPossibleBets = {
	        "Red or Black",
	        "Odd or Even",
	        "Three in a Row"
	    };
	
	private String RedBlack = "roulette.RedBlack";
	private String OddEven = "roulette.OddEven";
	private String ThreeConsecutive = "roulette.ThreeConsecutive";
	
	private ResourceBundle propertiesBundle = ResourceBundle.getBundle("util/factory");
	
	public BetFactory() {
		
	}
	
	public Bet getBet() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		
		System.out.println("You can make one of the following types of bets:");
        for (int k = 0; k < myPossibleBets.length; k++) {
            System.out.println(String.format("%d) %s", (k + 1), myPossibleBets[k]));
        }
        
        int response = ConsoleReader.promptRange("Please make a choice", 1, myPossibleBets.length);
        
        Class bet = Class.forName(propertiesBundle.getString(myPossibleBets[response]));
        Constructor c = bet.getConstructor(Integer.class, String.class);
        return (Bet) c.newInstance(myPossibleBets[response], 1);
        
        
	}
}
