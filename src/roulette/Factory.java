package roulette;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.ConsoleReader;

public class Factory {
    
    private String[] myPossibleBets = {"Red or Black", "Odd or Even", "Three in a row"};
	
    private Bet promptForBet () {
        System.out.println("You can make one of the following types of bets:");
        for (int k = 0; k < myPossibleBets.length; k++) {
            System.out.println(String.format("%d) %s", (k + 1), myPossibleBets[k]));
        }
        Object instance = null;
		try {
			instance = Class.forName(myPossibleBets[ConsoleReader.promptRange("Please make a choice", 1, myPossibleBets.length) - 1]).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return (Bet) instance;
    }

}
