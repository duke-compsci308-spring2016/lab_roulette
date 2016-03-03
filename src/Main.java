import roulette.Gambler;
import roulette.Game;


/**
 * Plays as many games of roulette until the player runs out of money.
 * 
 * @author Robert C. Duvall
 */
public class Main {
    public static void main (String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Game game = new Game();
        Gambler player = new Gambler("Robert", 1000);

        System.out.println(String.format("Hello %s, let's play %s!\n", player.getName(), game.getName()));
        while (player.isSolvent()) {
            game.play(player);
        }
        System.out.println();
        System.out.println(String.format("\nGoodbye %s, thanks for playing!", player.getName()));
    }
}
