package roulette;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Factory {
    private Map<Integer, Parameters> betTypes;
    
    public Factory () {
//       betTypes = Arrays.asList(new RedBlack("Red or Black", 1),
//                            new OddEven("Odd or Even", 1),
//                            new ThreeConsecutive("Three in a Row", 11));
        betTypes = new HashMap<>();
        betTypes.put(0, new Parameters("roulette.RedBlack", "Red or Black", 1));
        betTypes.put(1, new Parameters("roulette.OddEven", "Odd or Even", 1));
        betTypes.put(2, new Parameters("roulette.ThreeConsecutive", "Three in a Row", 11));
    }
    
    public Bet getBet (int index){
        try {
            Class<?> bet = Class.forName(betTypes.get(index).getGameName());
            Constructor<?> c = bet.getConstructor(String.class, Integer.TYPE);
            return (Bet) c.newInstance(betTypes.get(index).getDescription(), betTypes.get(index).getOdds());
        } catch (ReflectiveOperationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
        
    }
    
    public void print(){
        for (int i = 0; i < betTypes.size(); i++) {
            System.out.println(String.format("%d) %s", (i + 1), getBet(i).getDescription()));
        }
    }
    
    public int getLenth(){
        return betTypes.size();
    }
    
}
