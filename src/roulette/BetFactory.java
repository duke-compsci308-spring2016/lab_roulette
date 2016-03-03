package roulette;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class BetFactory {

    public BetFactory () {
        // Do nothing
    }

    public Bet getBet (String bet) throws ClassNotFoundException, NoSuchMethodException,
                                   SecurityException, InstantiationException,
                                   IllegalAccessException, IllegalArgumentException,
                                   InvocationTargetException {
        Class betClass = Class.forName(bet);
        Constructor betConstructor = betClass.getConstructor(double.class);
        return (Bet) betConstructor.newInstance();
    }

}
