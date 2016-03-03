package roulette;
import java.lang.reflect.Constructor;
import java.util.*;

public class Factory {
	private static final String myPath = "roulette/roulette.properties";
	private ResourceBundle myBundle;
    private Map<Integer, Parameters> myBetTypes;
    public Factory () {
    	myBundle = ResourceBundle.getBundle(myPath);
        myBetTypes = new HashMap<>();
        int counter = 0;
        for(String aKey: myBundle.keySet()) {
        	String myClassName = "roulette." + aKey;
        	String myDescription = myBundle.getString(aKey);
        	String [] args = myDescription.split(",");
        	myBetTypes.put(counter, new Parameters(myClassName, args[0], Integer.parseInt(args[1])));
        	counter++;
        }
    }
    public void print(){
        for (int i = 0; i < myBetTypes.size(); i++) {
            System.out.println(myBetTypes.get(i));
        }
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
    
    
    
    public int getLenth(){
        return myBetTypes.size();
    }
    
}
