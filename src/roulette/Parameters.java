package roulette;
 
 public class Parameters {
     private String myGameName, myDescription;
     private int myOdds;     
     public Parameters (String gameName, String description, int odds) {
    	 myDescription = description;
    	 myGameName = gameName;
    	 myOdds = odds;
     }
     
     public String getDescription() {
         return myDescription;
     }
     
     public String getGameName() {
         return myGameName;
    }
    
     public int getOdds() {
         return myOdds;
     }

 }