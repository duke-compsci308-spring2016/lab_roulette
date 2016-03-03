package roulette;

import util.ConsoleReader;


public class RedBlack extends Bet {
    public RedBlack (String description, int odds) {
        super(description, odds);
    }

    /**
     * @see Bet#place()
     */
    @Override
    public String place () {
        return ConsoleReader.promptOneOf("Please bet", Wheel.BLACK, Wheel.RED);
    }

    /**
     * @see Bet#isMade(String, Wheel)
     */
    @Override
    public boolean isMade (String betChoice, Wheel wheel) {
        return wheel.getColor().equals(betChoice);
    }
}
