package roulette;

import roulette.bets.OddEven;
import roulette.bets.RedBlack;
import roulette.bets.ThreeConsecutive;

public class BetFactory {
	private Bet[] myPossibleBets = {
	        new RedBlack("Red or Black", 1),
	        new OddEven("Odd or Even", 1),
	        new ThreeConsecutive("Three in a Row", 11),
	    };
	
	public Bet getBet(String betType){
		if(betType.equalsIgnoreCase("RedBlack")){
			return myPossibleBets[0];
		}
		else if(betType.equalsIgnoreCase("OddEven")){
			return myPossibleBets[1];
		}
		else if(betType.equalsIgnoreCase("ThreeConsecutive")){
			return myPossibleBets[2];
		}
		return null;
	}
}
