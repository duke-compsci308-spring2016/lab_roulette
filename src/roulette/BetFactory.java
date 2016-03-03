package roulette;

import java.util.Arrays;
import java.util.List;

public class BetFactory {
	List<Bet> betClassList = Arrays.asList(new OddEven(null, 0),new RedBlack(null, 0),new ThreeConsecutive(null, 0));
	public BetFactory(){
		
	}
	public Bet makeBetClass(String name){
		for (Bet b: betClassList){
			if (b.getClass().getName()==name){
				return b;
			}
		}
		return null;
	}
}
