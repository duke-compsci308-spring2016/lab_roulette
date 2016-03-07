package roulette;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;

import util.ConsoleReader;

public class Factory {
	private List<Bet> myPossibleBets;

	public Factory() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		myPossibleBets = new ArrayList<Bet>();

		ResourceBundle myResources = ResourceBundle.getBundle("betResources/Bets.properties");
		Enumeration<String> enumeration = myResources.getKeys();
		while(enumeration.hasMoreElements()){
			String myClassKey = enumeration.nextElement();
			Class betClass = Class.forName(myClassKey);
			
			Constructor betCtor = betClass.getConstructor(String.class, int.class);
			String classValue = myResources.getString(myClassKey);
			String description = classValue.substring(0, classValue.indexOf(","));
			classValue = classValue.substring(classValue.indexOf(",")+1);
			int odds = Integer.parseInt(classValue);
			Object betObj = betCtor.newInstance(new Object[] { description, odds });
			myPossibleBets.add((Bet)betObj);
		}
	}

	public Bet printMenuChoices(){
		System.out.println("You can make one of the following types of bets:");
		for (int k = 0; k < myPossibleBets.size(); k++) {
			System.out.println(String.format("%d) %s", (k + 1), myPossibleBets.get(k).getDescription()));
		}
		int response = ConsoleReader.promptRange("Please make a choice", 1, myPossibleBets.size());
		return myPossibleBets.get(response - 1);
	}

}