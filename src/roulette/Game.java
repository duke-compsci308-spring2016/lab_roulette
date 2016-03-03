package roulette;

import util.ConsoleReader;


/**
 * Plays a game of roulette.
 * 
 * @author Robert C. Duvall
 */
public class Game {
    // name of the game
    private static final String DEFAULT_NAME = "Roulette";
    // bets player can make
    private BetFactory bf;
    private Bet[] myPossibleBets = { 
        new RedBlackBet("Red or Black", 1),
        new OddEvenBet("Odd or Even", 1),
        new ThreeInARowBet("Three in a Row", 11)
    };
    private Wheel myWheel;

    /**
     * Construct the game.
     */
    public Game () {
        myWheel = new Wheel();
        bf = new BetFactory();
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
        String betChoice = b.placeBet();

        System.out.print("Spinning ...");
        myWheel.spin();
        System.out.println(String.format("Dropped into %s %d", myWheel.getColor(), myWheel.getNumber()));
        if (b.isMade(betChoice, myWheel)) {
            System.out.println("*** Congratulations :) You win ***");
            amount *= b.getOdds();
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
        bf.printBetChoices();
        return bf.getBet(ConsoleReader.promptRange("Please make a choice", 1, bf.numberOfBets()) - 1);
    }
    
}
