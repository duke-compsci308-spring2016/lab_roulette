package roulette;

import util.ConsoleReader;

public class Factory {

	public Factory() {
		// TODO Auto-generated constructor stub
	}
    // name of the game
    private static final String DEFAULT_NAME = "Roulette";
    // add new bet subclasses here
    private Bet[] myPossibleBets = {
        new RedBlack("Red or Black", 1),
        new OddEven("Odd or Even", 1),
        new ThreeConsecutive("Three in a Row", 11),
    };
    private Wheel myWheel;

    /**
     * Construct the game.
     */

    /**
     * @return name of the game
     */
    public String getName () {
        return DEFAULT_NAME;
    }


    /**
     * Prompt the user to make a bet from a menu of choices.
     */
    public Bet promptForBet () {
        System.out.println("You can make one of the following types of bets:");
        for (int k = 0; k < myPossibleBets.length; k++) {
            System.out.println(String.format("%d) %s", (k + 1), myPossibleBets[k].getDescription()));
        }
        int response = ConsoleReader.promptRange("Please make a choice", 1, myPossibleBets.length);
        return myPossibleBets[response - 1];
    }

}
