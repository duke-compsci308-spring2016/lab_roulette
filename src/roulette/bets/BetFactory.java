package roulette.bets;

import java.lang.reflect.Constructor;
import roulette.Bet;

public class BetFactory {

    private String[] myPossibleBets = {"RedBlack", "OddEven", "ThreeConsecutive"};

    public BetFactory () {
        
    }
    
    public Bet makeBet(int betIndex)  {
        String betClass = myPossibleBets[betIndex];
        try {
            Class<?> c = Class.forName(betClass);
            Constructor<?> constructor = null;
            constructor = c.getConstructor(String.class, Integer.class); 
            Bet bet = (Bet) constructor.newInstance(betClass, 1);
            return bet;
        } catch (ReflectiveOperationException e){
           // Deal with error
            return null;
        }
        
    }
    
    public String betChoicesToString() {
        String betChoices = ""; 
        for (int k = 0; k < myPossibleBets.length; k++) {
           betChoices += (String.format("%d) %s", (k + 1), myPossibleBets[k]));
        }       
        return betChoices;
    }

}
