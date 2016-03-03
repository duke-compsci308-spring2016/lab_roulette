package roulette.bets;

import roulette.Bet;
import roulette.Wheel;
import util.ConsoleReader;


public class OddEven extends Bet {
    private String myChoice;

    public OddEven (String description, int odds) {
        super(description, odds);
        myChoice = "";
    }

    /**
     * @see Bet#place()
     */
    @Override
    public void place () {
        myChoice = ConsoleReader.promptOneOf("Please bet", "even", "odd");
    }

    /**
     * @see Bet#isMade(String, Wheel)
     */
    @Override
    public boolean isMade (Wheel.SpinResult wheel) {
        return (wheel.getNumber() % 2 == 0 && myChoice.equals("even")) ||
               (wheel.getNumber() % 2 == 1 && myChoice.equals("odd"));
    }
}
