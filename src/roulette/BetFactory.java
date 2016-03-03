package roulette;

import java.util.Arrays;
import java.util.List;
import util.ConsoleReader;
import java.lang.reflect.*;

public class BetFactory {
    
    private List<String> myPossibleBets = Arrays.asList(new String[]{
                                                                     "RedBlack",
                                                                     "OddEven",
                                                                     "ThreeConsecutive"
//        new RedBlack("Red or Black", 1),
//        new OddEven("Odd or Even", 1),
//        new ThreeConsecutive("Three in a Row", 11),
    });
    
    public Bet getBetInstance(int betNumber){
        Class<?> c;
        try {
            c = Class.forName("roulette." + myPossibleBets.get(betNumber-1));
            Constructor construct = c.getConstructor(String.class, Integer.TYPE);//getConstructor(String.class, Integer.TYPE);
            return (Bet) construct.newInstance(myPossibleBets.get(betNumber-1), 1);
        }
        catch (ReflectiveOperationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

      
    }
    
    /**
     * Prompt the user to make a bet from a menu of choices.
     */
    public void printOptions () {
        System.out.println("You can make one of the following types of bets:");
        for (int k = 0; k < myPossibleBets.size(); k++) {
            System.out.println(String.format("%d) %s", (k + 1), this.getBetInstance(k).getDescription()));
        }
    }
    
    public int getNumberOfBets() {
        return myPossibleBets.size();
    }
}
