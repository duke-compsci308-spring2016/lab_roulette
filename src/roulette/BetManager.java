package roulette;

public class BetManager {
	
	private String[] possibleBets = {"OddEven", "RedBlack", "ThreeConsecutive"};
	
	public void printMenu() throws InstantiationException, IllegalAccessException {
		Object c = new Object();
		System.out.println("You can make one of the following types of bets:");
        for (int k = 0; k < possibleBets.length; k++) {
        	try {
        		c = Class.forName(possibleBets[k]).newInstance();
        	}
        	catch (ClassNotFoundException e) {
        		System.out.println("Class not found");
        	}
            System.out.println(String.format("%d) %s", (k + 1), c));
        }
	}

	
	
	
}
