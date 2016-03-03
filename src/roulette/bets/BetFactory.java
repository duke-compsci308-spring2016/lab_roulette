package roulette.bets;

import java.util.ArrayList;
import java.util.List;
import roulette.Bet;

public class BetFactory {

    List<String> betTypes;
    private Bet[] myPossibleBets = {
                                    new RedBlack("Red or Black", 1),
                                    new OddEven("Odd or Even", 1),
                                    new ThreeConsecutive("Three in a Row", 11),
    };

    public BetFactory () {
        betTypes = new ArrayList<>();
        betTypes.add("OddEven");
        betTypes.add("RedBlack");
        betTypes.add("ThreeConsecutive");
        
    }
    
    public Bet makeBet(String betType) {
        Bet bet = myPossibleBets[betTypes.indexOf(betType)];
        return bet;
        
    }
    
    public String betChoicesToString() {
        String betChoices = ""; 
        for (int k = 0; k < myPossibleBets.length; k++) {
           betChoices += (String.format("%d) %s", (k + 1), myPossibleBets[k]));
        }       
        return betChoices;
    }

}
