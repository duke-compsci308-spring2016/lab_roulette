package roulette.bets;

import roulette.Bet;

public class BetFactory {

    private Bet[] myPossibleBets = {
                                    new RedBlack("Red or Black", 1),
                                    new OddEven("Odd or Even", 1),
                                    new ThreeConsecutive("Three in a Row", 11),
    };

    public BetFactory () {
        
    }
    
    public Bet makeBet(int betIndex) {
        Bet bet = myPossibleBets[betIndex];
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
