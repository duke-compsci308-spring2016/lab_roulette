package roulette;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.ConsoleReader;

public class Factory {
    private Bet[] myPossibleBets = { 
            new RedBlackBet("Red or Black", 1),
            new OddEven("Odd or Even", 1),
            new Consecutive("Three in a Row", 11),
        };
	
    private Bet promptForBet () {
        System.out.println("You can make one of the following types of bets:");
        for (int k = 0; k < myPossibleBets.length; k++) {
            System.out.println(String.format("%d) %s", (k + 1), myPossibleBets[k].getDescription()));
        }
        return myPossibleBets[ConsoleReader.promptRange("Please make a choice", 1, myPossibleBets.length) - 1];
    }

	public static void main (String[] args) {
		
		
		
	}
}
