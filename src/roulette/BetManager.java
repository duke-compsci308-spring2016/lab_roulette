package roulette;

public class BetManager {
	
	private Bet[] possibleBets;
	
	public BetManager(Bet[] possibleBets) {
		this.possibleBets = possibleBets;
	}
	
	public void printMenu() {
		System.out.println("You can make one of the following types of bets:");
        for (int k = 0; k < possibleBets.length; k++) {
            System.out.println(String.format("%d) %s", (k + 1), possibleBets[k]));
        }
	}
	
	
		
}
