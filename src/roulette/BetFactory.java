package roulette;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import roulette.bets.OddEven;
import roulette.bets.RedBlack;
import roulette.bets.ThreeConsecutive;

public class BetFactory {
	private Map<String,Integer> keys;
	//private Bet[] myPossibleBets = { new RedBlack("Red or Black", 1), new OddEven("Odd or Even", 1),
			//new ThreeConsecutive("Three in a Row", 11), };
	public BetFactory(){
		keys.put("Red or Black",1);
		keys.put("Odd or Even",1);
		keys.put("Three in a Row",11);

	}
	public Bet getBet(String betType) {
		Constructor<Bet> myConstructor = null;
		Bet myInstance = null;
		try {
			try {
				myConstructor = (Constructor<Bet>) Class.forName("roulette.bets"+betType).getConstructor(String.class,Integer.class);
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			myConstructor.setAccessible(true);
			try {
				myInstance = myConstructor.newInstance(betType, keys.get(betType));
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
