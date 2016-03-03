package roulette.bets;

import roulette.Bet;
import roulette.Wheel;
import util.ConsoleReader;


public class ThreeConsecutive extends Bet {
    public static final int NUM_CONSECUTIVE = 3;
    private int myStart;

    public ThreeConsecutive (String description, int odds) {
        super(description, odds);
    }

    /**
     * @see Bet#place()
     */
    @Override
    public void place () {
        myStart = ConsoleReader.promptRange("Enter first of three consecutive numbers",
                                            1, (Wheel.NUM_SPOTS+1) - NUM_CONSECUTIVE);
    }

    /**
     * @see Bet#isMade(String, Wheel)
     */
    @Override
    public boolean isMade (Wheel.SpinResult wheel) {
        return (myStart <= wheel.getNumber() && wheel.getNumber() < myStart + NUM_CONSECUTIVE);
    }
}
