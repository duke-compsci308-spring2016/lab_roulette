package roulette;

import java.lang.reflect.Constructor;
import java.util.ResourceBundle;

import roulette.bets.OddEven;
import roulette.bets.RedBlack;
import roulette.bets.ThreeConsecutive;
import util.ConsoleReader;

public class BetFactory {
	ResourceBundle myResources = ResourceBundle.getBundle("Bet");
	private Bet[] myPossibleBets = {
	        new RedBlack("Red or Black", 1),
	        new OddEven("Odd or Even", 1),
	        new ThreeConsecutive("Three in a Row", 11),
	    };
	
	
	public BetFactory() {
		
	}
	
	public Bet createBet(){
		
		System.out.println("You can make one of the following types of bets:");
        for (int k = 0; k < myPossibleBets.length; k++) {
            System.out.println(String.format("%d) %s", (k + 1), myPossibleBets[k]));
        }
        String betTypeKey = ConsoleReader.promptString("Please select RedBlack, OddEven, or ThreeConsecutive.");
		String betTypeResource = myResources.getString(betTypeKey);
		
		String description = betTypeResource.split(",")[0];
		String odds = betTypeResource.split(",")[1];
		try{
			Class<?> betClass = Class.forName(betTypeKey);
			Constructor<?>[] constructors = betClass.getConstructors();
			Object instance = constructors[0].newInstance(description,Integer.parseInt(odds));
			Bet toReturn = (Bet) instance; 
			return toReturn;
		}catch(Exception e){
			return null;
		}
	}

}
