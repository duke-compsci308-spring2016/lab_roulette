package roulette;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class Factory {
    private static final String PATH = "roulette.bets";
    private Map<Integer, Parameters> betTypes;
    private ResourceBundle myBundle;
    
    public Factory () {
        myBundle = ResourceBundle.getBundle(PATH);
        betTypes = new HashMap<>();
        
        int counter = 0;
        for(String key: myBundle.keySet()) {
           String className = "roulette." + key;
           String DescriptionAndInt = myBundle.getString(key);
           String [] arguments = DescriptionAndInt.split(",");
           betTypes.put(counter, new Parameters(className, arguments[0], Integer.parseInt(arguments[1])));
           counter++;
        }
      
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
