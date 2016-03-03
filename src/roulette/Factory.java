package roulette;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import roulette.bets.OddEven;
import roulette.bets.RedBlack;
import roulette.bets.ThreeConsecutive;
import util.ConsoleReader;

public class Factory {

	List<Bet> myBets;
	private static ResourceBundle myResourceBundle = ResourceBundle.getBundle("roulette/Bets");
	
	public Factory() {
		// TODO Auto-generated constructor stub
		myBets = new ArrayList<Bet>();

	}
	
	public static Bet createBet(String type) {
			
			Class c;
			Bet bet;
			try {
				c = Class.forName("roulette."+ type );
				String[] args = myResourceBundle.getString(type).split(",");
				bet = (Bet)c.getConstructor(String.class, Integer.class).newInstance(args[0], Integer.parseInt(args[1]));
				return bet;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch(IllegalAccessException e){
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch(InvocationTargetException e){
				e.printStackTrace();
			} catch(NoSuchMethodException e){
				e.printStackTrace();
			}
			
			return null;
	}
	
	
	public List<Bet> getBets(){
		return myBets;
	}
	
    private Bet promptForBet () {
        System.out.println("You can make one of the following types of bets:");
        for (int k = 0; k < myBets.size(); k++) {
            System.out.println(myResourceBundle.getKeys());
        }
        int response = ConsoleReader.promptRange("Please make a choice", 1, myBets.size());
        return myBets.get(response - 1);
    }

}
