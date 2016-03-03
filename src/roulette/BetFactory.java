package roulette;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;

public class BetFactory {
	private static final String BETS_FILE = "roulette.bets";
	private static final String CLASS_PREFIX = "roulette.";
	
	

	
	public static Bet[] getBets(){
		ResourceBundle myResource = ResourceBundle.getBundle(BETS_FILE);
		
		List<Bet> betList = new ArrayList<Bet>();
		Enumeration<String> betNames = myResource.getKeys();
		while(betNames.hasMoreElements()){
			String betName = betNames.nextElement();
			String[] details = myResource.getString(betName).split(",");
			try {
				Class<?> betClass = Class.forName(CLASS_PREFIX + betName);
				Constructor<?> constructor = betClass.getConstructor(String.class, int.class);
				Bet instance = (Bet) constructor.newInstance(details[0], Integer.valueOf(details[1]));
				betList.add(instance);
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		return betList.toArray(new Bet[betList.size()]);
	}

}
