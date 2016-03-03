package roulette;

import java.lang.reflect.Constructor;
import java.util.ResourceBundle;

public class BetFactory {
	private ResourceBundle myResourceBundle;
	
	public BetFactory(ResourceBundle myResourceBundle) {
		this.myResourceBundle = myResourceBundle;
	}


	public Bet makeBet(String betName) throws Exception {
		Class betClass = Class.forName(betName);
		Constructor betConstructor = betClass.getConstructors()[0];
		String[] args = myResourceBundle.getString(betName).split(",");
		Bet newBet = (Bet) betConstructor.newInstance(args[0], Integer.parseInt(args[1]));
		
		return newBet;
	}
	
}
