package roulette;
import java.lang.reflect.Constructor;
import java.util.*;

public class Factory {
    private Map<Integer, Parameters> myBetTypes;
    public Factory () {
        myBetTypes = new HashMap<>();
        myBetTypes.put(0, new Parameters("RedBlack", "Red or Black", 1));
        myBetTypes.put(1, new Parameters("OddEven", "Odd or Even", 1));
        myBetTypes.put(2, new Parameters("ThreeConsecutive", "Three in a Row", 11));
    }
    
    public Bet getBet (int index){
    	try {
    		 Class<?> bet = Class.forName(myBetTypes.get(index).getGameName());
    		 Constructor<?> c = bet.getConstructor(String.class, Integer.TYPE);
    		 return (Bet) c.newInstance(myBetTypes.get(index).getDescription(), myBetTypes.get(index).getOdds());
    	} 
    	catch (ReflectiveOperationException e) {
    		 e.printStackTrace();
    	}
    	return null;    
    	}
    
    public void print(){
        for (int i = 0; i < myBetTypes.size(); i++) {
            System.out.println(myBetTypes.get(i));
        }
    }
    
    public int getLenth(){
        return myBetTypes.size();
    }
    
}
