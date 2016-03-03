package roulette;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;

import roulette.bets.OddEven;
import roulette.bets.RedBlack;
import roulette.bets.ThreeConsecutive;

public class BetFactory {
	List<String> betOptions = new ArrayList<String>(Arrays.asList({"RedBlack", "OddEven", "RedBlack"}));
	
	public Bet createBet(int input){
		Class betClass = Class.forName(betOptions.get(input));
		Constructor betConstructor = betClass.getConstructor(String.class, Integer.class);
		Bet bet = (Bet) betConstructor.newInstance(betOptions.get(input), input);
	}
	
	/*public Bet createBet(int input){
		switch(input){
		case 1:
	        return new RedBlack("Red or Black", 1);
		case 2: 	
			return new OddEven("Odd or Even", 1);
		case 3: 			
			return new ThreeConsecutive("Three in a Row", 11);
		
		default:
			return new RedBlack("default", 1); 
		}*/
	//}

}


