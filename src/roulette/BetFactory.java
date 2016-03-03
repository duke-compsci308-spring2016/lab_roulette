package roulette;

import java.util.Arrays;
import java.util.List;
import util.ConsoleReader;

public class BetFactory {
    
    private List<Bet> myPossibleBets = Arrays.asList(new Bet[]{
        new RedBlack("Red or Black", 1),
        new OddEven("Odd or Even", 1),
        new ThreeConsecutive("Three in a Row", 11),
    });
    
    public Bet getBetInstance(int betNumber){
        return myPossibleBets.get(betNumber);
    }
    
    /**
     * Prompt the user to make a bet from a menu of choices.
     */
    public void printOptions () {
        System.out.println("You can make one of the following types of bets:");
        for (int k = 0; k < myPossibleBets.size(); k++) {
            System.out.println(String.format("%d) %s", (k + 1), myPossibleBets.get(k).getDescription()));
        }
    }
    
    public int getNumberOfBets() {
        return myPossibleBets.size();
    }
}
