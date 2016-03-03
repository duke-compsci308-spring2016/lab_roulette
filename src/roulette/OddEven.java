package roulette;

import util.ConsoleReader;

<<<<<<< HEAD
public class OddEven extends Bet {

	public OddEven(String description, int odds) {
		super(description, odds);
	}
	
	public String placeBet(){
		return ConsoleReader.promptOneOf("Please bet", "even", "odd");
    }
    
	public boolean betIsMade(String betChoice, Wheel wheel) {
		return (wheel.getNumber() % 2 == 0 && betChoice.equals("even"))
				|| (wheel.getNumber() % 2 == 1 && betChoice.equals("odd"));
	}

=======

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
    @Override
    public boolean isMade (String betChoice, Wheel wheel) {
        return (wheel.getNumber() % 2 == 0 && betChoice.equals("even")) ||
               (wheel.getNumber() % 2 == 1 && betChoice.equals("odd"));
    }
>>>>>>> 6f08b447b45f36ee92d1ab4b61edb7988b4fdafa
}
