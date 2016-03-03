package roulette;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class BetFactory {
	List<Bet> betClassList = Arrays.asList(new OddEven(null, 0),new RedBlack(null, 0),new ThreeConsecutive(null, 0));
	ResourceBundle betResources = ResourceBundle.getBundle("betProperties");
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
			Constructor betConstructor = null;
			try {
				betConstructor = c.getConstructor();
			} catch (NoSuchMethodException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				return (Bet) betConstructor.newInstance(betResources.getString(name+"Odds"), betResources.getString(name+"Description"));
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
		}
		return null;
	}
}
