package roulette;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import roulette.bets.OddEven;
import roulette.bets.RedBlack;
import roulette.bets.ThreeConsecutive;
import util.ConsoleReader;

public class BetFactory {
	private String[] betNames = {"RedBlack", "OddEven", "ThreeConsecutive" };
	private Map<String, Integer> betOdds;
	
	public BetFactory(){
		betOdds = new HashMap<String, Integer>();
		int[] odds = { 1 , 1, 11};
		for(int i = 0; i < odds.length; i++){
			betOdds.put(betNames[i], odds[i]);
		}
	}
	public Bet getBetForParameters(String betName, int odds){
		Bet bet = null;
		try{
			bet = (Bet) Class.forName(betName)
											.getConstructor(String.class, int.class)
											.newInstance(betName, odds);
		}
		catch(Exception e){
			
		}
		return bet;
	}
    public Bet promptForBet () {
        System.out.println("You can make one of the following types of bets:");
        for (int k = 0; k < betNames.length; k++) {
            System.out.println(String.format("%d) %s", (k + 1), betNames[k]));
        }
        int response = ConsoleReader.promptRange("Please make a choice", 1, betNames.length);
        String betName = betNames[response - 1];
        return getBetForParameters(betName, betOdds.get(betName));
    }
}
