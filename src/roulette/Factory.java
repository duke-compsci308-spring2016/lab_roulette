package roulette;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Factory 
{
	private ArrayList<Bet> typesOfBets;

	private enum PossibleBets
	{
		RED_BLACK, ODD_EVEN, THREE_CONSECUTIVES
	}

	public Factory()
	{
		typesOfBets = new ArrayList<Bet>();

		addBet(RedBlack.class, "Red or Black", 1);
		addBet(OddEven.class, "Odd or Even", 1);
		addBet(ThreeConsecutive.class, "3 consecutive",11);
	}

	private void addBet( Class betType, String description, int odds )
	{
		try {
			typesOfBets.add((Bet) betType.getConstructor(String.class, int.class).newInstance(description, odds));
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void askBetPrompt()
	{
        System.out.println("You can make one of the following types of bets:");

        int i = 1;
		for (Bet lister: typesOfBets) 
		{
            System.out.println(String.format("%d) %s", i++, lister.getDescription()));
        }
	}
	
	public Bet getBet(int index)
	{
		return typesOfBets.get(index);
	}
	
	public int getNumBets()
	{
		return typesOfBets.size();
	}
	
}
