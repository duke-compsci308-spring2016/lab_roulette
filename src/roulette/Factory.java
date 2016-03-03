package roulette;

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
		
		addBet(PossibleBets.RED_BLACK);
		addBet(PossibleBets.ODD_EVEN);
		addBet(PossibleBets.THREE_CONSECUTIVES);
	}
	
	private void addBet( PossibleBets betType )
	{
		switch ( betType )
		{
		case RED_BLACK:
			typesOfBets.add(new RedBlack("Red or Black", 1));
			break;
		case ODD_EVEN:
			typesOfBets.add(new OddEven("Odd or Even", 1));
			break;
		case THREE_CONSECUTIVES:
			typesOfBets.add(new ThreeConsecutive("Three Consecutives", 11));
			break;
		default:
			break;
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
