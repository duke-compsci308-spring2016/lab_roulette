package roulette;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BetFactory {
	
	private List<Class<?>> betsList;
	
	public BetFactory() {
		this.betsList = new ArrayList<Class<?>>();
		
		this.betsList.addAll(Arrays.asList(RedBlackBet.class, OddEvenBet.class, ThreeInARowBet.class));
	}
	
	public void printBetChoices() {
		for(int k = 0; k < betsList.size(); k++) {
            System.out.println(String.format("%d) %s", (k + 1), betsList.get(k).getSimpleName()));
        }
	}
	
	public int numberOfBets() {
		return betsList.size();
	}
	
	public Bet getBet(int index) {
		Class<?> clazz  = this.betsList.get(index - 1);
		try {
			Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
			return (Bet) clazz.newInstance();
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
