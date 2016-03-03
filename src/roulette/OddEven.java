package roulette;

import roulette.Wheel.SpinResult;
import util.ConsoleReader;


public class OddEven extends Bet {
    public OddEven (String description, int odds) {
        super(description, odds);
    }

    /**
     * @see Bet#place()
     */
    @Override
    public String place () {
        return ConsoleReader.promptOneOf("Please bet", "even", "odd");
    }

    /**
     * @see Bet#isMade(String, Wheel)
     */
    public boolean isMade (String betChoice, Wheel wheel) {
        return (wheel.getNumber() % 2 == 0 && betChoice.equals("even")) ||
               (wheel.getNumber() % 2 == 1 && betChoice.equals("odd"));
    }

	@Override
	public boolean isMade(SpinResult spinResult) {
		// TODO Auto-generated method stub
		return false;
	}
}
