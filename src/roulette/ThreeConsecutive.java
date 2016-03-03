package roulette;

import util.ConsoleReader;


public class ThreeConsecutive extends Bet {
    public ThreeConsecutive (String description, int odds) {
        super(description, odds);
    }

    /**
     * @see Bet#place()
     */
    @Override
    public String place () {
        return "" + ConsoleReader.promptRange("Enter first of three consecutive numbers", 1, 34);
    }

    /**
     * @see Bet#isMade(String, Wheel)
     */
    @Override
    public boolean isMade (String betChoice, Wheel wheel) {
        int start = Integer.parseInt(betChoice);
        return (start <= wheel.getNumber() && wheel.getNumber() < start + 3);
    }
}
