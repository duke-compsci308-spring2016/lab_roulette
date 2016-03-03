package roulette;

import java.util.ResourceBundle;

public class BetFactory {

	private String[] myBets = {"RedBlack", "OddEven", "'ThreeConsecutive"}; 
	private static final String PROPERTY_PATH = "Resources";
  	private ResourceBundle myResources;
	
  	BetFactory() { 
  		ResourceBundle.getBundle(PROPERTY_PATH);
  	}
  	
	public void printOut(){
		for (int i=0; i < myBets.length; i++){
		System.out.println(myBets[i] + " " + myResources.getString(myBets[i]));
		}
	}
	
	public Bet getChoice(int i){
		Bet bet;
        try {
            String betName = myBets[i];
            String betClassName = myResources.getString(betName);
            @SuppressWarnings("rawtypes")
			Class c = Class.forName(betClassName);
            bet = (Bet) c.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
        		bet = null;
        }
        return bet;
	}
	
}
