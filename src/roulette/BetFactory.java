package roulette;

import roulette.bets.OddEven;
import roulette.bets.RedBlack;
import roulette.bets.ThreeConsecutive;
import util.ConsoleReader;

public class BetFactory {
	private Bet[] myPossibleBets = {
	        new RedBlack("Red or Black", 1),
	        new OddEven("Odd or Even", 1),
	        new ThreeConsecutive("Three in a Row", 11),
	    };
	
	private String RedBlack = "roulette.RedBlack";
	private String OddEven = "roulette.OddEven";
	private String ThreeConsecutive = "roulette.ThreeConsecutive";
	
	public BetFactory() {
		
	}
	
	public Bet getBet() {
		
		System.out.println("You can make one of the following types of bets:");
        for (int k = 0; k < myPossibleBets.length; k++) {
            System.out.println(String.format("%d) %s", (k + 1), myPossibleBets[k]));
        }
        
        int response = ConsoleReader.promptRange("Please make a choice", 1, myPossibleBets.length);
        
        return myPossibleBets[response - 1];
        
	}
}
