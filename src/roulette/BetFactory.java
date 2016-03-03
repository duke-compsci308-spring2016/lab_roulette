package roulette;

import roulette.bets.OddEven;
import roulette.bets.RedBlack;
import roulette.bets.ThreeConsecutive;

public class BetFactory {
	
	public Bet createBet(int input){
		switch(input){
		case 1:
	        return new RedBlack("Red or Black", 1);
		case 2: 
			return new OddEven("Odd or Even", 1);
		case 3: 				
			return new ThreeConsecutive("Three in a Row", 11);
		
		default:
			return new RedBlack("default", 1); 
		}
	}

}


