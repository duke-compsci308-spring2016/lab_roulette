package roulette;

import java.util.Arrays;
import java.util.List;

public class BetFactory {
	List<Bet> betClassList = Arrays.asList(new OddEven(null, 0),new RedBlack(null, 0),new ThreeConsecutive(null, 0));
	public BetFactory(){
		
	}
	public Bet makeBetClass(String name){
		Class c = null;
		try {
			c = Class.forName(name);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			return (Bet) c.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
