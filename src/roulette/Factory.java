package roulette;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import util.ConsoleReader;

public class Factory {
    private ResourceBundle myBundle = ResourceBundle.getBundle("BetMap.properties");
    private String[] myPossibleBets = {"Red or Black", "Odd or Even", "Three in a row"};
	
    private Bet promptForBet () throws NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        System.out.println("You can make one of the following types of bets:");
        for (int k = 0; k < myPossibleBets.length; k++) {
            System.out.println(String.format("%d) %s", (k + 1), myPossibleBets[k]));
        }
		try {
			String myName = myPossibleBets[ConsoleReader.promptRange("Please make a choice", 1, myPossibleBets.length) - 1];
			String[] myList = myBundle.getString(myName).split(",");
			Class myClass = Class.forName(myName);
			Constructor myConstructor = myClass.getDeclaredConstructor(new Class[] { String.class , int.class});
			return (Bet) myConstructor.newInstance(new Object[] {myList[0], myList[1]});	
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }

}
