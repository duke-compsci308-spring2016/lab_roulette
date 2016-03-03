package roulette;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Factory {
	Class[] bets = { OddEven.class, ThreeConsecutive.class, RedBlack.class };
	String[] betName = { "Red or Black", "Odd or Even", "Three in a Row" };
	int[] betNumber = {1, 1, 11};

	public Bet makeBet(int i) {
		Bet b = null;
		Constructor cons = null;
		try {
			cons = bets[i].getDeclaredConstructor(new Class[] { String.class, int.class });
		} catch (NoSuchMethodException | SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			b = (Bet) cons.newInstance(betName[i], betNumber[i]);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	public List<String> getBetNames() {
		List<String> names = new ArrayList<String>();

		for (Class c : bets) {
			names.add(c.getName());
		}

		return names;
	}
}
