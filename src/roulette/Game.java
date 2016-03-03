package roulette;

import roulette.bets.BetFactory;
import util.ConsoleReader;


/**
 * Plays a game of roulette.
 * 
 * @author Robert C. Duvall
 */
public class Game {
    // name of the game
    private static final String DEFAULT_NAME = "Roulette";
    private BetFactory myBetFactory;
    private Wheel myWheel;

    /**
     * Construct the game.
     */
    public Game () {
        myWheel = new Wheel();
        myBetFactory = new BetFactory();
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

    /**
     * Prompt the user to make a bet from a menu of choices.
     */
    private Bet promptForBet () {
        System.out.println("You can make one of the following types of bets:");
        System.out.println(myBetFactory.betChoicesToString());
        int response = ConsoleReader.promptRange("Please make a choice", 1, myBetFactory.numBets());
        return myBetFactory.makeBet(response);
    }
}
