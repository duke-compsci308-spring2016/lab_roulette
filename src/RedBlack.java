package roulette.bets;

import roulette.Bet;
import roulette.Wheel;
import util.ConsoleReader;


public class RedBlack extends Bet {
    private String myChoice;

    public RedBlack (String description, int odds) {
        super(description, odds);
        // no initialization needed for myChoice
    }

    /**
     * @see Bet#place()
     */
    @Override
    public void place () {
        myChoice = ConsoleReader.promptOneOf("Please bet", Wheel.BLACK, Wheel.RED);
    }

    /**
     * @see Bet#isMade(String, Wheel)
     */
    @Override
    public boolean isMade (Wheel.SpinResult wheel) {
        return wheel.getColor().equals(myChoice);
    }
}
