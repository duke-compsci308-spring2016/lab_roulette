package roulette.bets;

import java.lang.reflect.Constructor;
import java.util.Enumeration;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import roulette.Bet;
import java.util.ResourceBundle;

public class BetFactory {

    private ResourceBundle myResources;
    private List<String> myPossibleBets;
    private List<Entry<String, Integer>> myBetInfos;

    
    public BetFactory () {
        myResources = ResourceBundle.getBundle("resources/resources");
        myBetInfos = new ArrayList<Entry<String, Integer>>();
        myPossibleBets = new ArrayList<String>();
        init();
    }
    
    private void init() {
        Enumeration<String> iter = myResources.getKeys();
        while (iter.hasMoreElements()) {
            String key = iter.nextElement();
            String value = myResources.getString(key);
            String[] info = value.split(",");
            String description = info[0];
            System.out.println(info[1]);
            int odds = Integer.parseInt(info[1]);
            
            Entry<String, Integer> entry = new SimpleEntry<>(description, odds);
            myPossibleBets.add(key);
            myBetInfos.add(entry);
           
        }
        
    }
    
    public Bet makeBet(int betIndex)  {
        String betClass = myPossibleBets.get(betIndex);
        Entry<String, Integer> betInfo = myBetInfos.get(betIndex);
        try {
            Class<?> c = Class.forName(betClass);
            Constructor<?> constructor = null;
            constructor = c.getConstructor(String.class, Integer.class); 
            Bet bet = (Bet) constructor.newInstance(betInfo.getKey(), betInfo.getValue());
            return bet;
        } catch (ReflectiveOperationException e){
           // Deal with error
            return null;
        }
        
    }
    
    public int numBets() {
        return myPossibleBets.size();
    }
    
    public String betChoicesToString() {
        String betChoices = ""; 
        for (int k = 0; k < myPossibleBets.size(); k++) {
           betChoices += (String.format("%d) %s \n", (k + 1), myPossibleBets.get(k)));
        }       
        return betChoices;
    }
    
    

}
