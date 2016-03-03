package roulette;

import java.util.Arrays;
import java.util.List;

public class Factory {
    private List<Bet> betTypes;

    public Factory () {
       betTypes = Arrays.asList(new RedBlack("Red or Black", 1),
                            new OddEven("Odd or Even", 1),
                            new ThreeConsecutive("Three in a Row", 11));
    }
    
    public Bet getBet (int index){
        return betTypes.get(index);
    }
    
    public void print(){
        for (int i = 0; i < betTypes.size(); i++) {
            System.out.println(String.format("%d) %s", (i + 1),betTypes.get(i).getDescription()));
        }
    }
    
    public int getLenth(){
        return betTypes.size();
    }
    
}
