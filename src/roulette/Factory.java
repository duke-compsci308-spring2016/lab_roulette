package roulette;

import util.ConsoleReader;

public class Factory {

    private String[] betTypes = {
                                   "RedBlack",
                                   "OddEven",
                                   "ThreeConsecutive"
    };
    
    private String[] betDescriptions = {
                                 "Red or Black",
                                 "Odd or Even",
                                 "Three in a Row"
  };
    
    private int[] betOdds = {
                             1,
                             1,
                             11
         };
            
    public Bet promptForBet() {
        System.out.println("You can make one of the following types of bets:");
        for (int k = 0; k < betTypes.length; k++) {
            System.out.println(String.format("%d) %s", (k + 1), betDescriptions[k]));
        }
        int response = ConsoleReader.promptRange("Please make a choice", 1, betTypes.length);
        Bet bet = null;
        try {
            bet = (Bet) Class.forName("roulette." + betTypes[response - 1])
                    .getConstructor(String.class, int.class).newInstance(betDescriptions[response - 1], 
                                                                         betOdds[response - 1]);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return bet;
    }
}
