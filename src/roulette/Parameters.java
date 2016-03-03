package roulette;

public class Parameters {

    private String description;
    private String gameName;
    private int odds; 
    
    public Parameters (String gameName, String description, int odds) {
        this.description = description;
        this.gameName = gameName;
        this.odds = odds;
    }
    
    public String getDescription() {
        return description;
    }
    
    public int getOdds() {
        return odds;
    }
    
    public String getGameName() {
        return gameName;
    }

}
