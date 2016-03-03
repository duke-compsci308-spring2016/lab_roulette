package roulette;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Properties;

public class Factory 
{
	private ArrayList<Bet> typesOfBets;
	private Properties betProperties;
	
	public Factory()
	{
		typesOfBets = new ArrayList<Bet>();
		
		betProperties = new Properties();
		
		try {
			betProperties.load(getClass().getClassLoader().getResourceAsStream("betProperties.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

		addBet(RedBlack.class, betProperties );
		addBet(OddEven.class, betProperties);
		addBet(ThreeConsecutive.class, betProperties);
	}

	private void addBet( Class betType, Properties betProperties)
	{		
		String[] properties = betProperties.getProperty(RedBlack.class.getName()).split(",");
		
		try {
			typesOfBets.add((Bet) betType.
					getConstructor(String.class, int.class).
					newInstance(properties[0], Integer.parseInt(properties[1])));
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
