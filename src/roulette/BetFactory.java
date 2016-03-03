package roulette;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import roulette.bets.OddEven;
import roulette.bets.RedBlack;
import roulette.bets.ThreeConsecutive;

public class BetFactory {
	private ResourceBundle myBundle;
	public Bet getBet(String betType) {
		Constructor<Bet> myConstructor = null;
		Bet myInstance = null;
		
		myBundle = ResourceBundle.getBundle("roulette/BetTypes.properties");
		String myClassName = myBundle.getString(betType).split(",")[0];
		int myClassInt = Integer.parseInt(myBundle.getString(betType).split(",")[1]);

		try {
			try {
				myConstructor = (Constructor<Bet>) Class.forName("roulette.bets"+myClassName).getConstructor(String.class,Integer.class);
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			myConstructor.setAccessible(true);
			try {
				myInstance = myConstructor.newInstance(betType,myClassInt);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		return myInstance;
	}
}
