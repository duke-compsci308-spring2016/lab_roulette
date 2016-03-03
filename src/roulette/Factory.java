package roulette;

import java.util.ResourceBundle;

import util.ConsoleReader;

public class Factory {

	public Factory() {
		 myResources = ResourceBundle.getBundle(DEFAULT_RESOURCES);
	}
    // name of the game
    private static final String DEFAULT_NAME = "Roulette";
    public static final String DEFAULT_RESOURCES = "resources/bet";
//    private String[] betDescriptors = {"RedBlack", "OddEven", "ThreeConsecutive"};
//    private Integer[] betOdds = {1,1,11};
    // add new bet subclasses here
//    private Bet[] myPossibleBets = {
//        new RedBlack("Red or Black", 1),
//        new OddEven("Odd or Even", 1),
//        new ThreeConsecutive("Three in a Row", 11),
//    };
    
    private ResourceBundle myResources;
   
    
    private Wheel myWheel;

    /**
     * Construct the game.
     */

    /**
     * @return name of the game
     */
    public String getName () {
    	return DEFAULT_NAME;
    }


    /**
     * Prompt the user to make a bet from a menu of choices.
     * @throws ClassNotFoundException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    public Bet createReflection (String description) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    	Bet toReturn;
    	try{
    		System.out.println("reached");
    		String info = myResources.getString(description);
    		String[] betInfo = info.split(",");
        toReturn = (Bet)Class.forName("roulette." + description).getConstructor(String.class,int.class).newInstance(betInfo[0], Integer.parseInt(betInfo[1]));
    	}
    	catch(Exception e){
    		System.out.println("fail");
    		e.printStackTrace();
    		return null;
    	}
    	//System.out.println("reached");
        return toReturn;
    }

}
