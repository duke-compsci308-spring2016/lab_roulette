package roulette;

import java.util.Enumeration;
import java.util.ResourceBundle;
import util.ConsoleReader;

public class BetFactory {
	
	public BetFactory(){
	}
	public Bet getBetForParameters(String betName, int odds){
		Bet bet = null;
		try{
			bet = (Bet) Class.forName(betName)
											.getConstructor(String.class, int.class)
											.newInstance(betName, odds);
		}
		catch(Exception e){
			
		}
		return bet;
	}
    public Bet promptForBet () {
        System.out.println("You can make one of the following types of bets:");
        ResourceBundle resource = ResourceBundle.getBundle("Resources/BetParameters");
        Enumeration<String> iter = resource.getKeys();
        int k = 0;
        
        while(iter.hasMoreElements()){
            System.out.println(String.format("%d) %s", (++k), iter.nextElement()));
        }
        int response = ConsoleReader.promptRange("Please make a choice", 1, k);
        int index = 1;
        Enumeration<String> secondIteration = resource.getKeys();
        String betName = "";
        
        while(secondIteration.hasMoreElements()){
        	betName = secondIteration.nextElement();
        	if(index++ == response){
        		break;
        	}
        }
        
        String betParameters = (String) resource.getObject(betName);
        String[] params = betParameters.split(",");
        return getBetForParameters(params[0], Integer.parseInt(params[1]));
    }
}
