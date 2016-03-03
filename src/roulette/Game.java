package roulette;

import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;

import roulette.bets.OddEven;
import roulette.bets.RedBlack;
import roulette.bets.ThreeConsecutive;
import util.ConsoleReader;


/**
 * Plays a game of roulette.
 * 
 * @author Robert C. Duvall
 */
public class Game {
    // name of the game
    private static final String DEFAULT_NAME = "Roulette";
    
    public static final String BET_RESOURCES = "bet.properties";
    private ResourceBundle myResources;
    
    // add new bet subclasses here
    private BetFactory betMaker;
    private Wheel myWheel;

    /**
     * Construct the game.
     */
    public Game () {
        myWheel = new Wheel();
        myResources = ResourceBundle.getBundle(BET_RESOURCES);
        betMaker = new BetFactory(myResources);
    }

    /**
     * @return name of the game
     */
    public String getName () {
        return DEFAULT_NAME;
    }

    /**
     * Play a round of roulette.
     *
     * Prompt player to make a bet, then spin the roulette wheel, and then verify 
     * that the bet is won or lost.
     *
     * @param player one that wants to play a round of the game
     */
    public void play (Gambler player) {
        int amount = ConsoleReader.promptRange("How much do you want to bet",
                                               0, player.getBankroll());
        try {
        Bet b = promptForBet();       
        b.place();

        System.out.print("Spinning ...");
        Wheel.SpinResult spinResult = myWheel.spin();
        System.out.println(String.format("Dropped into %s", spinResult));
        if (b.isMade(spinResult)) {
            System.out.println("*** Congratulations :) You win ***");
            amount = b.payout(amount);
        }
        else {
            System.out.println("*** Sorry :( You lose ***");
            amount *= -1;
        }
        player.updateBankroll(amount);
        }
        catch (Exception e) {
        	System.out.println("Please enter a valid bet");
        }
    }

    /**
     * Prompt the user to make a bet from a menu of choices.
     */
    private Bet promptForBet () throws Exception{
    	Enumeration<String> bets = myResources.getKeys();
        System.out.println("You can make one of the following types of bets:");
        int k = 1;
        while (bets.hasMoreElements()) {
            System.out.println(String.format("%d) %s", (k), bets.nextElement()));
        	k++;
        }
        String response = ConsoleReader.promptString("Please enter the bet name");
        return betMaker.makeBet(response);
    }
}
