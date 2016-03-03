package roulette;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Factory {

	private List<Bet> myBets;
	
	public Factory () {
		myBets = new ArrayList<Bet>();
		
	}
	
	public Bet createBet (String classname, String description, int odds) 
			throws InstantiationException, IllegalAccessException, 
			ClassNotFoundException, NoSuchMethodException, 
			SecurityException, IllegalArgumentException, InvocationTargetException {
//		Bet myInstance = (Bet) Class.forName(classname).newInstance();
		
		Class<?> clazz = Class.forName("roulette.bets." + classname);
		Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
		
		Bet instance = (Bet) constructor.newInstance(description, new Integer(odds));
		
		myBets.add(instance);
		return instance;
	}

}
