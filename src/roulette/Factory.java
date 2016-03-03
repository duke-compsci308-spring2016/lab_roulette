package roulette;

import java.util.ArrayList;
import java.util.List;

import roulette.bets.OddEven;
import roulette.bets.RedBlack;
import roulette.bets.ThreeConsecutive;
import util.ConsoleReader;

public class Factory {

	List<Bet> myBets;
	
	public Factory() {
		// TODO Auto-generated constructor stub
		myBets = new ArrayList<Bet>();
		myBets.add( new OddEven("Odd or Even", 1));
		myBets.add( new RedBlack("Red or Black", 1));
		myBets.add( new ThreeConsecutive("Three in a Row", 11));
	}
	
	public List<Bet> getBets(){
		return myBets;
	}
	
    private Bet promptForBet () {
        System.out.println("You can make one of the following types of bets:");
        for (int k = 0; k < myBets.size(); k++) {
            System.out.println(String.format("%d) %s", (k + 1), myBets.get(k)));
        }
        int response = ConsoleReader.promptRange("Please make a choice", 1, myBets.size());
        return myBets.get(response - 1);
    }

}
