package roulette;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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
	
	public BetFactory() {
		
	}
	
	public Bet getBet() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		
		System.out.println("You can make one of the following types of bets:");
        for (int k = 0; k < myPossibleBets.length; k++) {
            System.out.println(String.format("%d) %s", (k + 1), myPossibleBets[k]));
        }
        
        int response = ConsoleReader.promptRange("Please make a choice", 1, myPossibleBets.length);
        
        switch(response) {
        case 1:
        	Class redblack = Class.forName(RedBlack);
        	Constructor c = redblack.getConstructor(Integer.class, String.class);
        	return (Bet) c.newInstance("Red or Black", 1);
        case 2:
        	Class oddEven = Class.forName(OddEven);
        	Constructor b = oddEven.getConstructor(Integer.class, String.class);
        	return (Bet) b.newInstance("Odd or Even", 1);
        case 3:
        	Class threeConsecutives = Class.forName(ThreeConsecutive);
        	Constructor a = threeConsecutives.getConstructor(Integer.class, String.class);
        	return (Bet) a.newInstance("ThreeConsecutive", 11);
        
        }
        
        return null;
        
	}
}
